package com.baobaotao.aspectj.fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @Filename AnnotationAspectjTest.java
 * 
 * @Description 测试基于Annotation的Aspect
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年1月26日 上午9:12:31
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/baobaotao/aspectj/fun/AnnotationAspectConfig.xml")
public class AnnotationAspectjTest {

	@Autowired
	private Waiter naughtyWaiter;

	@Autowired
	private Waiter naiveWaiter;

	@Test
	public void test() {
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/baobaotao/aspectj/fun/AnnotationAspectConfig.xml");
		
		NaughtyWaiter naughtyWaiter = (NaughtyWaiter) ac.getBean("naughtyWaiter");*/
		
		naughtyWaiter.greetTo("Sam");

		naiveWaiter.greetTo("Bob");
	}
}
