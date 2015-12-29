package com.baobaotao.proxy;
/**
 * 
 * @Filename TestForumService.java
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
 * @Date: 2015年12月26日 上午9:22:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestForumService{
	public static void main(String[] args) {
		ForumService forumService = new ForumServiceImpl();
		forumService.removeTopic(1);
		forumService.removeForum(2);
	}
}

