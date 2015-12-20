package com.baobaotao.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.attr.Car;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename FactoryBeanTest.java
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
 * @Date: 2015年11月29日 下午2:01:36
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class FactoryBeanTest extends BaseLoggerController {
	
	public void testFactoryBean() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
			"com/baobaotao/factorybean/bean1.xml");
		
		Car car = (Car) ac.getBean("car");
		logger.info("使用FactoryBean创建的car={}", car);
		CarFactoryBean carFactoryBean = (CarFactoryBean) ac.getBean("&car");
		logger.info("CarFactoryBean自身的实例carFactoryBean={}", carFactoryBean);
	}
	
	public static void main(String[] args) {
		FactoryBeanTest beanTest = new FactoryBeanTest();
		beanTest.testFactoryBean();
	}
}
