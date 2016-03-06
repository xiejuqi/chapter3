package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
public class BindingClassAnnotationObjAspect extends BaseLoggerController {
	/**
	 * 通过(2)处查找出m对应Monitorable类型的注解，因而真实的切点表达式为@within(Monitorable)，
	 * 当增强方法织入目标连接点时，增强方法通过m入参可以引用到连接点处的注解对象。
	 * @param m
	 */
	@Before("@within(m)")
	public void bindTypeAnnoObject(Monitorable m){//(2)
		logger.info("[---bindTypeAnnoObject()---Start---]");
		logger.info("m={}",m.getClass().getName());
		logger.info("[---bindTypeAnnoObject()---End---]");
	}
}

