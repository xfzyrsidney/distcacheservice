package com.sidney.dbsyncserver.syncinstance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;

import com.adchina.utils.DateUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.dbaccess.admanager.AdManagerContext;
import com.sidney.dbsyncserver.dbaccess.admanager.AdManagerDbAccess;
import com.sidney.dbsyncserver.dbaccess.dsp.DspContext;
import com.sidney.dbsyncserver.dbaccess.dsp.DspDbAccess;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;
import com.sidney.dbsyncserver.syncinterface.BinaryData;
import com.sidney.dbsyncserver.syncinterface.BinaryType;
import com.sidney.dbsyncserver.syncinterface.IMaster;
import com.sidney.dbsyncserver.syncinterface.TransferInfo;
import com.sidney.dbsyncserver.syncmodel.Balance;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.syncmodel.ListNameType;
import com.sidney.dbsyncserver.syncmodel.SyncDbListType;
import com.sidney.dbsyncserver.syncstruct.balanceoperation.*;
import com.sidney.dbsyncserver.tserializ.balance.TBalance;
import com.sidney.dbsyncserver.tserializ.balance.TBalanceObj;
import com.sidney.dbsyncserver.tserializ.common.DbSerializeService;
import com.sidney.dbsyncserver.utils.SendMailService;

public class MasterSync implements IMaster.Iface
{

	private static Log logger = LogFactory.getLog(MasterSync.class);

	private static final int MASTERSYNCVERSION = 10;
			
	// / <summary>
	// / heart test
	// / </summary>
	// / <returns>always true</returns>
	public boolean ping() throws TException
	{
		return true;
	}

