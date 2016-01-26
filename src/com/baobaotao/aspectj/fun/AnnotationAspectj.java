package com.baobaotao.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename TestAspectjAnnotation.java
 * 
 * @Description	测试基于AspectJ的Annotation注解的切面
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年1月26日 上午9:04:20
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

@Aspect
public class AnnotationAspectj extends BaseLoggerController{
	
	/**后置增强切面*/
	@AfterReturning("@annotation(com.baobaotao.javaanno.NeedTest)")
	public void needTestFun(){
		logger.info("needTestFun() executed!");
	}
}
