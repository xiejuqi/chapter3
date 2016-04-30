package com.baobaotao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;
import com.mysql.jdbc.Statement;

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
	
	@Autowired
	private BasicDataSource dataSource;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
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
	
	/**
	 * 添加一个用户
	 * @param user
	 */
	public void addUser(User user){
		String sqlStr = "INSERT INTO t_user (user_name,credits, PASSWORD,last_visit,last_ip) VALUES (?,?,?,?,?);";
		jdbcTemplate.update(
				sqlStr,
				new Object[] { user.getUserName(), user.getCredits(), user.getPassword(),user.getLastVisit(),
								user.getLastIp()});
		
		/**指定参数的类型*/
		/**jdbcTemplate.update(sqlStr,new Object[] { user.getUserName(), user.getCredits(), user.getPassword(),user.getLastVisit(),
								user.getLastIp()},new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.DATE});*/
	}
	
	/**
	 * 添加一个用户(返回主键)
	 * @param user
	 */
	public void addUserWithKey(final User user){
		
		final String sql = "INSERT INTO t_user (user_name,credits, PASSWORD,last_visit,last_ip) VALUES (?,?,?,?,?);";
		
		final Connection conn = DataSourceUtils.getConnection(dataSource);
		
		/**1.创建一个主键持有者*/
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getUserName());
				ps.setInt(2, user.getCredits());
				ps.setString(3, user.getPassword());
				ps.setDate(4, null);
				ps.setString(5, "127.0.0.1");
				
				return ps;
			}
		},keyHolder);
		
		/**2.从主键持有者中获取主键*/
		user.setUserId(keyHolder.getKey().intValue());
		
		logger.info("[user={}]",user);
	}
}
