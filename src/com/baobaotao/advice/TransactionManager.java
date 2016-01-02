package com.baobaotao.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename TransactionManager.java
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
 * @Date: 2016年1月1日 下午3:34:45
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TransactionManager extends BaseLoggerController implements ThrowsAdvice {
	
	//定义增强逻辑
	public void afterThrowing(Method method,Object[] ars,Object target,Exception ex){
		logger.info("[------------------]");
		logger.info("[method:{}]",method.getName());
		logger.info("[抛出异常:{}]",ex.getMessage());
		logger.info("[成功回滚事务！]");
	}
}

