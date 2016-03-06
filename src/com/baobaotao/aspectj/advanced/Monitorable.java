package com.baobaotao.aspectj.advanced;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Filename Monitorable.java
 * 
 * @Description	测试@within()切点表达式切面
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月5日 上午9:50:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Retention(RetentionPolicy.RUNTIME)		
@Target(ElementType.TYPE)				
public @interface Monitorable {
	
}

