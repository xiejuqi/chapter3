package com.baobaotao.aspectj.fun;

import com.baobaotao.base.BaseLoggerController;
import com.baobaotao.javaanno.NeedTest;

/**
 * 
 * @Filename NaughtyWaiter.java
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
 * @Date: 2016年1月26日 上午9:08:50
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class NaughtyWaiter extends BaseLoggerController implements Waiter{
	
	@NeedTest
	public void serveTo(String clientName) {
		logger.info("[serveTo {}]",clientName);
	}

	@NeedTest
	public void greetTo(String clientName) {
		logger.info("[greetTo {}]",clientName);
	}

}
