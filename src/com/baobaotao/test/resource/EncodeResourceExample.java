package com.baobaotao.test.resource;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 * 
 * @Filename EncodeResourceExample.java
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
 * @Date: 2015年8月29日 下午6:22:33
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class EncodeResourceExample {
	public static void main(String[] args) throws IOException {
		Resource res = new ClassPathResource("conf/file1.txt");
		EncodedResource encRes = new EncodedResource(res, "UTF-8");
		String content = FileCopyUtils.copyToString(encRes.getReader());
		System.out.println(content);
	}
}
