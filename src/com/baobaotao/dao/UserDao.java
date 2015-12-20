package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename UserDao.java
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
 * @Date: 2015-8-23 上午09:59:14
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 验证此用户是否存在
	 * @param userName
	 * @param password
	 * @return
	 */
	public int getMatchCount(String userName, String password) {
		String sqlStr = "SELECT count(1) FROM t_user " + " WHERE user_name = ? and password = ?";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] { userName, password });
	}
	
	/**
	 * 根据user_name返回User对象
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(final String userName) {
		String sqlStr = "SELECT user_id,user_name,credits " + "FROM t_user WHERE user_name = ? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userName }, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(userName);
				user.setCredits(rs.getInt("credits"));
			}
		});
		return user;
	}
	
	/**
	 * 更新用户积分和IP等信息
	 * @param user
	 */
	public void updateLoginInfo(User user) {
		String sqlStr = "UPDATE t_user SET last_visit=?,last_ip=?,credits=? " + " WHERE user_id=? ";
		jdbcTemplate.update(
			sqlStr,
			new Object[] { user.getLastVisit(), user.getLastIp(), user.getCredits(),
							user.getUserId() });
	}
}
