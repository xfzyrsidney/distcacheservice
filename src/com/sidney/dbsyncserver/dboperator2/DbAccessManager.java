package com.sidney.dbsyncserver.dboperator2;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.utils.DateUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.oracledb.IOracleConn;
import com.sidney.dbsyncserver.syncstruct.loadunloadoperation.DbDataManager;
import com.sidney.dbsyncserver.utils.SendMailService;

public class DbAccessManager<T>
{
	private static Log logger = LogFactory.getLog(DbAccessManager.class);
	private Object lockObj = new Object();
	public ConcurrentHashMap<String, Object> db_access_cache = new ConcurrentHashMap<String, Object>();

	private static DbAccessManager<Object> thisInstance;

	public static <T> DbAccessManager<T> getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (DbAccessManager.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new DbAccessManager<Object>();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return (DbAccessManager<T>) thisInstance;

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="context"></param>
	// / <param name="from"></param>
	// / <param name="to"></param>
	// / <param name="ConnectObj"></param>
	// / <param name="isInit">是否已经初始化。如果不是，则按照tableattribute上的初始化from</param>
	public void getLoadDBAccessContext(Object context, Date from, Date to, IOracleConn ConnectObj)
	{

		Class<?> type = context.getClass(); // DspContext Type
		Field[] properties = type.getDeclaredFields(); // 获得每个属性类型
		for (int i = 0; i < properties.length; i++)
		{
			Field item = properties[i];
			try
			{
				Class itemType = item.getType();
				if (itemType.isPrimitive())
				{
					System.out.println("base type： " + itemType.getName());
				} else
				{
					if (itemType.isAssignableFrom(List.class))
					{ // 判断是否为List
						Type propertyType = item.getGenericType();
						Class<?> modelType = (Class<?>) ((ParameterizedType) propertyType).getActualTypeArguments()[0]; // 从Property声明中解析出Table
																														// model的类型
						TableAttribute tableAttr = (TableAttribute) ((Class<?>) modelType).getAnnotation(TableAttribute.class);

						if (!tableAttr.NeedLoad()) // 如果table配置不需要load，则不load
						{
							continue;
						}

						DbAccesser DB_Accessor = null;
						if (db_access_cache.containsKey(modelType.getName()))
						{
							DB_Accessor = (DbAccesser) db_access_cache.get(modelType.getName());
						} else
						{
							DB_Accessor = new DbAccesser(ConnectObj);
							db_access_cache.put(modelType.getName(), DB_Accessor);
						}

						Date tempFrom = from;
						Date tableDate = DateUtil.parseDate(tableAttr.InitFromDateTime(), "yyyy-MM-dd HH:mm:ss");
						if (tempFrom.compareTo(tableDate) < 0) // 如果from时间小于tableattribute，则from需要成tableattribute中的那个时间
						{
							tempFrom = tableDate;
						}

						List<Object> list = new ArrayList<Object>();
						DB_Accessor.load(list, tempFrom, to, modelType.newInstance());
						item.set(context, list);

						logger.info(String.format("[%s] Load From:%s,To:%s,Count:%d", tableAttr.Name(), tempFrom, to, list.size()));
					}
				}
			} catch (Exception ex)
			{
				String temp = String.format("[GetLoadDBAccessContext] Load failed: %s,%s", item.getName(), ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			}

		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="context"></param>
	// / <param name="from"></param>
	// / <param name="to"></param>
	// / <param name="ConnectObj"></param>
	// / <param name="isInit">是否已经初始化。如果不是，则按照tableattribute上的初始化from</param>
	public void getUnLoadDBAccessContext(Object context, Date from, Date to, IOracleConn ConnectObj)
	{

		Class<?> type = context.getClass();
		Field[] properties = type.getDeclaredFields();
		for (int i = 0; i < properties.length; i++)
		{
			Field item = properties[i];
			try
			{
				Class itemType = item.getType();
				if (itemType.isPrimitive())
				{
					System.out.println("base type： " + itemType.getName());
				} else
				{
					if (itemType.isAssignableFrom(List.class))
					{ // 判断是否为List

						Type propertyType = item.getGenericType();
						Class<?> modelType = (Class<?>) ((ParameterizedType) propertyType).getActualTypeArguments()[0]; // 从Property声明中解析出Table
																														// model的类型

						TableAttribute tableAttr = (TableAttribute) ((Class<?>) modelType).getAnnotation(TableAttribute.class);

						if (!tableAttr.NeedUnload()) // 如果table配置不需要unload，则不unload
						{
							continue;
						}

						DbAccesser DB_Accessor = null;
						if (db_access_cache.containsKey(modelType.getName()))
						{
							DB_Accessor = (DbAccesser) db_access_cache.get(modelType.getName());
						} else
						{
							DB_Accessor = new DbAccesser(ConnectObj);
							db_access_cache.put(modelType.getName(), DB_Accessor);
						}

						Date tempFrom = from;
						Date tableDate = DateUtil.parseDate(tableAttr.InitFromDateTime(), "yyyy-MM-dd HH:mm:ss");
						if (tempFrom.compareTo(tableDate) < 0) // 如果from时间小于tableattribute，则from需要成tableattribute中的那个时间
						{
							tempFrom = tableDate;
						}

						List<Object> list = new ArrayList<Object>();

						DB_Accessor.unLoad(list, tempFrom, to, modelType.newInstance());
						item.set(context, list);

						logger.info(String.format("[%s] Unload From:%s,To:%s,Count:%d", tableAttr.getClass().getName(), tempFrom, to, list.size()));
					}
				}
			} catch (Exception ex)
			{
				String temp = String.format("[GetUnLoadDBAccessContext] Unload failed: %s, %s", item.getName(), ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			}
		}

	}
}