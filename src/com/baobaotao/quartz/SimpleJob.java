package com.baobaotao.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @Filename SimpleJob.java
 * 
 * @Description	使用Quartz配置JobDetail
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月5日 下午3:04:38
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SimpleJob implements Job{

	/**
	 * 实现Job接口方法
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println(jobExecutionContext.getTrigger().getName()+"triggered. time is :"+(new Date()));
	}
	
}

