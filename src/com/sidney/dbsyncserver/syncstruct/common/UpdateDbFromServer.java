package com.sidney.dbsyncserver.syncstruct.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.oracledb.IOracleConn;
import com.sidney.dbsyncserver.oracledb.IOracleOperator;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.syncmodel.SyncStatusType;
import com.sidney.dbsyncserver.utils.SendMailService;
import com.sidney.dbsyncserver.utils.ShowBalanceObj;

public class UpdateDbFromServer implements IOracleOperator
{
	private static Log logger = LogFactory.getLog(UpdateDbFromServer.class);
	private Object lockObj = new Object();
	private IOracleConn ConnectObj = null;

	private List<AtomicBoolean> listDelegate = new ArrayList<AtomicBoolean>();

	public void registUpdateNotice(AtomicBoolean _delegate)
	{
		this.listDelegate.add(_delegate);
	}

	private void notice()
	{
		for (AtomicBoolean d : this.listDelegate)
		{
			d.set(true);
		}
	}

	private static UpdateDbFromServer thisInstance = new UpdateDbFromServer();

	public static UpdateDbFromServer getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (UpdateDbFromServer.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new UpdateDbFromServer();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	private UpdateDbFromServer()
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
		createForUpdateFromServerCommand(_conn);
		createUpdateFromServerCommand(_conn);
	}

	// region -- 来自广告投放server的数据，写入本地DB --

	private String CMD_FOR_UPDATE_FROM_SERVER = "select x_budget,x_hit,x_balance,total_budget,total_hit,saved_balance,sended_balance  from SYNC_BALANCE_CTRL where id = ? and list_name = ? and data_type = ? for update wait 1";
	private PreparedStatement ForUpdateFromServerCmd = null;

