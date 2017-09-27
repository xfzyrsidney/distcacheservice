package com.sidney.dbsyncserver.syncstruct.balanceoperation;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

public class UpdateAdSpaceClick implements IOracleOperator
{
	private static Log logger = LogFactory.getLog(UpdateAdSpaceClick.class);
	private Object lockObj = new Object();
	private static UpdateAdSpaceClick thisInstance = new UpdateAdSpaceClick();

	public static UpdateAdSpaceClick getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (UpdateAdSpaceClick.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new UpdateAdSpaceClick();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	// 获得当前campaign_id的一行记录，并锁定
	private static String CMD_SELECT_FOR_UPDATE = "  for update wait 1";

	private static String CMD_UPDATE = " ";

	private IOracleConn ConnectObj = null;
	private PreparedStatement SelectCommand = null;
	private PreparedStatement UpdateCommand = null;

	private UpdateAdSpaceClick()
	{
		this.ConnectObj = new OracleDBConnection(ConfigurationHelper.ADMANAGERDATASOURCE);
		this.ConnectObj.registCommand(this);
		createCmd(this.ConnectObj.getConnection());
	}

	public void createCmd(Connection _conn)
	{
		createSelectCommand(_conn);
		createUpdateCommand(_conn);
	}

	private void createSelectCommand(Connection _conn)
	{
		try
		{
			if (this.SelectCommand == null || this.SelectCommand.isClosed())
			{
				this.SelectCommand = _conn.prepareStatement(CMD_SELECT_FOR_UPDATE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
		}
	}

	private void createUpdateCommand(Connection _conn)
	{
		try
		{
			if (this.UpdateCommand == null || this.UpdateCommand.isClosed())
			{
				this.UpdateCommand = _conn.prepareStatement(CMD_UPDATE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
			
		} catch (SQLException e)
		{
		}
	}

	public void update(List<BalanceObj> _listBalance)
	{
		try
		{
			synchronized (lockObj)
			{
				Collections.sort(_listBalance);
				createCmd(this.ConnectObj.getConnection());
				List<Integer> lstReturnFailed = new ArrayList<Integer>(); // select失败，被其它事物lock住的
				List<BalanceObj> temp = new ArrayList<BalanceObj>();
				for (int i = 0; i < _listBalance.size(); i++)
				{
					temp.add(_listBalance.get(i));

					if (0 != i && i % ConfigurationHelper.UPDATE_BLOCK_SIZE == 0)
					{
						lstReturnFailed.addAll(updateInLock(temp)); // 按照配置的blocksize，批次update
						temp.clear();
					}
				}
				lstReturnFailed.addAll(updateInLock(temp)); // 把剩余的都update

				if (lstReturnFailed != null && lstReturnFailed.size() > 0)
				{
					StringBuffer sb = new StringBuffer();
					for (Integer i : lstReturnFailed)
					{
						sb.append(String.valueOf(i) + " ");
					}
					String tempLog = String.format("[UpdateAdSpaceClick]:(size:%d) %s", lstReturnFailed.size(), sb);
					logger.error(tempLog);
					new SendMailService(ConfigurationHelper.ERROR_MAIL_TO, String.format("[DbSync.Master %s] DB busy", ConfigurationHelper.SERVICE_ADDRESS), tempLog);
				}
			}
		} catch (Exception e)
		{
			logger.error(e);
		}
	}

	// / <summary>
	// / 执行update
	// / </summary>
	// / <param name="_listBalance"></param>
	// / <returns>返回update失败的id</returns>
	private List<Integer> updateInLock(List<BalanceObj> _listBalance)
	{
		List<Integer> lstReturnFailed = new ArrayList<Integer>(); // select失败，被其它事物lock住的

		if (null == _listBalance || 0 == _listBalance.size())
		{
			return lstReturnFailed;
		}

		try
		{
			// 连接由于异常,就不处理balance
			if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
			{
				return lstReturnFailed;
			}

			this.ConnectObj.getConnection().setAutoCommit(false);

			List<Integer> listId = new ArrayList<Integer>();
			List<BigDecimal> listNeedSyncBalance = new ArrayList<BigDecimal>();

			boolean bExist = false;
			for (BalanceObj balance : _listBalance)
			{
				ResultSet reader = null;
				try
				{
					this.SelectCommand.setInt(1, balance.Id);

					reader = this.SelectCommand.executeQuery();
					reader.last();
					if (reader.getRow() <= 0)
					{
						continue;
					}
					reader.beforeFirst();

					while (reader.next())
					{
						BigDecimal temp1 = reader.getBigDecimal(1);
						BigDecimal temp2 = reader.getBigDecimal(2);
						if(temp1 != null){
							balance.NewXBudget = temp1;
						}
						if(temp2 != null){
							balance.NewXHit = temp2;
						}
		
					}
					bExist = true;

					listNeedSyncBalance.add(balance.NeedSyncBalance);
					listId.add(balance.Id);
				} catch (Exception ex)
				{
					lstReturnFailed.add(balance.Id);
				} finally
				{
					if (null != reader)
					{
						reader.close();
					}
				}
			}
			if (!bExist) // 如果没有一个id存在，则回滚
			{
				this.ConnectObj.getConnection().rollback();
				return lstReturnFailed;
			}

			BigDecimal arrayDBBalance[] = new BigDecimal[listNeedSyncBalance.size()];
			for (int i = 0; i < listNeedSyncBalance.size(); ++i)
			{
				arrayDBBalance[i] = listNeedSyncBalance.get(i);
			}
			Integer arrayId[] = new Integer[listId.size()];
			for (int i = 0; i < listId.size(); ++i)
			{
				arrayId[i] = listId.get(i);
			}

			for (int index = 0; index < arrayId.length; index++)
			{
				this.UpdateCommand.setBigDecimal(1, arrayDBBalance[index]);
				this.UpdateCommand.setInt(2, arrayId[index]);
				this.UpdateCommand.addBatch();
			}
			int[] batchCounts = this.UpdateCommand.executeBatch();

			this.ConnectObj.getConnection().commit();

			for (BalanceObj balance : _listBalance)
			{
				if (listId.contains(balance.Id))
				{
					balance.NewXHit = balance.NewXHit.add(balance.NeedSyncBalance); // 之前从db中读取的每日流量
																					// -
																					// 之后更新的已跑流量
					balance.Status = (int) SyncStatusType.SYNC_SUCCESS.getValue(); // 更新成功
				}
			}
		} catch (SQLException ex)
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
		return lstReturnFailed;
	}

	public void dispose()
	{

	}

}
