package com.sidney.dbsyncserver.syncstruct.common;

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
import com.sidney.dbsyncserver.syncstruct.balanceoperation.UpdateAdSpaceClick;
import com.sidney.dbsyncserver.utils.SendMailService;

public class UpdateDbFromMaster implements IOracleOperator
{
	private static Log logger = LogFactory.getLog(UpdateDbFromMaster.class);
	private Object lockObj = new Object();
	private static UpdateDbFromMaster thisInstance = new UpdateDbFromMaster();
	private IOracleConn ConnectObj = null;

	public static UpdateDbFromMaster getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (UpdateDbFromMaster.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new UpdateDbFromMaster();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	private UpdateDbFromMaster()
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
		createForUpdateFromMasterCommand(_conn);
		createUpdateFromMasterCommand(_conn);
	}

	// region -- 来自master status service的数据，写入本地DB --
	private String CMD_FOR_UPDATE_FROM_MASTER = "select sended_balance, x_budget, x_hit, x_balance ,total_budget,total_hit,version from SYNC_BALANCE_CTRL  where id = ? and list_name = ? and data_type = ? for update wait 1";
	private PreparedStatement ForUpdateFromMasterCmd = null;

	private void createForUpdateFromMasterCommand(Connection _conn)
	{
		try
		{
			if (this.ForUpdateFromMasterCmd == null || this.ForUpdateFromMasterCmd.isClosed())
			{
				this.ForUpdateFromMasterCmd = _conn.prepareStatement(CMD_FOR_UPDATE_FROM_MASTER, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	// 从master的更新，设定status=2
	private String CMD_UPDATE_FROM_MASTER = "update SYNC_BALANCE_CTRL  set sended_balance = nvl(sended_balance, 0) + ?, x_budget = ?, x_hit = ?, x_balance = ?, total_budget = ?, total_hit = ? ,version = nvl(version, 0) + 1 , status = 2 where id = ? and list_name = ? and data_type = ? ";
	private PreparedStatement UpdateFromMasterCmd = null;

	private void createUpdateFromMasterCommand(Connection _conn)
	{
		try
		{
			if (this.UpdateFromMasterCmd == null || this.UpdateFromMasterCmd.isClosed())
			{
				this.UpdateFromMasterCmd = _conn.prepareStatement(CMD_UPDATE_FROM_MASTER, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	public void UpdateFromMaster(List<BalanceObj> _listBalance)
	{
		try
		{
			synchronized (lockObj)
			{
				Collections.sort(_listBalance);
				createCmd(this.ConnectObj.getConnection());
				if (ConfigurationHelper.UPDATE_ONE_BY_ONE)
                {
                    // 每次更新一行
                    for (int i = 0; i < _listBalance.size(); i++)
                    {
                        updateFromMasterOnebyOne(_listBalance.get(i));
                    }
                }
                else
                {
                    List<BalanceObj> temp = new ArrayList<BalanceObj>();
                    for (int i = 0; i < _listBalance.size(); i++)
                    {
                        temp.add(_listBalance.get(i));

                        if (0 != i && i % ConfigurationHelper.UPDATE_BLOCK_SIZE == 0)
                        {
                        	updateFromMasterInLock(temp); // 按照配置的blocksize，批次update
                            temp.clear();
                        }
                    }
                    updateFromMasterInLock(temp);
                }
			}
		} catch (Exception e)
		{
			logger.error(e);
		}
	}

	private void updateFromMasterInLock(List<BalanceObj> _listBalance)
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

			this.ConnectObj.getConnection().setAutoCommit(false);

			List<BigDecimal> listNeedSyncBalance = new ArrayList<BigDecimal>();
			List<BigDecimal> listBudget = new ArrayList<BigDecimal>();
			List<BigDecimal> listHit = new ArrayList<BigDecimal>();
			List<BigDecimal> listBalance = new ArrayList<BigDecimal>();
			List<BigDecimal> listTotalBudget = new ArrayList<BigDecimal>();
			List<BigDecimal> listTotalHit = new ArrayList<BigDecimal>();
			List<Integer> listId = new ArrayList<Integer>();
			List<Integer> listName = new ArrayList<Integer>();
			List<Integer> listDataType = new ArrayList<Integer>();

			boolean bExist = false;
			for (BalanceObj balance : _listBalance)
			{
				ResultSet reader = null;
				long version = 0;
				try
				{
					this.ForUpdateFromMasterCmd.setInt(1, balance.Id);
					this.ForUpdateFromMasterCmd.setInt(2, balance.ListName);
					this.ForUpdateFromMasterCmd.setInt(3, balance.DataType);

					reader = this.ForUpdateFromMasterCmd.executeQuery();
					reader.last();
					if (reader.getRow() <= 0)
					{
						continue;
					}
					reader.beforeFirst();
					while (reader.next())
					{
						version = reader.getLong(7);
					}
					bExist = true;

					if (version <= balance.Version)
					{
						listNeedSyncBalance.add(balance.NeedSyncBalance);
						listBudget.add(balance.NewXBudget);
						listHit.add(balance.NewXHit);
						listBalance.add(balance.NewXBalance);
						listTotalBudget.add(balance.NewTotalBudget);
						listTotalHit.add(balance.NewTotalHit);
						listId.add(balance.Id);
						listName.add(balance.ListName);
						listDataType.add(balance.DataType);
					}
				} catch (Exception ex)
                {
                    logger.error(String.format("[UpdateDbFromMaster.UpdateFromMasterInLock] error:{%d},{%d},{%d},{%s},{%s}",
                            balance.Id,
                            balance.ListName,
                            balance.DataType,
                            balance.NeedSyncBalance.toString(),
                            ex
                            ));
                
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
				 for (BalanceObj i : _listBalance)
                 {
					 logger.info(String.format("[UpdateDbFromMaster.UpdateFromMasterInLock] rollback all:{%d},{%d},{%d},{%s}",
                             i.Id,
                             i.ListName,
                             i.DataType,
                             i.NeedSyncBalance.toString()
                             ));
                 }
				return;
			}
			
			BigDecimal arraySendedBalance[] = new BigDecimal[listNeedSyncBalance.size()];
			for (int i = 0; i < listNeedSyncBalance.size(); ++i)
			{
				arraySendedBalance[i] = listNeedSyncBalance.get(i);
			}
			BigDecimal arrayXBudget[] = new BigDecimal[listBudget.size()];
			for (int i = 0; i < listBudget.size(); ++i)
			{
				arrayXBudget[i] = listBudget.get(i);
			}
			BigDecimal arrayXHit[] = new BigDecimal[listHit.size()];
			for (int i = 0; i < listHit.size(); ++i)
			{
				arrayXHit[i] = listHit.get(i);
			}
			BigDecimal arrayXBalance[] = new BigDecimal[listBalance.size()];
			for (int i = 0; i < listBalance.size(); ++i)
			{
				arrayXBalance[i] = listBalance.get(i);
			}
			BigDecimal arrayTotalBudget[] = new BigDecimal[listTotalBudget.size()];
			for (int i = 0; i < listTotalBudget.size(); ++i)
			{
				arrayTotalBudget[i] = listTotalBudget.get(i);
			}
			BigDecimal arrayTotalHit[] = new BigDecimal[listTotalHit.size()];
			for (int i = 0; i < listTotalHit.size(); ++i)
			{
				arrayTotalHit[i] = listTotalHit.get(i);
			}
			Integer arrayId[] = new Integer[listId.size()];
			for (int i = 0; i < listId.size(); ++i)
			{
				arrayId[i] = listId.get(i);
			}
			Integer arrayName[] = new Integer[listName.size()];
			for (int i = 0; i < listName.size(); ++i)
			{
				arrayName[i] = listName.get(i);
			}
			Integer arrayDataType[] = new Integer[listDataType.size()];
			for (int i = 0; i < listDataType.size(); ++i)
			{
				arrayDataType[i] = listDataType.get(i);
			}

			for (int index = 0; index < arrayId.length; index++)
			{
				this.UpdateFromMasterCmd.setBigDecimal(1, arraySendedBalance[index]);
				this.UpdateFromMasterCmd.setBigDecimal(2, arrayXBudget[index]);
				this.UpdateFromMasterCmd.setBigDecimal(3, arrayXHit[index]);
				this.UpdateFromMasterCmd.setBigDecimal(4, arrayXBalance[index]);
				this.UpdateFromMasterCmd.setBigDecimal(5, arrayTotalBudget[index]);
				this.UpdateFromMasterCmd.setBigDecimal(6, arrayTotalHit[index]);
				this.UpdateFromMasterCmd.setInt(7, arrayId[index]);
				this.UpdateFromMasterCmd.setInt(8, arrayName[index]);
				this.UpdateFromMasterCmd.setInt(9, arrayDataType[index]);
				this.UpdateFromMasterCmd.addBatch();
			}
			int[] batchCounts = this.UpdateFromMasterCmd.executeBatch();

			this.ConnectObj.getConnection().commit();
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
	
	private boolean updateFromMasterOnebyOne(BalanceObj balance)
	{
		if (null == balance)
		{
			return false;
		}

	
		try
		{
			// 连接由于异常,就不处理balance
			if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
			{
				return false;
			}

			this.ConnectObj.getConnection().setAutoCommit(false);

			ResultSet reader = null;
			long version = 0;
			this.ForUpdateFromMasterCmd.setInt(1, balance.Id);
			this.ForUpdateFromMasterCmd.setInt(2, balance.ListName);
			this.ForUpdateFromMasterCmd.setInt(3, balance.DataType);

			reader = this.ForUpdateFromMasterCmd.executeQuery();

			reader.last();
			if (reader.getRow() <= 0)
			{
				this.ConnectObj.getConnection().rollback();
				
				return true;
			}
			reader.beforeFirst();
			while (reader.next())
			{
				version = reader.getLong(7);

			}
			if (null != reader)
			{
				reader.close();
				reader = null;
			}

			if (version <= balance.Version)
			{
				this.UpdateFromMasterCmd.setBigDecimal(1, balance.NeedSyncBalance);
				this.UpdateFromMasterCmd.setBigDecimal(2, balance.NewXBudget);
				this.UpdateFromMasterCmd.setBigDecimal(3, balance.NewXHit);
				this.UpdateFromMasterCmd.setBigDecimal(4, balance.NewXBalance);
				this.UpdateFromMasterCmd.setBigDecimal(5, balance.NewTotalBudget);
				this.UpdateFromMasterCmd.setBigDecimal(6, balance.NewTotalHit);
				this.UpdateFromMasterCmd.setInt(7, balance.Id);
				this.UpdateFromMasterCmd.setInt(8, balance.ListName);
				this.UpdateFromMasterCmd.setInt(9, balance.DataType);

				this.UpdateFromMasterCmd.addBatch();
				this.UpdateFromMasterCmd.executeBatch();
			}
			this.ConnectObj.getConnection().commit();

			return true;
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
		return true;
	}


	public void dispose()
	{
	}
}