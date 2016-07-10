package com.baobaotao.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * 
 * @Filename SimpleTimerTask.java
 * 
 * @Description	JDK Timer实例
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年7月10日 上午10:16:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SimpleTimerTask extends TimerTask {
	
	private int count = 0 ;
	
	@Override
	public void run() {
		System.out.println("[execute task]");
		/**获取本次安排执行的时间点*/
		Date exeTime = (new Date(scheduledExecutionTime()));
		System.out.println("[本地任务安排执行时间点为:"+exeTime+"]");
		
		if(++count > 10){
			/**在任务运行10次后主动退出*/
			cancel();
		}
	}
}

