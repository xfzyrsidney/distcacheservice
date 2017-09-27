package com.sidney.dbsyncserver.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.EnumMap;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.common.Pair;
import com.adchina.configuration.ConfigurationManager;
import com.adchina.utils.StringUtil;
import com.sidney.dbsyncserver.init.GlobalInit;

 
public class ConfigurationHelper
{
	private static Log log = LogFactory.getLog(ConfigurationHelper.class);

	public static List<Integer> listTrackId = new ArrayList<Integer>();
	public static List<Integer> listTrackListName = new ArrayList<Integer>();
	public static List<Integer> listTrackDataType = new ArrayList<Integer>();

	/**
	 * @fields UPDATE_ONE_BY_ONE 每次更新db一行
	 */
	public static boolean UPDATE_ONE_BY_ONE = false;
	/**
	 * @fields CHECK_SLAVE_BALANCE_TIMESPAN
	 *         在slave中检查dailyhit>budget之间是否超越正常范围,此值最好大于MEMORY_BACK_BALANCE
	 */
	public static int CHECK_SLAVE_BALANCE_TIMESPAN;
	/**
	 * @fields LOAD_DATA_SERIAL_NUMBER 获得当前需要load/unload的数据
	 */
	public static HashSet<Integer> LOAD_DATA_SERIAL_NUMBER;
	/**
	 * @fields BROADCAST_PORT 广播端口，用来询问/通知其它service
	 */
	public static int BROADCAST_PORT = 0;
	/**
	 * @fields UPDATE_BLOCK_SIZE 每次update的行数
	 */
	public static int UPDATE_BLOCK_SIZE = 0;
	/**
	 * @fields ERROR_MAIL_TO Error报警邮件的收件人
	 */
	public static String ERROR_MAIL_TO;
	/**
	 * @fields SLAVE_LOG_FLAG slave通过api开启log功能
	 */
	public static int SLAVE_LOG_FLAG = 0;

	/**
	 * @fields DATA_TIMESPAN 从master 要load多长时间段内的数据
	 */
	public static int DATA_TIMESPAN;
	/**
	 * @fields LOAD_DB_FROM_MASTER 每隔多久从master load/unload更新db
	 */
	public static int LOAD_DB_FROM_MASTER = 0;
	/**
	 * @fields USE_MEMORY_CACHE ture:slave使用memory缓存balance。
	 *         false：slave直接将balance写入db。
	 */
	public static boolean USE_MEMORY_CACHE = false;
	/**
	 * @fields TRACK_PERCOUNT 时间监控条件 -1：取消 在第N条时打日志
	 */
	public static int TRACK_PERCOUNT = 0;
	/**
	 * @fields TARGET_SERVICE_ADDRESS slave用于记录master的地址
	 */
	public static String[] TARGET_SERVICE_ADDRESS;
	/**
	 * @fields UPDATE_MB_BALANCE slave向master发送数据的间隔时间
	 */
	public static int UPDATE_MB_BALANCE = 0;
	/**
	 * @fields MEMORY_BACK_BALANCE slave的memory写DB的间隔时间
	 */
	public static int MEMORY_BACK_BALANCE = 0;
	/**
	 * @fields SERVICE_NAME service name
	 */
	public static String SERVICE_NAME;
	/**
	 * @fields SERVICE_NAME service meta name
	 */
	public static String SERVICE_MATE_NAME;
	/**
	 * @fields SERVICE_ADDRESS service address
	 */
	public static String SERVICE_ADDRESS;
	/**
	 * @fields SERVICE_ADDRESS service meta address
	 */
	public static String SERVICE_META_ADDRESS;
	/**
	 * @fields MENLO_DB_CONNECTION menlo数据库连接字符串
	 */
	public static String MENLO_DB_CONNECTION;
	/**
	 * @fields DSP_DB_CONNECTION DSP数据库连接字符串
	 */
	public static String DSP_DB_CONNECTION;
	/**
	 * @fields ADMANAGER_DB_CONNECTION admanger数据库连接字符串
	 */
	public static String ADMANAGER_DB_CONNECTION;
	/**
	 * @fields CHECK_DB_TIMESPAN Load数据库间隔时间
	 */
	public static int CHECK_DB_TIMESPAN = 0;

