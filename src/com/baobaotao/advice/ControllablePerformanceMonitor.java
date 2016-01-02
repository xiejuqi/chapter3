package com.baobaotao.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import com.baobaotao.proxy.PerformanceMonitor;

/**
 * 
 * @Filename ControllablePerformanceMonitor.java
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
 * @Date: 2016年1月1日 下午4:21:56
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214548042984162947L;
	private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<Boolean>();
	
	@Override
	public void setMonitorActive(boolean active) {
		monitorStatusMap.set(active);
	}
	
	//拦截方法
	public Object invoke(MethodInvocation mi) throws Throwable{
		Object obj = null;
		//对于支持性能监视可控代理，通过判断其状态决定是否开启性能监控功能
		if(monitorStatusMap.get() != null && monitorStatusMap.get()){
			PerformanceMonitor.begin(mi.getClass().getName()+"."+mi.getMethod().getName());
			
			obj = super.invoke(mi);
			
			PerformanceMonitor.end();
		}else{
			obj = super.invoke(mi);
		}
		
		return obj;
	}

}

