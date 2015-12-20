package com.baobaotao.editor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename CustomEditorTest.java
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
 * @Date: 2015年12月19日 下午4:15:23
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CustomEditorTest extends BaseLoggerController{
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/editor/bean1.xml");
		
		Boss boss = (Boss) ac.getBean("boss");
		
		logger.info("[boss={}]",boss);
	}
	
	public static void main(String[] args) {
		new CustomEditorTest().test();
	}
}

