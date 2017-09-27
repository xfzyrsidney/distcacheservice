package com.sidney.dbsyncserver.dbaccess.dsp;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.dboperator2.DbAccessManager;
import com.sidney.dbsyncserver.oracledb.IOracleConn;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;
import com.sidney.dbsyncserver.syncstruct.common.UpdateDbFromMaster;

public class DspDbAccess
{
    private static Log logger = LogFactory.getLog(DspDbAccess.class);
    private static DspDbAccess thisInstance = null;
    public static DspDbAccess getInstance()
    {
    	if (thisInstance == null)
		{
			synchronized (DspDbAccess.class)
			{
				try
				{
					if (null == thisInstance)
					{
						thisInstance = new DspDbAccess();
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

    private DspDbAccess()
    {
    }

    /// <summary>
    /// master从db中load数据
    /// </summary>
    /// <param name="from"></param>
    /// <param name="to"></param>
    /// <returns></returns>
    public DspContext load(Date from, Date to)
    {
    	this.connectObj = new OracleDBConnection(ConfigurationHelper.DSPDATASOURCE);
        DspContext dc = new DspContext();
        try
        {
            DbAccessManager<DspContext> dbaIns = DbAccessManager.getInstance();
            dbaIns.getLoadDBAccessContext(dc, from, to, this.connectObj);
        }
        catch (Exception e)
        {
            dc = null;
        } finally
		{
        	this.dispose();
		}
        return dc;
    }
    /// <summary>
    /// master从db中获得unload数据
    /// </summary>
    /// <param name="from"></param>
    /// <param name="to"></param>
    /// <returns></returns>
    public DspContext unLoad(Date from, Date to)
    {
    	this.connectObj = new OracleDBConnection(ConfigurationHelper.DSPDATASOURCE);
        DspContext dc = new DspContext();
        try
        {
            DbAccessManager<DspContext> dbaIns = DbAccessManager.getInstance();
            dbaIns.getUnLoadDBAccessContext(dc, from, to, this.connectObj);
        }
        catch (Exception e)
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