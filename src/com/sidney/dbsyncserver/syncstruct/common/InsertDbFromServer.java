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

public class InsertDbFromServer implements IOracleOperator
{
	private static Log logger = LogFactory.getLog(InsertDbFromServer.class);
	private Object lockObj = new Object();
	private static InsertDbFromServer thisInstance = new InsertDbFromServer();
	private IOracleConn ConnectObj = null;

	public static InsertDbFromServer getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (InsertDbFromServer.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new InsertDbFromServer();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	private InsertDbFromServer()
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
		createInsertFromServerCommand(_conn);
	}

	private String CMD_SELECT = "select id,list_name,data_type from SYNC_BALANCE_CTRL ";
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

	// region -- 当自广告投放server的数据是新mediabuy时，Insert --
	private String CMD_INSERT_FROM_SERVER = "insert into SYNC_BALANCE_CTRL (id,list_name,data_type,status,create_time,last_changed,saved_balance,sended_balance,x_budget,x_hit,x_balance,total_budget,total_hit) values (?,?,?,1,sysdate,sysdate,?,0,?,?,?,?,?) ";
	private PreparedStatement InsertFromServerCmd = null;

	private void createInsertFromServerCommand(Connection _conn)
	{
		try
		{
			if (this.InsertFromServerCmd == null || this.InsertFromServerCmd.isClosed())
			{
				this.InsertFromServerCmd = _conn.prepareStatement(CMD_INSERT_FROM_SERVER, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	public void insertFromServer(List<BalanceObj> _listBalance)
	{
		for (int i = 0; i < _listBalance.size(); ++i)
		{
			logger.info(String.format("InsertFromServer:%d,%d,%d,%s", _listBalance.get(i).Id, _listBalance.get(i).ListName, _listBalance.get(i).DataType, _listBalance.get(i).NeedSyncBalance.toString()));
		}

		synchronized (this.lockObj)
		{
			createCmd(this.ConnectObj.getConnection());

			List<BalanceObj> temp = new ArrayList<BalanceObj>();
			for (int i = 0; i < _listBalance.size(); i++)
			{
				temp.add(_listBalance.get(i));

				if (0 != i && i % ConfigurationHelper.UPDATE_BLOCK_SIZE == 0)
				{
					insertFromServerInLock(temp); // 按照配置的blocksize，批次update
					temp.clear();
				}
			}
			insertFromServerInLock(temp);
		}
	}

	private void insertFromServerInLock(List<BalanceObj> _listBalance)
	{
		if (null == _listBalance || 0 == _listBalance.size())
		{
			return;
		}

		try
		{
			// 连接由于异常,就不处理balance
			if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
			{
				return;
			}

			List<BalanceObj> tempBalanceObj = new ArrayList<BalanceObj>();
			ResultSet reader = null;
			try
			{
				reader = this.SelectCommand.executeQuery();
				while (reader.next())
				{
					int id = reader.getInt(1);
					int listname = reader.getInt(2);
					int datatype = reader.getInt(3);
					BalanceObj balaObj = new BalanceObj();
					balaObj.Id = id;
					balaObj.ListName = listname;
					balaObj.DataType = datatype;
					tempBalanceObj.add(balaObj);
				}
			} catch (Exception ex)
			{
			} finally
			{
				if (null != reader)
				{
					reader.close();
				}
			}

			List<BalanceObj> delBalanceObj = new ArrayList<BalanceObj>();
			for (int i = _listBalance.size() - 1; i >= 0; i--) // 防止重复插入，先搜索已经存在的数据，并删除
			{
				for (BalanceObj obj : tempBalanceObj)
				{
					if (obj.Id == _listBalance.get(i).Id && obj.ListName == _listBalance.get(i).ListName && obj.DataType == _listBalance.get(i).DataType)
					{
						delBalanceObj.add(_listBalance.get(i));
						break;
					}
				}
			}
			_listBalance.removeAll(delBalanceObj);

			if (null == _listBalance || 0 == _listBalance.size())
			{
				logger.error(String.format("Needn't to insert,because there are all mediabuys in SYNC_BALANCE_CTRL."));
				return;
			}

			this.ConnectObj.getConnection().setAutoCommit(false);

			try
			{
				for (BalanceObj balance : _listBalance)
				{
					this.InsertFromServerCmd.setInt(1, balance.Id);
					this.InsertFromServerCmd.setInt(2, balance.ListName);
					this.InsertFromServerCmd.setInt(3, balance.DataType);
					this.InsertFromServerCmd.setBigDecimal(4, balance.NeedSyncBalance);
					this.InsertFromServerCmd.setBigDecimal(5, balance.NewXBudget);
					this.InsertFromServerCmd.setBigDecimal(6, balance.NewXHit);
					this.InsertFromServerCmd.setBigDecimal(7, balance.NewXBalance);
					this.InsertFromServerCmd.setBigDecimal(8, balance.NewTotalBudget);
					this.InsertFromServerCmd.setBigDecimal(9, balance.NewTotalHit);
					this.InsertFromServerCmd.addBatch();
				}
				int[] batchCounts = this.InsertFromServerCmd.executeBatch();

				this.ConnectObj.getConnection().commit();
			} catch (SQLException ex)
			{
				logger.info(String.format("id,list_name,data_type,saved_balance,x_budget,x_hit,x_balance,total_budget,total_hit:%d", _listBalance.size()));
				for (int i = 0; i < _listBalance.size(); ++i)
				{
					logger.info(String.format("%d,%d,%d,%s,%s,%s,%s,%s,%s", _listBalance.get(i).Id, _listBalance.get(i).ListName, _listBalance.get(i).DataType, _listBalance.get(i).NeedSyncBalance.toString(), _listBalance.get(i).NewXBudget.toString(), _listBalance.get(i).NewXHit.toString(), _listBalance.get(i).NewXBalance.toString(),
							_listBalance.get(i).NewTotalBudget.toString(), _listBalance.get(i).NewTotalHit.toString()));
				}
			}

			for (BalanceObj balance : _listBalance)
			{
				balance.NewXBalance = balance.NewXBalance.subtract(balance.NeedSyncBalance); // 之前从db中读取的剩余流量
																								// -
																								// 之后更新的已跑流量
				balance.NewXHit = balance.NewXHit.add(balance.NeedSyncBalance);
				balance.Status = (int) SyncStatusType.SYNC_SUCCESS.getValue(); // 更新成功
			}
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
		} finally
		{
			try
			{
				this.ConnectObj.getConnection().commit();
				this.ConnectObj.getConnection().setAutoCommit(true);
			} catch (SQLException e)
			{
				logger.error(e);
			}
		}
	}

	public void dispose()
	{
	}
}