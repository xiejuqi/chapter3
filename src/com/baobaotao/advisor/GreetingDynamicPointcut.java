package com.baobaotao.advisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * 
 * @Filename GreetingDynamicPointcut.java
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
 * @Date: 2016年1月2日 下午3:23:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
	
	private static List<String> specialClientList = new ArrayList<String>();
	
	static{
		specialClientList.add("John");
		specialClientList.add("Tom");
	}
	
	/* 
	 * 对类进行静态切点检查
	 * @see org.springframework.aop.support.DynamicMethodMatcherPointcut#getClassFilter()
	 */
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("调用getClassFilter()对"+clazz.getName()+"做静态检查.");
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}	

	/* 对方法进行静态切点检查
	 * @see org.springframework.aop.MethodMatcher#matches(java.lang.reflect.Method, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("调用matches(method,targetClass,args)"+targetClass.getName()+"."+method.getName()+"做静态检查.");
		return "greetTo".equals(method.getName());
	}
	
	/* 对方法进行动态切点检查
	 * @see org.springframework.aop.MethodMatcher#matches(java.lang.reflect.Method, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		System.out.println("调用matches(method,targetClass,args)"+targetClass.getName()+"."+method.getName()+"做动态检查.");
		String clientName = (String) args[0];
		return specialClientList.contains(clientName);
	}

}

