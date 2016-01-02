package com.baobaotao.advice;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.baobaotao.aspecthandler.ForumService;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename TestSpringTypeConfigAdvice.java
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
 * @Date: 2016年1月1日 上午9:53:49
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestSpringTypeConfigAdvice extends BaseLoggerController {
	void test() throws SQLException{
		/**前置增强*/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advice/MethodBeforeAdvice.xml");
		/**后置增强*/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advice/AfterReturningAdvice.xml");
		/**环绕增强*/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advice/MethodBeforeAdvice.xml");
		/**异常抛出增强*/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advice/ThrowsAdvice.xml");
		/**引介增强*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/advice/DelegatingIntroductionInterceptor.xml");
		
		
		/**这里的forumService是测试异常增强的*/
//		ForumService forumService = (ForumService) ac.getBean("forumService");
//		forumService.removeForum(1);
//		forumService.updateForum(1);
		
		/**这里的forumService是测试 前置 后置 环绕 增强的*/
//		Waiter waiter = (Waiter) ac.getBean("waiter");
//		waiter.greedTo("Jhon");
		
		
		/**这里的forumService是测试引介增强的，和上面的ForumService并不是一个包中的ForumService*/
		ForumService forumService = (ForumService) ac.getBean("forumService");
		forumService.removeForum(1);
		
		Monitorable monitorable = (Monitorable) forumService;
		monitorable.setMonitorActive(true);
		
		forumService.removeTopic(1);
				
	}
	
	public static void main(String[] args) throws SQLException {
		new TestSpringTypeConfigAdvice().test();
	}
}

