/**
 * 
 */
package com.baobaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

/**
 * 
 * @Filename UserService.java
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
 * @Date: 2015年8月23日 下午2:28:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

//将UserService标注为一个服务层的Bean
@Service
public class UserService {
	
	//自动注入JdbcTemplate的Bean
	@Autowired(required = false)
	@Qualifier("loginLogDao")
	private LoginLogDao loginLogDao;
	
	@Autowired
	private UserDao userDao;
	
	public boolean hasMatchUser(String userName, String passWord) {
		int matchCount = userDao.getMatchCount(userName, passWord);
		return matchCount > 0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	/**
	 * @param user
	 */
	public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	
	/*	*//**
	 * 自动将loginLogDao传给方法入参
	 * @param loginLogDao the loginLogDao to set
	 */
	/*
	@Autowired
	public void setLoginLogDao(LoginLogDao loginLogDao) {
	this.loginLogDao = loginLogDao;
	}
	
	*//**
	 * 自动将名为userDao的Bean传给方法入参
	 * @param userDao the userDao to set
	 */
	/*
	@Autowired
	@Qualifier("userDao")
	public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
	}
	
	@Autowired
	public void Init(@Qualifier("userDao") UserDao userDao, LoginLogDao loginLogDao) {
		System.out.println("multi param inject");
		this.userDao = userDao;
		this.loginLogDao = loginLogDao;
	}*/
	
}
