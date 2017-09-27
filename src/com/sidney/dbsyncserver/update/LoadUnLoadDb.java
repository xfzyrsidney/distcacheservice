package com.sidney.dbsyncserver.update;

import java.util.Date;









import com.adchina.utils.DateUtil;
import com.sidney.dbsyncserver.syncinterface.BinaryType;
import com.sidney.dbsyncserver.syncinterface.ClientInfo;
import com.sidney.dbsyncserver.syncinterface.IMaster;
import com.sidney.dbsyncserver.syncinterface.ISlave;
import com.sidney.dbsyncserver.syncinterface.TransferInfo;
import com.sidney.dbsyncserver.syncmodel.SyncDbListType;
import com.sidney.dbsyncserver.thriftclient.ClientToMaster;
import com.sidney.dbsyncserver.thriftclient.ClientToSlave;
import com.sidney.dbsyncserver.tserializ.common.DbSerializeService;

public class LoadUnLoadDb
{
	private static final String DATE_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static LoadUnLoadDb thisInstance = new LoadUnLoadDb();

	public static LoadUnLoadDb getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (LoadUnLoadDb.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new LoadUnLoadDb();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;
	}

	private ClientToSlave slaveProxy = null;
	private ClientToMaster masterProxy = null;

	public LoadUnLoadDb()
	{
		this.slaveProxy = null;
		this.masterProxy = null;
	}

	public Object loadFromMaster(Date _from, Date _to, int dbType, String[] _addr)
	{
		if (null == _addr)
		{
			return null;
		}

		if (null == masterProxy)
		{
			masterProxy = new ClientToMaster(_addr);
		}	

		Object ret = null;
		IMaster.Client proxy = null;
		try
		{
			// 生成代理
			proxy = masterProxy.getMasterProxy();
			if (null == proxy)
			{
				return null;
			}

			String from = DateUtil.format(_from, DATE_STRING_FORMAT);
			String to = DateUtil.format(_to, DATE_STRING_FORMAT);

			TransferInfo di = proxy.load(from, to, dbType);

			if (null != di)
			{
				if (dbType == SyncDbListType.ADMANAGE.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.ADMANAGER);
				}
				if (dbType == SyncDbListType.MENLO.getValue())
				{
				}
				if (dbType == SyncDbListType.DSP.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.DSP);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
		}
		return ret;
	}

	public Object unloadFromMaster(Date _from, Date _to, int dbType, String[] _addr)
	{
		if (null == _addr)
		{
			return null;
		}

		if (null == masterProxy)
		{
			masterProxy = new ClientToMaster(_addr);
		}

		Object ret = null;
		IMaster.Client proxy = null;
		try
		{
			// 生成代理
			proxy = masterProxy.getMasterProxy();
			if (null == proxy)
			{
				return null;
			}

			String from = DateUtil.format(_from, DATE_STRING_FORMAT);
			String to = DateUtil.format(_to, DATE_STRING_FORMAT);
			TransferInfo di = proxy.unLoad(from, to, dbType);
			if (null != di)
			{
				if (dbType == SyncDbListType.ADMANAGE.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.ADMANAGER);
				}
				if (dbType == SyncDbListType.MENLO.getValue())
				{
				}
				if (dbType == SyncDbListType.DSP.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.DSP);
				}
			}
		} catch (Exception e)
		{

		} finally
		{
		}
		return ret;
	}

	public Date getTimeFromMaster(int dbType, String[] _addr)
	{
		if (null == _addr)
		{
			return new Date();
		}

		if (null == masterProxy)
		{
			masterProxy = new ClientToMaster(_addr);
		}

		Date ret = null;
		IMaster.Client proxy = null;
		try
		{
			// 生成代理
			proxy = masterProxy.getMasterProxy();
			if (null == proxy)
			{
				return new Date();
			}

			String retStr = proxy.getDbTime(dbType);
			ret = DateUtil.parseDate(retStr, DATE_STRING_FORMAT);
		} catch (Exception e)
		{

		} finally
		{
		}
		return ret;
	}

	public Object loadFromSlave(Date _from, Date _to, int dbType, String[] _addr)
	{
		if (null == _addr)
		{
			return null;
		}

		if (null == slaveProxy)
		{
			slaveProxy = new ClientToSlave(_addr);
		}

		Object ret = null;
		ISlave.Client proxy = null;
		try
		{
			// 生成代理
			proxy = slaveProxy.getSlaveProxy();
			if (null == proxy)
			{
				return null;
			}

			String from = DateUtil.format(_from, DATE_STRING_FORMAT);
			String to = DateUtil.format(_to, DATE_STRING_FORMAT);

			TransferInfo di = proxy.load(from, to, dbType);
			if (null != di)
			{
				if (dbType == SyncDbListType.ADMANAGE.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.ADMANAGER);
				}
				if (dbType == SyncDbListType.MENLO.getValue())
				{
				}
				if (dbType == SyncDbListType.DSP.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.DSP);
				}
			}
		} catch (Exception e)
		{

		} finally
		{
		}
		return ret;
	}

	public Object unloadFromSlave(Date _from, Date _to, int dbType, String[] _addr)
	{
		if (null == _addr)
		{
			return null;
		}

		if (null == slaveProxy)
		{
			slaveProxy = new ClientToSlave(_addr);
		}

		Object ret = null;
		ISlave.Client proxy = null;
		try
		{
			// 生成代理
			proxy = slaveProxy.getSlaveProxy();
			if (null == proxy)
			{
				return null;
			}

			String from = DateUtil.format(_from, DATE_STRING_FORMAT);
			String to = DateUtil.format(_to, DATE_STRING_FORMAT);
			TransferInfo di = proxy.unLoad(from, to, dbType);
			if (null != di)
			{
				if (dbType == SyncDbListType.ADMANAGE.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.ADMANAGER);
				}
				if (dbType == SyncDbListType.MENLO.getValue())
				{
				}
				if (dbType == SyncDbListType.DSP.getValue())
				{
					ret = new DbSerializeService().deSerializefromBytes(di.getData().getData(), BinaryType.DSP);
				}
			}
		} catch (Exception e)
		{

		} finally
		{
		}
		return ret;
	}

	public void flagFromSlave(String _t, String[] _addr)
	{
		if (null == _addr)
		{
			return;
		}

		if (null == slaveProxy)
		{
			slaveProxy = new ClientToSlave(_addr);
		}

		ISlave.Client proxy = null;
		try
		{
			// 生成wcf代理
			proxy = slaveProxy.getSlaveProxy();

			if (null == proxy)
			{
				return;
			}

			proxy.flag(_t);
		} catch (Exception e)
		{

		} finally
		{
		}
	}
}