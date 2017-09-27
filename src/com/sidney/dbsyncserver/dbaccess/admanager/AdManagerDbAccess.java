package com.sidney.dbsyncserver.dbaccess.admanager;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;

import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.dboperator2.DbAccessManager;
import com.sidney.dbsyncserver.oracledb.IOracleConn;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;
import com.sidney.dbsyncserver.syncinstance.MasterSync;
import com.sidney.dbsyncserver.syncstruct.common.UpdateDbFromMaster;

public class AdManagerDbAccess {
	private static Log logger = LogFactory.getLog(AdManagerDbAccess.class);
	private static AdManagerDbAccess thisInstance = null;

	public static AdManagerDbAccess getInstance()
	{
		if (thisInstance == null)
		{
			synchronized (AdManagerDbAccess.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new AdManagerDbAccess();
					}
				} catch (Exception e)
				{
					thisInstance = null;
				}
			}
		}
		return thisInstance;
	}

	private IOracleConn connectObj = null;

	private AdManagerDbAccess()
	{
		
	}

	// / <summary>
	// / master从db中load数据
	// / </summary>
	// / <param name="from"></param>
	// / <param name="to"></param>
	// / <returns></returns>
	public AdManagerContext load(Date from, Date to)
	{
		this.connectObj = new OracleDBConnection(ConfigurationHelper.ADMANAGERDATASOURCE);
		AdManagerContext dc = new AdManagerContext();
		try
		{
			DbAccessManager<AdManagerContext> dbaIns = DbAccessManager.getInstance();
			dbaIns.getLoadDBAccessContext(dc, from, to, this.connectObj);
		} catch (Exception e)
		{
			dc = null;
		} finally
		{
        	this.dispose();
		}
		return dc;
	}

	// / <summary>
	// / master从db中获得unload数据
	// / </summary>
	// / <param name="from"></param>
	// / <param name="to"></param>
	// / <returns></returns>
	public AdManagerContext unLoad(Date from, Date to)
	{
		this.connectObj = new OracleDBConnection(ConfigurationHelper.ADMANAGERDATASOURCE);
		AdManagerContext dc = new AdManagerContext();
		try
		{
			DbAccessManager<AdManagerContext> dbaIns = DbAccessManager.getInstance();
			dbaIns.getUnLoadDBAccessContext(dc, from, to, this.connectObj);
		} catch (Exception e)
		{
			dc = null;
		} finally
		{
        	this.dispose();
		}
		return dc;
	}

	public void dispose()
	{
		if(this.connectObj != null){
    		this.connectObj.dispose();
			this.connectObj = null;
    	}
	}
}
