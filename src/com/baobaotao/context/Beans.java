package com.baobaotao.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baobaotao.test.reflect.domain.Car;

/**
 * 
 * @Filename Beans.java
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
 * @Date: 2015年11月8日 下午5:10:49
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Configuration
public class Beans {
	
	@Bean(name = "car")
	public Car buildCar() {
		Car car = new Car();
		car.setBrand("红旗CA72");
		car.setMaxSpeed(200);
		return car;
	}
}