	public static String ADMANAGERDATASOURCE;

	public static String DSPDATASOURCE;

	public static String MENLODATASOURCE;
	
	/**
	 * @fields DSPSYNCBALANCECTRLFLAG 	ture: use the SYNC_BALANCE_CTRL belongs to dsp db connection
	 *         							false：use the SYNC_BALANCE_CTRL belongs to admanager db connection
	 */
	public static boolean DSPSYNCBALANCECTRLFLAG = false;
	
	
	
	/**
	 * @fields ZK_QUORUM_NUM total num of zookeeper Quorum peers
	 */
	public static int ZK_QUORUM_NUM = 0;
	
	/**
	 * @fields ZK_CONNECTION_STRING ZK client Connection String
	 */
	public static String ZK_CONNECTION_STRING;
	
	/**
	 * @fields ZK_SYNCBALANCE_NODE_PATH 
	 */
	public static String ZK_SYNCBALANCE_NODE_PATH;
	
	/**
	 * @fields ZK_QUORUM_SYNCBALANCE_NODES_PATH 
	 */
	public static List<String> ZK_QUORUM_SYNCBALANCE_NODES_PATH;
	
	
	static
	{
		ConfigFileReadThread thrRead = new ConfigFileReadThread(15000, listTrackId, listTrackListName, listTrackDataType);

		thrRead.start();

		SERVICE_NAME = GetServiceName();
		SERVICE_MATE_NAME = GetServiceMetaName();
		SERVICE_ADDRESS = GetServiceAddress();
		SERVICE_META_ADDRESS = GetServiceMetaAddress();

		CHECK_DB_TIMESPAN = GetCheckDBTimespan();
		ADMANAGER_DB_CONNECTION = GetAdManagerConnectionString();
		DSP_DB_CONNECTION = GetDspConnectionString();
		MENLO_DB_CONNECTION = GetMenloConnectionString();
		UPDATE_MB_BALANCE = GetUpdateMbBalance();

		TARGET_SERVICE_ADDRESS = GetTargetServiceName();

		TRACK_PERCOUNT = GetTrackPerCount();
		USE_MEMORY_CACHE = GetUseMemoryCache();
		MEMORY_BACK_BALANCE = GetMemoryBackBalance();

		LOAD_DB_FROM_MASTER = GetLoadDbFromMaster();
		DATA_TIMESPAN = GetDataTimeSpan();

		ERROR_MAIL_TO = GetErrorMailTo();

		UPDATE_BLOCK_SIZE = GetUpdateBlockSize();

		BROADCAST_PORT = GetBroadcastPort();

		LOAD_DATA_SERIAL_NUMBER = GetLoadDataSerialNumber();

		CHECK_SLAVE_BALANCE_TIMESPAN = GetCheckSlaveBalanceTimeSpan();

		UPDATE_ONE_BY_ONE = GetUpdateOneByOne();

		ADMANAGERDATASOURCE = getAdManagerDataSource();

		DSPDATASOURCE = getDspDataSource();

		MENLODATASOURCE = getMenloDataSource();
		
		DSPSYNCBALANCECTRLFLAG = GetDspSyncBalanceCtrlFlag();
		
	    ZK_QUORUM_NUM = getZKQuorumNum();
		ZK_CONNECTION_STRING = getZKConnectionString();
		ZK_SYNCBALANCE_NODE_PATH = getZKSyncBalanceNodePath();
		ZK_QUORUM_SYNCBALANCE_NODES_PATH = getZKQuorumSyncBalanceNodesPath();
		
		log.info(String.format("SERVICE_NAME:{%s}", SERVICE_NAME));
		log.info(String.format("SERVICE_MATE_NAME:{%s}", SERVICE_MATE_NAME));
		log.info(String.format("SERVICE_ADDRESS:{%s}", SERVICE_ADDRESS));
		log.info(String.format("SERVICE_META_ADDRESS:{%s}", SERVICE_META_ADDRESS));
		log.info(String.format("CHECK_DB_TIMESPAN:{%d}", CHECK_DB_TIMESPAN));
		log.info(String.format("ADMANAGER_DB_CONNECTION:{%s}", ADMANAGER_DB_CONNECTION));
		log.info(String.format("DSP_DB_CONNECTION:{%s}", DSP_DB_CONNECTION));
		log.info(String.format("MENLO_DB_CONNECTION:{%s}", MENLO_DB_CONNECTION));
		log.info(String.format("UPDATE_MB_BALANCE:{%d}", UPDATE_MB_BALANCE));
		if (TARGET_SERVICE_ADDRESS != null)
		{
			for (String addr : TARGET_SERVICE_ADDRESS)
			{
				log.info(String.format("TARGET_SERVICE_ADDRESS:{%s}", addr));
			}
		}
		log.info(String.format("TRACK_PERCOUNT:{%d}", TRACK_PERCOUNT));
		log.info(String.format("USE_MEMORY_CACHE:{%s}", USE_MEMORY_CACHE));
		log.info(String.format("MEMORY_BACK_BALANCE:{%d}", MEMORY_BACK_BALANCE));
		log.info(String.format("LOAD_DB_FROM_MASTER:{%d}", LOAD_DB_FROM_MASTER));
		log.info(String.format("DATA_TIMESPAN:{%d}", DATA_TIMESPAN));
		log.info(String.format("ERROR_MAIL_TO:{%s}", ERROR_MAIL_TO));
		log.info(String.format("UPDATE_BLOCK_SIZE:{%d}", UPDATE_BLOCK_SIZE));
		log.info(String.format("BROADCAST_PORT:{%d}", BROADCAST_PORT));
		log.info(String.format("LOAD_DATA_SERIAL_NUMBER:{%s}", LOAD_DATA_SERIAL_NUMBER));
		log.info(String.format("CHECK_SLAVE_BALANCE_TIMESPAN:{%d}", CHECK_SLAVE_BALANCE_TIMESPAN));
		log.info(String.format("UPDATE_ONE_BY_ONE:{%s}", UPDATE_ONE_BY_ONE));
		log.info(String.format("DSPSYNCBALANCECTRLFLAG:{%s}", DSPSYNCBALANCECTRLFLAG));

		log.info(String.format("ZK_QUORUM_NUM:{%d}", ZK_QUORUM_NUM));
		log.info(String.format("ZK_CONNECTION_STRING:{%s}", ZK_CONNECTION_STRING));
		log.info(String.format("ZK_SYNCBALANCE_NODE_PATH:{%s}", ZK_SYNCBALANCE_NODE_PATH));
		log.info(ZK_QUORUM_SYNCBALANCE_NODES_PATH);
		
	}

