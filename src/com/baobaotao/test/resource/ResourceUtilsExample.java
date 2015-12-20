package com.baobaotao.test.resource;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 * @Filename ResourceUtilsExample.java
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
 * @Date: 2015年9月3日 下午4:15:37
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ResourceUtilsExample {
	public static void main(String[] args) throws IOException {
		//1.加载所有类包com.baobaotao(及子孙包)下的以XML为后缀的资源
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resources[] = resolver.getResources("classpath*:com/baobaotao/**/*.xml");
		for (Resource resouce : resources) {
			System.out.println(resouce.getDescription());
		}
	}
}
