package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ProceedJoinPointTest.java
 * 
 * @Description	使用ProceedJoinPoint连接点来访问连接点信息
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月1日 上午9:01:45
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class ProceedJoinPointAspect extends BaseLoggerController{
	@Around("execution(* greetTo(..)) && target(com.baobaotao.aspectj.fun.NaiveWaiter)")	//(1)环绕增强
	public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable{	//(2)声明连接点入参
		logger.info("[---joinPointAccess---]");
		
		logger.info("[args[0]={}]",pjp.getArgs()[0]);
		
		//(3)访问连接点信息
		logger.info("[signature:{}]",pjp.getTarget().getClass());
		
		//(4)通过连接点执行目标对象方法
		pjp.proceed();
		
		logger.info("[---joinPointAccess---]");
	}
}
