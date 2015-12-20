package com.baobaotao.beanfactorylifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BeanLifeCycle.java
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
 * @Date: 2015年11月15日 上午10:28:12
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BeanLifeCycle extends BaseLoggerController {
	
	public void LifeCycleInBeanFactory() {
		//1.装载配置文件并启动容器
		Resource resource = new ClassPathResource("com/baobaotao/beanfactorylifecycle/beans.xml");
		BeanFactory bf = new XmlBeanFactory(resource);
		
		//2.向容器中注册MyBeanPostProcessor后处理器
		((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
		
		//3.向容器MyInstantiationAwareBeanPostProcessor后处理器
		((ConfigurableBeanFactory) bf)
			.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		//4.第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用
		Car car1 = (Car) bf.getBean("car");
		logger.info("[car1={}" + car1.toString() + "]");
		car1.introduce();
		car1.setColor("红色");
		
		//5.第二次从容器中获取car，直接从缓存池中获取
		Car car2 = (Car) bf.getBean("car");
		
		//6.查看car1和car2是否指向同一引用
		logger.info("[car1==car2:" + (car1 == car2) + "]");
		
		//7.关闭容器
		((XmlBeanFactory) bf).destroySingletons();
	}
	
	public static void main(String[] args) {
		BeanLifeCycle blc = new BeanLifeCycle();
		blc.LifeCycleInBeanFactory();
	}
}
