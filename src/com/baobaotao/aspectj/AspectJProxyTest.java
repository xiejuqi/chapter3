package com.baobaotao.aspectj;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.baobaotao.advice.Waiter;

/**
 * 
 * @Filename AspectJProxyTest.java
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
 * @Date: 2016年1月17日 上午9:30:14
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class AspectJProxyTest {
	public static void main(String[] args) {
		Waiter target = new NativeWaiter();
		
		AspectJProxyFactory factory = new AspectJProxyFactory();
		
		//设置目标对象
		factory.setTarget(target);
		
		//添加切面类
		factory.addAspect(PreGreetingAspect.class);
		
		//生成织入切面的代理对象
		Waiter proxy = factory.getProxy();
		
		proxy.greetTo("Bob");
		proxy.serverTo("John");
	}
}

