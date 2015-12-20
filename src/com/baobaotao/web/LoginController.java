package com.baobaotao.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

/**
 * 
 * @Filename LoginController.java
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
 * @Date: 2015年8月23日 下午4:23:17
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

//标注成为一个Spring MVC的Controller
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	//通过sl4j得到log4j
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/index.html")
	public String loginPage() {
		logger.info("[进入login登录控制器]");
		return "login";
	}
	
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),
			loginCommand.getPassword());
		
		logger.info("[进入登录验证控制器，入参loginCommand={}]", loginCommand);
		
		if (!isValidUser) {
			logger.info("[登录失败，入参loginCommand={}]", loginCommand);
			return new ModelAndView("login", "error", "用户名或者密码错误！");
		} else {
			logger.info("[登录成功，入参loginCommand={}]", loginCommand);
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastIp(request.getRemoteAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
	
	@RequestMapping(value = "/viewServletContextResource.html")
	public String viewServletContextResource() {
		return "resource";
	}
}
