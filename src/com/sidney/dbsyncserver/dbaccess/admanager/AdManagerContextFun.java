package com.sidney.dbsyncserver.dbaccess.admanager;

import java.lang.reflect.*;
import java.util.Date;
import java.util.List;

import com.sidney.dbsyncserver.syncinterface.IDBContext;

public class AdManagerContextFun
{
	public static void toContextDic(AdManagerContext _original, AdManagerContextDic _ret)
	{
		try
		{
			Class<?> dcType = AdManagerContext.class; // Context Type
			Field[] dcProperties = dcType.getDeclaredFields(); // 获得每个属性类型
																// List<T>
			for (Field dcItem : dcProperties)
			{
				Class itemType = dcItem.getType();
				if (itemType.isPrimitive())
				{
					System.out.println("base type： " + itemType.getName());
				} else
				{
					if (itemType.isAssignableFrom(List.class))
					{ // 判断是否为List
						Type propertyType = dcItem.getGenericType();
						Class<?> modelType = (Class<?>) ((ParameterizedType) propertyType).getActualTypeArguments()[0]; // 从List<T>的Property声明中解析出T的类型

						Object instance = modelType.newInstance(); // 使用无参构造函数，将T实例化

						Class partypes[] = new Class[2];
						partypes[0] = IDBContext.class;
						partypes[1] = IDBContext.class;

						Method meth = modelType.getMethod("toContextDic", partypes);
						meth.invoke(instance, new Object[] { _original, _ret });
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void toContextList(AdManagerContextDic _original, AdManagerContext _ret)
	{
		try
		{
			Class<?> dcType = AdManagerContext.class; // Context Type
			Field[] dcProperties = dcType.getDeclaredFields(); // 获得每个属性类型
																// List<T>
			for (Field dcItem : dcProperties)
			{
				Class itemType = dcItem.getType();
				if (itemType.isPrimitive())
				{
					System.out.println("base type： " + itemType.getName());
				} else
				{
					if (itemType.isAssignableFrom(List.class))
					{ // 判断是否为List
						Type propertyType = dcItem.getGenericType();
						Class<?> modelType = (Class<?>) ((ParameterizedType) propertyType).getActualTypeArguments()[0]; // 从List<T>的Property声明中解析出T的类型

						Object instance = modelType.newInstance(); // 使用无参构造函数，将T实例化

						Class partypes[] = new Class[2];
						partypes[0] = IDBContext.class;
						partypes[1] = IDBContext.class;

						Method meth = modelType.getMethod("toContextList", partypes);
						meth.invoke(instance, new Object[] { _original, _ret });
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static AdManagerContext getSpecifiedData(AdManagerContext _original, Date _from, Date _to)
	{
		AdManagerContext ret = new AdManagerContext();
		ret.toTime = _to;
		
		try
		{
			Class<?> dcType = AdManagerContext.class; // Context Type
			Field[] dcProperties = dcType.getDeclaredFields(); // 获得每个属性类型
																// List<T>
			for (Field dcItem : dcProperties)
			{
				Class itemType = dcItem.getType();
				if (itemType.isPrimitive())
				{
					System.out.println("base type： " + itemType.getName());
				} else
				{
					if (itemType.isAssignableFrom(List.class))
					{ // 判断是否为List
						Type propertyType = dcItem.getGenericType();
						Class<?> modelType = (Class<?>) ((ParameterizedType) propertyType).getActualTypeArguments()[0]; // 从List<T>的Property声明中解析出T的类型

						Object instance = modelType.newInstance(); // 使用无参构造函数，将T实例化

						Class partypes[] = new Class[3];
						partypes[0] = IDBContext.class;
						partypes[1] = Date.class;
						partypes[2] = Date.class;

						Method meth = modelType.getMethod("getSpecifiedData", partypes);
						Object valueList = meth.invoke(instance, new Object[] { _original, _from, _to });
						dcItem.set(ret, valueList);
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}

	public static void removeFromList(AdManagerContext _original, AdManagerContext _Del)
	{
		try
		{
			Class<?> dcType = AdManagerContext.class; // Context Type
			Field[] dcProperties = dcType.getDeclaredFields(); // 获得每个属性类型
																// List<T>
			for (Field dcItem : dcProperties)
			{
				Class itemType = dcItem.getType();
				if (itemType.isPrimitive())
				{
					System.out.println("base type： " + itemType.getName());
				} else
				{
					if (itemType.isAssignableFrom(List.class))
					{ // 判断是否为List
						Type propertyType = dcItem.getGenericType();
						Class<?> modelType = (Class<?>) ((ParameterizedType) propertyType).getActualTypeArguments()[0]; // 从List<T>的Property声明中解析出T的类型

						Object instance = modelType.newInstance(); // 使用无参构造函数，将T实例化

						Class partypes[] = new Class[2];
						partypes[0] = IDBContext.class;
						partypes[1] = IDBContext.class;

						Method meth = modelType.getMethod("removeFromList", partypes);
						meth.invoke(instance, new Object[] { _original, _Del });
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static AdManagerContext addFromList(AdManagerContext _original, AdManagerContext _Add)
	{
		AdManagerContext ret = new AdManagerContext();

		try
		{
			if (null == _Add)
			{
				return _original;
			}

			AdManagerContextDic temContextDic = new AdManagerContextDic();
			AdManagerContextFun.toContextDic(_original, temContextDic);

			Class<?> dcType = AdManagerContext.class; // Context Type
			Field[] dcProperties = dcType.getDeclaredFields(); // 获得每个属性类型
																// List<T>
			for (Field dcItem : dcProperties)
			{
				Class itemType = dcItem.getType();
				if (itemType.isPrimitive())
				{
					System.out.println("base type： " + itemType.getName());
				} else
				{
					if (itemType.isAssignableFrom(List.class))
					{ // 判断是否为List
						Type propertyType = dcItem.getGenericType();
						Class<?> modelType = (Class<?>) ((ParameterizedType) propertyType).getActualTypeArguments()[0]; // 从List<T>的Property声明中解析出T的类型

						Object instance = modelType.newInstance(); // 使用无参构造函数，将T实例化

						Class partypes[] = new Class[2];
						partypes[0] = IDBContext.class;
						partypes[1] = IDBContext.class;

						Method meth = modelType.getMethod("addToDic", partypes);
						meth.invoke(instance, new Object[] { temContextDic, _Add });
					}
				}
			}

			// 将dictionary转换成list
			AdManagerContextFun.toContextList(temContextDic, ret);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return ret;
	}
}