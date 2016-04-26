package com.baobaotao.nestcall;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


/**
 * 
 * @Filename UserService.java
 * 
 * @Description	用于测试Spring相互嵌套的服务方法的事务管理
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月25日 上午8:24:25
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class UserService {
	
	protected  Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ScoreService scoreService;
	
	/**该方法嵌套调用了本类的其他方法以及其他服务类的方法*/
	public void logon(String userName){
		logger.info("[before userService.updateLastLogonTIme...]");
		/**本服务类的其他方法*/
		updateLastLogonTime(userName);
		logger.info("[after userService.updateLastLoginTime...]");
		
		
		logger.info("[before scoreService.addScore...]");
		/**其他服务类的其他方法*/
		scoreService.addScore(userName, 20);
		logger.info("[after scoreService.addScore...]");
	}
	
	public void updateLastLogonTime(String userName){
		String sql ="UPDATE t_user u SET u.last_visit=? WHERE user_name=? ";
		jdbcTemplate.update(sql,new Date(),userName);
	}
}
