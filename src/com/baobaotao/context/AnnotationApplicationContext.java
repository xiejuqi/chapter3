package com.baobaotao.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.baobaotao.test.reflect.domain.Car;

/**
 * 
 * @Filename AnnotationApplicationContext.java
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
 * @Date: 2015年11月8日 下午5:12:39
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class AnnotationApplicationContext {
	public static void main(String[] args) {
		//1.通过一个带@Configuration的POJO装载Bean配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		Car car = ctx.getBean("car", Car.class);
		System.out.println(car.toString());
	}
}
