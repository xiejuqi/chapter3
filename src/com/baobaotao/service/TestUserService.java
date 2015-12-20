package com.baobaotao.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename TestUserService.java
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
 * @Date: 2015年8月23日 下午2:28:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
//基于JUnit4的Spring测试框架
@RunWith(SpringJUnit4ClassRunner.class)
//启动Spring容器
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "111111");
		assertTrue(b1);
		assertTrue(!b2);
	}
	
	@Test
	public void findUserByUserName() {
		System.out.println("[userService=]" + userService);
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
		userService.loginSuccess(user);
	}
	
}
