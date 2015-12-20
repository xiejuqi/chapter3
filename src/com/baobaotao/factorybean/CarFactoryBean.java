package com.baobaotao.factorybean;

import org.springframework.beans.factory.FactoryBean;

import com.baobaotao.attr.Car;

/**
 * 
 * @Filename CarFactoryBean.java
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
 * @Date: 2015年11月29日 下午1:55:10
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CarFactoryBean implements FactoryBean<Car> {
	
	private String carInfo;
	
	/**
	 * 1.接收逗号分隔的属性设置信息
	 * @param carInfo the carInfo to set
	 */
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
	
	/**
	 * 2.实例化Car Bean
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		return car;
	}
	
	/**
	 * 3.返回Car类型
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}
	
	/**
	 * 4.标识通过该FactoryBean返回的Bean是singleton
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
}
