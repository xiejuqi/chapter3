package com.baobaotao.special;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * 
 * @Filename UserService.java
 * 
 * @Description	测试Spring不能被织入AOP事务的特殊方法(基于CGLIB的动态代理)
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月28日 上午8:39:28
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Service
public class UserService {
	
	protected  Logger logger = LoggerFactory.getLogger(getClass());
	
	/**1.private方法因为访问权限的限制，无法被子类覆盖*/
	private void method1(){
		logger.info("[method1]");
	}
	
	/**2.final方法无法被子类覆盖*/
	private final void method2(){
		logger.info("[method2]");
	}
	
	/**3.static是类级别的方法，无法被子类覆盖*/
	public static void method3(){
		System.out.println("[method3]");
	}
	
	/**4.public方法可以被子类覆盖，因此可以被动态字节码增强*/
	public void method4(){
		logger.info("[method4]");
	}
	
	/**5.final的方法不能被子类覆盖*/
	public final void method5(){
		logger.info("[in method5]");
	}
	
	/**6.protected方法可以被子类覆盖，因此可以被动态字节码增强*/
	protected void method6(){
		logger.info("[in method6]");
	}
}
