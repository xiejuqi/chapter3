package com.baobaotao.advice;

import java.sql.SQLException;

/**
 * 
 * @Filename ForumService.java
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
 * @Date: 2016年1月1日 下午3:30:04
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ForumService {
	public void removeForum(int forumId){
		//do something...
		throw new RuntimeException("运行异常！");
	}
	
	public void updateForum(int forumId) throws SQLException{
		//do something...
		throw new SQLException("数据库更新操作异常！");
	}
}	

