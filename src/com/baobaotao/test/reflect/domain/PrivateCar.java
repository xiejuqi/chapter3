package com.baobaotao.test.reflect.domain;

/**
 * 
 * @Filename PrivateCar.java
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
 * @Date: 2015年8月29日 下午5:25:24
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class PrivateCar {
	//1.private成员变量，使用传统的类实例调用方式，只能在本类中访问。
	private String color;
	
	//2.protected方法，使用传统的类实例调用方式，只能在子类和本包中使用
	private void drive() {
		System.out.println("drive private car! the color is :" + this.color);
	}
}
