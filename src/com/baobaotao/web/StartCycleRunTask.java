package com.baobaotao.web;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @Filename StartCycleRunTask.java
 * 
 * @Description	Web应用程序中调度器的启动和关闭问题(线程是JVM级别的，静态变量是ClassLoader级别)
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年7月11日 上午8:57:42
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class StartCycleRunTask implements ServletContextListener {
	
	private Timer timer;
	
	/**1.该方法在Web容器关闭时执行*/
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("[Web应用程序关闭...]");
	}
	
	/**2.在Web容器启动时自动执行该方法*/
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("[Web应用程序启动...]");
		/**创建一个Timer，Timmer内部自动创建一个背景线程*/
		timer = new Timer();
		TimerTask task = new SimpleTimerTask();
		/**注册一个5秒钟运行一次的任务*/
		timer.schedule(task, 1000L,5000L);
	}
	
	/**
	 * 
	 * 任务
	 * @author xiejuqi
	 *
	 */
	class SimpleTimerTask extends TimerTask{
		private int count ;

		@Override
		public void run() {
			System.out.println((++count)+"execute taks..."+(new Date()));
		}
	}
}
