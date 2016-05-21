package com.baobaotao.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.dao.UserDao;
import com.baobaotao.dao.UserOODao;
import com.baobaotao.domain.User;

import sun.util.logging.resources.logging;

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
	
	@Autowired 
	private UserDao userDao;
	
	@Autowired
	private UserOODao userOODao;
	
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "111111");
		assertTrue(b1);
		assertTrue(!b2);
	}
	
	public void findUserByUserName() {
		System.out.println("[userService=]" + userService);
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
		userService.loginSuccess(user);
	}
	
	public void add(){
		User u = new User();
		u.setUserName("Think");
		u.setCredits(10);
		u.setPassword("123456");
		u.setLastVisit(new Date());
		u.setLastIp("11111");
		
		userDao.addUser(u);
		/*userDao.addUserWithKey(u);*/
	}
	
	public void queryList(){
		List<User> list = userDao.getUsers2("Think");
		for(User u : list){
			System.out.println("User:"+u);
		}
	}
	
	public void procedure(){
		int n = userDao.getUserNum2(1);
		System.out.println("n="+n);
	}
	
	/**
	 * 以OO方式访问数据库
	 */
	@Test
	public void getUserByOODao(){
		User user = userOODao.getUser(1);
		System.out.println("user="+user);
		

		User u = new User();
		u.setUserName("Think");
		u.setCredits(10);
		u.setPassword("123456");
		u.setLastVisit(new Date());
		u.setLastIp("11111");
		userOODao.addUser(user);
		
	}
	
	public void batchAdd(){
		List<User> list = new ArrayList<User>();
		
		User u = new User();
		u.setUserName("Think");
		u.setCredits(10);
		u.setPassword("123456");
		u.setLastVisit(new Date());
		u.setLastIp("11111");
		
		User u2 = new User();
		u2.setUserName("Think");
		u2.setCredits(10);
		u2.setPassword("123456");
		u2.setLastVisit(new Date());
		u2.setLastIp("11111");
		
		User u3 = new User();
		u3.setUserName("Think");
		u3.setCredits(10);
		u3.setPassword("123456");
		u3.setLastVisit(new Date());
		u3.setLastIp("11111");
		
		list.add(u);
		list.add(u2);
		list.add(u3);
		
		userDao.batchAddUser(list);
	}
	
}
