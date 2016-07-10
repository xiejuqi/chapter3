package com.baobaotao.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @Filename TimerRunner.java
 * 
 * @Description	通过Timer以固定延迟时间的方式每5秒执行一次任务
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年7月10日 上午10:22:44
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TimerRunner {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new SimpleTimerTask();
		/**在延迟1秒钟后，每5秒钟运行一次任务*/
		timer.schedule(task, 1000L,5000L);
	}
}

