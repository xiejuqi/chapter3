package com.baobaotao.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @Filename JavaConfigTest.java
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
 * @Date: 2015年12月19日 上午10:43:59
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class JavaConfigTest {
	public static void main(String[] args) {
		//1.使用@Configuration类提供的Bean定义信息启动容器
//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		//2.注册多个@Configuration配置类
//		ac.register(ServiceConfig.class);
		
//		ac.refresh();
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ServiceConfig.class);
		
		UserDao userDao = (UserDao) ac.getBean("userDao");
		ServiceConfig serviceConfig = (ServiceConfig) ac.getBean("serviceConfig");
		System.out.println("userDao的ID为："+userDao.getId());
		System.out.println(serviceConfig.logonService());
	}
}

