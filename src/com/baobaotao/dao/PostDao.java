package com.baobaotao.dao;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.MySQLConnection;

/**
 * 
 * @Filename PostDao.java
 * 
 * @Description	获取本地数据源连接
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年5月15日 上午8:52:17
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class PostDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void getNativeConn(){
		try {
			/**1.使用DataSourceUtils从模板类中获取连接*/
			Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
			
			/**2.使用模板类的本地Jdbc抽取器获取本地的Connection*/
			conn = jdbcTemplate.getNativeJdbcExtractor().getNativeConnection(conn);
			
			/**3.这时可以强制进行类型转换了*/
			MySQLConnection oconn = (MySQLConnection)conn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

