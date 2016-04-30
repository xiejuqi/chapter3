package com.baobaotao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baobaotao.nestcall.UserService;

/**
 * 
 * @Filename TestSpringNestTransactionController.java
 * 
 * @Description 用于测试Spring相互嵌套的服务方法的事务管理
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年4月25日 上午8:48:32
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Controller
public class TestSpringNestTransactionController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/testNestTransaction.html")
	public String test() {
		userService.logon("admin");
		return "login";
	}
	
}
