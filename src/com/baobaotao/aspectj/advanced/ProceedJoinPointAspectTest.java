package com.baobaotao.aspectj.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.fun.NaiveWaiter;
import com.baobaotao.aspectj.fun.Waiter;

/**
 * 
 * @Filename ProceedJoinPointAspectTest.java
 * 
 * @Description	测试使用ProceedJoinPoint访问环绕增强中的连接点上下文信息
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月2日 上午8:07:43
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ProceedJoinPointAspectTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/aspectj/advanced/ProceedJoinPointAspect.xml");

		Waiter naiveWaiter = (Waiter) ac.getBean("naiveWaiter");
		
		naiveWaiter.greetTo("SAM");
		
	}
}
