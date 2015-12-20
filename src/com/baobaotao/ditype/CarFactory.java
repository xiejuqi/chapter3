package com.baobaotao.ditype;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename CarFactory.java
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
 * @Date: 2015年11月21日 上午11:48:00
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CarFactory extends BaseLoggerController {
	//1.创建Car的非静态工厂方法
	public Car createHongQiCar() {
		Car car = new Car();
		car.setBrand("红旗CA72");
		car.setMaxSpeed(500);
		return car;
	}
	
	//2.静态工厂方法
	public static Car getInstance() {
		Car car = new Car();
		car.setBrand("黑骑士PRO");
		car.setMaxSpeed(500);
		return car;
	}
}
