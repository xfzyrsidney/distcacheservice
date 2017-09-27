package com.sidney.dbsyncserver.syncmodel;

import java.math.BigDecimal;
 
public class BalanceObj implements Comparable<BalanceObj>
{
    public BalanceObj() 
    {
        this.Id = 0;
        this.ListName = 0;
        this.DataType = 0;
        this.NeedSyncBalance = new BigDecimal("0");
        this.Status = (int)SyncStatusType.INIT.getValue();
        this.NewXBalance = new BigDecimal("0");
        this.NewXHit = new BigDecimal("0");
        this.NewXBudget = new BigDecimal("0");
        this.NewTotalHit = new BigDecimal("0");
        this.NewTotalBudget = new BigDecimal("0");
        this.Version = 0;
    }
    public BalanceObj(BalanceObj _obj)
    {
        this.Id = _obj.Id;
        this.ListName = _obj.ListName;
        this.DataType = _obj.DataType;
        this.NeedSyncBalance = new BigDecimal(_obj.NeedSyncBalance.toString());
        this.Status = _obj.Status;
        this.NewXBalance = new BigDecimal(_obj.NewXBalance.toString());
        this.NewXHit = new BigDecimal(_obj.NewXHit.toString());
        this.NewXBudget = new BigDecimal(_obj.NewXBudget.toString());
        this.NewTotalHit = new BigDecimal(_obj.NewTotalHit.toString());
        this.NewTotalBudget = new BigDecimal(_obj.NewTotalBudget.toString());
        this.Version = _obj.Version;
    }
    
    public BalanceObj(int id,
    	    int listName,
    	    int dataType,
    	    String needSyncBalance,
    	    int status,
    	    String newXBalance,
    	    String newXHit,
    	    String newXBudget,
    	    String newTotalHit,
    	    String newTotalBudget,
    	    long version)
    {
        this.Id = id;
        this.ListName = listName;
        this.DataType = dataType;
        this.NeedSyncBalance = new BigDecimal(needSyncBalance);
        this.Status = status;
        this.NewXBalance = new BigDecimal(newXBalance);
        this.NewXHit = new BigDecimal(newXHit);
        this.NewXBudget = new BigDecimal(newXBudget);
        this.NewTotalHit = new BigDecimal(newTotalHit);
        this.NewTotalBudget = new BigDecimal(newTotalBudget);
        this.Version = version;
    }

    /// <summary>
    /// 需要sync的campaignid，mediabuyid等主键id
    /// </summary>
    public int Id;

    /// <summary>
    /// 参看ListNameType枚举，决定update的表和字段
    /// </summary>
    public int ListName;

    public int DataType;

    /// <summary>
    /// 需要sync的量
    /// </summary>
    public BigDecimal NeedSyncBalance;

    /// <summary>
    /// 是否同步成功
    /// </summary>
    public int Status;

    /// <summary>
    /// 同步后获得的新balance量
    /// </summary>
    public BigDecimal NewXBalance;

    /// <summary>
    /// 同步后获得的新DailyHit，它的单位可以是钱，也可以是pv等
    /// </summary>
    public BigDecimal NewXHit;

    /// <summary>
    /// 同步后获得的新DailyBudget，它的单位可以是钱，也可以是pv等
    /// </summary>
    public BigDecimal NewXBudget;

    /// <summary>
    /// 同步后获得的新TotalHit，它的单位可以是钱，也可以是pv等
    /// </summary>
    public BigDecimal NewTotalHit;

    /// <summary>
    /// 同步后获得的新TotalBudget，它的单位可以是钱，也可以是pv等
    /// </summary>
    public BigDecimal NewTotalBudget;
    
    public long Version;
    
    @Override
	public int compareTo(BalanceObj o)
	{
		if(this.Id > o.Id){
			return 1;
		} else {
			if(this.Id < o.Id){
				return -1;
			} else {
				if(this.ListName > o.ListName){
					return 1;
				} else {
					if(this.ListName < o.ListName){
						return -1;
					} else{
						if(this.DataType > o.DataType){
							return 1;
						}
						if(this.DataType == o.DataType){
							return 0;
						}
						if(this.DataType < o.DataType){
							return -1;
						}
					}
				}
			}
		}
		return 0;
	}
}

