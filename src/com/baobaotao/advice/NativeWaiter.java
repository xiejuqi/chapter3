package com.baobaotao.advice;

import com.baobaotao.base.BaseLoggerController;
import com.sun.istack.internal.logging.Logger;

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
 * @Date: 2016年1月1日 上午9:00:59
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class NativeWaiter extends BaseLoggerController implements Waiter {

	@Override
	public void greedTo(String name) {
		logger.info("[greet to {}]",name);
	}

	@Override
	public void serverTo(String name) {
		logger.info("[serverTo {}]",name);
	}

}

