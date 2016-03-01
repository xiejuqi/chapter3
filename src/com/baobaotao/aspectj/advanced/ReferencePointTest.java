package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ReferencePointTest.java
 * 
 * @Description	通过名称引用别的类中定义的切点
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月1日 上午8:43:07
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class ReferencePointTest extends BaseLoggerController {
	
	/**
	 * (1)
	 */
	@Before("TestNamePointcut.inPkgGreetTo()")
	public void pkgGreetTo(){
		logger.info("[--pkgGreetTo() executed!--]"); 
	}
	
	/**
	 * (2)
	 */
	@Before("!target(com.baobaotao.NaiveWaiter) && TestNamePointcut.inPkgGreetTo()")
	public void pkgGreetToNotNaiveWaiter(){
		logger.info("[--pkgGreetToNotNaiveWaiter() executed!--]"); 
	}
	
}
