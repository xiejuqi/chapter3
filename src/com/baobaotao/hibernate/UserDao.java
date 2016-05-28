package com.baobaotao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

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
 * @Date: 2016年5月28日 上午9:29:54
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class UserDao extends BaseDao{
	
	/**1.保存实体对象*/
	public void addUser(User user){
		getHibernateTemplate().save(user);
	}
	
	/**2.更改实体对象*/
	public void updateUser(User user){
		getHibernateTemplate().update(user);
	}
	
	/**3.获取实体对象*/
	public User getUser(int userId){
		return getHibernateTemplate().get(User.class, userId);
	}
	
	/**4.使用HQL查询*/
	@SuppressWarnings("unchecked")
	public List<User> findUserByName(String userName){
		return getHibernateTemplate().find("FROM User u where user_name like ?",userName+"%");
	}
	
	/**5.使用Iterate返回结果*/
	public long getUserNum(){
		Object obj = getHibernateTemplate().iterate("SELECT count(u.user_id) FROM User u").next();
		return (Long)obj;
	}
}

