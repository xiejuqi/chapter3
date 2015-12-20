package com.baobaotao.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @Filename DaoConfig.java
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
 * @Date: 2015年11月29日 下午5:45:00
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Configuration
public class DaoConfig {
	@Bean
	public UserDao userDao() {
		//这里相当于是UserDao的实例化逻辑
		UserDao userDao = new UserDao();
		userDao.setId("1");
		userDao.setName("小螃蟹");
		return userDao;
	}
	
	@Bean
	public LogDao logDao() {
		LogDao logDao = new LogDao();
		logDao.setId("2");
		logDao.setName("大螃蟹");
		return logDao;
	}
}
