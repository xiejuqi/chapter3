package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.fun.NaiveWaiter;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindingAfterReturingValueAspect.java
 * 
 * @Description	后置增强绑定连接点返回值测试
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月5日 上午10:56:23
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BindingAfterReturingValueAspectTest extends BaseLoggerController {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/aspectj/advanced/BindingAfterReturingValueAspectConfig.xml");
		
		SmartSellerImpl smartSellerImpl = (SmartSellerImpl) ac.getBean("smartSellerImpl");
		
		smartSellerImpl.sellGoods("shoe", "SAM");
		
	}
}

