package com.baobaotao.anno;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename LogDao.java
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
 * @Date: 2015年11月29日 下午4:16:20
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class LogDao extends BaseLoggerController{
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
