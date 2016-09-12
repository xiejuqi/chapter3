package com.baobaotao.springmvc;

import com.baobaotao.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @FileName PathVariableController.java
 *
 * @Description     通过@PathVariable可以将URL中的占位符参数绑定到控制器处理方法的入参中
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

    public ModelAndView showDetail(@PathVariable("userId") String userId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/showDetail");
        mav.addObject("user",new User());
        return mav;
    }
}
