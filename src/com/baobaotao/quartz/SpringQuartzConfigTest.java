package com.baobaotao.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Filename SpringQuartzConfigTest.java
 * 
 * @Description	测试Spring和Quartz的集成
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月19日 上午9:58:54
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SpringQuartzConfigTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/quartz/spring-quartz.xml");
	}
}
