package com.baobaotao.schema;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename TestBeforeAdvice.java
 * 
 * @Description	测试基于Schema样式配置的Before增强
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月6日 下午3:18:23
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestBeforeAdvice extends BaseLoggerController implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("[---TestBeforeAdvice.before()---Start---]");
		logger.info("[clientName={}]",args[0]);
		logger.info("[---TestBeforeAdvice.before()---End---]");
	}
}

