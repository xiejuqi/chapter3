package com.baobaotao.advisor;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Waiter.java
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
 * @Date: 2016年1月2日 上午10:40:43
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Waiter extends BaseLoggerController {
	public void greetTo(String name){
		logger.info("[waiter greet to {} ...]",name);
	}
	
	public void serveTo(String name){
		logger.info("[waiter serving to {} ...]",name);
	}
}

