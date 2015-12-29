package com.baobaotao.aspecthandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.baobaotao.base.BaseLoggerController;
import com.baobaotao.proxy.PerformanceMonitor;

/**
 * 
 * @Filename PerformanceHandler.java
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
 * @Date: 2015年12月26日 上午9:48:00
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class PerformanceHandler extends BaseLoggerController implements InvocationHandler {

	private Object target;

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 1.开始对该方法进行性能监视
		PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
		
		Object obj = method.invoke(target, args);

		// 2.结束对该方法进行性能监视
		PerformanceMonitor.end();
		
		return obj;
	}

}
