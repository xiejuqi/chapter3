package com.baobaotao.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ThisAndTargetDiff.java
 * 
 * @Description	本类主要测试this()和target()切点函数的区别，TestAspect是通过判断运行期代理对象所属类型来定义切点的切面。
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年2月29日 上午8:29:06
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class TestAspect extends BaseLoggerController{
	@AfterReturning("this(com.baobaotao.aspectj.fun.Seller)")
	public void thisTest(){
		logger.info("[thisTest() executed!]");
	}
}
