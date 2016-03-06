package com.baobaotao.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.advanced.SmartSellerExceptionImpl;
import com.baobaotao.aspectj.fun.NaiveWaiter;
import com.baobaotao.aspectj.fun.NaughtyWaiter;
import com.baobaotao.aspectj.fun.Seller;
import com.baobaotao.aspectj.fun.Waiter;

/**
 * 
 * @Filename SshemaAspectConfigTest.java
 * 
 * @Description	测试基于Schema配置的Advisor增强
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月6日 上午9:45:54
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SshemaAspectAdvisorConfigTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/schema/SchemaAspectAdvisorConfig.xml");

		Waiter naiveWaiter = (Waiter) ac.getBean("naiveWaiter");
		
		naiveWaiter.greetTo("SAM");
		
	}
}

