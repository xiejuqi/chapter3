package com.baobaotao.proxy;

import com.baobaotao.base.BaseLoggerController;

import sun.util.logging.resources.logging;

/**
 * 
 * @Filename PerformanceMonitor.java
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
 * @Date: 2015年12月26日 上午9:13:19
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class PerformanceMonitor extends BaseLoggerController{
	//1.通过一个ThreadLocal保存调用线程相关的性能监视信息
	private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();
	
	//2.启动对某一目标方法的性能监视
	public static void begin(String method){
		System.out.println("begin monitor ...");
		MethodPerformance mp = new MethodPerformance(method);
		performanceRecord.set(mp);
	}
	
	public static void end(){
		MethodPerformance mp = performanceRecord.get();
		
		//3.打印出方法性能监视的结果信息
		mp.printPerformance();
		
		System.out.println("end monitor ...");
	}
	
}

