package com.baobaotao.beanprop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ApplicationManager.java
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
 * @Date: 2015年12月20日 上午11:36:28
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component
public class ApplicationManager extends BaseLoggerController{
	@Value("#{sysConfig.sessionTimeout}")
	private int sessionTimeout;
	@Value("#{sysConfig.maxTagPageNum}")
	private int maxTabpageNum;
}

