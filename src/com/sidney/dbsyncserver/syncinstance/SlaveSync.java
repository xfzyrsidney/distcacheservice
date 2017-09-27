package com.sidney.dbsyncserver.syncinstance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;

import com.adchina.utils.DateUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.dbaccess.admanager.AdManagerContext;
import com.sidney.dbsyncserver.dbaccess.dsp.DspContext;
import com.sidney.dbsyncserver.syncinterface.BinaryData;
import com.sidney.dbsyncserver.syncinterface.BinaryType;
import com.sidney.dbsyncserver.syncinterface.ISlave;
import com.sidney.dbsyncserver.syncinterface.TransferInfo;
import com.sidney.dbsyncserver.syncmodel.Balance;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.syncmodel.SyncDbListType;
import com.sidney.dbsyncserver.syncmodel.SyncStatusType;
import com.sidney.dbsyncserver.syncstruct.common.MemoryFromServer;
import com.sidney.dbsyncserver.syncstruct.common.SelectDbFromLocal;
import com.sidney.dbsyncserver.syncstruct.common.TryLockDbFromLocal;
import com.sidney.dbsyncserver.syncstruct.common.UpdateDbFromMaster;
import com.sidney.dbsyncserver.syncstruct.common.UpdateDbFromServer;
import com.sidney.dbsyncserver.syncstruct.loadunloadoperation.DbDataManager;
import com.sidney.dbsyncserver.tserializ.common.DbSerializeService;
import com.sidney.dbsyncserver.update.UpdateBalance;
import com.sidney.dbsyncserver.utils.SendMailService;
import com.sidney.dbsyncserver.utils.ShowBalanceObj;
import com.sidney.dbsyncserver.zookeeperservice.ZKClient;

public class SlaveSync implements ISlave.Iface
{
	private static Log logger = LogFactory.getLog(SlaveSync.class);
	private static final int SLAVESYNCVERSION = 10; 
	// / <summary>
	// / 1）当一直有调用UpdateFromServer，则更新bActive=true。
	// / 2）线程将在bActive==true时保持执行逻辑，否则不执行逻辑。执行一次线程循环，则置bActive=false
	// / </summary>
	private static AtomicBoolean bActive = new AtomicBoolean(false);

	static
	{
		for (String v : ConfigurationHelper.TARGET_SERVICE_ADDRESS)
		{
			logger.info(String.format("[slave] master address:%s", v));
		}

		DbDataManager dataManager = DbDataManager.getInstance();
		
		MemoryFromServer.getInstance().registUpdateNotice(bActive);

		UpdateDbFromServer.getInstance().registUpdateNotice(bActive);

		//register watch dog on zookeeper quorum sync nodes
		ZKClient zk = new ZKClient(ConfigurationHelper.ZK_CONNECTION_STRING);
		zk.watchOnQuorumSyncNodes();
		
		Thread thrBalance = new Thread(new Runnable() {
			public void run()
			{
				threadBalanceFun();
			}
		});

		thrBalance.start();

	}

