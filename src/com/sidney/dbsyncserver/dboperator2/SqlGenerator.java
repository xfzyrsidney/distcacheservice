package com.sidney.dbsyncserver.dboperator2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.utils.StringUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.utils.SendMailService;

public class SqlGenerator
{
	private static Log Logger = LogFactory.getLog(SqlGenerator.class);

	// / <summary>
	// / load的sql
	// / </summary>
	public SqlInfo loadSqlInfo()
	{
		return m_LoadSqlInfo;
	}

	private SqlInfo m_LoadSqlInfo;

	// / <summary>
	// / Unload的sql
	// / </summary>
	public SqlInfo unloadSqlInfo()
	{
		return m_UnloadSqlInfo;
	}

	private SqlInfo m_UnloadSqlInfo;

	// / <summary>
	// / Load时计算count的sql
	// / </summary>
	public SqlInfo loadCountSqlInfo()
	{
		return m_LoadCountSqlInfo;
	}

	private SqlInfo m_LoadCountSqlInfo;

	// / <summary>
	// / Unload时计算count的sql
	// / </summary>
	public SqlInfo unloadCountSqlInfo()
	{
		return m_UnloadCountSqlInfo;
	}

	private SqlInfo m_UnloadCountSqlInfo;

	// / <summary>
	// / 构造函数
	// / </summary>
	public SqlGenerator(Object obj)
	{
		generateLoadString(obj);
		generateUnloadString(obj);

		generateLoadCountString(obj);
		generateUnloadCountString(obj);
	}

