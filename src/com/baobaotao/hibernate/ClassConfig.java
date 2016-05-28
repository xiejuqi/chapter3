package com.baobaotao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename ClassConfig.java
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
 * @Date: 2016年5月28日 上午8:42:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ClassConfig {
	public static void main(String[] args) {
		/*Configuration cfg = new Configuration().configure("com/baobaotao/hibernate/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();*/
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/hibernate/hibernate-spring.xml");
		
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		List<User> list =	userDao.findUserByName("Think");
		
		System.out.println("list:"+list.size());
	}
}

