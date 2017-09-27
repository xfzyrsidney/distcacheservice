package com.sidney.dbsyncserver.oracledb;

import java.sql.Connection;


/// <summary>
/// oracle的连接接口
/// </summary>
public interface IOracleConn
{
    /// <summary>
    /// 获得OracleConnection对象
    /// </summary>
    /// <returns></returns>
    Connection getConnection();

    /// <summary>
    /// 注册sql操作
    /// </summary>
    /// <param name="_operator"></param>
    void registCommand(IOracleOperator _operator);

    /// <summary>
    /// 关闭连接
    /// </summary>
    void dispose();
}
