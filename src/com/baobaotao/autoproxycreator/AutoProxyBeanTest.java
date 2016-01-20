package com.baobaotao.autoproxycreator;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.advisor.Seller;
import com.baobaotao.advisor.Waiter;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename AutoProxyBeanTest.java
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
 * @Date: 2016年1月16日 上午10:03:50
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class AutoProxyBeanTest extends BaseLoggerController{
	
	public void test(){
		/**BeanNameAutoProxyCreator自动创建代理*/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/autoproxycreator/BeanNameAutoProxyCreator.xml");
		
		/**DefaultAdvisorAutoProxyCreator自动创建代理*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/autoproxycreator/BeanNameAutoProxyCreator.xml");
		
		Waiter waiter = (Waiter) ac.getBean("waiter");
		Seller seller = (Seller) ac.getBean("seller");
		
		waiter.greetTo("John");
		seller.greetTo("Mr.Xie");
	}
	
	public static void main(String[] args) {
		new AutoProxyBeanTest().test();
	}
}

