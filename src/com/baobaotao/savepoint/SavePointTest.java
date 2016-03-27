package com.baobaotao.savepoint;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * 
 * @Filename SavePointTest.java
 * 
 * @Description	JDBC(1.4以及以后的版本)可以回滚到指定的回滚点
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月26日 下午4:11:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SavePointTest {
	
	public void insert() throws SQLException{
		Connection conn = DataSourceUtils.getConnection(null);
		Statement stmt = conn.createStatement();
		
		int rows = stmt.executeUpdate("INSERT INTO t_topic VALUES(1,'tom')");
		
		/**设置一个保存点*/
		Savepoint svpt = conn.setSavepoint("savePoint1");
		rows = stmt.executeUpdate("UPDATE t_user set topic_nums=topic_nums+1"+"WHERE user_id=1");
		
		conn.rollback(svpt);
		
		conn.commit();
	}
}

