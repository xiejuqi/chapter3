package com.baobaotao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baobaotao.domain.Post;
///*import com.baobaotao.domain.User;*/
import com.baobaotao.hibernate.User;
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
	
	@Autowired
	private SessionFactory sessionFactory;
	
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
	
	/**获取CLOB和BLOB属性的对象*/
	public Post getPost(int userId){
		return getHibernateTemplate().get(Post.class, userId);
	}
	
	/**4.使用HQL查询*/
	@SuppressWarnings("unchecked")
	public List<User> findUserByName(String userName){
		return getHibernateTemplate().find("FROM User u where userName like ?",userName+"%");
	}
	
	/**5.使用Iterate返回结果，没有Spring事务配置的话会报错*/
	@Transactional
	public long getUserNum(){
		Object obj = getHibernateTemplate().iterate("select count(u.userId) from User u").next();
		return (Long)obj;
	}
	
	/**6.基于回调函数的形式来实现*/
	public long getUserNum2(){
		Long userNum = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				Object obj = session.createQuery("select count(u.userId) from User u").list().iterator().next();
				return (Long)obj;
			}
		});
		return userNum;
	}
	
	/**
	 * 7.使用原生Hibernate API操作
	 * 没有事务的话会出现异常
	 * @param user
	 */
	@Transactional
	public void addUser2(User user){
		sessionFactory.getCurrentSession().save(user);
	}
	
	/**
	 * 8.使用原生Hibernate API操作
	 * 没有事务的话会出现异常
	 * @param user
	 */
	@Transactional
	public void updateUser2(User user){
		sessionFactory.getCurrentSession().update(user);
	}
}

