package com.baobaotao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.Post;
import com.baobaotao.domain.User;
import com.mysql.jdbc.MySQLConnection;

/**
 * 
 * @Filename PostDao.java
 * 
 * @Description	获取本地数据源连接
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年5月15日 上午8:52:17
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class PostDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private LobHandler lobHandler;
	
	public void getNativeConn(){
		try {
			/**1.使用DataSourceUtils从模板类中获取连接*/
			Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
			
			/**2.使用模板类的本地Jdbc抽取器获取本地的Connection*/
			conn = jdbcTemplate.getNativeJdbcExtractor().getNativeConnection(conn);
			
			/**3.这时可以强制进行类型转换了*/
			MySQLConnection oconn = (MySQLConnection)conn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 插入一个帖子(包含Lob字段)
	 * @param post
	 */
	public void addPost(final Post post){
		String sqlStr = "INSERT INTO t_post (post_id,user_id,post_text,post_attach) VALUES (?,?,?,?);";
		
		jdbcTemplate.execute(sqlStr,new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			
			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
				
				ps.setInt(1, 1);
				ps.setInt(2, post.getUserId());
				
				lobCreator.setClobAsString(ps, 3, post.getPostText());
				lobCreator.setBlobAsBytes(ps, 4, post.getPostAttach());
			}
		});
	}
}

