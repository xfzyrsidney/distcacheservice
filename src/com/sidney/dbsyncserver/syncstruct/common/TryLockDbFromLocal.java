package com.sidney.dbsyncserver.syncstruct.common;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.oracledb.IOracleConn;
import com.sidney.dbsyncserver.oracledb.IOracleOperator;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;

public class TryLockDbFromLocal implements IOracleOperator
{
	private static Log logger = LogFactory.getLog(TryLockDbFromLocal.class);
	private Object lockObj = new Object();
	private static TryLockDbFromLocal thisInstance = new TryLockDbFromLocal();
	private IOracleConn ConnectObj = null;

	public static TryLockDbFromLocal getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (TryLockDbFromLocal.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new TryLockDbFromLocal();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	private TryLockDbFromLocal()
	{
		if (ConfigurationHelper.DSPSYNCBALANCECTRLFLAG == true)
		{
			this.ConnectObj = new OracleDBConnection(ConfigurationHelper.DSPDATASOURCE);
		} else
		{
			this.ConnectObj = new OracleDBConnection(ConfigurationHelper.ADMANAGERDATASOURCE);
		}
		this.ConnectObj.registCommand(this);
		createCmd(this.ConnectObj.getConnection());
	}

	public void createCmd(Connection _conn)
	{
		createGetLockCommand(_conn);

	}

	private String CMD_FOR_LOCK_FROM_LOCAL = "select id from sync_lock_ctrl where id=1 for update nowait";
	private PreparedStatement ForLockFromLocalCmd = null;

	private void createGetLockCommand(Connection _conn)
	{
		try
		{
			if (this.ForLockFromLocalCmd == null || this.ForLockFromLocalCmd.isClosed())
			{
				this.ForLockFromLocalCmd = _conn.prepareStatement(CMD_FOR_LOCK_FROM_LOCAL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	public boolean tryLock()
	{
		try
		{
			synchronized (lockObj)
			{
				createCmd(this.ConnectObj.getConnection());
				if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
				{
					return false;
				}

				this.ConnectObj.getConnection().setAutoCommit(false);

				ResultSet reader = null;
				Boolean bExist = false;
				try
				{
					reader = this.ForLockFromLocalCmd.executeQuery();
					reader.last();
					if (reader.getRow() <= 0)
					{
						bExist = false;
					}
					reader.beforeFirst();
					bExist = true;
				} catch (Exception ex)
				{
					bExist = false;
					logger.error(String.format("[Lock failed]:{%s}", ex));

				} finally
				{
					if (null != reader)
					{
						reader.close();
					}
				}

				if (!bExist)
				{
					this.ConnectObj.getConnection().rollback();

					logger.error(String.format("[Lock error] : no id=1 existed or resource is busy now and try lock later!"));

					return false;
				} else
				{
					return true;
				}

			}
		} catch (Exception e)
		{
			logger.error(e);
			return false;
		}
	}

	public void unLock()
	{
		try
		{
			this.ConnectObj.getConnection().commit();
			this.ConnectObj.getConnection().setAutoCommit(true);
		} catch (Exception ex)
		{
			if (this.ConnectObj.getConnection() != null)
			{
				try
				{
					this.ConnectObj.getConnection().rollback();
				} catch (SQLException e)
				{
					logger.error(e);
				}
			}
			logger.error(ex);
		}
	}
}