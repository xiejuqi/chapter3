package com.baobaotao.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.baobaotao.base.BaseLoggerController;

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
 * @Date: 2015年11月29日 下午2:22:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

@Component("UserDao")
//指定Bean的作用范围为prototype
@Scope("prototype")
public class UserDao extends BaseLoggerController{
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
