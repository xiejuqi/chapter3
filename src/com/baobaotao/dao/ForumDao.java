package com.baobaotao.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename ForumDao.java
 * 
 * @Description 使用NamedParameterJdbcTemplate,以OO方式访问数据库
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年5月21日 下午2:16:34
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class ForumDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private BasicDataSource dataSource;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 使用NamedParameterJdbcTemplate命名参数绑定的模板类
	 * 
	 * @param user
	 */
	public void addForumByNamedParams(final User user) {
		/** 1.定义参数源 */
		final String sql = "INSERT INTO t_user (user_id,user_name,credits,password,last_visit,last_ip) "
				+ "VALUES (:userId,:userName,:credits,:password,:lastVisit,:lastIp)";

		/** 2.定义命名参数 */
		SqlParameterSource sps = new BeanPropertySqlParameterSource(user);

		namedParameterJdbcTemplate.update(sql, sps);
	}

	/**
	 * 如果没有相应的领域对象，则使用MapSqlParameterSource来达到绑定参数的目的。
	 * @param user
	 */
	public void addUser(final User user) {
		final String sql = "INSERT INTO t_user (user_id,user_name,credits,password,last_visit,last_ip) "
				+ "VALUES (:userId,:userName,:credits,:password,:lastVisit,:lastIp)";

		MapSqlParameterSource sps = new MapSqlParameterSource().addValue("userId", user.getUserId())
				.addValue("userName", user.getUserName()).addValue("credits", user.getCredits())
				.addValue("password", user.getPassword()).addValue("lastVisit", user.getLastVisit())
				.addValue("lastIp", user.getLastIp());
		namedParameterJdbcTemplate.update(sql, sps);
	}
}
