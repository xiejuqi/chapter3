package com.baobaotao.nestcall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @Filename ScoreService.java
 * 
 * @Description	用于测试Spring相互嵌套的服务方法的事务管理
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月25日 上午8:25:36
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Service
public class ScoreService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addScore(String userName,int toAdd){
		String sql = "UPDATE t_user u SET u.credits=u.credits+? WHERE user_name=?";
		jdbcTemplate.update(sql,toAdd,userName);
	}
}
