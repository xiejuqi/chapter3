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
public class ConstructorInjectCar2 extends BaseLoggerController {
	private int maxSpeed;
	private String brand;
	private double price;
	private String corp;
	
	/**
	 * @param brand
	 * @param price
	 * @param corp
	 */
	public ConstructorInjectCar2(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.price = price;
		this.corp = corp;
	}
	
}
