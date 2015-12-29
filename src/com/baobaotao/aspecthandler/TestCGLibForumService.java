package com.baobaotao.aspecthandler;
/**
 * 
 * @Filename TestCGLibForumService.java
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
 * @Date: 2015年12月26日 下午3:25:20
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestCGLibForumService {
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		//通过动态生成子类的方式创建代理类
		ForumServiceImpl forumServiceImpl = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
		forumServiceImpl.removeForum(1);
		forumServiceImpl.removeTopic(2);
	}
}

