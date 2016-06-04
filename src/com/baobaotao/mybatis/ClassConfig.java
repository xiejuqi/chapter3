package com.baobaotao.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.domain.User;
/**
 * 
 * @Filename ClassConfig.java
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
 * @Date: 2016年5月28日 上午8:42:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ClassConfig {
	public static void main(String[] args) {
		/*Configuration cfg = new Configuration().configure("com/baobaotao/hibernate/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();*/
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/mybatis/mybatis-spring.xml");
		
		SqlSessionFactory sf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		
		SqlSession session = 	sf.openSession();
		
		try {
			User user = (User) session.selectOne("com.baobaotao.mybatis.UserMapper.getUserById",1);
			System.out.println("user="+user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
}

