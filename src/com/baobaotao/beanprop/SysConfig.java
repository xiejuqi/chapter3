package com.baobaotao.beanprop;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baobaotao.base.BaseLoggerController;

import sun.jdbc.odbc.ee.DataSource;

/**
 * 
 * @Filename SysConfig.java
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
 * @Date: 2015年12月20日 上午11:32:13
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component
public class SysConfig extends BaseLoggerController{
	
	private int sessionTimeout;
	private int maxTagPageNum;
	@Autowired
	private BasicDataSource dataSource;
	
	//1.模拟从数据库中获取配置值并设置相应的属性
	@PostConstruct
	public void initFromDB(){
		//模拟从数据库获取配置值
		this.sessionTimeout = 30;
		this.maxTagPageNum = 10;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public int getMaxTagPageNum() {
		return maxTagPageNum;
	}

	public void setMaxTagPageNum(int maxTagPageNum) {
		this.maxTagPageNum = maxTagPageNum;
	}

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
}

