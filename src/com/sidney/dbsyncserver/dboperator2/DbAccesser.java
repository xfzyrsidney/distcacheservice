package com.sidney.dbsyncserver.dboperator2;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.dbaccess.Database;
import com.adchina.utils.DateUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.oracledb.IOracleConn;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;
import com.sidney.dbsyncserver.utils.SendMailService;

public class DbAccesser
{
	private static Log logger = LogFactory.getLog(DbAccesser.class);

	private OracleDBConnection connection;

	public DbAccesser(String dataSource)
	{
		try
		{
			this.connection = new OracleDBConnection(dataSource);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DbAccesser(IOracleConn ConnectObj)
	{
		this.connection = (OracleDBConnection) ConnectObj;
	}

	// / <summary>
	// / 加载表中的字段
	// / </summary>
	// / <param name="list">需要加载的字典实例</param>
	// / <param name="from">开始时间</param>
	// / <param name="to">结束时间</param>
	// / <returns>0 代表加载成功， -1代表加载失败</returns>
	public int load(List<Object> list, Date from, Date to, Object obj)
	{
		int status = 0;
		int readerLength = 0;
		ResultSet reader = null;
		PreparedStatement cmd = null;
		SqlInfo si = null;
		try
		{
			si = new SqlGenerator(obj).loadSqlInfo();
			cmd = si.createCommand(this.connection.getConnection());
			reader = si.executeReader(new Object[] { from, to });
			reader.last();
			readerLength = reader.getRow();
			reader.beforeFirst();
			while (reader.next())
			{
				Constructor ct = obj.getClass().getConstructor();
				Object model = ct.newInstance();
				this.loadFillModel(reader, model);
				list.add(model);
			}
			status = 1;
		} catch (Exception ex)
		{
			status = -1;
			String temp = String.format("[Load Table]:%s,%s", si.sqlStr, ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			if (null != reader)
			{
				try
				{
					cmd.close();
					reader.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="reader"></param>
	// / <param name="model"></param>
	private void loadFillModel(ResultSet reader, Object model)
	{
		Field[] fields = model.getClass().getDeclaredFields();
		Field proInfo = null;
		for (int i = 0; i < fields.length; i++)
		{
			proInfo = fields[i];
			try
			{
				FieldAttribute fieldAttribute = proInfo.getAnnotation(FieldAttribute.class);
				SetPropertyValue(reader, i + 1, model, proInfo, fieldAttribute.OracleTypes());
			} catch (Exception ex)
			{
				String temp = String.format("[LoadFillModel]%s.%s:%s", model.getClass().getName(), proInfo.getName(), ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			}
		}
	}

	// / <summary>
	// / 卸载表中的字段
	// / </summary>
	// / <param name="dic">需要卸载的字典实例</param>
	// / <param name="from">开始时间</param>
	// / <param name="to">结束时间</param>
	// / <returns>0 代表卸载成功， -1代表卸载失败</returns>
	public int unLoad(List<Object> list, Date from, Date to, Object obj)
	{
		int status = 0;
		ResultSet reader = null;
		PreparedStatement cmd = null;
		SqlInfo si = null;
		try
		{
			si = new SqlGenerator(obj).unloadSqlInfo();
			cmd = si.createCommand(this.connection.getConnection());
			reader = si.executeReader(new Object[] { from, to });
			while (reader.next())
			{
				Constructor ct = obj.getClass().getConstructor();
				Object model = ct.newInstance();
				this.unloadFillModel(reader, model);
				if (!list.contains(model))
				{
					list.add(model);
				}
			}
			status = 1;
		} catch (Exception ex)
		{
			status = -1;
			String temp = String.format("[Unload Table]:%s,%s", si.sqlStr, ex);
			logger.error(temp);
			new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
		} finally
		{
			if (null != reader)
			{
				try
				{
					cmd.close();
					reader.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	// / <summary>
	// / 从Oracale Reader中填充Table Model
	// / </summary>
	// / <param name="reader">The Oracle Reader</param>
	// / <param name="model">Table model</param>
	// / <param name="bUnload">是否是在unload中运行, 如果是，则只需要带key的property</param>
	private void unloadFillModel(ResultSet reader, Object model)
	{
		Field[] fields = model.getClass().getDeclaredFields();
		Field proInfo = null;
		int iReadIndex = 1;
		for (int i = 0; i < fields.length; i++)
		{
			proInfo = fields[i];
			try
			{
				FieldAttribute fieldAttribute = proInfo.getAnnotation(FieldAttribute.class);

				if (!fieldAttribute.NeedUnload()) // 如果不需要needunload的字段，则不需要在unload时填充
				{
					continue;
				}

				SetPropertyValue(reader, iReadIndex, model, proInfo, fieldAttribute.OracleTypes());
				iReadIndex++;
			} catch (Exception ex)
			{
				String temp = String.format("[UnloadFillModel]%s.%s:%s", model.getClass().getName(), proInfo.getName(), ex);
				logger.error(temp);
				new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] Error", ConfigurationHelper.SERVICE_ADDRESS), temp);
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void SetPropertyValue(ResultSet _reader, int _iIndex, Object model, Field _proInfo, int _dbType) throws Exception
	{
		switch (_dbType)
		{
			case OracleTypes.DATE:
				java.sql.Timestamp retSt = _reader.getTimestamp(_iIndex);
				Date temp1 = null;
				if (retSt == null)
				{
					temp1 = DateUtil.parseDate("2012-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
				} else
				{
					temp1 = new Date(retSt.getTime());
				}

				_proInfo.set(model, temp1);
				break;
			case OracleTypes.DECIMAL:
				BigDecimal temp2 = _reader.getBigDecimal(_iIndex);
				_proInfo.set(model, temp2 == null ? new BigDecimal("0") : temp2);
				break;
			case OracleTypes.BIGINT:
				Long temp3 = _reader.getLong(_iIndex);
				_proInfo.set(model, temp3 == null ? new Long(0) : temp3);
				break;
			case OracleTypes.DOUBLE:
				Double temp4 = _reader.getDouble(_iIndex);
				_proInfo.set(model, temp4 == null ? new Double(0.0) : temp4);
				break;
			case OracleTypes.INTEGER:
				Integer temp5 = _reader.getInt(_iIndex);
				_proInfo.set(model, temp5 == null ? 0 : temp5);
				break;
			case OracleTypes.VARCHAR:
				String temp6 = _reader.getString(_iIndex);
				_proInfo.set(model, temp6 == null ? "" : temp6);
				break;
			case OracleTypes.NCHAR:
				String temp7 = _reader.getString(_iIndex);
				_proInfo.set(model,  temp7 == null ? "" : temp7);
				break;
			case OracleTypes.NVARCHAR:
				String temp8 = _reader.getString(_iIndex);
				_proInfo.set(model, temp8 == null ? "" : temp8);
				break;
			case OracleTypes.CLOB:
				String temp9 = clobToString(_reader.getClob(_iIndex));
				_proInfo.set(model, temp9 == null ? "" : temp9);
				break;

			default:
				break;
		}
	}

	private String clobToString(Clob clob)
	{
		if (clob == null)
		{
			return null;
		}
		try
		{
			Reader inStreamDoc = clob.getCharacterStream();

			char[] tempDoc = new char[(int) clob.length()];
			inStreamDoc.read(tempDoc);
			inStreamDoc.close();
			return new String(tempDoc);
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (SQLException es)
		{
			es.printStackTrace();
		}

		return null;
	}

}