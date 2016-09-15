package com.baobaotao.springmvc;

import com.baobaotao.domain.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @FileName RelativePathUriTemplateController.java
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
 * @Date: 2016/9/15  9:09
 *
 * @Version: 1.0
 *
 * @Content: create
 */
@Controller
@RequestMapping("/owners/{ownerId}")
public class RelativePathUriTemplateController {

    @RequestMapping("pets/{petId}")
    public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model mo) {
        System.out.println("ownerId=" + ownerId);
        System.out.println("petId=" + petId);
    }


    /**************************************请求处理方法签名概述********************************************************/

    /**
     * 1.请求参数按照名称匹配的方式绑定到方法入参中，方法返回的字符串代表逻辑视图名
     */
    @RequestMapping("/handle1")
    public String handle1(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("realName") String realName) {
        return "success";
    }

    /**
     * 2.将Coolie值以及报文头属性绑定到入参中，方法返回ModelAndView
     */
    @RequestMapping("handle2")
    public ModelAndView handle2(@CookieValue("JSESSIONID") String sessionId, @RequestHeader("Accept-Language") String acceptLanguage) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("user", new User());
        return mav;
    }

    /**3.请求参数按照名称匹配的方式绑定到user的属性中，方法返回的字符串代表逻辑视图名*/
    @RequestMapping(value = "/handle3")
    public String handle3(User user){
        return "success";
    }

    /**4.直接将HTTP请求对象传递给处理方法，方法返回的字符串代表逻辑视图名*/
    @RequestMapping(value = "/handle4")
    public String handle4(HttpServletRequest httpservletRequest){
        return "success";
    }

    /**************************************处理方法签名详细说明********************************************************/

    @RequestMapping(value = "/handle11")
    public String handle11(@RequestParam(value = "userName" , required = false) String userName,@RequestParam("age") int age){
        return "success";
    }

    /**使用@CookieValue可以让处理方法入参绑定某个Cookie的值，它和@RequestParam拥有三个一样的参数*/
    @RequestMapping(value = "/handle12")
    public String handle12(@CookieValue(value = "sessionId" , required = false) String sessionId,@RequestParam(value = "age") int age){
        return "success";
    }

    /**请求报文包含了若干个报文头属性，服务器可据此获知客户端的信息，通过@RequestHeader即可将报文头属性值绑定到处理方法的入参中*/
    @RequestMapping(value = "/handle13")
    public String handle13(@RequestHeader("Accept-Encoding") String encoding,@RequestHeader("Keep-Alive") long keepAlive){
        return "success";
    }

    /**使用命令/表单对象绑定请求参数值*/
    @RequestMapping(value = "/handle14")
    public String handle14(User user){
        return "success";
    }


    /**************************************使用Servlet API对象作为入参********************************************************/

    /**同时使用HttpServletRequest和HttpServletResponse*/
    @RequestMapping(value = "/handle21")
    public void handle21(HttpServletRequest request, HttpServletResponse response){
        String userName = WebUtils.findParameterValue(request,"userName");
        response.addCookie(new Cookie("userName",userName));
    }

    /**仅使用HttpServletRequest作为入参*/
    @RequestMapping("/handle22")
    public ModelAndView handle22(HttpServletRequest request){
        String userName = WebUtils.findParameterValue(request,"userName");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("userName",userName);
        return mav;
    }

    /**使用HttpSession作为入参*/
    @RequestMapping(value = "/handle23")
    public String handle23(HttpSession httpSession){
        httpSession.setAttribute("sessionId",1234);
        return "success";
    }


    /**既使用HttpServletRequest同时使用基本类型的入参*/
    @RequestMapping(value = "/handle24")
    public String handle24(HttpServletRequest request,@RequestParam("userName") String userName){
        return "success";
    }

    /**可代理Servlet原生API类的接口*/
    @RequestMapping(value = "/handle25")
    public String handle25(WebRequest webRequest){
        String userName = webRequest.getParameter("userName");
        return "success";
    }

    /**************************************使用IO对象作为入参********************************************************/
    @RequestMapping("/handle31")
    public void handle31(OutputStream outputStream) throws IOException {
        Resource res = new ClassPathResource("/image.jpg");//读取类路径下的图片文件
        FileCopyUtils.copy(res.getInputStream(),outputStream);//将图片写入到输出流中
    }











}

