package com.baobaotao.threadlocal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * 
 * @Filename ThreadLocalTopicDao.java
 * 
 * @Description	使用ThreadLocal对TopicDao进行改造
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月26日 下午5:37:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ThreadLocalTopicDao {
	/**1.使用ThreadLocal保存Connection变量*/
	private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<Connection>();

	public static Connection getConnection(){
		/**2.如果connThreadLocal没有本线程对应的Connection创建一个新的Connection，并将其保存到线程本地变量中*/
		if(connThreadLocal.get() == null){
			Connection conn = DataSourceUtils.getConnection(null);
			connThreadLocal.set(conn);
			return conn;
		}else{
			/**3.直接返回线程本地变量*/
			return connThreadLocal.get();
		}
	}
	
	public void addTopic() throws SQLException{
		/**从ThreadLocal中获取线程对应的*/
		Statement stat = getConnection().createStatement();
	}
}

