package com.sidney.dbsyncserver.syncmodel;

public enum SyncDbListType {
	OTHER(0),

	// / <summary>
	// / schema为adchina
	// / </summary>
	ADMANAGE(1),

	// / <summary>
	// / schema为mlt_user
	// / </summary>
	MENLO(2),

	// / <summary>
	// / schema为adchina_dsp
	// / </summary>
	DSP(3);

	public int value;

	SyncDbListType(int value)
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