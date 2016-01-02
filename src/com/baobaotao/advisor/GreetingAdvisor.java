package com.baobaotao.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * 
 * @Filename GreetingAdvisor.java
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
 * @Date: 2016年1月2日 上午10:43:35
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6539815556578748225L;

	/* 
	 * 切点方法匹配规则：方法名为greetTo
	 * @see org.springframework.aop.MethodMatcher#matches(java.lang.reflect.Method, java.lang.Class)
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "greetTo".equals(method.getName());
	}
	
	/* 
	 * 切点匹配规则：为Waiter的类或子类
	 * @see org.springframework.aop.support.StaticMethodMatcherPointcut#getClassFilter()
	 */
	@Override
	public ClassFilter getClassFilter(){
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
}

