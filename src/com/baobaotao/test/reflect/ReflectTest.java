package com.baobaotao.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.baobaotao.test.reflect.domain.Car;

/**
 * 
 * @Filename ReflectTest.java
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
 * @Date: 2015年8月29日 下午3:45:20
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ReflectTest {
	public static void main(String[] args) throws Exception {
		Car car = initByDefaultConst();
		System.out.println(car);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException,
											InstantiationException, IllegalAccessException,
											InvocationTargetException {
		//1.通过类装载器获取Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.baobaotao.test.reflect.Car");
		
		//2.获取类的默认构造器对象并通过它实例化Car
		Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
		Car car = (Car) cons.newInstance();
		
		//3.通过反射方法设置属性
		@SuppressWarnings("unchecked")
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗CA72");
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "黑色");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 200);
		
		return car;
	}
	
}
