package com.baobaotao.aspecthandler;

import java.lang.reflect.Proxy;

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
public class TestJdkForumService {
	public static void main(String[] args) {
		//1.希望被代理的目标业务类
		ForumService forumService = new ForumServiceImpl();
		
		//2.将目标业务类和横切代码编织到了一起
		PerformanceHandler performanceHandler = new PerformanceHandler(forumService);

		//3.根据编织了目标业务类逻辑和性能监视横切逻辑的Invocationhandler实例创建代理实例
		ForumService proxy = (ForumService) Proxy.newProxyInstance(forumService.getClass().getClassLoader(),
				forumService.getClass().getInterfaces(), performanceHandler);
		
		//4.调用代理实例
		proxy.removeForum(10);
		proxy.removeTopic(1012);
	}
}
