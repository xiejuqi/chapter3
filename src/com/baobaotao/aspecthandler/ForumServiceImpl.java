package com.baobaotao.aspecthandler;

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

/**移除性能监视横切代码*/
public class ForumServiceImpl extends BaseLoggerController implements ForumService {
	
	@Override
	public void removeTopic(int topicId) {
		logger.info("[模拟删除Topic记录：{}]",topicId);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeForum(int forumId) {
		
		logger.info("[模拟删除Forum记录：{}]",forumId);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

