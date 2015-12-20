package com.baobaotao.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @Filename LogonAppConfig.java
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
 * @Date: 2015年12月19日 下午1:41:17
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
//1.通过@ImportResource引入XML配置文件
@Configuration
@ImportResource("classpath:com/baobaotao/anno/bean2.xml")
public class LogonAppConfig {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private LogDao logDao;
	
	//2.自动注入XML文件中定义的Bean
	@Bean
	@Autowired
	public LogonService logonService(){
		LogonService logonService = new LogonService();
		logonService.setLogDao(logDao);
		logonService.setUserDao(userDao);
		return logonService;
	}
}

