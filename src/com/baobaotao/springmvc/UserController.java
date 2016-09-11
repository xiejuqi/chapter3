package com.baobaotao.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

/**
 * @FileName UserController.java
 * 
 * @Description 处理请求的控制器
 * 
 * @Version 1.0
 * 
 * @Author xiejuqi
 * 
 * @Email xiejuqi@yolo24.com
 * 
 * @History Author: xiejuqi
 * 
 * @Date: 2016/9/6 14:28
 * 
 * @Version: 1.0
 * 
 * @Content: create
 */

//1.使用UserController成为处理请求的控制器
@Controller
//2.处理来自/user URI的请求
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//3.返回一个ModelAndView对象
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	//处理/user的请求，不过请求的方法必须为POST
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	//将表单值映射到User对象中，调用UserService保存user，返回ModelAndView
	/*public ModelAndView createUser(User user) {
		ModelAndView mav = new ModelAndView();
		mav.setView("createSuccess");
		mav.addObject("user", user);
		return new ModelAndView("createSuccess", null);
	}*/
	public String createUser(User user) {
		return "createSuccess";
	}
	
}
