package com.baobaotao.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @Filename JDBCJobStoreRunner.java
 * 	
 * @Description	从数据库中恢复任务的调度
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月10日 上午9:56:35
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class JDBCJobStoreRunner {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		/**1.获取调度器中所有的触发器组*/
		String[] triggerGroups = scheduler.getTriggerGroupNames();
		
		/**重新恢复在tgroup1组中，名为trigger1_1触发器的运行*/
		for(int i = 0 ; i < triggerGroups.length ; i ++){
			String[] triggers = scheduler.getTriggerNames(triggerGroups[i]);
			
			for(int j = 0 ; j < triggers.length ; j ++){
				Trigger tg = scheduler.getTrigger(triggers[j], triggerGroups[i]);
				/**根据名称判断*/
				if(tg instanceof SimpleTrigger && tg.getFullName().equals("tgroup1.trigger1_1")){
					/**恢复运行*/
					scheduler.rescheduleJob(triggers[j], triggerGroups[i],tg);
				}
			}
		}
		
		scheduler.start();
	}
}

