package com.sidney.dbsyncserver.syncstruct.common;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.syncmodel.ListNameType;
import com.sidney.dbsyncserver.syncmodel.SyncStatusType;
import com.sidney.dbsyncserver.utils.SendMailService;
import com.sidney.dbsyncserver.utils.ShowBalanceObj;
import com.sidney.dbsyncserver.zookeeperservice.ZKClient;


public class MemoryFromServer
{
	private static Log logger = LogFactory.getLog(MemoryFromServer.class);

	// private ManualResetEvent[] manualevent = new ManualResetEvent[1] { new
	// ManualResetEvent(true) };
	private List<HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>>> listBalanceObj = new ArrayList<HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>>>(); // lsit<id,<name,<type,obj>>>只有2个元素

	// / <summary>
	// / 1)当前使用的主buff,它会被切换
	// / 2)它会被作为lock的obj
	// / </summary>
	private int[] listIndex = { 0 };

	// / <summary>
	// / 1）当一直有调用UpdateFromServer，则更新bActive=true。
	// / 2）线程将在bActive==true时保持执行逻辑，否则不执行逻辑。执行一次线程循环，则置bActive=false
	// / </summary>
	private AtomicBoolean bActive = new AtomicBoolean(false);

	private List<AtomicBoolean> listDelegate = new ArrayList<AtomicBoolean>();

	public void registUpdateNotice(AtomicBoolean _delegate)
	{
		this.listDelegate.add(_delegate);
	}

	private void notice()
	{
		for (AtomicBoolean d : this.listDelegate)
		{
			d.set(true);
		}
	}

	private static MemoryFromServer thisInstance = new MemoryFromServer();

