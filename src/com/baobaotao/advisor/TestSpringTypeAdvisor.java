package com.baobaotao.advisor;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.advice.Monitorable;
import com.baobaotao.aspecthandler.ForumService;


/**
 * 
 * @Filename TestSpringTypeAdvisor.java
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
 * @Date: 2016年1月2日 下午2:13:40
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestSpringTypeAdvisor {
	public static void main(String[] args) {
		/** 使用静态方法匹配切面 */
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("com/baobaotao/advisor/StaticMethodMatcherPointcutAdvisor.xml");

		/** 使用正则表达式方法匹配切面 */
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("com/baobaotao/advisor/RegexpMethodPointcutAdvisor.xml");

		/** 使用动态切面方法匹配切面 */
		/*
		 * ApplicationContext ac = new ClassPathXmlApplicationContext(
		 * "com/baobaotao/advisor/DynamicMethodMatcherPointcut.xml");
		 * 
		 * Waiter waiter = (Waiter) ac.getBean("waiter"); Seller seller =
		 * (Seller) ac.getBean("seller");
		 * 
		 * waiter.greetTo("Jhon"); waiter.serveTo("Kobe");
		 * 
		 * waiter.greetTo("Peter"); waiter.greetTo("Jhon");
		 * waiter.serveTo("John"); seller.greetTo("Jhon");
		 */

		/** 使用流程切面方法匹配切面 */
		/*
		 * ApplicationContext ac = new ClassPathXmlApplicationContext(
		 * "com/baobaotao/advisor/ControlFlowAdvisor.xml");
		 * 
		 * Waiter waiter = (Waiter) ac.getBean("waiter3");
		 * 
		 * WaiterDelegate waiterDelegate = new WaiterDelegate();
		 * 
		 * waiterDelegate.setWaiter(waiter);
		 * 
		 * System.out.println(
		 * "------------从Waiter调用Waiter方法开始----------------------");
		 * waiter.greetTo("John"); waiter.serveTo("Jason"); System.out.println(
		 * "------------从Waiter调用Waiter方法结束----------------------");
		 * 
		 * System.out.println(); System.out.println(
		 * "------------从WaiterDelegate调用Waiter方法开始----------------------");
		 * waiterDelegate.service("Proxy"); System.out.println(
		 * "------------从WaiterDelegate调用Waiter方法结束----------------------");
		 */

		/** 使用复合切面 */
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advisor/ComposableAdvisor.xml");

		Waiter waiter = (Waiter) ac.getBean("waiter4");

		WaiterDelegate waiterDelegate = new WaiterDelegate();

		waiterDelegate.setWaiter(waiter);
		
		System.out.println("-----从Waiter调用方法开始------");
		waiter.greetTo("SAM");
		waiter.serveTo("Locus");
		System.out.println("-----从Waiter调用方法结束------");
		
		System.out.println("");
		System.out.println("-----从WaiterDelegater调用方法开始------");
		waiterDelegate.service("GOME");
		System.out.println("-----从WaiterDelegater调用方法结束------");*/
		
		/** 使用引介切面 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advisor/IntroduceAdvisor.xml");
		
		ForumService forumService =	(ForumService) ac.getBean("forumService");
		
		Monitorable monitorable  = (Monitorable) forumService;
		monitorable.setMonitorActive(true);
		
		forumService.removeForum(1);
		forumService.removeTopic(1);
	}
}
