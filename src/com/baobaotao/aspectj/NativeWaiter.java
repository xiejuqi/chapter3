package com.baobaotao.aspectj;

import com.baobaotao.advice.Waiter;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename NativeWaiter.java
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
 * @Date: 2016年1月17日 上午9:07:16
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class NativeWaiter extends BaseLoggerController implements Waiter {

	@Override
	public void greetTo(String name) {
		logger.info("[NativeWaiter greet to clientName={}]",name);
	}

	@Override
	public void serverTo(String name) {
		logger.info("[NativeWaiter server to clientName={}]",name);
	}

}

