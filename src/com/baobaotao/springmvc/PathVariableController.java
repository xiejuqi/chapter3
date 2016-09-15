package com.baobaotao.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.User;

/**
 * @FileName PathVariableController.java
 * 
 * @Description 通过@PathVariable可以将URL中的占位符参数绑定到控制器处理方法的入参中
 * 
 * @Version 1.0
 * 
 * @Author xiejuqi
 * 
 * @Email xiejuqi@yolo24.com
 * 
 * @History Author: xiejuqi
 * 
 * @Date: 2016/9/12 9:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 */
@Controller
@RequestMapping("/user")
public class PathVariableController {
	
	@RequestMapping("/{userId}")
	public ModelAndView showDetail(@PathVariable("userId") String userId) {
		System.out.println("userId=" + userId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/showDetail");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET, params = "userId")
	public String test1(@RequestParam("userId") String userId) {
		System.out.println("userId=" + userId);
		return "register";
	}


	@RequestMapping(value = "/show",headers = "content-type=text/*")
	public String test2(){
	    return "register";
    }
	
}