	private static void AddList(List<Integer> _list, String[] param)
	{
		_list.clear();
		if (param.length >= 2 && !StringUtil.isNullOrEmpty(param[1]))
		{
			String[] Tracks = param[1].split(",");
			for (String v : Tracks)
			{
				try
				{
					int outResult = Integer.parseInt(v);
					_list.add(outResult);
				} catch (NumberFormatException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static Boolean GetUpdateOneByOne()
	{
		String temp = ConfigurationManager.getAppSetting("UpdateOneByOne");
		if (!StringUtil.isNullOrEmpty(temp) && Boolean.parseBoolean(temp))
		{
			return true;
		}
		return false; // default
	}

	private static int GetCheckSlaveBalanceTimeSpan()
	{
		String temp = ConfigurationManager.getAppSetting("CheckSlaveBalanceTimeSpan");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	private static HashSet<Integer> GetLoadDataSerialNumber()
	{
		String temp = ConfigurationManager.getAppSetting("LoadDataSerialNumber");
		HashSet<Integer> ret = new HashSet<Integer>();
		if (!StringUtil.isNullOrEmpty(temp))
		{
			String[] arr = temp.split(",");
			int i = 0;
			for (String v : arr)
			{
				try
				{
					i = Integer.parseInt(v);
					ret.add(i);
				} catch (NumberFormatException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret; // default
	}

	private static int GetBroadcastPort()
	{
		String temp = ConfigurationManager.getAppSetting("BroadcastPort");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 55001; // default
	}

	private static int GetUpdateBlockSize()
	{
		String temp = ConfigurationManager.getAppSetting("UpdateBlockSize");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 100; // default
	}

	private static String GetErrorMailTo()
	{
		String ret = ConfigurationManager.getAppSetting("ErrorMailTo");
		if (!StringUtil.isNullOrEmpty(ret))
		{
			return ret;
		}
		return "hang.yu@adchina.com"; // default
	}

	private static int GetDataTimeSpan()
	{
		String temp = ConfigurationManager.getAppSetting("DataTimeSpan");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 600000; // default 10 分钟
	}

	private static int GetLoadDbFromMaster()
	{
		String temp = ConfigurationManager.getAppSetting("LoadDbFromMaster");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 120000; // default
	}

	private static boolean GetUseMemoryCache()
	{
		String temp = ConfigurationManager.getAppSetting("UseMemoryCache");
		if (!StringUtil.isNullOrEmpty(temp) && Boolean.parseBoolean(temp))
		{
			return true;
		}
		return false; // default
	}
	
	private static boolean GetDspSyncBalanceCtrlFlag()
	{
		String temp = ConfigurationManager.getAppSetting("DspSyncBalanceCtrlFlag");
		if (!StringUtil.isNullOrEmpty(temp) && Boolean.parseBoolean(temp))
		{
			return true;
		}
		return false; // default
	}

	private static int GetTrackPerCount()
	{
		String temp = ConfigurationManager.getAppSetting("TrackPerCount");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 10000; // default
	}

	private static String[] GetTargetServiceName()
	{
		int iIndex = 1;
		List<String> ret = new ArrayList<String>();
		while (true)
		{
			String s = "TargetServiceName" + String.valueOf(iIndex);
			String temp = ConfigurationManager.getAppSetting(s);
			if (!StringUtil.isNullOrEmpty(temp))
			{
				ret.add(temp);
				iIndex++;
			} else
			{
				break;
			}
		}
		if (ret.size() == 0)
		{
			return null;
		}
		String strArr[] = new String[ret.size()];
		for (int i = 0; i < ret.size(); ++i)
		{
			strArr[i] = ret.get(i);
		}

		return strArr;
	}

	private static int GetUpdateMbBalance()
	{
		String temp = ConfigurationManager.getAppSetting("UpdateMbBalance");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 15000; // default
	}

	private static int GetMemoryBackBalance()
	{
		String temp = ConfigurationManager.getAppSetting("MemoryBackBalance");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 15000; // default
	}

	private static String GetServiceName()
	{
		String ret = ConfigurationManager.getAppSetting("ServiceName");
		if (!StringUtil.isNullOrEmpty(ret))
		{
			return ret;
		}
		return "MasterStatusService"; // default
	}

	private static String GetServiceMetaName()
	{
		String ret = ConfigurationManager.getAppSetting("ServiceMetaName");
		if (!StringUtil.isNullOrEmpty(ret))
		{
			return ret;
		}
		return "MasterStatusService/metadata"; // default
	}

	private static String GetServiceAddress()
	{
		String ret = ConfigurationManager.getAppSetting("ServiceAddress");
		if (!StringUtil.isNullOrEmpty(ret))
		{
			return ret;
		}
		return "net.tcp://127.0.0.1:50000"; // default
	}

	private static String GetServiceMetaAddress()
	{
		String ret = ConfigurationManager.getAppSetting("ServiceMetaAddress");
		if (!StringUtil.isNullOrEmpty(ret))
		{
			return ret;
		}
		return "http://127.0.0.1:50000"; // default
	}

	private static String GetMenloConnectionString()
	{
		Pair<String, String>[] temp = ConfigurationManager.getSettings("connectionStrings");
		if (temp != null)
		{
			for (Pair<String, String> pairData : temp)
			{
				assert (pairData.name != null);
				if (pairData.name.equalsIgnoreCase("MenloConnectionString"))
				{
					if (!StringUtil.isNullOrEmpty(pairData.value))
					{
						return pairData.value;
					}
				}
			}
		}

		return ""; // default
	}

	private static String GetDspConnectionString()
	{
		Pair<String, String>[] temp = ConfigurationManager.getSettings("connectionStrings");
		if (temp != null)
		{
			for (Pair<String, String> pairData : temp)
			{
				assert (pairData.name != null);
				if (pairData.name.equalsIgnoreCase("DspConnectionString"))
				{
					if (!StringUtil.isNullOrEmpty(pairData.value))
					{
						return pairData.value;
					}
				}
			}
		}
		return ""; // default
	}

	private static String GetAdManagerConnectionString()
	{
		Pair<String, String>[] temp = ConfigurationManager.getSettings("connectionStrings");
		if (temp != null)
		{
			for (Pair<String, String> pairData : temp)
			{
				assert (pairData.name != null);
				if (pairData.name.equalsIgnoreCase("AdManagerConnectionString"))
				{
					if (!StringUtil.isNullOrEmpty(pairData.value))
					{
						return pairData.value;
					}
				}
			}
		}
		return ""; // default
	}

	private static int GetCheckDBTimespan()
	{
		String temp = ConfigurationManager.getAppSetting("CheckDBTimeSpan");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 60000; // default
	}

	public static String getAdManagerDataSource()
	{
		String temp = ConfigurationManager.getAppSetting("AdManagerDataSource", "");
		log.info(String.format("DATA_SOURCE:[%s]", temp));
		return temp;
	}

	private static String getDspDataSource()
	{
		String temp = ConfigurationManager.getAppSetting("DspDataSource", "");
		log.info(String.format("DATA_SOURCE:[%s]", temp));
		return temp;
	}

	private static String getMenloDataSource()
	{
		String temp = ConfigurationManager.getAppSetting("MenloDataSource", "");
		log.info(String.format("DATA_SOURCE:[%s]", temp));
		return temp;
	}
	
	private static int getZKQuorumNum()
	{
		String temp = ConfigurationManager.getAppSetting("ZKQuorumNum");
		int ret = 0;
		if (!StringUtil.isNullOrEmpty(temp))
		{
			try
			{
				ret = Integer.parseInt(temp);
				return ret;
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	private static String getZKConnectionString()
	{
		String temp = ConfigurationManager.getAppSetting("ZKConnectionString", "");
		return temp;
	}
	
	private static String getZKSyncBalanceNodePath()
	{
		String temp = ConfigurationManager.getAppSetting("ZKSyncBalanceNodePath", "");
		return temp;
	}
	
	private static List<String> getZKQuorumSyncBalanceNodesPath()
	{
		String temp = ConfigurationManager.getAppSetting("ZKQuorumSyncBalanceNodesPath", "");
		String[] tempArr =  temp.split(",");
		List<String> ret = new ArrayList<String>();
		for(String str : tempArr){
			if (!StringUtil.isNullOrEmpty(str.trim()))
			{
				ret.add(str.trim());
			}
		}
		return ret;
	}
	


}
