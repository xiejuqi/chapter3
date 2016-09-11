package com.baobaotao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baobaotao.multithread.UserService;

/**
 * 
 * @Filename TestSpringMultipleThreadTransaction.java
 * 
 * @Description Spring多线程下的事务困惑
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月26日 上午9:13:14
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Controller
public class TestSpringMultipleThreadTransaction {
	
	@Autowired(required = false)
	private UserService userService;
	
	@RequestMapping(value = "/testMultithreadTransaction.html")
	public String test() {
		userService.logon("admin");
		return "login";
	}
}
