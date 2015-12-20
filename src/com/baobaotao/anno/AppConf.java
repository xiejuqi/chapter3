package com.baobaotao.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @Filename AppConf.java
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
 * @Date: 2015年11月29日 下午4:13:26
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
//1.将一个POJO类标注为定义Bean的配置类
@Configuration
public class AppConf {
	
	/** 2.以下2个方法定义了两个Bean，并提供了Bean的实例化逻辑 */
	@Bean
	public UserDao userDao() {
		return new UserDao();
		
	}
	
	@Bean
	public LogDao logDao() {
		return new LogDao();
	}
	
	/** 3.定义了logonService的Bean */
	@Bean
	public LogonService logonService() {
		/** 4.将2和3处定义的Bean注入到logonService Bean中 */
		LogonService logonService = new LogonService();
		logonService.setLogDao(logDao());
		logonService.setUserDao(userDao());
		return logonService;
	}
}
