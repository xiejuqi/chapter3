package com.baobaotao.beanfactorylifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
 * @Filename MyBeanPostProcessor.java
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
 * @Date: 2015年11月15日 上午10:21:03
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	private static Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
																				throws BeansException {
		// TODO Auto-generated method stub
		if ("car".equals(beanName)) {
			Car car = (Car) bean;
			if (car.getColor() == null) {
				logger
					.info("[调用BeanPostProcessor.postProcess BeforeInitialization(),color为空，设置为默认黑色]");
				car.setColor("黑色");
			}
		}
		return bean;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
																				throws BeansException {
		// TODO Auto-generated method stub
		if (beanName.equals("car")) {
			Car car = (Car) bean;
			if (car.getMaxSpeed() >= 200) {
				logger
					.info("[调用BeanPostProcessor.postProcess postProcessAfterInitialization(),将maxSpeed调整为200"
							+ "]");
				car.setMaxSpeed(200);
			}
		}
		return bean;
	}
	
}
