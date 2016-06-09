package com.baobaotao.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @Filename SimpleTriggerRunner.java
 * 
 * @Description Quartz的简单触发器
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月5日 下午3:09:36
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SimpleTriggerRunner {
	public static void main(String[] args) throws SchedulerException {
		/**1.创建一个JobDetail实例，指定SimpleJob*/
		JobDetail jobDetail = new JobDetail("job1_1", "jgroup1", SimpleJob.class);

		/**2.通过SimpleTrigger定义调度规则，马上启动，每2秒运行一次，共运行100次*/
		SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1","tgroup1");
		simpleTrigger.setStartTime(new Date());
		simpleTrigger.setRepeatInterval(2000);
		simpleTrigger.setRepeatCount(100);
		
		/**3.通过SchedulerFactory获取一个调度器实例*/
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		/**4.注册并进行调度*/
		scheduler.scheduleJob(jobDetail,simpleTrigger);
		
		/**5.调度启动*/
		scheduler.start();
		
	}
	
	
	private static void method2() throws SchedulerException{
		/**1.创建一个JobDetail实例，指定SimpleJob*/
		JobDetail jobDetail = new JobDetail("job1_1", "jgroup1", SimpleJob.class);

		/**2.通过SimpleTrigger定义调度规则，马上启动，每2秒运行一次，共运行100次*/
		SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1","tgroup1");
		simpleTrigger.setStartTime(new Date());
		simpleTrigger.setRepeatInterval(2000);
		simpleTrigger.setRepeatCount(100);
		
		
		/**2.1指定关联的Job组名*/
		simpleTrigger.setJobGroup("jgroup1");
		/**2.2指定关联的Job名称*/
		simpleTrigger.setJobName("job1_1");
		
		/**3.通过SchedulerFactory获取一个调度器实例*/
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		/**3.1注册JobDetail*/
		scheduler.addJob(jobDetail, true);
		
		/**4.注册并进行调度*/
		scheduler.scheduleJob(jobDetail,simpleTrigger);
		
		/**5.调度启动*/
		scheduler.start();
	}
}
