package com.baobaotao.tagdepend;

import java.util.Timer;
import java.util.TimerTask;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename CacheManager.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2015年11月29日 上午8:06:58
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CacheManager extends BaseLoggerController {
	public CacheManager() {
		Timer timer = new Timer();
		TimerTask cacheTask = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		timer.schedule(cacheTask, 0, SystemSettings.REFRESH_CYCLE);
	}
}
