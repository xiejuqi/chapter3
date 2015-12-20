package com.baobaotao.placeholder;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename PlaceHolderTest.java
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
 * @Date: 2015年12月20日 上午8:48:44
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class PlaceHolderTest extends BaseLoggerController{
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/baobaotao/placeholder/bean1.xml");
		BasicDataSource basicDataSource = (BasicDataSource) ac.getBean("dataSource");
		logger.info("[basicDataSourceUrl={}]",basicDataSource.getUrl());
		logger.info("[basicDataSourceUsername={}]",basicDataSource.getUsername());
		logger.info("[basicDataSourceDriverClassname={}]",basicDataSource.getDriverClassName());
		
		MyDataSource myDataSource = (MyDataSource) ac.getBean("myDataSource");
		logger.info("[myDataSource={}]",myDataSource);
	}
	
	public static void main(String[] args) {
		new PlaceHolderTest().test();
	}
}

