package com.baobaotao.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename JdbcTemplateTest.java
 * 
 * @Description	演示Spring JdbcTemplate模板类的使用
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月30日 下午4:28:01
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class JdbcTemplateTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 1.为了forum可以在内部类中使用，必须声明为final
	public void addForum(final User user) throws SQLException {

		final Connection conn = null;

		// 1.由于sql变量需要在内部类中使用，将其生命为final
		final String sql = "INSERT INTO t_user (user_name,credits, PASSWORD,last_visit,last_ip) VALUES (?,?,?,?,?);";

		// 2.通过匿名内部类定义回调实例
		//基于PreparedStatementSetter回调函数的使用
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
			}
		});
		
		//基于PreparedStatementCreator回调函数的使用
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				return ps;
			}
		});
		
		//演示Statement绑定并获取数据库产生的主键值的过程：
		Statement stmt = conn.createStatement();
		String sql2 = "ININSET INO t_topic(topic_title,user_id) VALUES ('测试主题','123')";
		
		//指定绑定表自增主键值
		stmt.executeUpdate(sql2,Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()){
			int key = rs.getInt(1);
		}
	}
}
