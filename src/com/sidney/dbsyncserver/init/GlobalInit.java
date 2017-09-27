package com.sidney.dbsyncserver.init;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

import com.adchina.utils.StringUtil;
import com.adchina.configuration.ConfigurationManager;
import com.adchina.dbaccess.Database;
import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.oracledb.OracleDBConnection;
 
public class GlobalInit implements ServletContextListener {
	public final static String WEB_APP_ROOT = "webAppRoot";
	public final static String LOG4J_PROPERTIES = "WEB-INF/log4j.properties";
	public static String DYNAMIC_CONFIG_INI_PATH = "WEB-INF/classes/config.ini";

	static volatile ServletContext servletContext;

	public static ServletContext getServletContext()
	{
		return servletContext;
	}

	public void contextInitialized(ServletContextEvent event)
	{
		servletContext = event.getServletContext();
		applicationOnStart(servletContext, event);
	}

	public void contextDestroyed(ServletContextEvent event)
	{
		applicationOnEnd(event.getServletContext(), event);
		servletContext = null;
	}

	private void initLog4JConfiguration()
	{
		final String webApplicationPath = getServletContext().getRealPath("/");
		System.setProperty(WEB_APP_ROOT, webApplicationPath);
		PropertyConfigurator.configure(StringUtil.combinePath(webApplicationPath, LOG4J_PROPERTIES));
	}
	
	private void initDataBase()
	{
		Date now = new Date();

		Date timeAtDatabaseServer = null;
		Connection conn = null;

		try
		{
			String ds = ConfigurationHelper.ADMANAGERDATASOURCE;
			Database database = Database.getDatabase(ds);
			if (database != null)
			{
				OracleDBConnection oraDbConn = new OracleDBConnection(ds);
				oraDbConn.getConnection();
				timeAtDatabaseServer = oraDbConn.getDatabaseTime();
				long timeDifference = timeAtDatabaseServer.getTime() - now.getTime();
				oraDbConn.dispose();
			}
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			Database.close(conn);
		}
	}

	public void applicationOnStart(ServletContext ctx, ServletContextEvent e)
	{
		System.out.println("start init global..");  
		final String webApplicationPath = getServletContext().getRealPath("/");
		DYNAMIC_CONFIG_INI_PATH = webApplicationPath + DYNAMIC_CONFIG_INI_PATH;
		ConfigurationManager.initInstance(webApplicationPath + "WEB-INF/classes/web.config");
		initLog4JConfiguration();
		initDataBase();
		
	}

	public void applicationOnEnd(ServletContext ctx, ServletContextEvent e)
	{
		ConfigurationManager.freeInstance();
	}

}
