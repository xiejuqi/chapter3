package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename TestAspect.java
 * 
 * @Description	@Aspect进阶，使用切点进行复合运算
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年2月29日 上午9:07:14
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class TestAspect extends BaseLoggerController{
	
	/**
	 * (1)与运算
	 */
	@After("within(com.baobaotao.*) && execution(* greetTo(..))")
	public void greeToFun(){
		logger.info("[greetToFun() executed!]"); 
	}
	
	/**
	 * (2)非运算
	 */
	@Before("!target(com.baobaotao.NaiveWaiter) && execution(* serveTo(..))")
	public void notServeInNaiveWaiter(){
		logger.info("[notServeInNaiveWaiter() executed!]"); 
	}
	
	/**
	 * (3)或运算
	 */
	@AfterReturning("target(com.baobaotao.Waiter) || target(com.baobaotao.Seller)")
	public void waiterOrSeller(){
		logger.info("[waiterOrSeller() executed!]"); 
	}
}
