package com.baobaotao.springmvc.modeldata;

import com.baobaotao.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @FileName ModelDataHandleController.java
 *
 * @Description     Spring MVC处理模型数据
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/9/17  10:38
 *
 * @Version: 1.0
 *
 * @Content: create
 */
@Controller
@RequestMapping(value = "/modelData")
@SessionAttributes("user")
public class ModelDataHandleController {

    /*******************************************************使用@ModelAttribute*************************************************/

    @RequestMapping(value = "/handle61")
    public String handle61(@ModelAttribute(value = "user")User user){
        user.setUserId(111);
        return "success";
    }

    /**访问ModelDataHandleController中任何一个请求处理方法前，Spring MVC会先执行该方法，并将返回值以user为键添加到模型中*/
    @ModelAttribute
    public User getUser(){
        User user = new User();
        user.setUserId(1111);
        return user;
    }

    /**在此，模型数据会赋给User的入参，然后再根据HTTP请求消息进一步填充覆盖User对象*/
    @RequestMapping(value = "/handle62")
    public String handle62(@ModelAttribute(value = "user") User user){
        user.setUserName("Tom");
        return "success";
    }

    /*******************************************************使用Map以及Model*************************************************/

    /**使用Map以及Model，Spring MVC会将请求对应的隐含模型对象传递给ModelMap，因此在方法中可以通过它访问模型中的数据*/
    @RequestMapping(value = "/handle63")
    public String handle63(ModelMap modelMap){
        modelMap.addAttribute("testAttr","value1");
        User user = (User) modelMap.get("user");
        user.setUserName("Tom");
        return "success";
    }


    /*******************************************************使用@SessionAttribute*************************************************/
    @RequestMapping(value = "/handle71")
    public String handle71(@ModelAttribute("user") User user){
        user.setUserName("John");
        return "redirect:/success";
    }

    @RequestMapping(value = "/handle72")
    public String handle72(ModelMap modelMap, SessionStatus sessionStatus){
        //读取模型中的数据
        User user = (User) modelMap.get("user");
        if(user != null){
            user.setUserName("Jetty");
            //让Spring MVC清除本处理器对应的会话属性
            sessionStatus.setComplete();
        }
        return "success";
    }





}
