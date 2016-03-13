package com.baobaotao.ltw;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename PreGreetingAspect.java
 * 
 * @Description	通过@Aspect注解配置一个切面，然后通过Spring LTW的方式织入这个切面。
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月12日 下午4:19:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class PreGreetingAspect extends BaseLoggerController {
	@Before("execution(* greetTo(..))")
	public void beforeGreeting(){
		logger.info("[How are you ?]");
	}
}