	// / <summary>
	// / thread balance function
	// / </summary>
	private static void threadBalanceFun()
	{
		while (true)
		{
			try
			{
				Thread.sleep(ConfigurationHelper.UPDATE_MB_BALANCE);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			try
			{
				StringBuilder sb = new StringBuilder();

				long selectTime = 0;
				long syncTime = 0;
				long updateTime = 0;

				if (bActive.get() == false)
				{
					continue;
				} else {
					logger.info("[slave] Update thread is runing!");
				}
				
				if (TryLockDbFromLocal.getInstance().tryLock() == false)
				{
					continue;
				} else {
					logger.info("[slave] Got lock from sync_lock_ctrl!");
				}

				long slave_select = new Date().getTime();
				List<BalanceObj> mbbo = SelectDbFromLocal.getInstance().select(); // 从DB中获得需要传输的mediabuy
																					// balance
																					// 数据
				logger.info(String.format("[Slave.ThreadBalanceFun] select from syncdb:{%d}", mbbo != null ? mbbo.size() : 0));
                
				selectTime = new Date().getTime() - slave_select;

				ShowBalanceObj.show(mbbo, "Slave.ThreadBalanceFun.A", logger); // log

				if (null != mbbo)
				{
					// 传输给master
					long slave_sync = new Date().getTime();
					List<BalanceObj> retmbbo = UpdateBalance.getInstance().updateBalanceToMaster(mbbo, ConfigurationHelper.TARGET_SERVICE_ADDRESS, null);
					syncTime = new Date().getTime() - slave_sync;

					ShowBalanceObj.show(retmbbo, "Slave.ThreadBalanceFun.B", logger); // log

					if (null != retmbbo)
					{
						List<BalanceObj> successBal = new ArrayList<BalanceObj>();
                        for(BalanceObj ret : retmbbo)
                        {
                            if (ret.Status == (int) SyncStatusType.SYNC_SUCCESS.getValue())
                            {
                            	successBal.add(ret);
                            }
                        }
						logger.info(String.format("[Slave.ThreadBalanceFun] update syncdb from master:{%d},success:{%d}", 
								retmbbo != null ? retmbbo.size() : 0, successBal != null ? successBal.size() : 0));
 
						long slave_updatefrommaster = new Date().getTime();
						UpdateDbFromMaster.getInstance().UpdateFromMaster(successBal); // 将来自master更新成功的数据更新至本地DB
						updateTime = new Date().getTime() - slave_updatefrommaster;

						ShowBalanceObj.show(successBal, "Slave.ThreadBalanceFun.C", logger); // log
					}
				}

				logger.info(String.format("[Slave.ThreadBalanceFun]:time(milli):%d,%d,%d", (long) selectTime, (long) syncTime, (long) updateTime));
				
				TryLockDbFromLocal.getInstance().unLock();
				logger.info("[slave] Release lock from sync_lock_ctrl!");
			} catch (Exception ex)
			{
				TryLockDbFromLocal.getInstance().unLock();
				logger.info("[slave] Release lock from sync_lock_ctrl!");
				
				String temp = String.format("[Slave.ThreadBalanceFun]:%s", ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			} finally
			{
				bActive.set(false);
			}
		}
	}

	// / <summary>
	// / heart test
	// / </summary>
	// / <returns>always true</returns>
	public boolean ping()
	{
		return true;
	}

	// / <summary>
	// / 由adserver传输过来的balance数据
	// / </summary>
	// / <param name="_info">来自adserver的经过序列化和压缩的数据结构</param>
	// / <param name="dbType">db标识</param>
	// / <returns>update&merge后的数据结构</returns>
	public TransferInfo syncBalance(TransferInfo info, int dbType)
	{
		StringBuilder sb = new StringBuilder();
		int size = 0;
		long time = 0;
		TransferInfo bi = null;
		try
		{
			sb.append(String.format("[slave syncbalance]:dbType:%d,", dbType));

			bi = info;
			sb.append(String.format("[slave syncbalance]:syncBalance size:%d (bytes),", bi.getData().getData().length));
			Balance mbb = (Balance) new DbSerializeService().deSerializefromBytes(bi.getData().getData(), BinaryType.BALANCE);

			if (mbb.IsValidVersion()) // 判断版本是否有效
			{
				if (ConfigurationHelper.USE_MEMORY_CACHE)
				{
					MemoryFromServer.getInstance().updateFromServer(mbb.mbObj); // 往slave本地的memorycache写数据
				} else
				{
					UpdateDbFromServer.getInstance().updateFromServer(mbb.mbObj); // 往slave本地的DB写数据
				}
				// 将获得返回的值重新传回adserver
				byte[] bytes = new DbSerializeService().serializeToBytes(mbb, BinaryType.BALANCE);
				bi.setVersion(SLAVESYNCVERSION);
				bi.setType(BinaryType.BALANCE.getValue());
				bi.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(SLAVESYNCVERSION);
				biData.setType(BinaryType.BALANCE);
				biData.setData(bytes);
				biData.setLength(bytes.length);
				bi.setData(biData);
				size = bytes.length;
			} else
			{
				sb.append("The version of struct is invalid!");
			}
		} catch (Exception ex)
		{
			String temp = String.format("[SyncBalance]:{0}", ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			logger.info(sb.toString());
		}
		return bi;
	}

	// / <summary>
	// / 根据adserver的时间要求，获得并返回load数据
	// / </summary>
	// / <param name="fromTime">更新起始时间</param>
	// / <param
	// name="toTime">更新结束时间,如果adserver的totime超越了slave的更新时间，则已slave的更新时间为totime，并返回这个值</param>
	// / <param name="dbType">db标识</param>
	// / <returns>返回一个经过序列化和压缩的数据结构</returns>
	public TransferInfo load(String fromTime, String toTime, int dbType)
	{
		StringBuilder sb = new StringBuilder();
		int size = 0;
		long time = 0;
		TransferInfo di = null;
		byte[] tempBytes = null;
		Date fromDate = DateUtil.parseDate(fromTime, "yyyy-MM-dd HH:mm:ss");
		Date toDate = DateUtil.parseDate(toTime, "yyyy-MM-dd HH:mm:ss");

		try
		{
			sb.append(String.format("[slave load]:fromtime:%s,totime:%s,dbtype:%d,", fromDate, toDate, dbType));
			long slave_load = new Date().getTime();

			di = new TransferInfo();
			if (dbType == SyncDbListType.ADMANAGE.getValue())
			{
				AdManagerContext admContext = (AdManagerContext) DbDataManager.getInstance().getLoad(dbType, fromDate, toDate);
				tempBytes = new DbSerializeService().serializeToBytes(admContext, BinaryType.ADMANAGER);
				di.setVersion(SLAVESYNCVERSION);
				di.setType(BinaryType.ADMANAGER.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(SLAVESYNCVERSION);
				biData.setType(BinaryType.ADMANAGER);
				biData.setData(tempBytes);
				biData.setLength(tempBytes.length);
				di.setData(biData);
				size = tempBytes.length;
			}

			if (dbType == SyncDbListType.MENLO.getValue())
			{

			}
			if (dbType == SyncDbListType.DSP.getValue())
			{
				DspContext dspContext = (DspContext) DbDataManager.getInstance().getLoad(dbType, fromDate, toDate);
				tempBytes = new DbSerializeService().serializeToBytes(dspContext, BinaryType.DSP);
				di.setVersion(SLAVESYNCVERSION);
				di.setType(BinaryType.DSP.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(SLAVESYNCVERSION);
				biData.setType(BinaryType.DSP);
				biData.setData(tempBytes);
				biData.setLength(tempBytes.length);
				di.setData(biData);
				size = tempBytes.length;
			}

			time = new Date().getTime() - slave_load;
			sb.append(String.format("realtime:%s,size:%d,runtime:%d,", toDate, size, (long) time));
		} catch (Exception ex)
		{
			String temp = String.format("[Load]:{0}", ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			logger.info(sb.toString());
		}
		return di;
	}

	// / <summary>
	// / 根据adserver的时间要求，获得并返回unload数据
	// / </summary>
	// / <param name="fromTime">更新起始时间</param>
	// / <param
	// name="toTime">更新结束时间,如果adserver的totime超越了slave的更新时间，则已slave的更新时间为totime，并返回这个值</param>
	// / <param name="dbType">db标识</param>
	// / <returns>返回一个经过序列化和压缩的数据结构</returns>
	public TransferInfo unLoad(String fromTime, String toTime, int dbType)
	{
		StringBuilder sb = new StringBuilder();
		int size = 0;
		long time = 0;
		TransferInfo di = null;
		byte[] tempBytes = null;
		Date fromDate = DateUtil.parseDate(fromTime, "yyyy-MM-dd HH:mm:ss");
		Date toDate = DateUtil.parseDate(toTime, "yyyy-MM-dd HH:mm:ss");

		try
		{
			sb.append(String.format("[slave unload]:fromtime:%s,totime:%s,dbtype:%d,", fromDate, toDate, dbType));

			long slave_unload = new Date().getTime();
			di = new TransferInfo();

			if (dbType == SyncDbListType.ADMANAGE.getValue())
			{
				AdManagerContext admContext = (AdManagerContext) DbDataManager.getInstance().getUnload(dbType, fromDate, toDate);
				tempBytes = new DbSerializeService().serializeToBytes(admContext, BinaryType.ADMANAGER);
				di.setVersion(SLAVESYNCVERSION);
				di.setType(BinaryType.ADMANAGER.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(SLAVESYNCVERSION);
				biData.setType(BinaryType.ADMANAGER);
				biData.setData(tempBytes);
				biData.setLength(tempBytes.length);
				di.setData(biData);
				size = tempBytes.length;
			}

			if (dbType == SyncDbListType.MENLO.getValue())
			{
			}
			if (dbType == SyncDbListType.DSP.getValue())
			{
				DspContext dspContext = (DspContext) DbDataManager.getInstance().getUnload(dbType, fromDate, toDate);
				tempBytes = new DbSerializeService().serializeToBytes(dspContext, BinaryType.DSP);
				di.setVersion(SLAVESYNCVERSION);
				di.setType(BinaryType.DSP.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(SLAVESYNCVERSION);
				biData.setType(BinaryType.DSP);
				biData.setData(tempBytes);
				biData.setLength(tempBytes.length);
				di.setData(biData);
				size = tempBytes.length;
			}

			time = new Date().getTime() - slave_unload;
			sb.append(String.format("realtime:%s,size:%d,runtime:%d,", toDate, size, (long) time));
		} catch (Exception ex)
		{
			String temp = String.format("[Unload]:{0}", ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			logger.info(sb.toString());
		}
		return di;
	}

	public void flag(String flg)
	{
		DbDataManager.getInstance().showLog(flg);
	}

}
