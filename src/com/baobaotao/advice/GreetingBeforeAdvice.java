package com.baobaotao.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename GreetingBeforeAdvice.java
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
 * @Date: 2016年1月1日 上午9:04:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GreetingBeforeAdvice extends BaseLoggerController implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String clientName = "";
		if(args.length > 0){
			clientName = (String) args[0];
		}
		logger.info("[How are you! Mr.{}.]",clientName);
	}
}

