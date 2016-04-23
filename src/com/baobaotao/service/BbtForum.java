package com.baobaotao.service;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename BbtForum.java
 * 
 * @Description	测试使用原始的TransactionProxyFactoryBean来配置事务
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月3日 上午8:23:13
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public interface BbtForum {
	void addUserAndLoginLog(User user);
	void updateUser(User user);
	User getUser(String userName);
}

