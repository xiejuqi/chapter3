package com.baobaotao.ditype;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ConstructorInjectCar.java
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
 * @Date: 2015年11月21日 上午10:28:18
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ConstructorInjectCar extends BaseLoggerController {
	private int maxSpeed;
	private String brand;
	private double price;
	
	/**
	 * @param brand
	 * @param price
	 */
	public ConstructorInjectCar(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	
}
