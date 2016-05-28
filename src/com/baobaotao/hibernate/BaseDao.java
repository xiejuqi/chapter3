package com.baobaotao.hibernate;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * @Filename BaseDao.java
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
 * @Date: 2016年5月28日 上午9:25:40
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Repository
public class BaseDao extends HibernateDaoSupport{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }  
}

