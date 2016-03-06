package com.baobaotao.schema;

import org.aspectj.lang.ProceedingJoinPoint;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename AdviceMethods.java
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
 * @Date: 2016年3月6日 上午9:42:18
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class AdviceMethods extends BaseLoggerController {
	public void preGreeting(){
		logger.info("[---how are you---]");
	}
	
	/**
	 * 增强方法，retVal和配置文件中的returning属性值相同
	 * retVal必须和增强方法的入参名一致
	 * @param retVal
	 */
	public void afterReturning(){
		logger.info("[---afterReturning---]");
	}
	
	/**
	 * 环绕增强的方法，proceedingJoinPoint可以访问到环绕增强的连接点信息
	 * @param proceedingJoinPoint
	 */
	public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
		logger.info("[---aroundMethod---]");
	}
	
	/**
	 * 通过throwing属性声明需要绑定的异常对象，指定的异常名必须和增强方法对应的入参名一致
	 * @param illegalArgumentException
	 */
	public void afterThrowingMethod(IllegalArgumentException illegalArgumentException){
		logger.info("[---afterThrowingMethod---]");
	}
	
	/**
	 * 配置一个Final增强方法
	 */
	public void afterMethod(){
		logger.info("[---afterMethod---]");
	}
	
	/**
	 * 通过Schema配置的方式绑定增强入参
	 * @param num
	 * @param name
	 */
	public void bindParams(int num,String name){
		logger.info("[---bindParams---]");
		logger.info("[num={},name={}]",num,name);
	}
}

