package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindAfterThrowingExceptionAspect.java
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
 * @Date: 2016年3月5日 上午11:14:52
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class BindAfterThrowingExceptionAspect extends BaseLoggerController {
	@AfterThrowing(value="target(com.baobaotao.aspectj.fun.SmartSeller)",throwing="iae")
	public void bindException(IllegalArgumentException iae){
		logger.info("[---bindException---Start---]");
		logger.info("[Exception:{}]",iae.getMessage());
		logger.info("[---bindException---End---]");
	}
}

