package com.sidney.dbsyncserver.syncmodel;

public enum SyncStatusType
{
	// / <summary>
	// / 初始化
	// / </summary>
	INIT(0),

	// / <summary>
	// / 同步更新数据成功
	// / </summary>
	SYNC_SUCCESS(1),

	// / <summary>
	// / 来自server的更新数据
	// / </summary>
	UPDATE_FROM_SERVER(2),

	// / <summary>
	// / 来自slave的更新数据
	// / </summary>
	UPDATE_FROM_MASTER(4);

	public int value;

	SyncStatusType(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

}