package com.sidney.dbsyncserver.zookeeperservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKDistributedLock
{
	private static Log logger = LogFactory.getLog(ZKDistributedLock.class);

	private static final byte[] data = { 0x12, 0x34 };
	private ZooKeeper zookeeper = null;
	private final String root;
	private String id;
	private LockNode idName;
	private String ownerId;
	private String lastChildId;
	private Throwable other = null;
	private KeeperException exception = null;
	private InterruptedException interrupt = null;
	private int DEFAULT_TIMEOUT_PERIOD = 10000;

	public ZKDistributedLock(String connStr, String root)
	{
		this.root = root;
		try
		{
			zookeeper = new ZooKeeper(connStr, DEFAULT_TIMEOUT_PERIOD, new ZKAsyncWatcher() {
				public void asyncProcess(WatchedEvent event)
				{
				}
			});
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		ensureExists(root);
	}

	/**
	 * blocking lock that is can be interrupted
	 */
	public void lock() throws InterruptedException, KeeperException
	{
		if (exception != null)
		{
			throw exception;
		}

		if (interrupt != null)
		{
			throw interrupt;
		}

		if (other != null)
		{
			throw new RuntimeException(other);
		}

		if (isOwner())
		{
			System.out.println(id + " got lock!"); 
			return;
		}

		CountDownLatch latch = new CountDownLatch(1);
		boolean awaitFlag = false;
		acquireLock(latch);

		try
		{
			awaitFlag = latch.await(DEFAULT_TIMEOUT_PERIOD, TimeUnit.MILLISECONDS);
			if (false == awaitFlag)
			{
				lock();
			}
		} catch (InterruptedException e)
		{
			if (false == awaitFlag)
			{
				lock();
			}
		}

		if (exception != null)
		{
			throw exception;
		}

		if (interrupt != null)
		{
			throw interrupt;
		}

		if (other != null)
		{
			throw new RuntimeException(other);
		}
		
		System.out.println(id + " got lock!"); 
	}

	/**
	 * try lock, no blocking
	 * 
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	public boolean tryLock() throws KeeperException
	{
		if (exception != null)
		{
			throw exception;
		}

		if (isOwner())
		{
			return true;
		}

		acquireLock(null);

		if (exception != null)
		{
			throw exception;
		}

		if (interrupt != null)
		{
			Thread.currentThread().interrupt();
		}

		if (other != null)
		{
			throw new RuntimeException(other);
		}

		return isOwner();
	}

	/**
	 * release lock
	 */
	public void unlock() throws KeeperException
	{
		if (id != null)
		{
			try
			{
				zookeeper.delete(root + "/" + id, -1);
				System.out.println(id + " release lock!"); 
			} catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
			} catch (KeeperException.NoNodeException e)
			{
				// do nothing
			} finally
			{
				id = null;
			}
		} else
		{
			// do nothing
		}
	}

	private void ensureExists(final String path)
	{
		try
		{
			Stat stat = zookeeper.exists(path, false);
			if (stat != null)
			{
				return;
			}
			zookeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		} catch (KeeperException e)
		{
			exception = e;
		} catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
			interrupt = e;
		}
	}

	public String getRoot()
	{
		return root;
	}

	public boolean isOwner()
	{
		return id != null && ownerId != null && id.equals(ownerId);
	}

	public String getId()
	{
		return this.id;
	}

	/**
	 * do lock operation，if latch != null, it's blocking way.
	 */
	private Boolean acquireLock(final CountDownLatch latch)
	{
		try
		{
			do
			{
				if (id == null)
				{
					long sessionId = zookeeper.getSessionId();
					String prefix = "x-" + sessionId + "-";
					String path = zookeeper.create(root + "/" + prefix, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
					int index = path.lastIndexOf("/");
					id = path.substring(index + 1);
					idName = new LockNode(id);
				}

				if (id != null)
				{
					List<String> names = zookeeper.getChildren(root, false);
					if (names.isEmpty())
					{
						id = null;
					} else
					{
						SortedSet<LockNode> sortedNames = new TreeSet<LockNode>();
						for (String name : names)
						{
							sortedNames.add(new LockNode(name));
						}

						if (sortedNames.contains(idName) == false)
						{
							id = null;
							continue;
						}

						// set the first node as ownerId
						ownerId = sortedNames.first().getName();
						if (latch != null && isOwner())
						{
							latch.countDown();
							return true;
						} else if (latch == null)
						{
							return isOwner();
						}

						SortedSet<LockNode> lessThanMe = sortedNames.headSet(idName);
						if (!lessThanMe.isEmpty())
						{
							// watch the node less than me
							LockNode lastChildName = lessThanMe.last();
							lastChildId = lastChildName.getName();

							Stat stat = zookeeper.exists(root + "/" + lastChildId, new ZKAsyncWatcher() {
								public void asyncProcess(WatchedEvent event)
								{
									acquireLock(latch);
								}
							});

							if (stat == null)
							{
								acquireLock(latch);
							}
						} else
						{
							if (isOwner())
							{
								latch.countDown();
							} else
							{
								// maybe myself node hang.
								id = null;
							}
						}
					}
				}
			} while (id == null);
		} catch (KeeperException e)
		{
			exception = e;
			if (latch != null)
			{
				latch.countDown();
			}
		} catch (InterruptedException e)
		{
			interrupt = e;
			if (latch != null)
			{
				latch.countDown();
			}
		} catch (Throwable e)
		{
			other = e;
			if (latch != null)
			{
				latch.countDown();
			}
		}

		if (isOwner() && latch != null)
		{
			latch.countDown();
		}
		return Boolean.FALSE;
	}

}
