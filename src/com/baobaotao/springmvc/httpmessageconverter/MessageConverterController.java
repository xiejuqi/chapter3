package com.baobaotao.springmvc.httpmessageconverter;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baobaotao.domain.User;

/**
 * @FileName MessageConverterController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xiejuqi
 * 
 * @Email xiejuqi@yolo24.com
 * 
 * @History Author: xiejuqi
 * 
 * @Date: 2016/9/15 17:18
 * 
 * @Version: 1.0
 * 
 * @Content: create
 */
@Controller
@RequestMapping("/messageConverter")
public class MessageConverterController {
	
	/****************************** 使用@RequestBody和@ResponseBody *******************************************/
	
	/** 将请求报文体转换为字符串绑定到requestBody入参中 */
	@RequestMapping(value = "/handle41")
	public String handle41(@RequestBody String requestBody) {
		System.out.println("requestBody=" + requestBody);
		return "register";
	}
	
	/** 读取一张图片，并将图片数据输出到响应流中，客户端将显示这张图片 */
	@ResponseBody
	@RequestMapping(value = "/handle42/{imageId}")
	public byte[] handle42(@PathVariable(value = "imageId") String imageId) throws IOException {
		System.out.println("imageId=" + imageId);
		Resource res = new ClassPathResource("temp.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
		return fileData;
	}
	
	/****************************** 使用HttpEntity<>和ResponseEntity<> *******************************************/
	
	/** 使用StringHttpMessageConverter将请求报文体以及报文头的信息绑定到httpEntity中，在方法中可以对相应信息进行访问 */
	@RequestMapping(value = "/handle43")
	public String handle43(HttpEntity<String> httpEntity) {
		long contentLen = httpEntity.getHeaders().getContentLength();
		System.out.println(httpEntity.getBody());
		return "success";
	}
	
	/** 在方法中创建HttpEntity<byte[]>对象并返回，ByteArrayHttpMessageConverter负责将其写出到响应流中 */
	@RequestMapping(value = "/handle44/{imageId}")
	public ResponseEntity<byte[]> handle44(@PathVariable(value = "imageId") String imageId)
																							throws IOException {
		Resource resource = new ClassPathResource("temp.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(fileData, HttpStatus.OK);
		return responseEntity;
	}
	
	/** 支持XML和JSON消息的处理方法 */
	@RequestMapping(value = "/handle51")
	public ResponseEntity<User> handle51(HttpEntity<User> requestEntity) {
		User user = requestEntity.getBody();
		user.setUserId(11111);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
