package com.sidney.dbsyncserver.update;

import java.util.List;

import com.sidney.dbsyncserver.syncinterface.BinaryData;
import com.sidney.dbsyncserver.syncinterface.BinaryType;
import com.sidney.dbsyncserver.syncinterface.ClientInfo;
import com.sidney.dbsyncserver.syncinterface.IMaster;
import com.sidney.dbsyncserver.syncinterface.ISlave;
import com.sidney.dbsyncserver.syncinterface.TransferInfo;
import com.sidney.dbsyncserver.syncmodel.Balance;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.thriftclient.ClientToMaster;
import com.sidney.dbsyncserver.thriftclient.ClientToSlave;
import com.sidney.dbsyncserver.tserializ.common.DbSerializeService;

public class UpdateBalance
{
	private static UpdateBalance thisInstance = new UpdateBalance();

	public static UpdateBalance getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (UpdateBalance.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new UpdateBalance();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;

	}

	private ClientToSlave slaveProxy = null;
	private ClientToMaster masterProxy = null;

	// / <summary>
	// / 构造函数
	// / </summary>
	public UpdateBalance()
	{
		this.slaveProxy = null;
		this.masterProxy = null;
	}

	// / <summary>
	// / 向status service发送/接收mediabuy的balance数据
	// / </summary>
	// / <param name="_mbb">mediabuy balance数据结构</param>
	// / <param name="_addr">连接字符串，如
	// "http://localhost:8080/MasterService"</param>
	// / <returns>mediabuybalance的对象集合</returns>
	public List<BalanceObj> updateBalanceToSlave(List<BalanceObj> _mbb, String[] _addr, ClientInfo clientInfo)
	{
		if (null == _mbb || null == _addr)
		{
			return null;
		}

		if (null != clientInfo)
		{
			clientInfo.setVersion(10);
		}
		
		if (null == slaveProxy)
		{
			slaveProxy = new ClientToSlave(_addr);
		}

		List<BalanceObj> ret = null;
		ISlave.Client proxy = null;
		try
		{
			// 生成代理
			proxy = slaveProxy.getSlaveProxy();
			if (null == proxy)
			{
				return null;
			}

			// 生成mediabuybalance结构
			Balance mbb = new Balance(1, _mbb);

			// 生成传输结构
			TransferInfo bi = new TransferInfo();
			byte[] bytes = new DbSerializeService().serializeToBytes(mbb, BinaryType.BALANCE);
			bi.setVersion(10);
			bi.setType(BinaryType.BALANCE.getValue());
			bi.setStatus(1);
			bi.setClientinfo(clientInfo);
			BinaryData biData = new BinaryData();
			biData.setVersion(10);
			biData.setType(BinaryType.BALANCE);
			biData.setData(bytes);
			biData.setLength(bytes.length);
			bi.setData(biData);

			// 向service传输, 并获得返回
			TransferInfo retBi = proxy.syncBalance(bi, 0);

			// 处理返回的数据
			Balance retmbb = (Balance) new DbSerializeService().deSerializefromBytes(retBi.getData().getData(), BinaryType.BALANCE);
			ret = retmbb.mbObj;
		} catch (Exception e)
		{

		} finally
		{
		}
		return ret;
	}

	// / <summary>
	// / 从slave向上一层status service发送数据
	// / </summary>
	// / <param name="_mbb">mediabuy balance数据结构</param>
	// / <param name="_addr">连接字符串，如 "http://localhost:8080/MasterService"
	// </param>
	// / <returns>mediabuybalance的对象集合</returns>
	public List<BalanceObj> updateBalanceToMaster(List<BalanceObj> _mbb, String[] _addr, ClientInfo clientInfo)
	{
		if (null == _mbb || null == _addr)
		{
			return null;
		}
		
		if (null != clientInfo)
		{
			clientInfo.setVersion(10);
		}

		if (null == masterProxy)
		{
			masterProxy = new ClientToMaster(_addr);
		}

		List<BalanceObj> ret = null;
		IMaster.Client proxy = null;
		try
		{
			// 生成代理
			proxy = masterProxy.getMasterProxy();
			if (null == proxy)
			{
				return null;
			}

			// 生成mediabuybalance结构
			Balance mbb = new Balance(1, _mbb);

			// 生成传输结构
			TransferInfo bi = new TransferInfo();
			byte[] bytes = new DbSerializeService().serializeToBytes(mbb, BinaryType.BALANCE);
			bi.setVersion(10);
			bi.setType(BinaryType.BALANCE.getValue());
			bi.setStatus(1);
			bi.setClientinfo(clientInfo);
			BinaryData biData = new BinaryData();
			biData.setVersion(10);
			biData.setType(BinaryType.BALANCE);
			biData.setData(bytes);
			biData.setLength(bytes.length);
			bi.setData(biData);

			// 向service传输, 并获得更新
			TransferInfo retBi = proxy.syncBalance(bi, 0);

			// 获得返回的数据
			Balance retmbb = (Balance) new DbSerializeService().deSerializefromBytes(retBi.getData().getData(), BinaryType.BALANCE);
			ret = retmbb.mbObj;
		} catch (Exception e)
		{

		} finally
		{
		}
		return ret;
	}
}