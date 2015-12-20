package com.baobaotao.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename MyDataSource.java
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
 * @Date: 2015年12月20日 上午9:14:12
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component
public class MyDataSource extends BaseLoggerController{
	@Value("${driverClassname}")
	private String driverClassName;
	
	@Value("${url}")
	private String url;
	
	@Value("${userName}")
	private String userName;
	
	@Value("${password}")
	private String password;
}

