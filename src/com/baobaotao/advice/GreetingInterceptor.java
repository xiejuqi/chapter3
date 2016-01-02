package com.baobaotao.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename GreetingInterceptor.java
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
 * @Date: 2016年1月1日 下午3:17:42
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GreetingInterceptor extends BaseLoggerController implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//目标方法入参
		Object[] args = invocation.getArguments();
		String clientName = (String) args[0];
		//在目标方法执行前调用
		logger.info("[How are you ! Mr.{}]",clientName);
		
		//通过反射机制调用目标方法
		Object obj = invocation.proceed();
		
		//在目标方法执行后调用
		logger.info("please enjoy yourself !");
		
		return obj;
	}
	
}

