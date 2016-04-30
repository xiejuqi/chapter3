package com.baobaotao.connleak;

import java.sql.Connection;
import java.util.Date;

import javax.activation.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @Filename JdbcUserService.java
 * 
 * @Description	Spring JDBC数据连接泄漏
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月29日 上午8:33:54
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Service
public class JdbcUserService {
	
	private static Logger logger = LoggerFactory.getLogger(JdbcUserService.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional("jdbcManager")
	public void logon(String userName){
		
		Connection conn = null;
		
		try {
			/**1.直接从数据源获取连接,后续程序没有显式释放该连接*/
			 conn = jdbcTemplate.getDataSource().getConnection();
			
			/**使用DataSourceUtils获取数据连接,不用自己手动去释放连接，Spring会帮我们完成。*/
			/*conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());*/
			
			String sql = "UPDATE t_user SET last_visit=? WHERE user_name = ? ";
			jdbcTemplate.update(sql,new Date(),userName);
			
			/**模拟程序代码的执行时间*/
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/**2.显式使用DataSourceUtils释放连接*/
			/*DataSourceUtils.releaseConnection(conn, jdbcTemplate.getDataSource());*/
		}
	}
	
	/**1.以异步线程的方式执行JdbcUserService{@link #logon(String)}方法，以模拟多线程的环境*/
	public static void asynchrLogon(JdbcUserService userService,String userName){
		UserServiceRunner runner = new UserServiceRunner(userService,userName);
		runner.start();
	}
	
	private static class UserServiceRunner extends Thread{
		private JdbcUserService userService;
		private String userName;
		
		public UserServiceRunner(JdbcUserService userService,String userName){
			this.userService = userService;
			this.userName = userName;
		}
		
		public void run(){
			userService.logon(userName);
		}
	}
	
	/**2.让主执行线程睡眠一段指定的时间*/
	public static void sleep(long time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**3.汇报数据源的连接占用情况*/
	public static void reportConn(BasicDataSource basicDataSource){
		logger.info("[连接数active:{}，idle:{}]",basicDataSource.getNumActive(),basicDataSource.getNumIdle());
	}
	
	public static void main(String[] args) {
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/connleak/SpringConnleakConfig.xml");*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/connleak/TransactionAwareDataSourceProxy.xml");
		
		JdbcUserService userService = (JdbcUserService) ac.getBean("jdbcUserService");
		
		BasicDataSource basicDataSource = (BasicDataSource) ac.getBean("originDataSource");
		
		/**4.汇报数据源初始连接占用情况 0:0*/
		JdbcUserService.reportConn(basicDataSource);
		
		/**启动一个异步线程A*/
		JdbcUserService.asynchrLogon(userService,"Tom");
		JdbcUserService.sleep(500);
		
		/**5.此时线程A正在执行JdbcUserService#logon()方法 2:0*/
		JdbcUserService.reportConn(basicDataSource);
		JdbcUserService.sleep(2000);
		
		/**6.此时线程A所执行的JdbcUserService#logon()方法已经执行完毕 1:1*/
		JdbcUserService.reportConn(basicDataSource);
		
		/**启动一个异步线程B*/
		JdbcUserService.asynchrLogon(userService,"John");
		
		JdbcUserService.sleep(500);
		
		/**此时线程B正在执行JdbcUserService#logon()方法 3:1*/
		JdbcUserService.reportConn(basicDataSource);
		
		JdbcUserService.sleep(2000);
		
		/**8.此时线程A和B都已经完成JdbcUserService#logon()方法的执行 2:1*/
		JdbcUserService.reportConn(basicDataSource);
		
	}
}
