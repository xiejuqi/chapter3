package com.baobaotao.aspectj.advanced;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename BindingAfterReturingValueAspect.java
 * 
 * @Description	后置增强绑定连接点返回值测试
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月5日 上午10:56:23
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class BindingAfterReturingValueAspect extends BaseLoggerController {
	@AfterReturning(value="target(com.baobaotao.aspectj.fun.SmartSeller)",returning="retVal")
	public void bindReturnValue(int retVal){
		logger.info("[---bindReturnValue---Start---]");
		logger.info("retVal={}",retVal);
		logger.info("[---bindReturnValue---End---]");
	}
}

