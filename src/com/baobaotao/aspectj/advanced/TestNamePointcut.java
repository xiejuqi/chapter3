package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @Filename TestNamePointcut.java
 * 
 * @Description 使用@Pointcut注解来命名切点
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月1日 上午8:31:34
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestNamePointcut {
	
	/**
	 * (1)通过注解方法，inPackage()对该切点进行命名，方法可视域修饰符为private，表明该命名切点只能在本切面类中使用。
	 */
	@Pointcut("within(com.baobaotao.*)")
	private void inPackage(){
		
	}
	
	/**
	 * (2)通过注解方法，greetTo()对该切点进行命名，方法可视域修饰符为protected，表明该命名切点可以在当前包中的切面类，子切面类中使用。
	 */
	@Pointcut("execution(* greetTo(..))")
	protected void greetTo(){
		
	}
	
	/**
	 * (3)引用命名切点定义的切点，本切点也是命名切点，它对应的可视域为public
	 */
	@Pointcut("inPackage() and greetTo()")
	public void inPkgGreetTo(){
		
	}
}
