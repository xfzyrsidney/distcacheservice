package com.sidney.dbsyncserver.dboperator2;

import java.util.Date;
import java.util.List;

import com.sidney.dbsyncserver.syncinterface.IDBContext;

public interface IContextFun<T>
{
    /// <summary>
    /// 根据时间排序接口
    /// </summary>
    /// <param name="_ori"></param>
    void listSort(IDBContext _ori);

    /// <summary>
    /// list转换dic接口
    /// </summary>
    /// <param name="_ori">原list</param>
    /// <param name="_ret">新dic</param>
    void toContextDic(IDBContext _ori, IDBContext _ret);

    /// <summary>
    /// dic转换list接口
    /// </summary>
    /// <param name="_ori">>原dic</param>
    /// <param name="_ret">新list</param>
    void toContextList(IDBContext _ori, IDBContext _ret);

    /// <summary>
    /// 根绝条件，返回值
    /// </summary>
    /// <param name="_ori">原list</param>
    /// <param name="_from">起始时间</param>
    /// <param name="_to">结束时间</param>
    /// <returns>返回list</returns>
    List<T> getSpecifiedData(IDBContext _ori, Date _from, Date _to);

    /// <summary>
    /// 从list中移除接口
    /// </summary>
    /// <param name="_ori">原list</param>
    /// <param name="_del">需要删除的list</param>
    void removeFromList(IDBContext _ori, IDBContext _del);

    /// <summary>
    /// 增量加入list接口
    /// </summary>
    /// <param name="_ret">新dic</param>
    /// <param name="_add">需要增加的list</param>
    void addToDic(IDBContext _ret, IDBContext _add);
}