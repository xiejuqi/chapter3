package com.baobaotao.editor;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Boss.java
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
 * @Date: 2015年12月19日 下午3:30:22
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Boss extends BaseLoggerController{
	private String name;
	private Car car = new Car();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
}

