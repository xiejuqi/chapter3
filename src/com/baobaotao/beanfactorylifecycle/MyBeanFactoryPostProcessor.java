package com.baobaotao.beanfactorylifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename MyBeanFactoryPostProcessor.java
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
 * @Date: 2015年11月15日 上午11:38:24
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 * @Annotation 
 * ApplicationContext在启动时，将首先为配置文件中每个<bean>生成一个BeanDefinition对象，BeanDefinition是
 * <bean>在Spring容器中的内部表示。当配置文件中所有的<bean>都被解析成BeanDefinition时，
 * ApplicationContext将调用工厂后处理器的方法， 因此我们有机会
 * 通过程序的方式调整Bean的配置信息。在这里，我们将car对应的BeanDefinition进行调整，将brand 属性设置为"奇瑞QQ"
 * 
 */
public class MyBeanFactoryPostProcessor extends BaseLoggerController implements
																	BeanFactoryPostProcessor {
	
	/**
	 * 对car<bean>的brand属性配置信息进行"偷梁换柱"的加工操作 (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
																					throws BeansException {
		// TODO Auto-generated method stub
		BeanDefinition bd = beanFactory.getBeanDefinition("car");
		
		bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
		logger.info("[调用BeanFactoryPostProcessor.postProcessBean Factory()]");
	}
}
