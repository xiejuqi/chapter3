package com.baobaotao.test.reflect;

/**
 * 
 * @Filename ClassLoaderTest.java
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
 * @Date: 2015年8月29日 下午3:31:22
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String s = new String("333");
		System.out.println("current loader:" + loader);
		System.out.println("parent loader:" + loader.getParent());
		//祖父ClassLoader是根类装载器，因为在Java中无法获得它的句柄，所以直接返回NULL
		System.out.println("grandparent loader:" + loader.getParent().getParent());
	}
}
