package com.baobaotao.anno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.attr.Car;

/**
 * 
 * @Filename AnnotationTest.java
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
 * @Date: 2015年11月29日 下午4:04:58
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class AnnotationTest {
	private static Logger logger = LoggerFactory.getLogger(AnnotationTest.class);
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/anno/bean1.xml");
		
/*		UserDao userDao = (UserDao) ac.getBean("userDao");
		logger.info("[通过Java类配置的方式声明的userDao={}]", userDao);
		
		LogDao logDao = (LogDao) ac.getBean("logDao");
		logger.info("[通过Java类配置的方式声明的logDao={}]", logDao);
		
		LogonService logonService = (LogonService) ac.getBean("logonService");
		logger.info("[通过Java类配置的方式声明的logonService={}]", logonService);
		*/
		
		logger.info("[car={}]",(Car)ac.getBean("car"));
		logger.info("[UserDao={}]",(UserDao)ac.getBean("UserDao"));
		ServiceConfig serviceConfig = (ServiceConfig) ac.getBean("serviceConfig");
		logger.info("[serviceConfig={}]",serviceConfig);
		DaoConfig userDao = (DaoConfig) ac.getBean("daoConfig");
		logger.info("[userDao={}]",userDao);
		logger.info("[userDao={}]",userDao.userDao());
		logger.info("[通过Configuration注解得到的serviceConfig={}]",serviceConfig);
		logger.info("[serviceConfig的方法注入返回值logonService={}]",serviceConfig.logonService());
		
		
		((ClassPathXmlApplicationContext) ac).destroy();
		
	}
}
