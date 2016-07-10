package com.baobaotao.timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.timer.ScheduledTimerTask;

/**
 * 
 * @Filename SpringScheduledTimerTaskTest.java
 * 
 * @Description	测试Spring 对JDK Timer的支持
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年7月10日 上午10:37:00
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SpringScheduledTimerTaskTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/timer/ScheduledTimerTask.xml");
		
	}
}

