package com.baobaotao.aspectj.fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @Filename DeclareAspectJConfigTest.java
 * 
 * @Description	用于配置测试基于AspectJ定义的引介增强切面 
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年1月26日 上午8:42:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/baobaotao/aspectj/fun/DeclareAspectConfig.xml")
public class DeclareAspectJConfigTest {
	
	@Autowired
	private Waiter waiter;
	
	@Test
	public void test(){
		waiter.greetTo("Sam");
		
		Seller seller = (Seller)waiter;
		
		seller.sell("shoe", "Sam");
	}
}