	// / <summary>
	// / 根据slave server的时间要求，获得并返回load数据
	// / </summary>
	// / <param name="_fromTime">更新起始时间 ，格式"yyyy-MM-dd HH:mm:ss"</param>
	// / <param name="_toTime">更新结束时间，格式"yyyy-MM-dd HH:mm:ss"</param>
	// / <param name="_dbType">db标识</param>
	// / <returns>返回一个经过序列化和压缩的数据结构</returns>
	public TransferInfo load(String fromTime, String toTime, int dbType) throws TException
	{
		logger.info("[master load]:begin!");

		StringBuilder sb = new StringBuilder();
		TransferInfo di = new TransferInfo();
		int size = 0;
		byte[] tempBytes = null;
		long time = 0;
		Date fromDate = DateUtil.parseDate(fromTime, "yyyy-MM-dd HH:mm:ss");
		Date toDate = DateUtil.parseDate(toTime, "yyyy-MM-dd HH:mm:ss");
		try
		{
			sb.append(String.format("[master load]:end! fromtime:{%s},totime:{%s},dbType:{%s},", fromDate, toDate, String.valueOf(dbType)));
			long master_load = new Date().getTime();

			if (dbType == SyncDbListType.ADMANAGE.getValue())
			{
				AdManagerContext admcontext = AdManagerDbAccess.getInstance().load(fromDate, toDate);
				admcontext.toTime = toDate;
				tempBytes = new DbSerializeService().serializeToBytes(admcontext, BinaryType.ADMANAGER);
				di.setVersion(MASTERSYNCVERSION);
				di.setType(BinaryType.ADMANAGER.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(MASTERSYNCVERSION);
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
				DspContext dspcontext = DspDbAccess.getInstance().load(fromDate, toDate);
				dspcontext.toTime = toDate;
				tempBytes = new DbSerializeService().serializeToBytes(dspcontext, BinaryType.DSP);
				di.setVersion(MASTERSYNCVERSION);
				di.setType(BinaryType.DSP.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(MASTERSYNCVERSION);
				biData.setType(BinaryType.DSP);
				biData.setData(tempBytes);
				biData.setLength(tempBytes.length);
				di.setData(biData);
				size = tempBytes.length;
			}

			time = new Date().getTime() - master_load;
			sb.append(String.format("size:%s,runtime:%s", String.valueOf(size), String.valueOf(time)));
		} catch (Exception ex)
		{
			di = null;

			String temp = String.format("[Load]:%s", ex.getMessage());
			logger.error(temp, ex);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			logger.info(sb.toString());
		}
		return di;
	}

	// / <summary>
	// / 根据slave server的时间要求，获得并返回unload数据
	// / </summary>
	// / <param name="_fromTime">更新起始时间</param>
	// / <param name="_toTime">更新结束时间</param>
	// / <param name="_dbType">db标识</param>
	// / <returns>返回一个经过序列化和压缩的数据结构</returns>
	public TransferInfo unLoad(String fromTime, String toTime, int dbType) throws TException
	{
		logger.info(String.format("[master unload]:begin!"));

		StringBuilder sb = new StringBuilder();
		byte[] tempBytes = null;
		TransferInfo di = new TransferInfo();
		int size = 0;
		long time = 0;
		Date fromDate = DateUtil.parseDate(fromTime, "yyyy-MM-dd HH:mm:ss");
		Date toDate = DateUtil.parseDate(toTime, "yyyy-MM-dd HH:mm:ss");
		try
		{
			sb.append(String.format("[master unload]:end! fromtime:{%s},totime:{%s},dbType:{%s},", fromDate, toDate, String.valueOf(dbType)));
			long master_unload = new Date().getTime();

			if (dbType == SyncDbListType.ADMANAGE.getValue())
			{
				AdManagerContext admcontext = AdManagerDbAccess.getInstance().unLoad(fromDate, toDate);
				admcontext.toTime = toDate;
				tempBytes = new DbSerializeService().serializeToBytes(admcontext, BinaryType.ADMANAGER);
				di.setVersion(MASTERSYNCVERSION);
				di.setType(BinaryType.ADMANAGER.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(MASTERSYNCVERSION);
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
				DspContext dspcontext = DspDbAccess.getInstance().unLoad(fromDate, toDate);
				dspcontext.toTime = toDate;
				tempBytes = new DbSerializeService().serializeToBytes(dspcontext, BinaryType.DSP);
				di.setVersion(MASTERSYNCVERSION);
				di.setType(BinaryType.DSP.getValue());
				di.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(MASTERSYNCVERSION);
				biData.setType(BinaryType.DSP);
				biData.setData(tempBytes);
				biData.setLength(tempBytes.length);
				di.setData(biData);
				size = tempBytes.length;
			}

			time = new Date().getTime() - master_unload;
			sb.append(String.format("size:%s,runtime:%s", String.valueOf(size), String.valueOf(time)));
		} catch (Exception ex)
		{
			di = null;
			String temp = String.format("[UnLoad]:%s", ex);
			logger.error(temp, ex);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			logger.info(sb.toString());
		}
		return di;
	}

	// / <summary>
	// / 根据slave server的要求，更新balance，并返回merge&update后的balance数据
	// / </summary>
	// / <param name="_info">来自slave的经过序列化和压缩的数据结构</param>
	// / <param name="_dbType">db标识</param>
	// / <returns>update&merge后的数据结构</returns>
	public TransferInfo syncBalance(TransferInfo _info, int _dbType) throws TException
	{
		StringBuilder sb = new StringBuilder();
		int size = 0;
		long time = 0;
		TransferInfo bi = null;

		try
		{
			sb.append(String.format("[master syncbalance]:dbType:%s,", String.valueOf(_dbType)));
			long master_update = new Date().getTime();
			bi = _info;
			sb.append(String.format("[master syncbalance]:syncBalance size:%d (bytes),", bi.getData().getData().length));
			Balance mbb = (Balance) new DbSerializeService().deSerializefromBytes(bi.getData().getData(), BinaryType.BALANCE);

			if (mbb.IsValidVersion())// 判断版本是否有效
			{
				HashMap<ListNameType, List<BalanceObj>> listObj = parseData(mbb.mbObj);
				for (ListNameType lt : listObj.keySet())
				{
					switch (lt)
					{
						

						case ADMANAGE_AD_SPACE_PV:
							UpdateAdSpacePV.getInstance().update(listObj.get(lt));
							break;

						case ADMANAGE_AD_SPACE_CLICK:
							UpdateAdSpaceClick.getInstance().update(listObj.get(lt));
							break;

					
						default:
							break;
					}
				}
				byte[] bytes = new DbSerializeService().serializeToBytes(mbb, BinaryType.BALANCE);
				bi.setVersion(MASTERSYNCVERSION);
				bi.setType(BinaryType.BALANCE.getValue());
				bi.setStatus(1);
				BinaryData biData = new BinaryData();
				biData.setVersion(MASTERSYNCVERSION);
				biData.setType(BinaryType.BALANCE);
				biData.setData(bytes);
				biData.setLength(bytes.length);
				bi.setData(biData);
				size = bytes.length;
			} else
			{
				sb.append("The version of struct is invalid!");
			}

			time = new Date().getTime() - master_update;
			sb.append(String.format("size:%s,runtime:%s", String.valueOf(size), String.valueOf(time)));
		} catch (Exception ex)
		{
			String temp = String.format("[SyncBalance]:%s", ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			logger.info(sb.toString());
		}

		return bi;
	}

	// / <summary>
	// / 分解数据，将更新同一个表的数据整理在一个list中
	// / </summary>
	// / <param name="_listObj"></param>
	// / <returns></returns>
	public static HashMap<ListNameType, List<BalanceObj>> parseData(List<BalanceObj> _listObj)
	{
		HashMap<ListNameType, List<BalanceObj>> ret = new HashMap<ListNameType, List<BalanceObj>>();
		try
		{
			for (BalanceObj obj : _listObj)
			{

				if (ListNameType.ADMANAGE_MEDIA_BUY.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.ADMANAGE_MEDIA_BUY))
					{
						ret.put(ListNameType.ADMANAGE_MEDIA_BUY, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.ADMANAGE_MEDIA_BUY).add(obj);
				}

				if (ListNameType.ADMANAGE_RTB_TANX_BUDGET.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.ADMANAGE_RTB_TANX_BUDGET))
					{
						ret.put(ListNameType.ADMANAGE_RTB_TANX_BUDGET, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.ADMANAGE_RTB_TANX_BUDGET).add(obj);
				}

				if (ListNameType.DSP_CAMPAIGN_MONEY.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_CAMPAIGN_MONEY))
					{
						ret.put(ListNameType.DSP_CAMPAIGN_MONEY, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_CAMPAIGN_MONEY).add(obj);
				}

				if (ListNameType.DSP_CAMPAIGN_KPI.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_CAMPAIGN_KPI))
					{
						ret.put(ListNameType.DSP_CAMPAIGN_KPI, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_CAMPAIGN_KPI).add(obj);
				}

				if (ListNameType.DSP_STRATEGY_MONEY.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_STRATEGY_MONEY))
					{
						ret.put(ListNameType.DSP_STRATEGY_MONEY, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_STRATEGY_MONEY).add(obj);
				}

				if (ListNameType.ADMANAGE_AD_SPACE_PV.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.ADMANAGE_AD_SPACE_PV))
					{
						ret.put(ListNameType.ADMANAGE_AD_SPACE_PV, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.ADMANAGE_AD_SPACE_PV).add(obj);
				}
				if (ListNameType.ADMANAGE_AD_SPACE_CLICK.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.ADMANAGE_AD_SPACE_CLICK))
					{
						ret.put(ListNameType.ADMANAGE_AD_SPACE_CLICK, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.ADMANAGE_AD_SPACE_CLICK).add(obj);
				}
				if (ListNameType.ADMANAGE_AD_SPACE_MONEY.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.ADMANAGE_AD_SPACE_MONEY))
					{
						ret.put(ListNameType.ADMANAGE_AD_SPACE_MONEY, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.ADMANAGE_AD_SPACE_MONEY).add(obj);
				}
				if (ListNameType.ADMANAGE_MEDIA_BUY_MONEY.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.ADMANAGE_MEDIA_BUY_MONEY))
					{
						ret.put(ListNameType.ADMANAGE_MEDIA_BUY_MONEY, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.ADMANAGE_MEDIA_BUY_MONEY).add(obj);
				}
				if (ListNameType.DSP_STRATEGY_KPI.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_STRATEGY_KPI))
					{
						ret.put(ListNameType.DSP_STRATEGY_KPI, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_STRATEGY_KPI).add(obj);
				}
				if (ListNameType.MENLO_MEDIA_BUY.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.MENLO_MEDIA_BUY))
					{
						ret.put(ListNameType.MENLO_MEDIA_BUY, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.MENLO_MEDIA_BUY).add(obj);
				}
				
				if (ListNameType.DSP_CAMPAIGN_CLICK.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_CAMPAIGN_CLICK))
					{
						ret.put(ListNameType.DSP_CAMPAIGN_CLICK, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_CAMPAIGN_CLICK).add(obj);
				}
				if (ListNameType.DSP_CAMPAIGN_PV.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_CAMPAIGN_PV))
					{
						ret.put(ListNameType.DSP_CAMPAIGN_PV, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_CAMPAIGN_PV).add(obj);
				}
				if (ListNameType.DSP_MEDIA_BUY_CLICK.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_MEDIA_BUY_CLICK))
					{
						ret.put(ListNameType.DSP_MEDIA_BUY_CLICK, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_MEDIA_BUY_CLICK).add(obj);
				}
				if (ListNameType.DSP_MEDIA_BUY_PV.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_MEDIA_BUY_PV))
					{
						ret.put(ListNameType.DSP_MEDIA_BUY_PV, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_MEDIA_BUY_PV).add(obj);
				}
				if (ListNameType.DSP_STRATEGY_GROUP_MONEY.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_STRATEGY_GROUP_MONEY))
					{
						ret.put(ListNameType.DSP_STRATEGY_GROUP_MONEY, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_STRATEGY_GROUP_MONEY).add(obj);
				}
				if (ListNameType.DSP_STRATEGY_GROUP_CLICK.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_STRATEGY_GROUP_CLICK))
					{
						ret.put(ListNameType.DSP_STRATEGY_GROUP_CLICK, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_STRATEGY_GROUP_CLICK).add(obj);
				}
				if (ListNameType.DSP_STRATEGY_GROUP_PV.getValue() == obj.ListName)
				{
					if (!ret.containsKey(ListNameType.DSP_STRATEGY_GROUP_PV))
					{
						ret.put(ListNameType.DSP_STRATEGY_GROUP_PV, new ArrayList<BalanceObj>());
					}
					ret.get(ListNameType.DSP_STRATEGY_GROUP_PV).add(obj);
				}
			}
		} catch (Exception ex)
		{
		}
		return ret;
	}

	public String getDbTime(int dbType) throws TException
	{
		try
		{
			String dataSource = "";
			if (dbType == SyncDbListType.ADMANAGE.getValue())
			{
				dataSource = ConfigurationHelper.ADMANAGERDATASOURCE;
			}
			if (dbType == SyncDbListType.MENLO.getValue())
			{
				dataSource = ConfigurationHelper.MENLODATASOURCE;
			}
			if (dbType == SyncDbListType.DSP.getValue())
			{
				dataSource = ConfigurationHelper.DSPDATASOURCE;
			}
			OracleDBConnection oracDbcon = new OracleDBConnection(dataSource);
			oracDbcon.getConnection();
			Date date = oracDbcon.getDatabaseTime();
			oracDbcon.dispose();
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception ex)
		{
			String temp = String.format("[GetDbTime]:{%s}", ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		}
		return DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

}
