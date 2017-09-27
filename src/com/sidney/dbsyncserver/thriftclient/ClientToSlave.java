package com.sidney.dbsyncserver.thriftclient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import com.sidney.dbsyncserver.syncinstance.SlaveSync;
import com.sidney.dbsyncserver.syncinterface.ISlave;

public class ClientToSlave
{
	private static Log logger = LogFactory.getLog(ClientToSlave.class);

	private Object obj = new Object();

	private List<Queue<ServiceInfo>> qi = null;
	private int queueIndex = 0;

	private ISlave.Client proxy = null;

	public int CheckTimeSpan = 1000;// 查询/设置检查服务连接是否正常的间隔时间，

	public ClientToSlave(String[] _addr)
	{
		this.qi = new ArrayList<Queue<ServiceInfo>>();
		this.qi.add(new LinkedList<ServiceInfo>()); // first queue
		this.qi.add(new LinkedList<ServiceInfo>()); // second queue
		for (String a : _addr)
		{
			this.qi.get(0).offer(new ServiceInfo(a));
		}
		proxy = getValidProxy();
		initThread();
	}

	public ISlave.Client getSlaveProxy()
	{
		if (this.proxy == null)
		{
			reConnectService();
		} else {
			try
			{
				boolean flag = this.proxy.ping();
			} catch (TException e)
			{
				this.proxy = null;
				reConnectService();
			}
		}
		return this.proxy;
	}

	private void initThread()
	{
		Thread thr = new Thread(new Runnable() {
			public void run()
			{
				threadFun();
			}
		});

		thr.start();
	}

	private void threadFun()
	{
		while (true)
		{
			try
			{
				Thread.sleep(CheckTimeSpan);
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}

			if (this.proxy == null)
			{
				reConnectService();
			} 
		}
	}

	private void reConnectService()
	{
		try
		{
			synchronized (this.obj)
			{
				logger.info(String.format("[ClientToMaster] Need to ReConnectService!"));
				this.proxy = getValidProxy();
			}
		} catch (Exception e)
		{
		}
	}

	private ISlave.Client getValidProxy()
	{
		ISlave.Client proxy = null;

		// 当前队列无数据，则切换至另一个队列
		if ((0 == qi.get(queueIndex).size()))
		{
			queueIndex = (queueIndex ^ 1);
		}

		ServiceInfo si = qi.get(queueIndex).poll();

		proxy = initSlaveService(si.serviceAddr);
		if (null == proxy)
		{
			logger.info(String.format("[ClientToSlave] Connect Error:%s", si.serviceAddr));
			qi.get(queueIndex ^ 1).offer(si);
			proxy = getValidProxy();
		} else
		{
			logger.info(String.format("[ClientToSlave] Connect OK:%s", si.serviceAddr));
			qi.get(queueIndex ^ 1).offer(si);
		}
		return proxy;
	}

	private ISlave.Client initSlaveService(String _addr)
	{
		ISlave.Client proxy = null;
		try
		{
			// _addr is a url just like "http://localhost:8080/MasterService"
			THttpClient transport = new THttpClient(_addr);

			TProtocol protocol = new TBinaryProtocol(transport);
			proxy = new ISlave.Client(protocol);

			boolean flag = proxy.ping();
		} catch (TException e)
		{
			proxy = null;
			logger.error(e + ":" + _addr);
		}
		return proxy;
	}

}