package com.baobaotao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.baobaotao.service.BbtForum;
import com.baobaotao.service.UserService;

/**
 * 
 * @Filename BbtForumImpl.java
 * 
 * @Description	测试TransactionProxyFactoryBean操作事务	
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月3日 上午8:26:17
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Transactional
public class BbtForumImpl implements BbtForum {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;

	@Override
	@ForumTransactional
	public void addUserAndLoginLog(User user) {
		
		LoginLog loginLog = generateLoginLog(user);
		
		userDao.addUser(user);
		loginLogDao.insertLoginLog(loginLog);
		int a = 4/0;
	}

	@Override
	public void updateUser(User user) {
		userDao.updateLoginInfo(user);
	}

	@Override
	public User getUser(String userName) {
		return userDao.findUserByUserName(userName);
	}

	private LoginLog generateLoginLog(User user) {
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		return loginLog;
	}

	/*public void addTopoic(Topic topic){
		*//**依旧会提交此处的数据持久化操作*//*
		topicDao.addTopic(topic);
		if(true){
			throw new PessimisticLockingFailureException("fial");
		}
		*//**此处的数据持久化操作无法到达*//*
		postDao.addPost(topic.getPost());
	}*/

}

