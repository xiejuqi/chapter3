package com.baobaotao.special;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Filename SpringCGLIBConfig.java
 * 
 * @Description	测试Spring不能被织入AOP事务的特殊方法(基于CGLIB的动态代理)
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月28日 上午8:48:09
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SpringCGLIBConfig {
	
	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(SpringCGLIBConfig.class);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/special/SpringCGLIBTransactionConfig.xml");
		
		UserService userService = (UserService) ac.getBean("userService");
		
		/**
		 * 因为private修饰符的限制,不能在这里调用到
		userService.method1();
		userService.method2();
		*/
		
		
		logger.info("[before method3]");
		userService.method3();
		logger.info("[after method3]");
		
		logger.info("[before method4]");
		userService.method4();
		logger.info("[after method4]");
		
		logger.info("[before method5]");
		userService.method5();
		logger.info("[after method5]");
		
		logger.info("[before method6]");
		userService.method6();
		logger.info("[after method6]");
	}
}
