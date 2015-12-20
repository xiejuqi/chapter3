package com.baobaotao.beanfactorylifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Filename BeanFactoryPostProcessorTest.java
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
 * @Date: 2015年11月15日 上午11:52:03
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BeanFactoryPostProcessorTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"com/baobaotao/beanfactorylifecycle/beans1.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println("[car=]" + car.toString());
	}
}
