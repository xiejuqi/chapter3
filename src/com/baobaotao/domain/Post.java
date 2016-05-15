package com.baobaotao.domain;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Post.java
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
 * @Date: 2016年5月15日 上午9:51:12
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Post extends BaseLoggerController {
	
	private int postId;
	private int userId;
	private String postText;
	private byte[] postAttach;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public byte[] getPostAttach() {
		return postAttach;
	}
	public void setPostAttach(byte[] postAttach) {
		this.postAttach = postAttach;
	}
	
	
}

