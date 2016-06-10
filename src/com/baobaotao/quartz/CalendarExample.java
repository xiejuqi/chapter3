package com.baobaotao.quartz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

/**
 * 
 * @Filename CalendarExample.java
 * 
 * @Description	使用Calendar排除特定日期
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月10日 上午8:56:14
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CalendarExample {	
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		
		/**法定节日是以每年为周期的，所以使用AnnualCalendar*/
		AnnualCalendar holidays = new AnnualCalendar();
		
		/**五一劳动节*/
		Calendar laborDay = new GregorianCalendar();
		laborDay.add(Calendar.MONTH, 5);
		laborDay.add(Calendar.DATE, 1);
		
		/**国庆节*/
		Calendar nationalDay = new GregorianCalendar();
		nationalDay.add(Calendar.MONTH, 10);
		nationalDay.add(Calendar.DATE, 1);
		
		ArrayList<Calendar> calendars = new ArrayList<Calendar>();
		calendars.add(laborDay);
		calendars.add(nationalDay);
		
		/**排除这两个特殊日期*/
		holidays.setDaysExcluded(calendars);
		
		/**向Scheduler注册日历*/
		scheduler.addCalendar("holidays", holidays, false, false);
		
		/**4月1号上午10点*/
		Date runDate = TriggerUtils.getDateOf(0, 0, 10,1,4);
		
		JobDetail job = new JobDetail("job1","group1",SimpleJob.class);
		
		SimpleTrigger trigger = new SimpleTrigger("trigger1","group1",runDate,null,SimpleTrigger.REPEAT_INDEFINITELY,60L*60L*1000L);
		
		/**让Trigger应用指定的日历规则*/
		trigger.setCalendarName("holidays");
		
		scheduler.scheduleJob(job,trigger);
		
		scheduler.start();
		
	}
}

