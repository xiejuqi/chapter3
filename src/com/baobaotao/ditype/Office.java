package com.baobaotao.ditype;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Office.java
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
 * @Date: 2015年11月21日 上午10:58:34
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Office extends BaseLoggerController {
	private String site;
	private String size;
	
	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}
	
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
}
