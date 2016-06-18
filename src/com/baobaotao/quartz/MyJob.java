package com.baobaotao.quartz;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

/**
 * 
 * @Filename MyJob.java
 * 
 * @Description	使用JobDetail在Spring中配置一个JobDetail
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月18日 上午8:57:52
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MyJob implements Job{

	@Override
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		/**获取JobDetail关联的JobDataMap*/
		Map dataMap = jctx.getJobDetail().getJobDataMap();
		String size = (String) dataMap.get("size");
		
		Map triggerDataMap = jctx.getTrigger().getJobDataMap();
		
		String count = (String) triggerDataMap.get("count");
		System.out.println("[trigger.Count="+count+"]");
		triggerDataMap.put("count", "30");
		
		/**获取JobDetail关联的JobDataMap*/
		ApplicationContext ac = (ApplicationContext) dataMap.get("applicationContext");
		System.out.println("size:"+size);
		/**对JobDataMap所做的更改是否会被持久，取决于任务的类型*/
		dataMap.put("size", size+"0");
		
		//do something
		
	}

}

