package com.sidney.dbsyncserver.dbaccess.dsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class DspContextFun
{
	// / <summary>
	// / 为list按lastchanged排序
	// / </summary>
	public static void ListSort(DspContext _original)
	{


	}

	// / <summary>
	// / 将DspContext转换成DspContextDic
	// / </summary>
	// / <param name="_original">DspContext对象</param>
	// / <returns>DspContextDic对象</returns>
	public static void toDspContextDic(DspContext _original, DspContextDic _ret)
	{
		try
		{
			if (null == _original || null == _ret)
			{
				return;
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// / <summary>
	// / 将DspContextDic转换成DspContext
	// / </summary>
	// / <param name="_original">DspContextDic对象</param>
	// / <returns>DspContext对象</returns>
	public static void toDspContextList(DspContextDic _original, DspContext _ret)
	{
		
	}
	// / <summary>
	// / 获得lastchanged从from之后的数据
	// / </summary>
	// / <param name="_from"></param>
	public static DspContext getSpecifiedData(DspContext _original, Date _from, Date _to)
	{
		DspContext ret = new DspContext();
		ret.toTime = _to;
		
		try
		{
			

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}

	// / <summary>
	// / 移除不需要的数据
	// / </summary>
	// / <param name="_Del"></param>
	public static void removeFromList(DspContext _original, DspContext _Del)
	{
		try
		{
			if (null == _Del)
			{
				return;
			}

		
		
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// / <summary>
	// / 添加增量
	// / </summary>
	// / <param name="_original">原数据</param>
	// / <param name="_Add">增量数据</param>
	// / <returns>新数据</returns>
	public static DspContext addFromList(DspContext _original, DspContext _Add)
	{
		DspContext ret = new DspContext();

		try
		{
			if (null == _Add)
			{
				return _original;
			}

			DspContextDic tempDspContextDic = new DspContextDic();
			DspContextFun.toDspContextDic(_original, tempDspContextDic);

			
			
			// 将dictionary转换成list
			DspContextFun.toDspContextList(tempDspContextDic, ret);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
}
