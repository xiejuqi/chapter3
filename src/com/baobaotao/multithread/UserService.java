package com.baobaotao.multithread;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.baobaotao.nestcall.ScoreService;

/**
 * 
 * @Filename UserService.java
 * 
 * @Description	Spring多线程下的事务困惑
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月26日 上午8:56:35
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Service
public class UserService {
	
	protected  Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ScoreService scoreService;
	
	public void logon(String userName){
		logger.info("[before userService.updateLastLogonTime method...]");
		updateLastLogonTime(userName);
		logger.info("[after userService.updateLastLogonTime method...]");
		
		/**1.在同一个线程中调用scoreService#addScore()*/
		/*scoreService.addScore(userName, 20);*/
		
		/**2.在一个新线程中执行scoreService#addScore()*/
		Thread myThread = new MyThread(this.scoreService,userName,20);
		myThread.start();
		
	}
	
	
	public void updateLastLogonTime(String userName){
		String sql = "UPDATE t_user u SET u.last_visit=? WHERE user_name=? ";
		jdbcTemplate.update(sql,new Date(),userName);
	}
	
	
	/**负责执行ScoreService#addScore()的线程类*/
	private class MyThread extends Thread{
		private ScoreService scoreService;
		private String userName;
		private int toAdd;
		
		private MyThread(ScoreService scoreService,String userName,int toAdd){
			this.scoreService = scoreService;
			this.userName = userName;
			this.toAdd = toAdd;
		}
		
		public void run(){
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("[before scoreService.addScore method...]");
			scoreService.addScore(userName, toAdd);
			logger.info("[after scoreService.addScore method...]");
		}
	}
}
