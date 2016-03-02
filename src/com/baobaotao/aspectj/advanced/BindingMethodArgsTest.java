package com.baobaotao.aspectj.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.fun.NaiveWaiter;

/**
 * 
 * @Filename ProceedJoinPointAspectTest.java
 * 
 * @Description	测试args()绑定参数和匹配切点的功能
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月2日 上午8:07:43
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BindingMethodArgsTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/aspectj/advanced/BindingMethodArgsConfig.xml");

		NaiveWaiter naiveWaiter = (NaiveWaiter) ac.getBean("naiveWaiter");
		
		naiveWaiter.smile("John", 3);
	}
}
