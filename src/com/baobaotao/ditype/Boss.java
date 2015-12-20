package com.baobaotao.ditype;

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
 * @Date: 2015年11月21日 上午10:58:00
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Boss extends BaseLoggerController {
	private String name;
	private Car car;
	private Office office;
	
	/**
	 * @param name
	 * @param car
	 * @param office
	 */
	public Boss(String name, Car car, Office office) {
		super();
		this.name = name;
		this.car = car;
		this.office = office;
	}
}
