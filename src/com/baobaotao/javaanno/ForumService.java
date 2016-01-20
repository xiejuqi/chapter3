package com.baobaotao.javaanno;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ForumService.java
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
 * @Date: 2016年1月16日 下午3:47:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ForumService extends BaseLoggerController{
	@NeedTest(true)
	public void deleteForum(int forumId){
		logger.info("[删除论坛模块：forumId={}]",forumId);
	}
	
	@NeedTest(false)
	public void deleteTopic(int postId){
		logger.info("[删除论坛主题：postId={}]",postId);
	}
}

