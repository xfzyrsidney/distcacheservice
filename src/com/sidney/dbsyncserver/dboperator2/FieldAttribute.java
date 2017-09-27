package com.sidney.dbsyncserver.dboperator2;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import oracle.jdbc.OracleTypes;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
	    public @interface FieldAttribute
	    {
	        /// <summary>
	        /// 字段名称
	        /// </summary>
	        public String Name() default "";

	        /// <summary>
	        /// 在oracle中的字段类型
	        /// </summary>
	        public int OracleTypes() default OracleTypes.INTEGER;

	        /// <summary>
	        /// 0~N:键值序号,-1:非键
	        /// </summary>
	        public int KeyIndex() default -1;

	        /// <summary>
	        /// 是否需要在load时拼上
	        /// </summary>
	        public boolean NeedLoad() default true;

	        /// <summary>
	        /// 是否需要在unload时拼上
	        /// </summary>
	        public boolean NeedUnload() default false;

	        /// <summary>
	        /// 是否是status字段
	        /// </summary>
	        public boolean IsStatus() default false;

	        /// <summary>
	        /// 是否是lastchanged字段
	        /// </summary>
	        public boolean IsLastChanged() default false;

	        /// <summary>
	        /// 自定义符号
	        /// </summary>
	        public String LoadCustomSign() default "";

	        /// <summary>
	        /// 自定义值
	        /// </summary>
	        public String LoadCustomValue() default "";

	        /// <summary>
	        /// 自定义符号
	        /// </summary>
	        public String UnloadCustomSign() default "";

	        /// <summary>
	        /// 自定义值
	        /// </summary>
	        public String UnloadCustomValue() default "";

	    }