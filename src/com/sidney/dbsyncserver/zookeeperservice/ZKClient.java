package com.sidney.dbsyncserver.zookeeperservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.adchina.utils.StringUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.syncstruct.common.MemoryFromServer;

public class ZKClient
{
	private static Log logger = LogFactory.getLog(ZKClient.class);

	public ZooKeeper zk;
	private String root = "/syncbalance";
	private int sessionTimeout = 30000;

	public ZKClient(String connStr)
	{
		try
		{
			zk = new ZooKeeper(connStr, sessionTimeout, new ZKAsyncWatcher() {
				public void asyncProcess(WatchedEvent event)
				{
					List<String> syncBals = new ArrayList<String>();
					for (String path : ConfigurationHelper.ZK_QUORUM_SYNCBALANCE_NODES_PATH)
					{
						if (!StringUtil.isNullOrEmpty(event.getPath()) && event.getPath().equals(path) && event.getType() == EventType.NodeDataChanged)
						{
							try
							{
								String rawData = new String(zk.getData(path, true, null));
								if (!StringUtil.isNullOrEmpty(rawData))
								{
									syncBals.add(rawData);
								}
							} catch (KeeperException e)
							{
								e.printStackTrace();
							} catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						}
					}
					List<BalanceObj> balList = parseSyncBalanceNodeData(syncBals);
					if (balList.size() >= 1)
					{
						MemoryFromServer.getInstance().updateCacheFromQuorumPeers(balList);
					}

				}
			});

			if (null == zk.exists(root, false))
			{
				zk.create(root, "RootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			if (null == zk.exists(ConfigurationHelper.ZK_SYNCBALANCE_NODE_PATH, false))
			{
				zk.create(ConfigurationHelper.ZK_SYNCBALANCE_NODE_PATH, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<BalanceObj> parseSyncBalanceNodeData(List<String> syncBals)
	{
		List<BalanceObj> retBal = new ArrayList<BalanceObj>();
		for (String strBal : syncBals)
		{
			String[] balStrArray = strBal.split(";");
			if (balStrArray.length >= 1)
			{
				for (String strTmp : balStrArray)
				{
					String[] strTmpArray = strTmp.split(",");
					if (strTmpArray.length >= 4)
					{
						BalanceObj balObj = new BalanceObj();
						if (!StringUtil.isNullOrEmpty(strTmpArray[0]))
						{
							try
							{
								balObj.Id = Integer.parseInt(strTmpArray[0]);
							} catch (NumberFormatException e)
							{
								e.printStackTrace();
							}
						}
						if (!StringUtil.isNullOrEmpty(strTmpArray[1]))
						{
							try
							{
								balObj.ListName = Integer.parseInt(strTmpArray[1]);
							} catch (NumberFormatException e)
							{
								e.printStackTrace();
							}
						}
						if (!StringUtil.isNullOrEmpty(strTmpArray[2]))
						{
							try
							{
								balObj.DataType = Integer.parseInt(strTmpArray[2]);
							} catch (NumberFormatException e)
							{
								e.printStackTrace();
							}
						}
						if (!StringUtil.isNullOrEmpty(strTmpArray[3]))
						{
							try
							{
								balObj.NeedSyncBalance = new BigDecimal(strTmpArray[3]);
							} catch (Exception e)
							{
								e.printStackTrace();
							}
						}
						retBal.add(balObj);
					}
				}
			}
		}

		return retBal;
	}

	public void writeSyncBalanceNodeData(List<BalanceObj> syncBals)
	{
		StringBuilder sb = new StringBuilder(128);
		for (BalanceObj bal : syncBals)
		{
			if(bal.NeedSyncBalance.compareTo(new BigDecimal("0")) == 1){
				sb.append(String.format("%d,%d,%d,%s", bal.Id, bal.ListName, bal.DataType, bal.NeedSyncBalance.toString()));
				sb.append(";");
			}
		}
		if (sb.length() >= 1)
		{
			sb.delete(sb.length() - 1, sb.length());
		} else {
			return;
		}

		try
		{
			// firstly set to empty, then set to real value to ensure the watch
			// dog works while two same value is set.
			zk.setData(ConfigurationHelper.ZK_SYNCBALANCE_NODE_PATH, "".getBytes(), -1);
			zk.setData(ConfigurationHelper.ZK_SYNCBALANCE_NODE_PATH, sb.toString().getBytes(), -1);
			logger.info("ZKClient.writeSyncBalanceNodeData : " + sb.toString());
		} catch (KeeperException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

	public void watchOnQuorumSyncNodes()
	{
		try
		{
			if (null == zk.exists(root, false))
			{
				zk.create(root, "RootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		} catch (KeeperException e1)
		{
			e1.printStackTrace();
		} catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
		for (String path : ConfigurationHelper.ZK_QUORUM_SYNCBALANCE_NODES_PATH)
		{
			try
			{
				if (null == zk.exists(path, true))
				{
					zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				}
				zk.getData(path, true, null);
				logger.info("ZKClient.watchOnQuorumSyncNodes : " + path);
			} catch (KeeperException e)
			{
				e.printStackTrace();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}
	
	public void dispose()
	{
		try
		{
			zk.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
