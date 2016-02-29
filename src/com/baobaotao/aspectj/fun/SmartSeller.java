package com.baobaotao.aspectj.fun;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename SmartSeller.java
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
 * @Date: 2016年1月26日 上午8:33:57
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SmartSeller extends BaseLoggerController implements Seller {

	@Override
	public void sell(String goods,String clientName) {
		logger.info("sell {} to {}",goods,clientName);
//		System.out.println("seller "+goods+"to "+clientName);
	}

}
