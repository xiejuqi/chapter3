package com.baobaotao.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		/**使用静态方法匹配切面*/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advisor/StaticMethodMatcherPointcutAdvisor.xml");
		
		/**使用正则表达式方法匹配切面*/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advisor/RegexpMethodPointcutAdvisor.xml");
		
		/**使用动态切面方法匹配切面*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advisor/DynamicMethodMatcherPointcut.xml");

		Waiter waiter = (Waiter) ac.getBean("waiter");
		Seller seller = (Seller) ac.getBean("seller");
		
		waiter.greetTo("Jhon");
		waiter.serveTo("Kobe");
		
		waiter.greetTo("Peter");
		waiter.greetTo("Jhon");
		waiter.serveTo("John");
		seller.greetTo("Jhon");
		
	}
}

