package com.baobaotao.aspecthandler;

import java.lang.reflect.Method;

import com.baobaotao.proxy.PerformanceMonitor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @Filename CglibProxy.java
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
 * @Date: 2015年12月26日 下午3:14:24
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CglibProxy implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz){
		//1.设置需要创建的子类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		//2.通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	/* 
	 * 拦截父类所有方法的调用
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
		
		//通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		
		PerformanceMonitor.end();
		
		return result;
	}

}

