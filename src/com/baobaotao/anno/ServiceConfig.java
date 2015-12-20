package com.baobaotao.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ServiceConfig.java
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
 * @Date: 2015年12月19日 上午9:51:13
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Configuration
@Import(DaoConfig.class)
public class ServiceConfig extends BaseLoggerController{
	//1.像普通Bean一样注入DaoConfig
	@Autowired
	private DaoConfig daoConfig;
	
	@Bean
	public LogonService logonService(){
		LogonService logonService = new LogonService();
		//2.像普通Bean一样，调用Bean相关的方法
		logonService.setLogDao(daoConfig.logDao());
		logonService.setUserDao(daoConfig.userDao());
		return logonService;
	}
}

