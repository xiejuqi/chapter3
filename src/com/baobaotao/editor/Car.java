package com.baobaotao.editor;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Car.java
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
 * @Date: 2015年12月19日 下午3:29:29
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Car extends BaseLoggerController{
	private int maxSpeed;
	public String brand;
	public double price;
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

