package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename UserOODao.java
 * 
 * @Description	以OO方式访问数据库
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年5月21日 下午2:59:58
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class UserOODao {

	@Autowired
	private BasicDataSource dataSource;
	
	private UserQuery userQuery;

	private UserInsert userInsert;
	
	private GetTopicNum getTopicNum;
	
	@PostConstruct
	public void init() {
		this.userQuery = new UserQuery(this.dataSource);
		this.userInsert = new UserInsert(this.dataSource);
		this.getTopicNum = new GetTopicNum(this.dataSource);
	}
	
	public User getUser(int userId){
		return userQuery.findObject(userId);
	}
	
	public void addUser(User user){
		userInsert.insert(user);
	}
	
	public int getTopicNum(int userId){
		return getTopicNum.getTopicNum(userId);
	}

	/**4.定义MappingSqlQuery*/
	private class UserQuery extends MappingSqlQuery<User> {

		public UserQuery(DataSource ds) {
			/** 5.定义查询语句并预编译 */
			super(ds,
					"SELECT user_id,user_name,credits,password,last_visit,last_ip FROM t_user WHERE user_id=? ");
			
			declareParameter(new SqlParameter(Types.INTEGER));
			
			/**5-1不能忘记这行编译语句，否则会发生错误*/
			compile();
		}

		/**6.映射查询结果集*/
		@Override
		protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			User user = new User();
			user.setUserName(rs.getString("user_name"));
			user.setCredits(rs.getInt("credits"));
			user.setPassword(rs.getString("password"));
			user.setLastVisit(rs.getDate("last_visit"));
			user.setLastIp(rs.getString("last_ip"));
			
			return user;
		}

	}
	
	/**
	 * 扩展SqlUpdate定义子类，执行insert操作
	 * @author JuqiXie
	 *
	 */
	private class UserInsert extends SqlUpdate{
		public UserInsert(DataSource ds){
			/**定义SQL语句并且预编译*/
			super(ds,
					"INSERT INTO t_user (user_id,user_name,credits,password,last_visit,last_ip) "
				+ "VALUES (:userId,:userName,:credits,:password,:lastVisit,:lastIp)");
			
			declareParameter(new SqlParameter("userId",Types.INTEGER));
			declareParameter(new SqlParameter("userName",Types.VARCHAR));
			declareParameter(new SqlParameter("credits",Types.VARCHAR));
			declareParameter(new SqlParameter("password",Types.VARCHAR));
			declareParameter(new SqlParameter("lastVisit",Types.DATE));
			declareParameter(new SqlParameter("lastIp",Types.INTEGER));
			
			compile();
		}
		
		public void insert(User user){
			
			/**绑定参数*/
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("userId", user.getUserId());
			params.put("userName", user.getUserName());
			params.put("credits", user.getCredits());
			params.put("password", user.getPassword());
			params.put("lastVisit", user.getLastVisit());
			params.put("lastIp", user.getLastIp());
			
			super.updateByNamedParam(params);
		}
	}
	
	/**
	 * OO方式执行存储过程
	 * @author JuqiXie
	 *
	 */
	private class GetTopicNum extends StoredProcedure{
		
		private static final String SQL = "P_GET_TOPIC_NUM";
		
		public GetTopicNum(DataSource ds){
			setDataSource(ds);
			setSql(SQL);
			
			/**声明入参*/
			declareParameter(new SqlParameter("userId",Types.INTEGER));
			
			/**声明出参*/
			declareParameter(new SqlOutParameter("outNum", Types.INTEGER));
			
			compile();
		}
		
		public int getTopicNum(int userId){
			/**执行存储过程并返回结果*/
			Map<String,Integer> map = new HashMap<String, Integer>();
			
			map.put("userId", userId);
			Map<String,Object> outMap = execute(map);
			
			return (Integer) outMap.get("outNum");
		}
		
	}

}
