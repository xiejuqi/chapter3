package com.baobaotao.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.fun.NaiveWaiter;

/**
 * 
 * @Filename AspectjLtwTest.java
 * 
 * @Description	测试Spring LTW方式织入切面
 * 				    VM Arguments：-javaagent:E:/Git_workSpace/chapter3/WebRoot/WEB-INF/lib/org.springframework.instrument-3.0.5.RELEASE.jar
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月12日 下午4:34:01
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class AspectjLtwTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/ltw/SpringLTWConfig.xml");

		Waiter naiveWaiter = (Waiter) ac.getBean(Waiter.class);
		
		naiveWaiter.greetTo("John");
		
		naiveWaiter.serveTo("John");
	}
}