	public static MemoryFromServer getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (MemoryFromServer.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new MemoryFromServer();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	private MemoryFromServer()
	{
		this.listBalanceObj.add(new HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>>()); // first
		this.listBalanceObj.add(new HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>>()); // second
		
		
		// 因为初始化时间过长,使用线程初始化
		Thread thr = new Thread(new Runnable() {
			public void run()
			{
				initialise();
			}
		});

		thr.start();
	}

	private void initialise()
	{
		try
		{
			List<BalanceObj> initDic = SelectDbFromLocal.getInstance().selectAll(); // 从DB读取

			if (null != initDic)
			{
				logger.info(String.format("[MemoryFromServer] Init load db count:%d", initDic.size()));

				for (BalanceObj i : initDic)
				{
					if (null == addNew(this.listBalanceObj.get(0), i, false)) // 初始化元素0的数据
					{
					}
					if (null == addNew(this.listBalanceObj.get(1), i, false)) // 初始化元素1的数据
					{
					}
				}
			}

			Thread thr = new Thread(new Runnable() {
				public void run()
				{
					updateFromServerThrFun();
				}
			});
			thr.start();

			Thread thr2 = new Thread(new Runnable() {
				public void run()
				{
					checkThrFun();
				}
			});
			thr2.start();
		} catch (Exception ex)
		{
			String temp = String.format("[MemoryFromServer]:%s", ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		}
	}

	// / <summary>
	// / 双缓存交换，将接收的数据写入DB
	// / </summary>
	private void updateFromServerThrFun()
	{
		while (true)
		{
			try
			{
				Thread.sleep(ConfigurationHelper.MEMORY_BACK_BALANCE);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (bActive.get() == false)
			{
				// [MemoryFromServer] thread is paused!
				continue;
			}

			try
			{
				int tempIndex = 0;
				
				notice();

				synchronized (listIndex)
				{
					try
					{
						// 缓存A：正在被使用的内存块
						// 缓存B：正在被传输用的内存块

						tempIndex = (listIndex[0] ^ 1); // 从A 获得 B 索引

						logger.info(String.format("[MemoryFromServer]:in MemoryCache:%d,%d", listBalanceObj.get(listIndex[0]).size(), listBalanceObj.get(tempIndex).size()));

						HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>> dic1 = listBalanceObj.get(listIndex[0]);

						for (Integer key1 : dic1.keySet()) // 循环 A
															// （A是和adserver交互的内存块）
						{
							for (Integer key2 : dic1.get(key1).keySet())
							{
								for (Integer key3 : dic1.get(key1).get(key2).keySet()) // A
								{
									BalanceObj balobjInDic = dic1.get(key1).get(key2).get(key3);
									// 将A中的新元素插入B，并保持相同数据。(因为B之后就会变成为主交互内存块，所以要把B的NeedSyncBalance置为0)
									BalanceObj balobj = addNew(this.listBalanceObj.get(tempIndex), balobjInDic, true);

									if (null != balobj) // 已经存在B
									{
										// 将A数据更新给B modified by yuhang 20121225
										// 如果B已经存在，它的数据是老数据，必须把下述A跑的量更新给B，因为B之后也需要和server交互
										balobj.NewXHit = balobj.NewXHit.add(balobjInDic.NeedSyncBalance);
										balobj.NewXBalance = balobj.NewXBalance.subtract(balobjInDic.NeedSyncBalance);
										balobj.NewTotalHit = balobj.NewTotalHit.add(balobjInDic.NeedSyncBalance);

										ShowBalanceObj.show(balobjInDic, String.format("{%d} A has", listIndex[0]), logger);
										ShowBalanceObj.show(balobj, String.format("{%d} B has", tempIndex), logger);
									} else
									{
										logger.info(String.format("LockX {%d} block add new:{%d},{%d},{%d},{%s},MemoryCache:{%d},{%d}", tempIndex, this.listBalanceObj.get(tempIndex)
												.get(balobjInDic.Id).get(balobjInDic.ListName).get(balobjInDic.DataType).Id, this.listBalanceObj.get(tempIndex).get(balobjInDic.Id)
												.get(balobjInDic.ListName).get(balobjInDic.DataType).ListName, this.listBalanceObj.get(tempIndex).get(balobjInDic.Id).get(balobjInDic.ListName)
												.get(balobjInDic.DataType).DataType, this.listBalanceObj.get(tempIndex).get(balobjInDic.Id).get(balobjInDic.ListName).get(balobjInDic.DataType).NeedSyncBalance
												.toString(), this.listBalanceObj.get(listIndex[0]).size(), this.listBalanceObj.get(listIndex[0] ^ 1).size()));
									}
								}
							}
						}

						listIndex[0] = tempIndex; // listIndex[0] 原来的B
						tempIndex = (listIndex[0] ^ 1); // tempIndex 原来的A
														// ，此时外部使用 B
														// 进行数据交互，而A在后台写入DB
					} catch (Exception ex)
					{
						String temp = String.format("[MemoryFromServer.UpdateFromServerThrFun.lock1]:{%s}", ex);
						logger.error(temp);
						new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
					}
				}

				updateFromServer(tempIndex);// 将 A
											// 的数据写入DB,并从DB中获得从master传过来的更新数据

				synchronized (listIndex)
				{
					try
					{
						HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>> dic2 = listBalanceObj.get(listIndex[0]);
						for (Integer key1 : dic2.keySet()) // 循环
															// B（B是和adserver交互的内存块）
						{
							for (Integer key2 : dic2.get(key1).keySet())
							{
								for (Integer key3 : dic2.get(key1).get(key2).keySet()) // B
								{
									BalanceObj balobjInDic2 = dic2.get(key1).get(key2).get(key3);

									// 将B的新数据插入A，NeedSyncBalance不需要置为0。
									// 如果A中已经存在B的数据，则返回A中的原数据
									BalanceObj balobj = addNew(listBalanceObj.get(tempIndex), balobjInDic2, false);

									// 如果 B 中的一个元素在 A 中存在
									if (null != balobj)
									{
										// 如果A的数据在远端更新失败，在B上加上A的NeedSyncBalance，下次再进行传输
										if (0 == (balobj.Status & (int) SyncStatusType.SYNC_SUCCESS.getValue()) && balobj.NeedSyncBalance.compareTo(new BigDecimal("0")) == 1)
										{

											balobjInDic2.NeedSyncBalance = balobjInDic2.NeedSyncBalance.add(balobj.NeedSyncBalance);

											logger.info(String
													.format("A block {%d} update error:{%d},{%d},{%d},{%s},MemoryCache:{%d},{%d}", tempIndex, balobj.Id, balobj.ListName, balobj.DataType, balobj.NeedSyncBalance
															.toString(), this.listBalanceObj.get(listIndex[0]).size(), this.listBalanceObj.get(listIndex[0] ^ 1).size()));
										}
										balobj.NeedSyncBalance = new BigDecimal("0"); // A的更新完成，将A中的NeedSyncBalance置为0

										// 将A数据更新给B modified by yuhang 20121225
										// 因为A的数据是从DB来的，会带来新的budget等信息,所以需要更新到B
										balobjInDic2.NewXBudget = new BigDecimal(balobj.NewXBudget.toString());
										balobjInDic2.NewTotalBudget = new BigDecimal(balobj.NewTotalBudget.toString());

										ShowBalanceObj.show(balobjInDic2, String.format("{%d} A has", listIndex[0]), logger);
										ShowBalanceObj.show(balobj, String.format("{%d} B has", tempIndex), logger);
									} else
									{
										logger.info(String.format("LockY {%d} block add new:{%d},{%d},{%d},{%s},MemoryCache:{%d},{%d}", tempIndex, this.listBalanceObj.get(tempIndex)
												.get(balobjInDic2.Id).get(balobjInDic2.ListName).get(balobjInDic2.DataType).Id, this.listBalanceObj.get(tempIndex).get(balobjInDic2.Id)
												.get(balobjInDic2.ListName).get(balobjInDic2.DataType).ListName, this.listBalanceObj.get(tempIndex).get(balobjInDic2.Id)
												.get(balobjInDic2.ListName).get(balobjInDic2.DataType).DataType, this.listBalanceObj.get(tempIndex).get(balobjInDic2.Id)
												.get(balobjInDic2.ListName).get(balobjInDic2.DataType).NeedSyncBalance.toString(), this.listBalanceObj.get(listIndex[0]).size(), this.listBalanceObj
												.get(listIndex[0] ^ 1).size()));
									}
								}
							}
						}
					} catch (Exception ex)
					{
						String temp = String.format("[MemoryFromServer.UpdateFromServerThrFun.lock2]:{%s}", ex);
						logger.error(temp);
						new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
					}
				}
			} catch (Exception ex)
			{
				String temp = String.format("[MemoryFromServer.UpdateFromServerThrFun]:%s", ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			} finally
			{
				bActive.set(false);
				notice();// 通知其它模块，有新的balance写入了Db
			}
		}
	}

	// / <summary>
	// / 每隔一段时间（默认5分钟），检查dailyhit和budget是否和谐
	// / </summary>
	private void checkThrFun()
	{
		if (ConfigurationHelper.CHECK_SLAVE_BALANCE_TIMESPAN <= 0)
		{
			return;
		}

		while (true)
		{
			try
			{
				Thread.sleep(ConfigurationHelper.CHECK_SLAVE_BALANCE_TIMESPAN);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try
			{
				if (bActive.get() == false)
				{
					continue;
				}

				StringBuilder sb = new StringBuilder();
				synchronized (listIndex)
				{
					sb.append("<p><table border='1'><tr><th>ID</th><th>DataType</th><th>ListName</th><th>NewXBudget</th><th>NewXHit</th><th>NewXBalance</th><th>NewTotalBudget</th><th>NewTotalHit</th><th>NeedSyncBalance</th></tr>");
					HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>> dic = listBalanceObj.get(listIndex[0]);
					for (Integer key1 : dic.keySet()) // 循环和adserver交互的内存块
					{
						for (Integer key2 : dic.get(key1).keySet())
						{
							for (Integer key3 : dic.get(key1).get(key2).keySet()) // A
							{
								BalanceObj balobj = dic.get(key1).get(key2).get(key3);

								// 调试日志:
								boolean bShow = false;

								if (balobj.ListName == ListNameType.ADMANAGE_MEDIA_BUY.getValue())
								{
									if (balobj.NewXBalance.compareTo(new BigDecimal("0")) == -1)
									{
										bShow = true;
									}
								}
								if (balobj.ListName == ListNameType.DSP_CAMPAIGN_MONEY.getValue())
								{
								}
								if (balobj.ListName == ListNameType.DSP_STRATEGY_MONEY.getValue())
								{
									if (balobj.NewXHit.compareTo(balobj.NewXBudget) == 1 || balobj.NewTotalHit.compareTo(balobj.NewTotalBudget) == 1)
									{
										bShow = true;
									}
								}

								if (bShow)
								{
									sb.append(String
											.format("<tr><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td></tr>", balobj.Id, balobj.DataType, balobj.ListName, balobj.NewXBudget, balobj.NewXHit, balobj.NewXBalance, balobj.NewTotalBudget, balobj.NewTotalHit, balobj.NeedSyncBalance));
								}
							}
						}
					}
					sb.append("</table></p>");
				}

				logger.info(sb.toString());
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Balance alert", ConfigurationHelper.SERVICE_ADDRESS), sb.toString());
			} catch (Exception ex)
			{
				String temp = String.format("[MemoryFromServer.CheckThrFun]:%s", ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			} finally
			{
			}
		}
	}

	// / <summary>
	// / 写入sync_balance_ctrl
	// / </summary>
	// / <param name="tempIndex"></param>
	private void updateFromServer(int tempIndex)
	{
		List<BalanceObj> tempObj = new ArrayList<BalanceObj>();
		for (Integer key1 : listBalanceObj.get(tempIndex).keySet())
		{
			for (Integer key2 : listBalanceObj.get(tempIndex).get(key1).keySet())
			{
				for (Integer key3 : listBalanceObj.get(tempIndex).get(key1).get(key2).keySet())
				{
					BalanceObj obj = listBalanceObj.get(tempIndex).get(key1).get(key2).get(key3);
					ShowBalanceObj.show(obj, "MemoryFromServer.UpdateFromServer.before", logger); // log

					if (0 != (obj.Status & (int) SyncStatusType.UPDATE_FROM_SERVER.getValue())) // 如果更新来自server，则需要更新至sync_balance_ctrl
					{
						tempObj.add(obj);
					}
				}
			}
		}

		logger.info(String.format("[MemoryFromServer] queue %d update to syncdb count:%d", tempIndex, tempObj.size()));
		UpdateDbFromServer.getInstance().updateFromServer(tempObj); // 写入DB

		for (BalanceObj obj : tempObj)
		{
			ShowBalanceObj.show(obj, "MemoryFromServer.UpdateFromServer.after", logger); // log

			if (0 != (obj.Status & (int) SyncStatusType.SYNC_SUCCESS.getValue()))
			{
				obj.NeedSyncBalance = new BigDecimal("0"); // 如果更新成功，则清0
			}
		}
	}

	// / <summary>
	// / 添加新数据
	// / </summary>
	// / <param name="_dic">被更新的目标</param>
	// / <param name="_obj">新数据</param>
	// / <param name="SyncBalanceIsZero">是否需要将_dic中的NeedSyncBalance设为0</param>
	// / <returns>如果内存中已经存在新数据_obj，则返回找到的原obj</returns>
	private BalanceObj addNew(HashMap<Integer, HashMap<Integer, HashMap<Integer, BalanceObj>>> _dic, BalanceObj _obj, boolean syncBalanceIsZero)
	{
		BalanceObj ret = null;
		if (!_dic.containsKey(_obj.Id))
		{
			_dic.put(_obj.Id, new HashMap<Integer, HashMap<Integer, BalanceObj>>());
		}
		if (!_dic.get(_obj.Id).containsKey(_obj.ListName))
		{
			_dic.get(_obj.Id).put(_obj.ListName, new HashMap<Integer, BalanceObj>());
		}
		if (!_dic.get(_obj.Id).get(_obj.ListName).containsKey(_obj.DataType))
		{
			_dic.get(_obj.Id).get(_obj.ListName).put(_obj.DataType, new BalanceObj(_obj));
		} else
		{
			ret = _dic.get(_obj.Id).get(_obj.ListName).get(_obj.DataType); // 如果原结构内存在需要添加的obj，则返回找到的obj
		}

		if (syncBalanceIsZero) // NeedSyncBalance的字段要设为0
		{
			_dic.get(_obj.Id).get(_obj.ListName).get(_obj.DataType).NeedSyncBalance = new BigDecimal("0");
		}

		return ret;
	}

	// / <summary>
	// / 从adserver更新内存数据
	// / </summary>
	// / <param name="_listBalance"></param>
	public void updateFromServer(List<BalanceObj> _listBalance)
	{
		try
		{
			synchronized (listIndex)
			{
				updateFromServerInLock(_listBalance);
			}
			this.bActive.set(true);
			// write balance that need to sync to other Quorum peers 
			ZKClient zk = new ZKClient(ConfigurationHelper.ZK_CONNECTION_STRING);
			zk.writeSyncBalanceNodeData(_listBalance);
			zk.dispose();
		} catch (Exception e)
		{
			logger.error(e);
		}
	}

	private void updateFromServerInLock(List<BalanceObj> _listBalance)
	{
		try
		{
			// 循环传入的balance数据
			for (BalanceObj balance : _listBalance)
			{
				ShowBalanceObj.show(balance, "MemoryFromServer.UpdateFromServerInLock.A", logger); // log

				// 内存中的this.listBalanceObj[listIndex]中不存在数据，则添加进去
				if (null == addNew(this.listBalanceObj.get(listIndex[0]), balance, false))
				{
					// 如果内存中没有数据，一些可变参数不赋值
					logger.info(String.format("UpdateFromServerInLock New:{%d},{%d},{%d},{%s},MemoryCache:{%d},{%d}", balance.Id, balance.ListName, balance.DataType, balance.NeedSyncBalance
							.toString(), this.listBalanceObj.get(listIndex[0]).size(), this.listBalanceObj.get(listIndex[0] ^ 1).size()));
					// 内存中balance数据之一
					BalanceObj memoryObj = this.listBalanceObj.get(listIndex[0]).get(balance.Id).get(balance.ListName).get(balance.DataType);

					ShowBalanceObj.show(memoryObj, "MemoryFromServer.UpdateFromServerInLock.B+", logger); // log

					// balance.NewXBudget = memoryObj.NewXBudget;
					// balance.NewXHit = memoryObj.NewXHit;
					// balance.NewXBalance = memoryObj.NewXBalance;
					// balance.NewTotalBudget = memoryObj.NewTotalBudget;
					// balance.NewTotalHit = memoryObj.NewTotalHit;

					memoryObj.NeedSyncBalance = memoryObj.NeedSyncBalance.add(balance.NeedSyncBalance);
					memoryObj.NewXHit = memoryObj.NewXHit.add(balance.NeedSyncBalance);
					memoryObj.NewXBalance = memoryObj.NewXBalance.subtract(balance.NeedSyncBalance);
					memoryObj.NewTotalHit = memoryObj.NewTotalHit.add(balance.NeedSyncBalance);

					balance.NewXBalance = balance.NewXBalance.subtract(balance.NeedSyncBalance);
					balance.NewTotalHit = balance.NewTotalHit.add(balance.NeedSyncBalance);
					balance.NewXHit = balance.NewXHit.add(balance.NeedSyncBalance);

					memoryObj.Status |= (int) SyncStatusType.UPDATE_FROM_SERVER.getValue(); // 按位标识从server来的

					balance.Status = (int) SyncStatusType.SYNC_SUCCESS.getValue(); // 更新成功

					ShowBalanceObj.show(balance, "MemoryFromServer.UpdateFromServerInLock.C+", logger); // log
					ShowBalanceObj.show(memoryObj, "MemoryFromServer.UpdateFromServerInLock.D+", logger); // log

				} else
				{
					// 如果内存中存在数据

					// 内存中balance数据之一
					BalanceObj memoryObj = this.listBalanceObj.get(listIndex[0]).get(balance.Id).get(balance.ListName).get(balance.DataType);

					ShowBalanceObj.show(memoryObj, "MemoryFromServer.UpdateFromServerInLock.B", logger); // log

					balance.NewXBudget = memoryObj.NewXBudget;
					balance.NewXHit = memoryObj.NewXHit;
					balance.NewXBalance = memoryObj.NewXBalance;
					balance.NewTotalBudget = memoryObj.NewTotalBudget;
					balance.NewTotalHit = memoryObj.NewTotalHit;

					memoryObj.NeedSyncBalance = memoryObj.NeedSyncBalance.add(balance.NeedSyncBalance);
					memoryObj.NewXHit = memoryObj.NewXHit.add(balance.NeedSyncBalance);
					memoryObj.NewXBalance = memoryObj.NewXBalance.subtract(balance.NeedSyncBalance);
					memoryObj.NewTotalHit = memoryObj.NewTotalHit.add(balance.NeedSyncBalance);

					balance.NewXBalance = balance.NewXBalance.subtract(balance.NeedSyncBalance);
					balance.NewTotalHit = balance.NewTotalHit.add(balance.NeedSyncBalance);
					balance.NewXHit = balance.NewXHit.add(balance.NeedSyncBalance);

					memoryObj.Status |= (int) SyncStatusType.UPDATE_FROM_SERVER.getValue(); // 按位标识从server来的

					balance.Status = (int) SyncStatusType.SYNC_SUCCESS.getValue(); // 更新成功

					ShowBalanceObj.show(balance, "MemoryFromServer.UpdateFromServerInLock.C", logger); // log
					ShowBalanceObj.show(memoryObj, "MemoryFromServer.UpdateFromServerInLock.D", logger); // log
				}
			}
		} catch (Exception e)
		{
			logger.error(e);
		}
	}

	
	
	
	// <summary>
	// update local cache from other peers in zookeeper quorum
	// </summary>
	// <param name="_listBalance"></param>
	public void updateCacheFromQuorumPeers(List<BalanceObj> _listBalance)
	{
		try
		{
			synchronized (listIndex)
			{
				logger.info("update cache from other Quorum Peers");
				updateCacheFromQuorumPeersInLock(_listBalance, listIndex[0]);
				updateCacheFromQuorumPeersInLock(_listBalance, listIndex[0] ^ 1);
			}
			//notice SlaveSync.threadBalanceFun() to get new budget etc. (from master db)
			notice();
		} catch (Exception e)
		{
			logger.error(e);
		}
	}

	public void updateCacheFromQuorumPeersInLock(List<BalanceObj> _listBalance, int cacheIndex)
	{
		try
		{
				for (BalanceObj balance : _listBalance)
				{
					ShowBalanceObj.show(balance, "updateCacheFromQuorumPeers.A cacheIndex: " + cacheIndex, logger);

					// if there is no match in this.listBalanceObj[listIndex] , then add
					if (null == addNew(this.listBalanceObj.get(cacheIndex), balance, false))
					{
						logger.info(String.format("updateCacheFromQuorumPeers New:{%d},{%d},{%d},{%s},MemoryCache:{%d},{%d}", balance.Id, balance.ListName, 
								balance.DataType, balance.NeedSyncBalance.toString(), this.listBalanceObj.get(cacheIndex).size(), this.listBalanceObj.get(cacheIndex ^ 1).size()));

						BalanceObj memoryObj = this.listBalanceObj.get(cacheIndex).get(balance.Id).get(balance.ListName).get(balance.DataType);

						ShowBalanceObj.show(memoryObj, "MemoryFromServer.updateCacheFromQuorumPeers.B+", logger); 

						memoryObj.NewXHit = memoryObj.NewXHit.add(balance.NeedSyncBalance);
						memoryObj.NewXBalance = memoryObj.NewXBalance.subtract(balance.NeedSyncBalance);
						memoryObj.NewTotalHit = memoryObj.NewTotalHit.add(balance.NeedSyncBalance);
						memoryObj.Status |= (int) SyncStatusType.UPDATE_FROM_SERVER.getValue(); 

						ShowBalanceObj.show(balance, "MemoryFromServer.updateCacheFromQuorumPeers.C+", logger); 
						ShowBalanceObj.show(memoryObj, "MemoryFromServer.updateCacheFromQuorumPeers.D+", logger); 

					} else
					{
						// there is matched cache in this.listBalanceObj[listIndex]
						BalanceObj memoryObj = this.listBalanceObj.get(cacheIndex).get(balance.Id).get(balance.ListName).get(balance.DataType);

						ShowBalanceObj.show(memoryObj, "MemoryFromServer.updateCacheFromQuorumPeers.B", logger); 

						memoryObj.NewXHit = memoryObj.NewXHit.add(balance.NeedSyncBalance);
						memoryObj.NewXBalance = memoryObj.NewXBalance.subtract(balance.NeedSyncBalance);
						memoryObj.NewTotalHit = memoryObj.NewTotalHit.add(balance.NeedSyncBalance);
						memoryObj.Status |= (int) SyncStatusType.UPDATE_FROM_SERVER.getValue(); 

						ShowBalanceObj.show(balance, "MemoryFromServer.updateCacheFromQuorumPeers.C", logger); 
						ShowBalanceObj.show(memoryObj, "MemoryFromServer.updateCacheFromQuorumPeers.D", logger); 
					}
				}
			
		} catch (Exception e)
		{
			logger.error(e);
		}
	}

	
	public void dispose()
	{
	}
}