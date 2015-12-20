package com.baobaotao.anno;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename LogonService.java
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
 * @Date: 2015年11月29日 下午4:17:50
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class LogonService extends BaseLoggerController{
	private LogDao logDao;
	private UserDao userDao;
	
	/**
	 * @param logDao the logDao to set
	 */
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
