package com.baobaotao.advisor;
/**
 * 
 * @Filename GreetingComposablePointcut.java
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
 * @Date: 2016年1月12日 上午8:23:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.Pointcuts;

/**复合切面 */
public class GreetingComposablePointcut {
	public Pointcut getIntersectionPointcut(){
		
		/**创建一个复合切点*/
		ComposablePointcut cp = new ComposablePointcut();
		
		/** 创建一个流程切点*/
		Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class,"service");
		
		/** 创建一个方法名切点*/
		NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
		pt2.addMethodName("greetTo");
		
		
		return cp.intersection(pt1).intersection((Pointcut)pt2);
	}
}
