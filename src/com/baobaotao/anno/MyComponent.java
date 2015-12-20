package com.baobaotao.anno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baobaotao.attr.Car;

/**
 * 
 * @Filename MyComponent.java
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
 * @Date: 2015年11月29日 下午3:33:45
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component
public class MyComponent {
	
	@Autowired(required = false)
	private List<Car> car;
	
	/**
	 * @return the car
	 */
	public List<Car> getCar() {
		return car;
	}
	
}
