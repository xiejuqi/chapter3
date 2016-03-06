package com.baobaotao.aspectj.advanced;

import com.baobaotao.aspectj.fun.SmartSeller;

/**
 * 
 * @Filename SmartSellerImpl.java
 * 
 * @Description	用于测试AfterReturing切点绑定返回值
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月5日 上午11:01:27
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SmartSellerImpl extends SmartSeller {
	
	public int sellGoods(String goods,String clientName){
		logger.info("sell {} to {}",goods,clientName);
		return 100;
	}
}

