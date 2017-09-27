package com.sidney.dbsyncserver.dboperator2;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableAttribute {
	// / <summary>
	// / 数据库表的名称
	// / </summary>
	public String Name() default "";

	// / <summary>
	// / 是否需要load (default:true)
	// / </summary>
	public boolean NeedLoad() default true;

	// / <summary>
	// / 是否需要unload (default:true)
	// / </summary>
	public boolean NeedUnload() default true;

	// / <summary>
	// / 初始化时，需要load/unload的起始时间
	// / 因为许多时候，表的旧数据已经很多，不必要load
	// / </summary>
	public String InitFromDateTime() default "2007-01-01 00:00:00";

}