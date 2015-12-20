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
public class ConstructorInjectCar4 extends BaseLoggerController {
	private String brand;
	private Boss boss;
	
	/**
	 * @param brand
	 * @param boss
	 */
	public ConstructorInjectCar4(String brand, Boss boss) {
		super();
		this.brand = brand;
		this.boss = boss;
	}
}
