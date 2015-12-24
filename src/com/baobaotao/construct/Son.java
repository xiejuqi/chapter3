package com.baobaotao.construct;
/**
 * 
 * @Filename Son.java
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
 * @Date: 2015年12月24日 上午8:53:16
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Son extends Father{
	public Son(){
		super("ff");
		String a = "";
		System.out.println("Son默认无参构造器...");
	}
	
	public Son(String age){
		super("ff");
		System.out.println("Son有参构造器...");
	}

	public static void main(String[] args) {
		Son son = new Son("fff");
	}
}
