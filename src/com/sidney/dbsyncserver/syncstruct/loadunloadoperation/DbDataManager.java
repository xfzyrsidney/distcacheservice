package com.sidney.dbsyncserver.syncstruct.loadunloadoperation;

import java.util.Date;
import java.util.HashMap;
import java.lang.String;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.utils.DateUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.dbaccess.admanager.AdManagerContext;
import com.sidney.dbsyncserver.dbaccess.admanager.AdManagerContextFun;
import com.sidney.dbsyncserver.dbaccess.dsp.DspContext;
import com.sidney.dbsyncserver.dbaccess.dsp.DspContextFun;
import com.sidney.dbsyncserver.syncmodel.SyncDbListType;
import com.sidney.dbsyncserver.syncstruct.common.UpdateDbFromMaster;
import com.sidney.dbsyncserver.syncstruct.common.UpdateDbFromServer;
import com.sidney.dbsyncserver.update.LoadUnLoadDb;
import com.sidney.dbsyncserver.utils.SendMailService;

public class DbDataManager
{
	private static Log logger = LogFactory.getLog(DbDataManager.class);
	private Object lockObj = new Object();
	private static DbDataManager thisInstance = new DbDataManager();

	public static DbDataManager getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (DbDataManager.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new DbDataManager();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	
	private HashMap<Integer, Date> BeginTime = new HashMap<Integer, Date>();
	public HashMap<Integer, Object> LoadData = new HashMap<Integer, Object>();
	public HashMap<Integer, Object> UnloadData = new HashMap<Integer, Object>();

	private DbDataManager()
	{
		BeginTime.put((int) SyncDbListType.ADMANAGE.getValue(), DateUtil.parseDate("2007-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		BeginTime.put((int) SyncDbListType.MENLO.getValue(), DateUtil.parseDate("2007-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		BeginTime.put((int) SyncDbListType.DSP.getValue(), DateUtil.parseDate("2007-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));

		try
		{
			Thread thrLoad = new Thread(new Runnable() {
				public void run()
				{
					threadLoadFun();
				}
			});

			thrLoad.start();
		} catch (Exception ex)
		{
			String temp = String.format("[DbDataManager]:%s", ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		}
	}

	// / <summary>
	// / thread load function
	// / </summary>
	public void threadLoadFun()
	{
		while (true)
		{
			try
			{
				if (ConfigurationHelper.LOAD_DATA_SERIAL_NUMBER.contains((int) SyncDbListType.ADMANAGE.getValue()))
				{
					logger.info("[LoadAdManage]");
					DbDataManager.getInstance().LoadAdManage();
				}
				if (ConfigurationHelper.LOAD_DATA_SERIAL_NUMBER.contains((int) SyncDbListType.MENLO.getValue()))
				{
					logger.info("[LoadMenlo]");
					DbDataManager.getInstance().LoadMenlo();
				}
				if (ConfigurationHelper.LOAD_DATA_SERIAL_NUMBER.contains((int) SyncDbListType.DSP.getValue()))
				{
					logger.info("[LoadDsp]");
					DbDataManager.getInstance().LoadDsp();
				}
			} catch (Exception ex)
			{
				String temp = String.format("[ThreadLoadFun]:%s", ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			} finally
			{
			}

			try
			{
				Thread.sleep(ConfigurationHelper.LOAD_DB_FROM_MASTER);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	// / <summary>
	// / 从master获得admanage's db数据
	// /
	// 第一次load，并不是按照begintime进行load的，而是按照每个表的Attribute中的InitFromDateTime作为from进行load的。
	// / </summary>
	public void LoadAdManage()
	{
		try
		{
			Date from = BeginTime.get(SyncDbListType.ADMANAGE.getValue());
			Date to = new Date(new Date().getTime() - ConfigurationHelper.DATA_TIMESPAN);
			logger.info(String.format("[LoadAdManage]:Load fromtime:%s, totime:%s", from, to));

			AdManagerContext unloadData = ((AdManagerContext) get((int) SyncDbListType.ADMANAGE.getValue(), this.UnloadData)); // 从内存中获得unload数据
			if (unloadData == null)
			{
				unloadData = new AdManagerContext();
			}
			// unloadData.ListSort();// 按时间排序
			AdManagerContext unloaddc = (AdManagerContext) LoadUnLoadDb.getInstance().unloadFromMaster(from, to, (int) SyncDbListType.ADMANAGE.getValue(), ConfigurationHelper.TARGET_SERVICE_ADDRESS); // 增量

			logger.info(String.format("[LoadAdManage]:Unload end!"));

			AdManagerContext loadData = ((AdManagerContext) get((int) SyncDbListType.ADMANAGE.getValue(), this.LoadData)); // 从内存中获得load数据
			if (loadData == null)
			{
				loadData = new AdManagerContext();
			}

			// loadData.ListSort();// 按时间排序
			AdManagerContext loaddc = (AdManagerContext) LoadUnLoadDb.getInstance().loadFromMaster(from, to, (int) SyncDbListType.ADMANAGE.getValue(), ConfigurationHelper.TARGET_SERVICE_ADDRESS); // 增量

			logger.info(String.format("[LoadAdManage]:Load end!"));

			// unloadData.RemoveFromList(loaddc); //删除unload数据中又load的
			AdManagerContextFun.removeFromList(unloadData, loaddc);
			// loadData.RemoveFromList(unloaddc); //删除load数据中被unload的
			AdManagerContextFun.removeFromList(loadData, unloaddc);

			logger.info(String.format("[LoadAdManage]:RemoveFromList end!"));

			// unloadData.AddFromList(unloaddc);
			unloadData = AdManagerContextFun.addFromList(unloadData, unloaddc);
			add((int) SyncDbListType.ADMANAGE.getValue(), this.UnloadData, unloadData);

			logger.info(String.format("[LoadAdManage]:Add unload data end!"));

			// loadData.AddFromList(loaddc);
			loadData = AdManagerContextFun.addFromList(loadData, loaddc);
			add((int) SyncDbListType.ADMANAGE.getValue(), this.LoadData, loadData);

			logger.info(String.format("[LoadAdManage]:Add load data end!"));

			BeginTime.put(SyncDbListType.ADMANAGE.getValue(), to);

			logger.info(String.format("[LoadAdManage]:next load from time:%s", BeginTime.get(SyncDbListType.ADMANAGE.getValue())));
		} catch (Exception ex)
		{
			logger.error(ex);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave.LoadAdManage %s] Error", ConfigurationHelper.SERVICE_ADDRESS), ex.toString());
		} finally
		{

		}
	}

	// / <summary>
	// / 从master获得menlo's db数据
	// / </summary>
	public void LoadMenlo()
	{
		// TODO...
	}

	// / <summary>
	// / 从master获得dsp's db数据
	// / </summary>
	public void LoadDsp()
	{
		try
		{
			Date from = BeginTime.get(SyncDbListType.DSP.getValue());
			Date to = new Date(new Date().getTime() - ConfigurationHelper.DATA_TIMESPAN);
			logger.info(String.format("[LoadDsp]:Load fromtime:%s, totime:%s", from, to));

			DspContext unloadData = ((DspContext) get((int) SyncDbListType.DSP.getValue(), this.UnloadData)); // 从内存中获得unload数据
			if (unloadData == null)
			{
				unloadData = new DspContext();
			}

			// unloadData.ListSort();// 按时间排序
			DspContext unloaddc = (DspContext) LoadUnLoadDb.getInstance().unloadFromMaster(from, to, (int) SyncDbListType.DSP.getValue(), ConfigurationHelper.TARGET_SERVICE_ADDRESS); // 增量

			logger.info(String.format("[LoadDsp]:Unload end!"));

			DspContext loadData = ((DspContext) get((int) SyncDbListType.DSP.getValue(), this.LoadData)); // 从内存中获得load数据
			if (loadData == null)
			{
				loadData = new DspContext();
			}
			// loadData.ListSort();// 按时间排序
			DspContext loaddc = (DspContext) LoadUnLoadDb.getInstance().loadFromMaster(from, to, (int) SyncDbListType.DSP.getValue(), ConfigurationHelper.TARGET_SERVICE_ADDRESS); // 增量

			logger.info(String.format("[LoadDsp]:Load end!"));

			// unloadData.RemoveFromList(loaddc); //删除unload数据中又load的
			DspContextFun.removeFromList(unloadData, loaddc);
			// loadData.RemoveFromList(unloaddc); //删除load数据中被unload的
			DspContextFun.removeFromList(loadData, unloaddc);

			logger.info("[LoadDsp]:RemoveFromList end!");

			// unloadData.AddFromList(unloaddc);
			unloadData = DspContextFun.addFromList(unloadData, unloaddc);
			add((int) SyncDbListType.DSP.getValue(), this.UnloadData, unloadData);

			logger.info(String.format("[LoadDsp]:Add unload data end!"));

			// loadData.AddFromList(loaddc);
			loadData = DspContextFun.addFromList(loadData, loaddc);
			add((int) SyncDbListType.DSP.getValue(), this.LoadData, loadData);

			logger.info(String.format("[LoadDsp]:Add load data end!"));

			BeginTime.put(SyncDbListType.DSP.getValue(), to);

			logger.info(String.format("[LoadDsp]:next load from time:%s", BeginTime.get(SyncDbListType.DSP.getValue())));
		} catch (Exception ex)
		{
			logger.error(ex);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Slave.LoadDsp %s] Error", ConfigurationHelper.SERVICE_ADDRESS), ex.toString());
		} finally
		{

		}
	}

	public void showLog(String _t)
	{
		StringBuffer sb = new StringBuffer();

		for (int Key : this.UnloadData.keySet())
		{

			if (Key == SyncDbListType.ADMANAGE.getValue())
			{
				// sb.AppendFormat("[Unload Data]:ADMANAGE flag:{0}\r\n",
				// A.Key.ToString());
				// sb.Append(ShowLog<AdManagerContext>((AdManagerContext)A.Value,
				// _t));
			}

			if (Key == SyncDbListType.MENLO.getValue())
			{

			}
			if (Key == SyncDbListType.DSP.getValue())
			{
				sb.append(String.format("[Unload Data]:DSP flag:%d\r\n", Key));
				sb.append(showLog((DspContext) this.UnloadData.get(Key), _t));
			}
			break;

		}
		logger.info(sb.toString());

		sb = new StringBuffer();
		for (int Key : this.LoadData.keySet())
		{

			if (Key == SyncDbListType.ADMANAGE.getValue())
			{
				// sb.AppendFormat("[Load Data]:ADMANAGE flag:{0}\r\n",
				// B.Key.ToString());
				// sb.Append(ShowLog<AdManagerContext>((AdManagerContext)B.Value,
				// _t));
			}

			if (Key == SyncDbListType.MENLO.getValue())
			{

			}
			if (Key == SyncDbListType.DSP.getValue())
			{
				sb.append(String.format("[LoadData Data]:DSP flag:%d\r\n", Key));
				sb.append(showLog((DspContext) this.LoadData.get(Key), _t));
			}

		}

		logger.info(sb.toString());
	}

	private String showLog(AdManagerContext _dc, String _t)
	{
		return "";
	}

	private String showLog(DspContext _dc, String _t)
	{
		return "";
	}

	public Object getLoad(int _type, Date _fromTime, Date _toTime)
	{
		try
		{
			synchronized (this.LoadData)
			{
				if (_fromTime.compareTo(BeginTime.get(_type)) >= 0)
				{
					_toTime = (Date) BeginTime.get(_type).clone();
					return null;
				}
				if (_toTime.compareTo(BeginTime.get(_type)) > 0)
				{
					_toTime = (Date) BeginTime.get(_type).clone();
				}

				if (this.LoadData.containsKey(_type))
				{

					if (_type == SyncDbListType.ADMANAGE.getValue())
					{
						return AdManagerContextFun.getSpecifiedData((AdManagerContext) this.LoadData.get(_type), _fromTime, _toTime);
					}
					if (_type == SyncDbListType.MENLO.getValue())
					{

					}
					if (_type == SyncDbListType.DSP.getValue())
					{
						return DspContextFun.getSpecifiedData((DspContext) this.LoadData.get(_type), _fromTime, _toTime);
					}

				}
			}
		} catch (Exception ex)
		{
			logger.error(ex);
		}
		return null;
	}

	public Object getUnload(int _type, Date _fromTime, Date _toTime)
	{
		try
		{
			synchronized (this.UnloadData)
			{
				if (_fromTime.compareTo(BeginTime.get(_type)) >= 0)
				{
					_toTime = (Date) BeginTime.get(_type).clone();
					return null;
				}
				if (_toTime.compareTo(BeginTime.get(_type)) > 0)
				{
					_toTime = (Date) BeginTime.get(_type).clone();
				}

				if (this.UnloadData.containsKey(_type))
				{

					if (_type == SyncDbListType.ADMANAGE.getValue())
					{
						return AdManagerContextFun.getSpecifiedData((AdManagerContext) this.UnloadData.get(_type), _fromTime, _toTime);
					}
					if (_type == SyncDbListType.MENLO.getValue())
					{

					}
					if (_type == SyncDbListType.DSP.getValue())
					{
						return DspContextFun.getSpecifiedData((DspContext) this.UnloadData.get(_type), _fromTime, _toTime);
					}
				}
			}
		} catch (Exception ex)
		{
			logger.error(ex);
		}
		return null;
	}

	private void add(int _type, HashMap<Integer, Object> _org, Object _addObj)
	{
		synchronized (_org)
		{
			_org.put(_type, _addObj);

		}
	}

	private Object get(int _type, HashMap<Integer, Object> _org)
	{
		synchronized (_org)
		{
			if (_org.containsKey(_type))
			{
				return _org.get(_type);
			}
		}
		return null;
	}

	private void remove(int _type, HashMap<Integer, Object> _org)
	{
		synchronized (_org)
		{
			if (_org.containsKey(_type))
			{
				_org.remove(_type);
			}
		}
	}
}
