package com.baobaotao.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.baobaotao.test.reflect.domain.Car;

/**
 * 
 * @Filename BeanFactoryTest.java
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
 * @Date: 2015年11月8日 下午4:30:22
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BeanFactoryTest {
	public static void main(String[] args) {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("classpath:/com/baobaotao/beanfactory/beans.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		
		System.out.println("init BeanFactory.");
		
		Car car = bf.getBean("car1", Car.class);
		System.out.println(car.toString());
		System.out.println("car bean is ready for user!");
	}
}
