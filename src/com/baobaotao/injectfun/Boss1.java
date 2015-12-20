package com.baobaotao.injectfun;

import com.baobaotao.attr.Car;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Boss1.java
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
 * @Date: 2015年11月22日 下午2:52:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Boss1 extends BaseLoggerController {
	public Car getCar() {
		Car car = new Car();
		car.setBrand("宝马Z4");
		return car;
	}
}
