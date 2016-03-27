package com.baobaotao.threadlocal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @Filename TopicDao.java
 * 
 * @Description	非线程安全的举例
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月26日 下午5:33:06
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TopicDao {
	/**一个非线程安全的变量*/
	private Connection conn;

	public void addTopic() throws SQLException{
		/**引用非线程安全变量*/
		Statement statement = conn.createStatement();
	}
}

