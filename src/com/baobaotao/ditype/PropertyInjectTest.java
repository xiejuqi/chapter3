package com.baobaotao.ditype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Filename PropertyInjectTest.java
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
 * @Date: 2015年11月21日 上午9:58:07
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class PropertyInjectTest {
	
	private static Logger logger = LoggerFactory.getLogger(PropertyInjectTest.class);
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/ditype/bean1.xml");
		
		/** 属性注入 */
		Car car = (Car) ac.getBean("car");
		logger.info("car={}", car);
		
		/** 属性变量名命名规范测试() */
		Foo foo = (Foo) ac.getBean("foo");
		logger.info("foo={}", foo);
		
		/** 不同类型构造函数1测试 */
		ConstructorInjectCar constructorInjectCar = (ConstructorInjectCar) ac.getBean("car1");
		logger.info("constructorInjectCar={}", constructorInjectCar);
		
		/** 不同类型构造函数2测试 */
		ConstructorInjectCar2 constructorInjectCar2 = (ConstructorInjectCar2) ac.getBean("car2");
		logger.info("constructorInjectCar2={}", constructorInjectCar2);
		
		/** 不同类型构造函数3测试(多个构造函数) */
		ConstructorInjectCar3 constructorInjectCar3 = (ConstructorInjectCar3) ac.getBean("car3");
		logger.info("constructorInjectCar3={}", constructorInjectCar3);
		
		/** 通过自身类型反射匹配入参 */
		Boss boss = (Boss) ac.getBean("boss");
		logger.info("boss={}", boss);
		
		/** 通过非静态工厂类配置 */
		Car car5 = (Car) ac.getBean("car5");
		logger.info("car5={}", car5);
		
		/** 通过静态工厂类配置 */
		Car car6 = (Car) ac.getBean("car6");
		logger.info("car6={}", car6);
	}
}
