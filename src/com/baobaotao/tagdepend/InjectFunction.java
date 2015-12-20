package com.baobaotao.tagdepend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.attr.Boss;
import com.baobaotao.attr.Car;

/**
 * 
 * @Filename InjectFunction.java
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
 * @Date: 2015年11月22日 下午12:18:36
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class InjectFunction {
	private static Logger logger = LoggerFactory.getLogger(InjectFunction.class);
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/baobaotao/tagdepend/bean1.xml");
		
		Car car1 = (Car) ac.getBean("car1");
		logger.info("car1={}", car1);
		
		Car car2 = (Car) ac.getBean("car2");
		logger.info("car2={}", car2);
		
		/** car3 和 car4 是继承过来的Bean */
		Car car3 = (Car) ac.getBean("car3");
		logger.info("car3={}", car3);
		
		Car car4 = (Car) ac.getBean("car4");
		logger.info("car4={}", car4);
		
		/** 依赖关系 */
		CacheManager cacheManager = (CacheManager) ac.getBean("cacheManager");
		logger.info("cacheManager={}", cacheManager);
		
		SysInit sysInit = (SysInit) ac.getBean("sysInit");
		logger.info("sysInit={}", sysInit);
		
		/** 一个<bean>引用另一个<bean>的id属性值，采用普通方式配置 */
		Car car5 = (Car) ac.getBean("car5");
		logger.info("普通依赖的car5={}", car5);
		
		Boss boss1 = (Boss) ac.getBean("boss1");
		logger.info("普通依赖的boos1={}", boss1);
		
		Boss boss2 = (Boss) ac.getBean("boss2");
		logger.info("普通依赖的boos2={}", boss2);
	}
}
