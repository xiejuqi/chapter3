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
public class SshemaAllTypeAspectConfigTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/schema/SchemaAllTypeAspectConfig.xml");

		Waiter naiveWaiter = (Waiter) ac.getBean("naiveWaiter");
		
		Waiter naughtyWaiter = (NaughtyWaiter) ac.getBean("naughtyWaiter");
		
		SmartSellerExceptionImpl smartSellerExceptionImpl = (SmartSellerExceptionImpl)ac.getBean("smartSellerExceptionImpl") ;
		
		naiveWaiter.greetTo("SAM");
		
		naughtyWaiter.greetTo("John");
		
		/**配置了引介增强*/
		((Seller)naiveWaiter).sell("shoe", "SAM");
		
//		smartSellerExceptionImpl.checkBill(1);
		
		/**用于测试基于Schema的绑定入参*/
		NaiveWaiter naiveWaiter2 = (NaiveWaiter) naiveWaiter;
		naiveWaiter2.smile("Bob", 4);
	}
}

