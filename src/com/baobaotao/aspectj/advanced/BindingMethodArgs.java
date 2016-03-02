package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindingMethodArgs.java
 * 
 * @Description	args()切点函数绑定入参，匹配切点
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月2日 上午8:18:47
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class BindingMethodArgs extends BaseLoggerController {
	/**
	 * 绑定连接点参数，首先args(name,num..)根据(2)处的增强方法入参找到name和num对应的类型，
	 * 以得到真实的切点表达式，target(com.baobaotao.NaiveWaiter)&& args(name,num,..)在该增强织入
	 * 到目标连接点时，增强方法可以通过num和name访问到连接点方法的入参
	 * 
	 * @param num
	 * @param name
	 */
	@Before("target(com.baobaotao.aspectj.fun.NaiveWaiter) && args(name,num)")//1.增强方法接收连接点的参数
	public void bindJoinPointParams(int num,String name){//2.
		logger.info("[--bindJoinPointParams()---Start---]");
		logger.info("[name={}]",name);
		logger.info("[num={}]",num);
		logger.info("[--bindJoinPointParams()---End---]");
	}
}
