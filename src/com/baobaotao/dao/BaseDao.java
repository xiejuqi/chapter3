package com.baobaotao.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 
 * @Filename BaseDao.java
 * 
 * @Description	定义类级别的泛型基类
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月5日 上午7:38:59
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
//1.提供DAO类级别的泛型支持
public class BaseDao<T> {
	
	//2.注入Hibernate模板类
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//3.DAO的泛型类，即子类所指定的T所对应的类型
	private Class entityClass;
	
	//4.通过反射方式获取子类DAO对应的泛型实体类
	public BaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}
	
	@SuppressWarnings("unchecked")
	public T get(Serializable id){
		//5.直接使用entityClass
		return (T) hibernateTemplate.get(entityClass, id);
	}
	
	public void save(T entity){
		hibernateTemplate.save(entity);
	}
	
	public void update(T entity){
		hibernateTemplate.update(entity);
	}
	
	public HibernateTemplate getHibernateTemplate(){
		return this.hibernateTemplate;
	}
}

