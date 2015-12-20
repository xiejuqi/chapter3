package com.baobaotao.test.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * 
 * @Filename FileSourceExample.java
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
 * @Date: 2015年8月29日 下午5:47:42
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class FileSourceExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			String filePath = "E:/MyEclipse for Spring 2014/chapter3/WebRoot/WEB-INF/classes/conf/file1.txt";
			
			//1.使用系统文件路径方式加载文件
			Resource res1 = new FileSystemResource(filePath);
			
			//2.使用类路径方式加载文件
			Resource res2 = new ClassPathResource("conf/file1.txt");
			
			InputStream ins1 = res1.getInputStream();
			InputStream ins2 = res2.getInputStream();
			
			System.out.println("res1 :" + res1.getFilename());
			System.out.println("res2 :" + res2.getFilename());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
