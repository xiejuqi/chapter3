package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.aspectj.fun.NaiveWaiter;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindingClassAnnotationObjAspect.java
 * 
 * @Description	演示绑定类注解对象的切面例子
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月5日 上午9:34:03
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class BindingClassAnnotationObjAspectTest extends BaseLoggerController {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:com/baobaotao/aspectj/advanced/BindingClassAnnotationObjAspectConfig.xml");
		
		NaiveWaiter naiveWaiter = (NaiveWaiter) ac.getBean("naiveWaiter");
		
		naiveWaiter.greetTo("SAM");
	}
}

