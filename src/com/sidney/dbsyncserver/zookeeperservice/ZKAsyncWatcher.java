package com.sidney.dbsyncserver.zookeeperservice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public abstract class ZKAsyncWatcher implements Watcher
{
	private static final int DEFAULT_POOL_SIZE = 100;
	private static final int DEFAULT_ACCEPT_COUNT = 200;

	private static ExecutorService executor = new ThreadPoolExecutor(1, DEFAULT_POOL_SIZE, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(DEFAULT_ACCEPT_COUNT), 
			new NamedThreadFactory("Arbitrate-Async-Watcher"), new ThreadPoolExecutor.CallerRunsPolicy());

	public void process(final WatchedEvent event)
	{
		executor.execute(new Runnable() {
			@Override
			public void run()
			{
				asyncProcess(event);
			}
		});

	}

	public abstract void asyncProcess(WatchedEvent event);
}
