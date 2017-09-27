package com.sidney.dbsyncserver.oracledb;

import java.sql.Connection;


/// <summary>
/// oracle的cmd操作接口
/// </summary>
public interface IOracleOperator {
	// / <summary>
	// / 生成OracleCommand
	// / </summary>
	// / <returns></returns>
	void createCmd(Connection _conn);
}