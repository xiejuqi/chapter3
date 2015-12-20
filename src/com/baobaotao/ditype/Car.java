package com.baobaotao.ditype;

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
 * @Date: 2015年11月21日 上午9:51:57
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Car extends BaseLoggerController {
	
	private int maxSpeed;
	private String brand;
	private double price;
	
	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
}
