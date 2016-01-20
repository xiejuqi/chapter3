package com.baobaotao.javaanno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Filename NeedTest.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年1月16日 下午3:20:10
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Retention(RetentionPolicy.RUNTIME)		//1.声明注解的保留期限
@Target(ElementType.METHOD)				//2.声明可以使用该注解的目标类型
public @interface NeedTest {					//3.定义注解
	boolean value() default true;				//4.声明注解成员
}