	// / <summary>
	// / 生成load的SqlInfo
	// / </summary>
	// / <returns>返回SqlInfo</returns>
	private SqlInfo generateLoadString(Object obj)
	{
		SqlInfo ret = new SqlInfo();

		TableAttribute tableAttribute = obj.getClass().getAnnotation(TableAttribute.class);
		Field[] fields = obj.getClass().getDeclaredFields();
		List<FieldAttribute> listFieldAttribute = new ArrayList<FieldAttribute>();
		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];
			listFieldAttribute.add(field.getAnnotation(FieldAttribute.class));
		}

		StringBuilder sb = new StringBuilder(128);

		try
		{
			sb.append(" select ");
			for (int i = 0; i < listFieldAttribute.size(); ++i)
			{
				FieldAttribute fieldAttribute = listFieldAttribute.get(i);
				if (null == fieldAttribute)
				{
					continue;
				}
				if (fieldAttribute.NeedLoad())
				{
					sb.append(String.format(" %s,", fieldAttribute.Name()));
				}
			}
			sb.delete(sb.length() - 1, sb.length());

			// region from
			sb.append(String.format(" from %s ", tableAttribute.Name()));
			// endregion

			// region where
			boolean bExistWhere = false;
			for (int i = 0; i < listFieldAttribute.size(); ++i)
			{
				FieldAttribute fieldAttribute = listFieldAttribute.get(i);
				if (null == fieldAttribute)
				{
					continue;
				}
				if (!bExistWhere)
				{
					sb.append(" where ");
					bExistWhere = true;
				}
				if (!StringUtil.isNullOrEmpty(fieldAttribute.LoadCustomSign()) && !StringUtil.isNullOrEmpty(fieldAttribute.LoadCustomValue())) // 如果有自定义
				{
					sb.append(String.format(" %s %s %s and", fieldAttribute.Name(), fieldAttribute.LoadCustomSign(), fieldAttribute.LoadCustomValue()));
				} else
				{
					if (fieldAttribute.IsStatus()) // 如果是status字段
					{
						sb.append(String.format(" %s=1 and", fieldAttribute.Name()));

					}
					if (fieldAttribute.IsLastChanged()) // 如果是lastchanged字段
					{
						sb.append(String.format(" %s >= ? and %s < ? and", fieldAttribute.Name(), fieldAttribute.Name()));
						HashMap<String, Integer> dic1 = new HashMap<String, Integer>();
						dic1.put("from_date", fieldAttribute.OracleTypes());
						HashMap<String, Integer> dic2 = new HashMap<String, Integer>();
						dic2.put("to_date", fieldAttribute.OracleTypes());
						ret.sqlParam.add(dic1);
                        ret.sqlParam.add(dic2);
					}
				}
			}
			if (bExistWhere)
			{
				sb.delete(sb.length() - 3, sb.length()); // 去掉字符串末尾的"and"
			}
			// endregion

			ret.sqlStr = sb.toString();
			this.m_LoadSqlInfo = ret;

			Logger.info(ret.sqlStr);
		} catch (Exception ex)
		{
			String temp = String.format("[Generate Load String]:%s,%s", tableAttribute.Name(), ex);
			Logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		}
		return ret;
	}

	private SqlInfo generateLoadCountString(Object obj)
	{
		SqlInfo ret = new SqlInfo();

		TableAttribute tableAttribute = obj.getClass().getAnnotation(TableAttribute.class);
		Field[] fields = obj.getClass().getDeclaredFields();
		List<FieldAttribute> listFieldAttribute = new ArrayList<FieldAttribute>();
		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];
			listFieldAttribute.add(field.getAnnotation(FieldAttribute.class));
		}

		StringBuilder sb = new StringBuilder(128);

		try
		{
			// region select
			sb.append(" select count(*) ");
			// endregion

			// region from
			sb.append(String.format(" from %s ", tableAttribute.Name()));
			// endregion

			// region where
			boolean bExistWhere = false;
			for (int i = 0; i < listFieldAttribute.size(); ++i)
			{
				FieldAttribute fieldAttribute = listFieldAttribute.get(i);
				if (null == fieldAttribute)
				{
					continue;
				}
				if (!bExistWhere)
				{
					sb.append(" where ");
					bExistWhere = true;
				}
				if (!StringUtil.isNullOrEmpty(fieldAttribute.LoadCustomSign()) && !StringUtil.isNullOrEmpty(fieldAttribute.LoadCustomValue())) // 如果有自定义
				{
					sb.append(String.format(" %s %s %s and", fieldAttribute.Name(), fieldAttribute.LoadCustomSign(), fieldAttribute.LoadCustomValue()));
				} else
				{
					if (fieldAttribute.IsStatus()) // 如果是status字段
					{
						sb.append(String.format(" %s =1 and", fieldAttribute.Name()));

					}
					if (fieldAttribute.IsLastChanged()) // 如果是lastchanged字段
					{
						sb.append(String.format(" %s >= ? and %s < ? and", fieldAttribute.Name(), fieldAttribute.Name()));
						HashMap<String, Integer> dic1 = new HashMap<String, Integer>();
						dic1.put("from_date", fieldAttribute.OracleTypes());
						HashMap<String, Integer> dic2 = new HashMap<String, Integer>();
						dic2.put("to_date", fieldAttribute.OracleTypes());
						ret.sqlParam.add(dic1);
                        ret.sqlParam.add(dic2);
					}
				}
			}
			if (bExistWhere)
			{
				sb.delete(sb.length() - 3, sb.length()); // 去掉字符串末尾的"and"
			}
			// endregion

			ret.sqlStr = sb.toString();
			m_LoadCountSqlInfo = ret;

			Logger.info(ret.sqlStr);
		} catch (Exception ex)
		{
			String temp = String.format("[Generate Load String]:%s,%s", tableAttribute.Name(), ex);
			Logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		}
		return ret;
	}

	// / <summary>
	// / 生成unload语句
	// / </summary>
	// / <returns></returns>
	private SqlInfo generateUnloadString(Object obj)
	{
		SqlInfo ret = new SqlInfo();

		TableAttribute tableAttribute = obj.getClass().getAnnotation(TableAttribute.class);
		Field[] fields = obj.getClass().getDeclaredFields();
		List<FieldAttribute> listFieldAttribute = new ArrayList<FieldAttribute>();
		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];
			listFieldAttribute.add(field.getAnnotation(FieldAttribute.class));
		}
		StringBuilder sb = new StringBuilder(128);

		try
		{
			// region select
			sb.append(" select ");
			for (int i = 0; i < listFieldAttribute.size(); ++i)
			{
				FieldAttribute fieldAttribute = listFieldAttribute.get(i);
				if (null == fieldAttribute)
				{
					continue;
				}
				if (fieldAttribute.NeedUnload())
				{
					sb.append(String.format(" %s,", fieldAttribute.Name()));
				}
			}
			sb.delete(sb.length() - 1, sb.length());
			// endregion

			// region from
			sb.append(String.format(" from %s ", tableAttribute.Name()));
			// endregion

			// region where
			boolean bExistWhere = false;
			for (int i = 0; i < listFieldAttribute.size(); ++i)
			{
				FieldAttribute fieldAttribute = listFieldAttribute.get(i);
				if (null == fieldAttribute)
				{
					continue;
				}
				if (!bExistWhere)
				{
					sb.append(" where ");
					bExistWhere = true;
				}
				if (!StringUtil.isNullOrEmpty(fieldAttribute.UnloadCustomSign()) && !StringUtil.isNullOrEmpty(fieldAttribute.UnloadCustomValue())) // 如果有自定义
				{
					sb.append(String.format(" %s %s %s and", fieldAttribute.Name(), fieldAttribute.UnloadCustomSign(), fieldAttribute.UnloadCustomValue()));
				} else
				{
					if (fieldAttribute.IsStatus()) // 如果是status字段
					{
						sb.append(String.format(" %s !=1 and", fieldAttribute.Name()));

					}
					if (fieldAttribute.IsLastChanged()) // 如果是lastchanged字段
					{
						sb.append(String.format(" %s >= ? and %s < ? and", fieldAttribute.Name(), fieldAttribute.Name()));
						HashMap<String, Integer> dic1 = new HashMap<String, Integer>();
						dic1.put("from_date", fieldAttribute.OracleTypes());
						HashMap<String, Integer> dic2 = new HashMap<String, Integer>();
						dic2.put("to_date", fieldAttribute.OracleTypes());
						ret.sqlParam.add(dic1);
                        ret.sqlParam.add(dic2);
					}
				}
			}
			if (bExistWhere)
			{
				sb.delete(sb.length() - 3, sb.length()); // 去掉字符串末尾的"and"
			}
			// endregion

			ret.sqlStr = sb.toString();
			m_UnloadSqlInfo = ret;

			Logger.info(ret.sqlStr);
		} catch (Exception ex)
		{
			String temp = String.format("[Generate Unload String]:%s,%s", tableAttribute.Name(), ex);
			Logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		}
		return ret;
	}

	private SqlInfo generateUnloadCountString(Object obj)
	{
		SqlInfo ret = new SqlInfo();

		TableAttribute tableAttribute = obj.getClass().getAnnotation(TableAttribute.class);
		Field[] fields = obj.getClass().getDeclaredFields();
		List<FieldAttribute> listFieldAttribute = new ArrayList<FieldAttribute>();
		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];
			listFieldAttribute.add(field.getAnnotation(FieldAttribute.class));
		}
		StringBuilder sb = new StringBuilder(128);

		try
		{
			// region select
			sb.append(" select count(*) ");
			// endregion

			// region from
			sb.append(String.format(" from %s ", tableAttribute.Name()));
			// endregion

			// region where
			boolean bExistWhere = false;
			for (int i = 0; i < listFieldAttribute.size(); ++i)
			{
				FieldAttribute fieldAttribute = listFieldAttribute.get(i);
				if (null == fieldAttribute)
				{
					continue;
				}
				if (!bExistWhere)
				{
					sb.append(" where ");
					bExistWhere = true;
				}
				if (!StringUtil.isNullOrEmpty(fieldAttribute.UnloadCustomSign()) && !StringUtil.isNullOrEmpty(fieldAttribute.UnloadCustomValue())) // 如果有自定义
				{
					sb.append(String.format(" %s %s %s and", fieldAttribute.Name(), fieldAttribute.UnloadCustomSign(), fieldAttribute.UnloadCustomValue()));
				} else
				{
					if (fieldAttribute.IsStatus()) // 如果是status字段
					{
						sb.append(String.format(" %s !=1 and", fieldAttribute.Name()));

					}
					if (fieldAttribute.IsLastChanged()) // 如果是lastchanged字段
					{
						sb.append(String.format(" %s >= ? and  %s < ? and", fieldAttribute.Name(), fieldAttribute.Name()));
						HashMap<String, Integer> dic1 = new HashMap<String, Integer>();
						dic1.put("from_date", fieldAttribute.OracleTypes());
						HashMap<String, Integer> dic2 = new HashMap<String, Integer>();
						dic2.put("to_date", fieldAttribute.OracleTypes());
						ret.sqlParam.add(dic1);
                        ret.sqlParam.add(dic2);
					}
				}
			}
			if (bExistWhere)
			{
				sb.delete(sb.length() - 3, sb.length()); // 去掉字符串末尾的"and"
			}
			// endregion

			ret.sqlStr = sb.toString();
			m_UnloadCountSqlInfo = ret;

			Logger.info(ret.sqlStr);
		} catch (Exception ex)
		{
			String temp = String.format("[Generate Unload String]: %s, %s", tableAttribute.Name(), ex);
			Logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		}
		return ret;
	}
}