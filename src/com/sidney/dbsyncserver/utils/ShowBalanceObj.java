package com.sidney.dbsyncserver.utils;

import java.util.List;

import org.apache.commons.logging.Log;

import com.sidney.dbsyncserver.configuration.ConfigurationHelper;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;

public class ShowBalanceObj
{
    public static String show(List<BalanceObj> _objs, String _tip, Log _log)
    {
        StringBuilder sb = new StringBuilder();
        for (BalanceObj v : _objs)
        {
            sb.append(show(v, _tip, _log));
        }
        return sb.toString();
    }
    public static String show(BalanceObj _obj, String _tip, Log _log)
    {
    	String ret = "";
        if (ConfigurationHelper.listTrackId.contains(_obj.Id)
            && ConfigurationHelper.listTrackListName.contains(_obj.ListName)
            && ConfigurationHelper.listTrackDataType.contains(_obj.DataType))
        {
            ret = String.format(
            "Id:%d,Ln:%d,Dt:%d,Nsb:%s,s:%d,Tbg:%s,Th:%s,Xbal:%s,Xbg:%s,Xh:%s,Version:%d - <%s>",
                                _obj.Id,
                                _obj.ListName,
                                _obj.DataType,
                                _obj.NeedSyncBalance.toString(),
                                _obj.Status,
                                _obj.NewTotalBudget.toString(),
                                _obj.NewTotalHit.toString(),
                                _obj.NewXBalance.toString(),
                                _obj.NewXBudget.toString(),
                                _obj.NewXHit.toString(),
                                _obj.Version,
                                _tip);
            _log.info(ret);
        }
        return ret;
    }
}
