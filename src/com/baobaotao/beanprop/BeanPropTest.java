package com.baobaotao.beanprop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BeanPropTest.java
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
 * @Date: 2015年12月20日 上午11:38:44
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BeanPropTest extends BaseLoggerController{
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/baobaotao/beanprop/bean1.xml");
		ApplicationManager applicationManager =  (ApplicationManager) ac.getBean("applicationManager");
		logger.info("[applicationManager={}]",applicationManager);
	}
	
	public static void main(String[] args) {
		new BeanPropTest().test();
	}
}

