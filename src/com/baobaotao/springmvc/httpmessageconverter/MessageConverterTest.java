package com.baobaotao.springmvc.httpmessageconverter;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.baobaotao.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * @FileName MessageConverterTest.java
 * 
 * @Description 使用RestTemplate模板类测试@RequestBody和@ResponseBody注解
 * 
 * @Version 1.0
 * 
 * @Author xiejuqi
 * 
 * @Email xiejuqi@yolo24.com
 * 
 * @History Author: xiejuqi
 * 
 * @Date: 2016/9/16 10:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 */
public class MessageConverterTest {
	
	@Test
	public void testhandle41() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("userName", "tom");
		form.add("password", "112222");
		form.add("age", "45");
		/** 1.第一个参数为URL，第二个通过MultiValueMap准备报文体的参数数据 */
		URI uri = restTemplate.postForLocation(
			"http://localhost:8080/chapter3/messageConverter/handle43.html", form);
	}
	
	@Test
	public void testhandle42() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		/** 第二个参数为报文体参数数据，第三个参数指定方法的返回值类型，第四个参数为URL占位符参数的值 */
		byte[] response = restTemplate.postForObject(
			"http://localhost:8080/chapter3/messageConverter/handle44/{itemId}.html", null,
			byte[].class, "0000");
		Resource resource = new ClassPathResource("e:/image_copy.jpg");
		Resource fileSystemResource = new FileSystemResource("e:/image_copy.jpg");
		FileCopyUtils.copy(response, fileSystemResource.getFile());
	}
	
	@Test
	public void testhandle51() {
		RestTemplate restTemplate = buildRestTemplate();
		
		/** 创建User对象，它将通过RestTemplate流化为XML请求报文 */
		User user = new User();
		user.setUserName("Tom");
		user.setPassword("1234");
		user.setCredits(1111);
		
		HttpHeaders entityHeaders = new HttpHeaders();
		/** 指定请求的报文头头信息 */
		entityHeaders.setContentType(MediaType.valueOf("application/xml;UTF-8"));
		entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		
		/** 将User流化为XML，放到报文体中，同时指定请求方法以及报文头 */
		HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);
		ResponseEntity<User> responseEntity = restTemplate.exchange(
			"http://localhost:8080/chapter3/messageConverter/handle51.html", HttpMethod.POST,
			requestEntity, User.class);
		
		/** 将请求响应消息转换为User对象，并对响应值进行判断 */
		User responseUser = responseEntity.getBody();
		Assert.assertNotNull(responseUser);
		Assert.assertEquals(11111, responseUser.getUserId());
		Assert.assertEquals("Tom", responseUser.getUserName());
		Assert.assertEquals(1111, responseUser.getCredits());
	}
	
	/** 创建RestTemplate实例 */
	private RestTemplate buildRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		
		/** 使用XStream流化器，使用STAX技术处理XML，同时加载使用了XStream注解的User类 */
		XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
		xStreamMarshaller.setStreamDriver(new StaxDriver());
		xStreamMarshaller.setAnnotatedClasses(new Class[] { User.class });
		
		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
		xmlConverter.setMarshaller(xStreamMarshaller);
		xmlConverter.setUnmarshaller(xStreamMarshaller);
		restTemplate.getMessageConverters().add(xmlConverter);
		
		MappingJacksonHttpMessageConverter jsonConverter = new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(jsonConverter);
		
		return restTemplate;
	}
}
