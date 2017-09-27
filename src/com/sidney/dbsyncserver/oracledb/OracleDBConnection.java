package com.sidney.dbsyncserver.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.dbaccess.Database;
import com.adchina.utils.StringUtil;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;

public class OracleDBConnection implements IOracleConn
{
	private static Log Logger = LogFactory.getLog(OracleDBConnection.class);

	private long timeDiffFromDB; // server与DB的时间差
	private Connection oracleConn = null;
	private List<IOracleOperator> oracleCmd = null;

	private String dataSource = null;

	private String url = null;
	private String name = null;
	private String passwd = null;

	// / <summary>
	// / 构造函数
	// / </summary>
	// / <param name="_strConnection">连接字符串</param>
	public OracleDBConnection(String dataSource)
	{
		this.dataSource = dataSource;
	}

	public OracleDBConnection(String url, String name, String passwd)
	{
		this.url = url;
		this.name = name;
		this.passwd = passwd;
	}

	private void openDB()
	{
		Date timeAtDatabaseServer = new Date();
		try
		{
			this.closeDB();
		} catch (Exception e)
		{
			Logger.info(e);
		}
		this.oracleConn = null;

		try
		{
			if (!StringUtil.isNullOrEmpty(this.dataSource))
			{
				Database database = Database.getDatabase(this.dataSource);
				if (database != null)
				{
					try
					{
						this.oracleConn = database.getConnection();
					} catch (Exception e)
					{
						Logger.error("First failed to open DB! Exception: " + e);
						this.oracleConn = database.getConnection();
					}
				}
			}
			if (this.oracleConn == null && !StringUtil.isNullOrEmpty(this.url))
			{
				this.oracleConn = DriverManager.getConnection(url, this.name, this.passwd);
			}

			Date now = new Date();
			timeAtDatabaseServer = this.getDatabaseTime();
			this.timeDiffFromDB = timeAtDatabaseServer.getTime() - now.getTime();
			Logger.info("DB opened!");
		}catch (Exception e)
		{
			Logger.error("Failed to open DB! Exception: " + e);
		}
	}

	private void closeDB()
	{
		try
		{
			if (null != this.oracleConn)
			{
				this.oracleConn.close();
				this.oracleConn = null;
				Logger.info(String.format("OracleDBConnection has been closed!"));
			}
		} catch (Exception ex)
		{
			Logger.error(ex);
		} finally
		{
			this.oracleConn = null;
		}
	}

	private void createDBCommand()
	{
		try
		{
			if (this.oracleCmd != null)
			{
				for (int i = this.oracleCmd.size() - 1; i >= 0; i--)
				{
					if (null == this.oracleCmd.get(i))
					{
					} else
					{
						this.oracleCmd.get(i).createCmd(this.oracleConn);
					}

				}
			}
		} catch (Exception ex)
		{
			Logger.error(ex);
		}
	}

	public Date getDatabaseTime()
	{
		Date ret = null;
		ResultSet reader = null;
		PreparedStatement sqlCommand = null;
		try
		{
			sqlCommand = this.oracleConn.prepareStatement("SELECT sysdate FROM DUAL");
			reader = sqlCommand.executeQuery();
			while (reader.next())
			{
				java.sql.Timestamp retSt = reader.getTimestamp(1);
				ret = new Date(retSt.getTime());
				break;
			}
			
		} catch (Exception ex)
		{
			ret = new Date();
		} finally
		{
			if (reader != null)
			{
				try
				{
					sqlCommand.close();
					reader.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	public Date getCurrentDBTime()
	{
		try
		{
			return new Date(new Date().getTime() + this.timeDiffFromDB);
		} catch (Exception e)
		{
			return new Date();
		}
	}

	// / <summary>
	// / 获得有效的OracleConnection对象
	// / </summary>
	// / <returns></returns>
	public Connection getConnection()
	{
		try
		{
			if (null == this.oracleConn || this.oracleConn.isClosed())
			{
				openDB();
				createDBCommand();
			}
			this.timeDiffFromDB = this.getDatabaseTime().getTime() - (new Date()).getTime();
		} catch (Exception ex)
		{
			Logger.error(ex);
			this.oracleConn = null;
		}
		return this.oracleConn;
	}

	// / <summary>
	// / 注册OracleCommand
	// / </summary>
	// / <param name="_operator"></param>
	public void registCommand(IOracleOperator _operator)
	{
		if (null == this.oracleCmd)
		{
			this.oracleCmd = new ArrayList<IOracleOperator>();
		}

		this.oracleCmd.add(_operator);
	}

	// / <summary>
	// / 关闭
	// / </summary>
	public void dispose()
	{
		closeDB();
	}
}