package com.baobaotao.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

import com.baobaotao.dao.PostDao;
import com.baobaotao.domain.Post;
import com.baobaotao.threadlocal.TopicDao;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

/**
 * 
 * @Filename TestPostDao.java
 * 
 * @Description	测试Lob字段的存取
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年5月15日 上午10:29:06
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
//基于JUnit4的Spring测试框架
@RunWith(SpringJUnit4ClassRunner.class)
//启动Spring容器
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestPostDao {
	
	@Autowired 
	private PostDao postDao;
	
	public void testAddPost() throws IOException{
		Post post = new Post();
		
		post.setUserId(2);
		
		/**1.获取图片资源*/
		ClassPathResource res = new ClassPathResource("temp.jpg");
		
		/**2.读取图片文件的数据*/
		byte[] mockImg = FileCopyUtils.copyToByteArray(res.getFile());
		
		post.setPostAttach(mockImg);
		post.setPostText("测试帖子的内容");
		
		postDao.addPost(post);
	}
	
	public void testSelectPost(){
		
		List<Post> list = postDao.getAttachs(2);
		System.out.println(list.get(0));
		
		/**以流的形式接收Lob字段*/
		OutputStream os = new ByteOutputStream();
		postDao.getAttachs(1, os);
		System.out.println(os);
	}
	
	/**
	 * 测试行集返回数据
	 */
	@Test
	public void testSqlRowSet(){
		SqlRowSet srs = postDao.getTopicRowSet(1);
		
		/**1.这时，数据连接已经断开*/
		while(srs.next()){
			System.out.println(srs.getString("post_id"));
		}
	}
}

