package com.baobaotao.advisor;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Seller.java
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
 * @Date: 2016年1月2日 上午10:42:26
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Seller extends BaseLoggerController {
	public void greetTo(String name){
		logger.info("[seller greet to {} ...]",name);
	}
}

