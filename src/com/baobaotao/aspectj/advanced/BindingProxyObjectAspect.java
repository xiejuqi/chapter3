package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.baobaotao.aspectj.fun.Waiter;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindingProxyObjectAspect.java
 * 
 * @Description	使用this()切点函数来匹配切点，绑定参数
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月2日 上午9:00:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class BindingProxyObjectAspect extends BaseLoggerController {
	
	/**
	 * (1)通过(2)处查找出waiter对应的类型为Waiter，因而切点表达式为this(Waiter)，
	 * 当增强方法织入目标连接点时，增强方法通过waiter入参可以应用到代理对象的实例。
	 * @param waiter
	 */
	@Before("this(waiter)")
	public void bindProxyObj(Waiter waiter){//(2)
		logger.info("[---bindProxyObj()---Start---]");
		logger.info("[waiter:{}]",waiter.getClass().getName());
		logger.info("[---bindProxyObj()---End---]");
	}
	
}
