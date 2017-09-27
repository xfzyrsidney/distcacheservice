package com.sidney.dbsyncserver.syncmodel;

public enum ListNameType
{
	OTHER(0),

	// / <summary>
	// / admanage的media_buy表
	// / </summary>
	ADMANAGE_MEDIA_BUY(1),

	// / <summary>
	// / admanage的rtb_tanx_budget表
	// / </summary>
	ADMANAGE_RTB_TANX_BUDGET(2),

	// / <summary>
	// / dsp的dsp_campaign控钱
	// / </summary>
	DSP_CAMPAIGN_MONEY(3),

	// / <summary>
	// / dsp的dsp_campaign控kpi
	// / </summary>
	DSP_CAMPAIGN_KPI(4),

	// / <summary>
	// / dsp的dsp_strategy控钱
	// / </summary>
	DSP_STRATEGY_MONEY(5),

	// / <summary>
	// / admanage的adspace_balance表控pv
	// / </summary>
	ADMANAGE_AD_SPACE_PV(6),

	// / <summary>
	// / admanage的adspace_balance表控click
	// / </summary>
	ADMANAGE_AD_SPACE_CLICK(7),

	// / <summary>
	// / admanage的adspace_balance表控money
	// / </summary>
	ADMANAGE_AD_SPACE_MONEY(8),

	// / <summary>
	// / admanage的media_buy_extends表控钱
	// / </summary>
	ADMANAGE_MEDIA_BUY_MONEY(9),

	// / <summary>
	// / dsp的dsp_strategy控pv\click
	// / </summary>
	DSP_STRATEGY_KPI(10),

	// / <summary>
	// / menlo的media_buy控pv
	// / </summary>
	MENLO_MEDIA_BUY(11),
	
	DSP_CAMPAIGN_CLICK(12),

	DSP_CAMPAIGN_PV(13),
	
	DSP_MEDIA_BUY_CLICK(14),

	DSP_MEDIA_BUY_PV(15),
	
	DSP_STRATEGY_GROUP_MONEY(16),
	
	DSP_STRATEGY_GROUP_CLICK(17),
	
	DSP_STRATEGY_GROUP_PV(18);
	
	public int value;

	ListNameType(int value)
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
