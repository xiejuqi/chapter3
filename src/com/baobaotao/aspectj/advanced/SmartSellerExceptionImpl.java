package com.baobaotao.aspectj.advanced;

import com.baobaotao.aspectj.fun.SmartSeller;

/**
 * 
 * @Filename SmartSellerImpl.java
 * 
 * @Description	用于测试AfterThrowing切点绑定异常
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
public class SmartSellerExceptionImpl extends SmartSeller {
	
	public int sellGoods(String goods,String clientName){
		logger.info("sell {} to {}",goods,clientName);
		return 100;
	}
	
	/**
	 * 用于测试AfterThrowing切点绑定异常
	 * @param billId
	 */
	public void checkBill(int billId){
		if(billId == 1){
			throw new IllegalArgumentException("iae Exception");
		}else{
			throw new RuntimeException("re Exception");
		}
	}
}

