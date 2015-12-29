package com.baobaotao.proxy;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ForumServiceImpl.java
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
 * @Date: 2015年12月26日 上午9:22:42
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ForumServiceImpl extends BaseLoggerController implements ForumService {
	
	
	@Override
	public void removeTopic(int topicId) {
		//1.开始对该方法进行性能监视
		PerformanceMonitor.begin("com.baobaotao.proxy.ForumServiceImpl.removeTopic");
		logger.info("[模拟删除Topic记录：{}]",topicId);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2.结束对该方法进行性能监视
		PerformanceMonitor.end();
	}

	@Override
	public void removeForum(int forumId) {
		//1.开始对该方法进行性能监视
		PerformanceMonitor.begin("com.baobaotao.proxy.ForumServiceImpl.removeForum");
		
		logger.info("[模拟删除Forum记录：{}]",forumId);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2.结束对该方法进行性能监视
		PerformanceMonitor.end();
	}

}

