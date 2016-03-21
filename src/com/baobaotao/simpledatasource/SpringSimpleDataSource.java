package com.baobaotao.simpledatasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * @Filename SpringSimpleDataSource.java
 * 
 * @Description	使用Spring本身提供的一个简单的数据源实现类获取数据源
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月21日 上午8:42:23
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SpringSimpleDataSource {
	public static void main(String[] args) throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3309/sampledb");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		Connection actualCon = dataSource.getConnection();
		
	}
}