	private void createForUpdateFromServerCommand(Connection _conn)
	{
		try
		{
			if (this.ForUpdateFromServerCmd == null || this.ForUpdateFromServerCmd.isClosed())
			{
				this.ForUpdateFromServerCmd = _conn.prepareStatement(CMD_FOR_UPDATE_FROM_SERVER, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	// 从server的更新，设定status=1
	private String CMD_UPDATE_FROM_SERVER = "update SYNC_BALANCE_CTRL set last_changed = sysdate, status = 1, saved_balance = nvl(saved_balance, 0) + ? where id = ? and list_name = ? and data_type = ?  ";
	private PreparedStatement UpdateFromServerCmd = null;

	private void createUpdateFromServerCommand(Connection _conn)
	{
		try
		{
			if (this.UpdateFromServerCmd == null || this.UpdateFromServerCmd.isClosed())
			{
				this.UpdateFromServerCmd = _conn.prepareStatement(CMD_UPDATE_FROM_SERVER, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
		} catch (SQLException e)
		{
			logger.error(e);
		}
	}

	public void updateFromServer(List<BalanceObj> _listBalance)
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
						updateFromServerOnebyOne(_listBalance.get(i));
					}
				} else
				{
					// 每次更新多行
					List<BalanceObj> temp = new ArrayList<BalanceObj>();
					for (int i = 0; i < _listBalance.size(); i++)
					{
						temp.add(_listBalance.get(i));

						if (0 != i && i % ConfigurationHelper.UPDATE_BLOCK_SIZE == 0)
						{
							updateFromServerInLock(temp); // 按照配置的blocksize，批次update
							temp.clear();
						}
					}
					updateFromServerInLock(temp);
				}
				notice();
			}
		} catch (Exception e)
		{
			logger.error(e);
		}
	}

	private void updateFromServerInLock(List<BalanceObj> _listBalance)
	{
		if (null == _listBalance || 0 == _listBalance.size())
		{
			return;
		}

		List<BalanceObj> toInsert = null; // 没有更新的，需要再更新的

		try
		{
			// 连接由于异常,就不处理balance
			if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
			{
				return;
			}

			this.ConnectObj.getConnection().setAutoCommit(false);

			List<BalanceObj> newObjInDb = new ArrayList<BalanceObj>();

			List<BigDecimal> listNeedSyncBalance = new ArrayList<BigDecimal>();
			List<Integer> listId = new ArrayList<Integer>();
			List<Integer> listName = new ArrayList<Integer>();
			List<Integer> listDataType = new ArrayList<Integer>();

			boolean bExist = false;
			for (BalanceObj balance : _listBalance)
			{
				ResultSet reader = null;
				try
				{
					this.ForUpdateFromServerCmd.setInt(1, balance.Id);
					this.ForUpdateFromServerCmd.setInt(2, balance.ListName);
					this.ForUpdateFromServerCmd.setInt(3, balance.DataType);

					reader = this.ForUpdateFromServerCmd.executeQuery();
					reader.last();
					if (reader.getRow() <= 0)
					{
						continue;
					}
					reader.beforeFirst();

					ShowBalanceObj.show(balance, "UpdateDbFromServer.UpdateFromServerInLock.read before", logger); // log

					while (reader.next())
					{
						BigDecimal readerNewXBudget = reader.getBigDecimal(1);
						BigDecimal readerNewXHit = reader.getBigDecimal(2);
						BigDecimal readerNewXBalance = reader.getBigDecimal(3);
						BigDecimal readerNewTotalBudget = reader.getBigDecimal(4);
						BigDecimal readerNewTotalHit = reader.getBigDecimal(5);

						if (readerNewXBudget != null)
						{
							balance.NewXBudget = readerNewXBudget;
						}
						if (readerNewXHit != null)
						{
							balance.NewXHit = readerNewXHit;
						}
						if (readerNewXBalance != null)
						{
							balance.NewXBalance = readerNewXBalance;
						}
						if (readerNewTotalBudget != null)
						{
							balance.NewTotalBudget = readerNewTotalBudget;
						}
						if (readerNewTotalHit != null)
						{
							balance.NewTotalHit = readerNewTotalHit;
						}

						// 需要看saved和sended的量。因为他们的差值并没有被计算到balance这些量里。
						BigDecimal savedbalance = reader.getBigDecimal(6);
						BigDecimal sendedbalance = reader.getBigDecimal(7);
						if (savedbalance == null)
						{
							savedbalance = new BigDecimal("0");
						}
						if (readerNewTotalHit == null)
						{
							sendedbalance = new BigDecimal("0");
						}

						BigDecimal temp = savedbalance.subtract(sendedbalance);

						if (savedbalance.compareTo(sendedbalance) == 1)
						{
							balance.NewXHit = balance.NewXHit.add(temp);
							balance.NewXBalance = balance.NewXBalance.subtract(temp);
							balance.NewTotalHit = balance.NewTotalHit.add(temp);
						}
					}
					bExist = true;

					ShowBalanceObj.show(balance, "UpdateDbFromServer.UpdateFromServerInLock.read after", logger); // log

					listNeedSyncBalance.add(balance.NeedSyncBalance);
					listId.add(balance.Id);
					listName.add(balance.ListName);
					listDataType.add(balance.DataType);
				} catch (Exception ex)
				{
					logger.error(String.format("[UpdateDbFromServer.updateFromServerInLock] error:{%d},{%d},{%d},{%s},{%s}",
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
			if (!bExist)
			{
				this.ConnectObj.getConnection().rollback(); // 如果没有一个id存在，则先回滚

				toInsert = _listBalance; // 所有的数据将作为新数据插入表
				return;
			}
			
			BigDecimal arraySavedBalance[] = new BigDecimal[listNeedSyncBalance.size()];
			for (int i = 0; i < listNeedSyncBalance.size(); ++i)
			{
				arraySavedBalance[i] = listNeedSyncBalance.get(i);
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
				this.UpdateFromServerCmd.setBigDecimal(1, arraySavedBalance[index]);
				this.UpdateFromServerCmd.setInt(2, arrayId[index]);
				this.UpdateFromServerCmd.setInt(3, arrayName[index]);
				this.UpdateFromServerCmd.setInt(4, arrayDataType[index]);

				this.UpdateFromServerCmd.addBatch();
			}
			int[] batchCounts = this.UpdateFromServerCmd.executeBatch();

			this.ConnectObj.getConnection().commit();

			for (BalanceObj balance : _listBalance)
			{
				boolean bExistInlistId = false; // 判断当前balance是否在db中存在
				for (int i = 0; i < listId.size(); ++i)
				{
					if ((listId.get(i) == balance.Id) && (listName.get(i) == balance.ListName) && (listDataType.get(i) == balance.DataType))
					{
						ShowBalanceObj.show(balance, "UpdateDbFromServer.UpdateFromServerInLock.update before", logger); // log

						balance.NewXBalance = balance.NewXBalance.subtract(balance.NeedSyncBalance); // 之前从db中读取的剩余流量
																										// -
																										// 之后更新的已跑流量
						balance.NewXHit = balance.NewXHit.add(balance.NeedSyncBalance); // 之前从db中读取的每日流量
																						// +
																						// 之后更新的已跑流量
						balance.NewTotalHit = balance.NewTotalHit.add(balance.NeedSyncBalance);
						balance.Status = (int) SyncStatusType.SYNC_SUCCESS.getValue(); // 更新成功

						ShowBalanceObj.show(balance, "UpdateDbFromServer.UpdateFromServerInLock.update after", logger); // log

						bExistInlistId = true;
						break;
					}
				}
				if (!bExistInlistId)
				{
					if (null == toInsert)
					{
						toInsert = new ArrayList<BalanceObj>();
					}
					toInsert.add(balance); // 如果未能更新，说明可能是没有这个数据
				}
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

			try
			{
				if (null != toInsert && toInsert.size() > 0)
				{
					InsertDbFromServer.getInstance().insertFromServer(toInsert);
				}
			} catch (Exception e)
			{
				logger.error(e);
			}
		}
	}

	// / <summary>
	// / 逐个update
	// / </summary>
	// / <param name="_obj">1个需要更新的数据</param>
	// / <returns>false:update失败</returns>
	private boolean updateFromServerOnebyOne(BalanceObj balance)
	{
		if (null == balance)
		{
			return false;
		}

		List<BalanceObj> toInsert = new ArrayList<BalanceObj>(); // 没有更新的，需要再更新的
		ResultSet reader = null;
		try
		{
			// 连接由于异常,就不处理balance
			if (null == this.ConnectObj || this.ConnectObj.getConnection() == null || this.ConnectObj.getConnection().isClosed())
			{
				return false;
			}

			this.ConnectObj.getConnection().setAutoCommit(false);

			this.ForUpdateFromServerCmd.setInt(1, balance.Id);
			this.ForUpdateFromServerCmd.setInt(2, balance.ListName);
			this.ForUpdateFromServerCmd.setInt(3, balance.DataType);

			reader = this.ForUpdateFromServerCmd.executeQuery();

			reader.last();
			if (reader.getRow() <= 0)
			{
				this.ConnectObj.getConnection().rollback();
				toInsert.add(balance); // 数据将作为新数据插入表
				return true;
			}
			reader.beforeFirst();
			while (reader.next())
			{
				BigDecimal readerNewXBudget = reader.getBigDecimal(1);
				BigDecimal readerNewXHit = reader.getBigDecimal(2);
				BigDecimal readerNewXBalance = reader.getBigDecimal(3);
				BigDecimal readerNewTotalBudget = reader.getBigDecimal(4);
				BigDecimal readerNewTotalHit = reader.getBigDecimal(5);

				if (readerNewXBudget != null)
				{
					balance.NewXBudget = readerNewXBudget;
				}
				if (readerNewXHit != null)
				{
					balance.NewXHit = readerNewXHit;
				}
				if (readerNewXBalance != null)
				{
					balance.NewXBalance = readerNewXBalance;
				}
				if (readerNewTotalBudget != null)
				{
					balance.NewTotalBudget = readerNewTotalBudget;
				}
				if (readerNewTotalHit != null)
				{
					balance.NewTotalHit = readerNewTotalHit;
				}

				// 需要看saved和sended的量。因为他们的差值并没有被计算到balance这些量里。
				BigDecimal savedbalance = reader.getBigDecimal(6);
				BigDecimal sendedbalance = reader.getBigDecimal(7);
				if (savedbalance == null)
				{
					savedbalance = new BigDecimal("0");
				}
				if (readerNewTotalHit == null)
				{
					sendedbalance = new BigDecimal("0");
				}

				BigDecimal temp = savedbalance.subtract(sendedbalance);

				if (savedbalance.compareTo(sendedbalance) == 1)
				{
					balance.NewXHit = balance.NewXHit.add(temp);
					balance.NewXBalance = balance.NewXBalance.subtract(temp);
					balance.NewTotalHit = balance.NewTotalHit.add(temp);
				}
			}
			if (null != reader)
			{
				reader.close();
				reader = null;
			}

			this.UpdateFromServerCmd.setBigDecimal(1, balance.NeedSyncBalance);
			this.UpdateFromServerCmd.setInt(2, balance.Id);
			this.UpdateFromServerCmd.setInt(3, balance.ListName);
			this.UpdateFromServerCmd.setInt(4, balance.DataType);
			this.UpdateFromServerCmd.addBatch();

			int[] batchCounts = this.UpdateFromServerCmd.executeBatch();

			this.ConnectObj.getConnection().commit();

			balance.NewXBalance = balance.NewXBalance.subtract(balance.NeedSyncBalance); // 之前从db中读取的剩余流量
																							// -
																							// 之后更新的已跑流量
			balance.NewXHit = balance.NewXHit.add(balance.NeedSyncBalance); // 之前从db中读取的每日流量
																			// +
																			// 之后更新的已跑流量
			balance.NewTotalHit = balance.NewTotalHit.add(balance.NeedSyncBalance);
			balance.Status = (int) SyncStatusType.SYNC_SUCCESS.getValue(); // 更新成功

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
				if (null != reader)
				{
					reader.close();
					reader = null;
				}
				this.ConnectObj.getConnection().commit();
				this.ConnectObj.getConnection().setAutoCommit(true);
			} catch (SQLException e)
			{
				logger.error(e);
			}

			try
			{
				if (null != toInsert && toInsert.size() > 0)
				{
					InsertDbFromServer.getInstance().insertFromServer(toInsert);
				}
			} catch (Exception e)
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
