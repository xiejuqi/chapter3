package com.baobaotao.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.advice.Waiter;

/**
 * 
 * @Filename SpringConfigAspectJTest.java
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
 * @Date: 2016年1月17日 上午9:52:59
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SpringConfigAspectJTest {
	public static void main(String[] args) {
		/**通过配置使用@AspectJ切面*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/aspectj/AspectjAutoProxy.xml");
		
		Waiter waiter = (Waiter) ac.getBean("waiter");
	
		waiter.greetTo("Sam");
		waiter.serverTo("Jack");
	}
}

