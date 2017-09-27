package com.sidney.dbsyncserver.dboperator2;

public class InitDbOperator<T extends InitDbOperator<T>>
{
    /// <summary>
    /// 用来初始化所有的Context的Sql
    /// </summary>
    public static void InitOperator(Object obj)
    {
        SqlGenerator temp = new SqlGenerator(obj);
    }
}