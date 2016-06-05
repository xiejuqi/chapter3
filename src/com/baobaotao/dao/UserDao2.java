package com.baobaotao.dao;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename UserDao2.java
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
 * @Date: 2016年6月5日 上午7:56:11
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

//1.通过泛型指定实体类为User
public class UserDao2 extends BaseDao<User> {
	
	/**
	 * 2.子类仅需要编写特定的DAO方法就可以了，其他通用的从基类继承
	 * @return
	 */
	public int getUserNum(){
		Object obj = getHibernateTemplate().iterate("SELECT count(1) FROM t_user ").next();
		return (Integer) obj;
	}
}

