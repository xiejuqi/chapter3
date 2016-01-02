package com.baobaotao.advisor;

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
 * @Date: 2016年1月2日 上午10:47:15
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GreetingBeforeAdvice extends BaseLoggerController implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info(target.getClass().getName()+"."+method.getName());
		String clientName = (String) args[0];
		logger.info("How are you ! Mr.{}",clientName);
	}

}

