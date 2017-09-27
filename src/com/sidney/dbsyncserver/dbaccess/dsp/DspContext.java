package com.sidney.dbsyncserver.dbaccess.dsp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sidney.dbsyncserver.syncinterface.IDBContext;

public class DspContext implements IDBContext
{
	private static Log logger = LogFactory.getLog(DspContext.class);

	public Date toTime;
	
	
	
	// / <summary>
	// / 构造函数，初始化
	// / </summary>
	public DspContext()
	{
		this.toTime = null;
		
	}
}