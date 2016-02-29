package com.baobaotao.aspectj.fun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.baobaotao.aspectj.fun.Seller;

/**
 * 
 * @Filename TestThisAndTargetConfig.java
 * 
 * @Description	测试this()和target()切点函数的区别
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年2月29日 上午8:36:32
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestThisAndTargetConfig {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/aspectj/fun/TestThisAndTargetConfig.xml");
	
		Waiter naiveWaiter = (Waiter) ac.getBean("naiveWaiter");
		
		naiveWaiter.greetTo("John");
		
		naiveWaiter.serveTo("Easy..");
		
		((Seller)naiveWaiter).sell("mobile", "Bob");
		
		/**如果不输出这句，seller.sell方法没有织入增强，不知是什么原因造成的。*/
		System.out.println(naiveWaiter);
		
	}
}
