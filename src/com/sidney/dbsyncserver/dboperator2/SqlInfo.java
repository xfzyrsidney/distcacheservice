package com.sidney.dbsyncserver.dboperator2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.utils.StringUtil;
import com.sidney.dbsyncserver.oracledb.IOracleOperator;

public class SqlInfo
{
	// / <summary>
	// / sql脚本
	// / </summary>
	public String sqlStr;

	// / <summary>
	// / 由sql脚本生成的执行命令
	// / </summary>
	public PreparedStatement sqlCommand;

	// / <summary>
	// / sql脚本中的变量参数(有顺序)
	// / </summary>
	// / <param name="string">参数名</param>
	// / <param name="OracleDbType">值类型</param>
	public List<HashMap<String, Integer>> sqlParam;

	private static Log logger = LogFactory.getLog(SqlInfo.class);
	
	// / <summary>
	// / 构造函数
	// / </summary>
	public SqlInfo()
	{
		this.sqlParam = new ArrayList<HashMap<String, Integer>>();
	}

	// / <summary>
	// / 生成OracleCommand
	// / </summary>
	// / <param name="_conn">oracle 连接</param>
	public PreparedStatement createCommand(Connection _conn)
	{
		if (StringUtil.isNullOrEmpty(this.sqlStr))
		{
			return null;
		}

		try
		{
			if (this.sqlCommand != null)
			{
				this.sqlCommand.close();
			}
			this.sqlCommand = _conn.prepareStatement(this.sqlStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.sqlCommand;
	}

	// / <summary>
	// / 生成OracleDataReader
	// / </summary>
	// / <param name="_obj">需要填充的参数，一般就是from，to</param>
	// / <returns></returns>
	public ResultSet executeReader(Object[] _obj)
	{
		if (null == this.sqlCommand)
		{
			return null;
		}

		ResultSet rs = null;

		if (null != this.sqlParam)
		{
			for (int i = 0; i < this.sqlParam.size(); ++i)
			{
				try
				{
					if (_obj[i] instanceof Date)
					{
						Date date = (Date) _obj[i];
						this.sqlCommand.setTimestamp(i + 1, new java.sql.Timestamp(date.getTime()));
					} else
					{
						this.sqlCommand.setObject(i + 1, _obj[i]);
					}
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try
		{
			rs = this.sqlCommand.executeQuery();

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}