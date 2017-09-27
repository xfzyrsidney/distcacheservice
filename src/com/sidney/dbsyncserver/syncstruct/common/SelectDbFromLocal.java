package com.sidney.dbsyncserver.syncstruct.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.oracledb.IOracleConn;
import com.sidney.dbsyncserver.oracledb.IOracleOperator;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.syncmodel.SyncStatusType;
import com.sidney.dbsyncserver.utils.SendMailService;

public class SelectDbFromLocal implements IOracleOperator
{
	private static Log logger = LogFactory.getLog(SelectDbFromLocal.class);
	private static SelectDbFromLocal thisInstance = new SelectDbFromLocal();
	private IOracleConn ConnectObj = null;

	public static SelectDbFromLocal getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (SelectDbFromLocal.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new SelectDbFromLocal();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	private SelectDbFromLocal()
	{
		if(ConfigurationHelper.DSPSYNCBALANCECTRLFLAG == true){
			this.ConnectObj = new OracleDBConnection(ConfigurationHelper.DSPDATASOURCE);
		} else {
			this.ConnectObj = new OracleDBConnection(ConfigurationHelper.ADMANAGERDATASOURCE);
		}
		this.ConnectObj.registCommand(this);
		createCmd(this.ConnectObj.getConnection());
	}

	public void createCmd(Connection _conn)
	{
		createSelectCommand(_conn);
		createSelectAllCommand(_conn);
	}

	// region -- 读取本地DB中需要发向master status service数据 --
	private String CMD_SELECT = "select id,list_name,data_type,saved_balance,sended_balance,version from SYNC_BALANCE_CTRL where status in (1,2)";
	private PreparedStatement SelectCommand = null;

	private void createSelectCommand(Connection _conn)
	{
		try
		{
			if (this.SelectCommand == null || this.SelectCommand.isClosed())
			{
				this.SelectCommand = _conn.prepareStatement(CMD_SELECT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	public List<BalanceObj> select()
	{
		List<BalanceObj> ret = new ArrayList<BalanceObj>();

		ResultSet reader = null;
		try
		{
			// 连接由于异常,就不处理balance
			if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
			{
				return null;
			}
			createCmd(this.ConnectObj.getConnection());

			reader = this.SelectCommand.executeQuery();
			while (reader.next())
			{
				int id = reader.getInt(1);
				int listname = reader.getInt(2);
				int datatype = reader.getInt(3);
				BigDecimal savedbalance = reader.getBigDecimal(4);
				BigDecimal sendedbalance = reader.getBigDecimal(5);
				long version = reader.getLong(6);

				BalanceObj bObj = new BalanceObj();
				bObj.Id = id;
				bObj.ListName = listname;
				bObj.DataType = datatype;
				bObj.NeedSyncBalance = savedbalance.subtract(sendedbalance);
				if(bObj.NeedSyncBalance.compareTo(new BigDecimal("0"))  == -1){
					bObj.NeedSyncBalance = new BigDecimal("0");
				}
				bObj.Status = (int) SyncStatusType.INIT.getValue();
				bObj.Version = version;

				boolean existFlag = false;
				for (BalanceObj obj : ret)
				{
					if (obj.Id == id && obj.ListName == listname && obj.DataType == datatype)
					{
						existFlag = true;
						break;
					}
				}
				if (!existFlag)
				{
					ret.add(bObj);
					//logger.info(String.format("SelectDbFromLocal: got from local DB:{Id:%d,ListName:%d,DataType:%d,NeedSyncBalance:%s,Status:%d}", bObj.Id, bObj.ListName, bObj.DataType, bObj.NeedSyncBalance.toString(), bObj.Status));
				}
			}
		} catch (SQLException e)
		{
			logger.error(e);
		} finally
		{
			if (null != reader)
			{
				try
				{
					reader.close();
				} catch (SQLException e)
				{
					logger.error(e);
				}
			}
		}

		return ret;
	}

	// region -- 读取本地DB中所有数据 --
	private String CMD_SELECT_ALL = "select id,list_name,data_type, x_budget,x_hit,x_balance ,total_budget,total_hit,version from SYNC_BALANCE_CTRL where status in (1,2) ";
	private PreparedStatement SelectAllCommand = null;

	private void createSelectAllCommand(Connection _conn)
	{
		try
		{
			if (this.SelectAllCommand == null || this.SelectAllCommand.isClosed())
			{
				this.SelectAllCommand = _conn.prepareStatement(CMD_SELECT_ALL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	public List<BalanceObj> selectAll()
	{
		List<BalanceObj> ret = new ArrayList<BalanceObj>();

		ResultSet reader = null;
		try
		{
			// 连接由于异常,就不处理balance
			if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
			{
				return null;
			}
			createCmd(this.ConnectObj.getConnection());
			
			reader = this.SelectAllCommand.executeQuery();
			while (reader.next())
			{
				int id = reader.getInt(1);
				int listname = reader.getInt(2);
				int datatype = reader.getInt(3);
				BigDecimal xbudget = reader.getBigDecimal(4);
				BigDecimal xhit = reader.getBigDecimal(5);
				BigDecimal xbalance = reader.getBigDecimal(6);
				BigDecimal totalbudget = reader.getBigDecimal(7);
				BigDecimal totalhit = reader.getBigDecimal(8);
				long version = reader.getLong(9);

				BalanceObj bObj = new BalanceObj();
				bObj.Id = id;
				bObj.ListName = listname;
				bObj.DataType = datatype;
				bObj.NeedSyncBalance = new BigDecimal("0");
				bObj.Status = (int) SyncStatusType.INIT.getValue();
				bObj.NewXBudget = xbudget;
				bObj.NewXHit = xhit;
				bObj.NewXBalance = xbalance;
				bObj.NewTotalBudget = totalbudget;
				bObj.NewTotalHit = totalhit;
				bObj.Version = version;
				
				boolean existFlag = false;
				for (BalanceObj obj : ret)
				{
					if (obj.Id == id && obj.ListName == listname && obj.DataType == datatype)
					{
						existFlag = true;
						break;
					}
				}
				if (!existFlag)
				{
					ret.add(bObj);
				}
			}
		} catch (Exception ex)
		{
			logger.error(ex);
		} finally
		{
			if (null != reader)
			{
				try
				{
					reader.close();
				} catch (SQLException e)
				{
					logger.error(e);
				}
			}
		}

		return ret;
	}

	public void dispose()
	{
		if(this.ConnectObj != null){
    		this.ConnectObj.dispose();
			this.ConnectObj = null;
    	}
	}
}
