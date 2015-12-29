package com.baobaotao.proxy;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename MethodPerformance.java
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
 * @Date: 2015年12月26日 上午9:14:17
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MethodPerformance extends BaseLoggerController{
	
	private long begin;
	private long end;
	private String serviceMethod;
	
	public MethodPerformance(String serviceMethod){
		this.serviceMethod=serviceMethod;
		//1.记录目标类方法开始执行点的系统时间
		this.begin = System.currentTimeMillis();
	}
	
	public void printPerformance(){
		//2.获取目标类方法执行完成后的系统时间，并进而计算出目标类方法执行时间
		end = System.currentTimeMillis();
		long elapse = end-begin;
		logger.info(serviceMethod+"花费"+elapse+"毫秒");
	}
}

