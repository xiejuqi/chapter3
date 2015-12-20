package com.baobaotao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.LoginLog;

/**
 * 
 * @Filename LoginLogDao.java
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
 * @Date: 2015-8-23 上午10:46:44
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class LoginLogDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 用户登录后记录日志
	 * @param loginLog
	 */
	public void insertLoginLog(LoginLog loginLog) {
		String sqlStr = "INSERT INTO t_login_log(user_id,ip,login_datetime)" + "VALUES(?,?,?)";
		Object[] args = { loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate() };
		jdbcTemplate.update(sqlStr, args);
	}
}
