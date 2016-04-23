package com.baobaotao.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename TestTransactionProxyFactoryBean.java
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
 * @Date: 2016年4月3日 上午9:52:45
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestTransactionProxyFactoryBean {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/service/impl/TransactionProxyFactoryBean.xml");
		
		BbtForum bbtForum= (BbtForum) ac.getBean("bbtForum");
		
		User user = new User();
		user.setUserName("ThinkPads111");
		user.setCredits(10);
		user.setPassword("123456");
		user.setLastVisit(new Date());
		user.setLastIp("11111");
		
		bbtForum.addUserAndLoginLog(user);
		
	}

}

