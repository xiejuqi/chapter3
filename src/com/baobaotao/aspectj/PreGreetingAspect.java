package com.baobaotao.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename PreGreetingAspect.java
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
 * @Date: 2016年1月17日 上午9:08:48
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect	//通过该注解将PreGreetingAspect标识为一个切面
public class PreGreetingAspect extends BaseLoggerController{
	@Before("execution(* greetTo(..))")		//定义切点和增强类型
	public void beforeGreeting(){				//增强的横切逻辑
		logger.info("[How are you]");
	}
}

