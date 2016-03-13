package com.baobaotao.ltw;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Waiter.java
 * 
 * @Description	创建一个可被增强的类，测试Spring LTW的增强功能。
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月12日 下午4:25:00
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Waiter extends BaseLoggerController {
	public void greetTo(String clientName){
		logger.info("[greet to:{}]",clientName);
	}
	
	public void serveTo(String clientName){
		logger.info("[serve to:{}]",clientName);
	}
}

