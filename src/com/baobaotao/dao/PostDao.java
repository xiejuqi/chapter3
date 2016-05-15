package com.baobaotao.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

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
	
	@Autowired
	/**主键产生器*/
	private DataFieldMaxValueIncrementer incre;
	
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
				
				/**获取下一个主键值*/
				ps.setInt(1, incre.nextIntValue());
				ps.setInt(2, post.getUserId());
				
				lobCreator.setClobAsString(ps, 3, post.getPostText());
				lobCreator.setBlobAsBytes(ps, 4, post.getPostAttach());
			}
		});
	}
	
	/**
	 * 通过lobHandler读取Lob字段
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getAttachs(final int userId){
		String sql = "SELECT post_id,post_attach FROM t_post where user_id=? and post_attach is not null";
		
		return jdbcTemplate.query(sql, new Object[]{userId},new RowMapper<Post>(){

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				int postId = rs.getInt(1);
				
				/**1.以二进制数组方式获取Blob数据*/
				byte[] attach = lobHandler.getBlobAsBytes(rs, 2);
				
				Post post = new Post();
				post.setPostId(postId);
				post.setPostAttach(attach);
				return post;
			}
		});
	}
	
	/**
	 * 以流的形式接受Lob数据
	 * @param postId
	 * @param os
	 */
	@SuppressWarnings("unchecked")
	public void getAttachs(final int postId,final OutputStream os){
		String sql = "SELECT post_attach FROM t_post WHERE post_id=? ";
		jdbcTemplate.query(sql, new Object[]{postId},new AbstractLobStreamingResultSetExtractor() {
			
			/** 
			 * 处理未找到数据行的情况
			 */
			@Override
			protected void handleNoRowFound() throws DataAccessException {
				System.out.println("Not Found result! ");
			}
			
			/**
			 *以流的方式处理Lob字段
			 */
			@Override
			protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
				InputStream is = lobHandler.getBlobAsBinaryStream(rs, 1);
				if(is != null){
					FileCopyUtils.copy(is, os);
				}
			}
		});
	}
}

