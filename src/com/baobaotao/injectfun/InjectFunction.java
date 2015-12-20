package com.baobaotao.injectfun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
			"com/baobaotao/injectfun/bean1.xml");
		
		MagicBoss magicBoss = (MagicBoss) ac.getBean("magicBoss");
		logger.info("magicBoss={}", magicBoss);
		
		Car car1 = magicBoss.getCar();
		logger.info("car1={}", car1);
		
		/** 两次获得的car确实不是同一个对象，证明调用prototype的car成功 */
		Car car2 = magicBoss.getCar();
		logger.info("car2={}", car2);
		
		logger.info("car1==car2={}", car1 == car2);
		
		Boss1 boss1 = (Boss1) ac.getBean("boss1");
		logger.info("[boss1={}]", boss1);
		/** 这里得到的car brand为美人豹，调包成功！ */
		Car car3 = boss1.getCar();
		logger.info("[boss1.car={}]", car3);
		
		//这里不能直接new 实现类，这样得到的属性中的ApplicationContext会为null，也就得不到Car Bean对象了
		//如果某个类实现了ApplicationContextAware，容器会在启动之时调用setApplicationContext方法设置属性
		/*		MagicBoss magincBoss2 = new MagicBossImpl();
				Car car3 = magincBoss2.getCar();
				logger.info("car3={}", car3);
				
				Car car4 = magincBoss2.getCar();
				logger.info("car4={}", car4);
				
				logger.info("car3==car4={}", car3 == car4);*/
	}
}
