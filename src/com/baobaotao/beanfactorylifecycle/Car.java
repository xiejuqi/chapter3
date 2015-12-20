package com.baobaotao.beanfactorylifecycle;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @Filename Car.java
 * 
 * @Description	管理Bean生命周期的接口
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2015年11月15日 上午9:42:58
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

/**
 * 1.管理Bean生命周期的接口
 * @author 解巨琦
 * 
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	
	private static Logger logger = LoggerFactory.getLogger(Car.class);
	
	private String brand;
	private String color;
	private int maxSpeed;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	/**
	 * 
	 */
	public Car() {
		logger.info("[调用Car()构造函数]");
	}
	
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		logger.info("[调用setBrand()设置属性]");
		this.brand = brand;
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		logger.info("[调用setColor()设置属性]");
		this.color = color;
	}
	
	/**
	 * @return the maxSpeed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		logger.info("[调用setMaxSpeed()设置属性]");
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * @return the beanFactory
	 */
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}
	
	/**
	 * @return the beanName
	 */
	public String getBeanName() {
		return beanName;
	}
	
	/**
	 * 5.DisposableBean接口方法 (non-Javadoc)
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		logger.info("[调用DisposableBean.destroy()]");
	}
	
	public void introduce() {
		logger.info("Car [brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed + "]");
	}
	
	/**
	 * 6.通过<bean>的init-method属性指定的初始化方法
	 */
	public void myInit() {
		logger.info("[调用init-method所指定的myInit(),将maxSpeed设置为240]");
		this.maxSpeed = 240;
	}
	
	/**
	 * 7.通过<bean>的destroy-method属性指定的销毁方法
	 */
	public void myDestroy() {
		logger.info("[调用destroy-method所指定的myDestroy()]");
	}
	
	/**
	 * 4.InitializingBean接口方法 (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		logger.info("[调用InitializingBean.afterPropertiesSet()]");
	}
	
	/**
	 * 3.BeanNameAware接口方法 (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		logger.info("[调用BeanNameAware.setBeanName()]");
		this.beanName = name;
	}
	
	/**
	 * 2.BeanFactoryAware接口方法 (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("[调用BeanFactoryAware.setBeanFactory()]");
		this.beanFactory = beanFactory;
	}
	
	/**
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
