package com.baobaotao.attr;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Filename QuoteFatherContainerBean.java
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
 * @Date: 2015年11月21日 下午3:00:24
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class QuoteFatherContainerBean {
	private static Logger logger = LoggerFactory.getLogger(QuoteFatherContainerBean.class);
	
	public static void main(String[] args) {
		
		//1.父容器
		ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(
			new String[] { "com/baobaotao/attr/bean1.xml" });
		
		//2.指定pFactory为该容器的父容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[] { "com/baobaotao/attr/bean2.xml" }, pFactory);
		
		Boss boss = (Boss) ac.getBean("boss");
		
		logger.info("Boss={}", boss);
		
		//boss 的car属性作为内部Bean注入进boss中
		Boss insideBoss = (Boss) ac.getBean("boss1");
		logger.info("insideBoss={}", insideBoss);
		
		//引用null值
		Car nullCar = (Car) ac.getBean("car1");
		logger.info("nullCar={}", nullCar);
		
		//级联属性
		Boss cascadeBoss = (Boss) ac.getBean("boss2");
		logger.info("cascadeBoss={}", cascadeBoss);
		
		//List属性
		Boss listBoss = (Boss) ac.getBean("boss3");
		logger.info("listBoss={}", listBoss);
		
		//集合合并(子Bean合并父Bean)
		Boss childBoss = (Boss) ac.getBean("childBoss");
		logger.info("childBoss={}", childBoss);
		
		//List类型的Bean
		List favoriteList1 = (List) ac.getBean("favoriteList1");
		logger.info("favoriteList1={}", favoriteList1);
		
		//Set类型的Bean
		Set favoriteSet1 = (Set) ac.getBean("favoriteSet1");
		logger.info("favoriteSet1={}", favoriteSet1);
		
		//Map类型的Bean
		Map emails1 = (Map) ac.getBean("emails1");
		logger.info("emails1={}", emails1);
		
		//没有使用p命名空间前
		Boss boss4 = (Boss) ac.getBean("boss4");
		logger.info("未使用p命名标签前的boss4={}", boss4);
		
		//使用p命名空间后
		Boss boss5 = (Boss) ac.getBean("boss5");
		logger.info("使用p命名标签后的boss5={}", boss5);
	}
}
