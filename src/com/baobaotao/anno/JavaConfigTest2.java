package com.baobaotao.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename JavaConfigTest.java
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
 * @Date: 2015年12月19日 上午10:43:59
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class JavaConfigTest2 extends BaseLoggerController{
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/anno/bean2.xml");
		LogonAppConfig logonAppConfig = (LogonAppConfig) ac.getBean("logonAppConfig");
		logger.info("[logonAppConfig={}]",logonAppConfig);
		logger.info("[logonService={}]",logonAppConfig.logonService());
	}
	public static void main(String[] args) {
		JavaConfigTest2 configTest2 = new JavaConfigTest2();
		configTest2.test();
	}
}

