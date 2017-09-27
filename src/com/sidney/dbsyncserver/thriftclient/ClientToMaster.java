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
import org.apache.thrift.transport.TTransportException;

import com.sidney.dbsyncserver.syncinstance.SlaveSync;
import com.sidney.dbsyncserver.syncinterface.IMaster;

public class ClientToMaster
{
	private static Log logger = LogFactory.getLog(ClientToMaster.class);

	private Object obj = new Object();

	private List<Queue<ServiceInfo>> qi = null;
	private int queueIndex = 0;

	private IMaster.Client proxy = null;

	private int CheckTimeSpan = 1000;// 查询/设置检查服务连接是否正常的间隔时间，
	private int MasterTimeOut = Integer.MAX_VALUE;// 设置Master client time out

	public ClientToMaster(String[] _addr)
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

	public IMaster.Client getMasterProxy()
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

	private IMaster.Client getValidProxy()
	{
		IMaster.Client proxy = null;

		// 当前队列无数据，则切换至另一个队列
		if ((0 == qi.get(queueIndex).size()))
		{
			queueIndex = (queueIndex ^ 1);
		}

		ServiceInfo si = qi.get(queueIndex).poll();

		proxy = initMasterService(si.serviceAddr);
		if (null == proxy)
		{
			logger.info(String.format("[ClientToMaster] Connect Error:%s", si.serviceAddr));
			qi.get(queueIndex ^ 1).offer(si);
			proxy = getValidProxy();
		} else
		{
			logger.info(String.format("[ClientToMaster] Connect OK:%s", si.serviceAddr));
			qi.get(queueIndex ^ 1).offer(si);
		}
		return proxy;
	}

	private IMaster.Client initMasterService(String _addr)
	{
		IMaster.Client proxy = null;
		try
		{
			// _addr is a url just like
			// "http://localhost:8081/DbSyncServer/MasterService"
			THttpClient thc = new THttpClient(_addr);
			//thc.setConnectTimeout(MasterTimeOut);
			//thc.setReadTimeout(MasterTimeOut);

			TProtocol loPFactory = new TBinaryProtocol(thc);
			proxy = new IMaster.Client(loPFactory);

			boolean flag = proxy.ping();
		} catch (TException e)
		{
			logger.error(e + ":" + _addr);
			proxy = null;
		}
		return proxy;
	}

}