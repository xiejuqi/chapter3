package com.baobaotao.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.baobaotao.test.reflect.domain.PrivateCar;

/**
 * 
 * @Filename PrivateCarReflect.java
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
 * @Date: 2015年8月29日 下午5:29:07
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class PrivateCarReflect {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.baobaotao.test.reflect.domain.PrivateCar");
		
		PrivateCar pcar = (PrivateCar) clazz.newInstance();
		
		Field colorFiled = clazz.getDeclaredField("color");
		
		//1.取消Java语言访问检查以访问Private变量
		colorFiled.setAccessible(true);
		colorFiled.set(pcar, "红色");
		
		Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);
		//		Method driveMtd = clazz.getDeclaredMethod("drive");	JDK5.0下使用
		
		//2.取消Java语言访问检查以访问protected方法
		driveMtd.setAccessible(true);
		driveMtd.invoke(pcar, (Object[]) null);
	}
}
