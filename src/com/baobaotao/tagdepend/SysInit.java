package com.baobaotao.tagdepend;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename SysInit.java
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
 * @Date: 2015年11月28日 下午2:19:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SysInit extends BaseLoggerController {
	public SysInit() {
		SystemSettings.SESSION_TIMEOUT = 10;
		SystemSettings.REFRESH_CYCLE = 100;
	}
}
