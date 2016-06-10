package com.baobaotao.quartz;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @Filename CronTriggerRunner.java
 * 
 * @Description	使用Cron表达式触发器，每5秒执行一次
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月10日 上午8:43:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CronTriggerRunner {
	public static void main(String[] args) {
		try {
			
			
			JobDetail jobDetail = new JobDetail("job1_2","jGroup1",SimpleJob.class);
			
			/**创建CronTrigger，指定组以及名称*/
			CronTrigger cronTriggerRunner = new CronTrigger("trigger1_2","tgroup1");
			
			/**定义Cron表达式*/
			CronExpression cexp = new CronExpression("0/5 * * * * ?");
			
			/**设置Cron表达式*/
			cronTriggerRunner.setCronExpression(cexp);
			
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			
			scheduler.scheduleJob(jobDetail,cronTriggerRunner);
			
			scheduler.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

