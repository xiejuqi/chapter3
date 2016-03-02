package com.baobaotao.aspectj.fun;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename NaiveWaiter.java
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
 * @Date: 2016年1月26日 上午8:33:41
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class NaiveWaiter extends BaseLoggerController implements Waiter {

	@Override
	public void serveTo(String clientName) {
		logger.info("serveTo to {}",clientName);
	}

	@Override
	public void greetTo(String clientName) {
		logger.info("greetTo to {}",clientName);
	}
	
	public void smile(String name,int times){
		logger.info("smile to {}-{}..",name,times);
	}

}
