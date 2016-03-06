package com.baobaotao.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.fun.NaughtyWaiter;
import com.baobaotao.aspectj.fun.Waiter;

/**
 * 
 * @Filename SshemaAspectConfigTest.java
 * 
 * @Description	使用Schema配置一个简单的切面 
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
public class SshemaAspectConfigTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/schema/SchemaAspectConfig.xml");

		Waiter naiveWaiter = (Waiter) ac.getBean("naiveWaiter");
		
		Waiter naughtyWaiter = (NaughtyWaiter) ac.getBean("naughtyWaiter");
		
		naiveWaiter.greetTo("SAM");
		
		naughtyWaiter.greetTo("John");
	}
}

