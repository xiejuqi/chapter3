package com.baobaotao.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename GreetingAfterAdvice.java
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
 * @Date: 2016年1月1日 上午10:53:37
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GreetingAfterAdvice extends BaseLoggerController implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		//在目标类方法调用后执行
		logger.info("[please enjoy yourself!]");
	}

}

