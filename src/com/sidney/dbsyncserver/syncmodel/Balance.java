package com.sidney.dbsyncserver.syncmodel;

import java.util.List;

public class Balance
{
	public Balance(int _version, List<BalanceObj> _obj)
	{
		this.Version = _version;
		this.mbObj = _obj;
	}

	public boolean IsValidVersion()
	{
		return 1 == Version;
	}

	public int Version;

	public List<BalanceObj> mbObj;
}
