package com.baobaotao.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 
 * @Filename TestBeforeAdvice.java
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
 * @Date: 2016年1月1日 上午9:11:33
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestBeforeAdvice {
	public static void main(String[] args) {
		Waiter target = new NativeWaiter();
		
		BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
		
		//1.Spring提供的代理工厂
		ProxyFactory proxyFactory = new ProxyFactory();
		
		//指定对接口进行代理，将使用JDK代理技术
		proxyFactory.setInterfaces(target.getClass().getInterfaces());
		
		//启动优化，使用CGLib代理技术
		proxyFactory.setOptimize(true);
		
		//2.设置代理目标
		proxyFactory.setTarget(target);
		
		//3.为代理添加增强
		proxyFactory.addAdvice(beforeAdvice);
		
		//4.生成代理实例
		Waiter proxy = (Waiter) proxyFactory.getProxy();
		
		System.out.println("proxy:"+proxy);
		
		proxy.greedTo("John");
		proxy.serverTo("Tom");
		
	}
}

