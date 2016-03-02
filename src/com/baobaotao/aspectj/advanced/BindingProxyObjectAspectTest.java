package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.fun.NaiveWaiter;
import com.baobaotao.aspectj.fun.Waiter;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindingProxyObjectAspect.java
 * 
 * @Description	测试使用this()切点函数来匹配切点，绑定参数
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月2日 上午9:00:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class BindingProxyObjectAspectTest extends BaseLoggerController {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/aspectj/advanced/BindingProxyObjectConfig.xml");
		
		/**验证Waiter和NaiveWaiter实际都被this()织入了增强，表明this()使用"+"和不使用"+"的效果完全一样！*/
		
		/*Waiter naiveWaiter = (Waiter) ac.getBean("naiveWaiter");
		
		naiveWaiter.greetTo("SAM");*/
		
		NaiveWaiter naiveWaiter = (NaiveWaiter)ac.getBean("naiveWaiter");
		
		naiveWaiter.smile("SAM", 6);
	}
}
