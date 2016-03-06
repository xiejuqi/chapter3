package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindAfterThrowingExceptionAspect.java
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
 * @Date: 2016年3月5日 上午11:14:52
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BindAfterThrowingExceptionAspectTest extends BaseLoggerController {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/aspectj/advanced/BindAfterThrowingExceptionAspectConfig.xml");
		
		SmartSellerExceptionImpl smartSellerImpl = (SmartSellerExceptionImpl) ac.getBean("smartSellerExceptionImpl");
		
		smartSellerImpl.sellGoods("shoe", "SAM");
		
		smartSellerImpl.checkBill(2);
	}
}

