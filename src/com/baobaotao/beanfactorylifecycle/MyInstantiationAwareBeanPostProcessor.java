package com.baobaotao.beanfactorylifecycle;

import java.beans.PropertyDescriptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * 
 * @Filename MyInstantiationAwareBeanPostProcessor.java
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
 * @Date: 2015年11月15日 上午10:04:29
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MyInstantiationAwareBeanPostProcessor extends
													InstantiationAwareBeanPostProcessorAdapter {
	
	private static Logger logger = LoggerFactory
		.getLogger(MyInstantiationAwareBeanPostProcessor.class);
	
	/**
	 * 1.接口方法：在实例化Bean前进行调用
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessBeforeInstantiation(java.lang.Class,
	 * java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class beanClass, String beanName)
																					throws BeansException {
		//1.1仅对容器中car Bean进行处理
		if ("car".equals(beanName)) {
			logger.info("[InstantiationAware BeanPostProcessor.postProcessBeforeInstantiation]");
		}
		
		return null;
	}
	
	/**
	 * 2.接口方法：在实例化Bean后进行调用 (non-Javadoc)
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessAfterInstantiation(java.lang.Object,
	 * java.lang.String)
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName)
																				throws BeansException {
		//2.1仅对容器中car Bean进行处理
		if ("car".equals(beanName)) {
			logger.info("[InstantiationAware BeanPostProcessor.postProcessAfterInstantiation]");
		}
		
		return true;
	}
	
	/**
	 * 3.接口方法：在设置某个属性时使用 (non-Javadoc)
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessPropertyValues(org.springframework.beans.PropertyValues,
	 * java.beans.PropertyDescriptor[], java.lang.Object, java.lang.String)
	 */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds,
													Object bean, String beanName)
																					throws BeansException {
		//3.1仅对容器中car Bean进行处理，还可以通过pdst入参进行过滤，仅对car的某个特定属性时进行处理
		if ("car".equals(beanName)) {
			logger.info("[InstantiationAware BeanPostProcessor.postProcessPropertyValues]");
		}
		return pvs;
	}
	
}
