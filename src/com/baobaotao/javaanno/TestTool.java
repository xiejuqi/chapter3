package com.baobaotao.javaanno;

import java.lang.reflect.Method;

/**
 * 
 * @Filename TestTool.java
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
 * @Date: 2016年1月17日 上午8:40:37
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class TestTool {
	public static void main(String[] args) {
		/**得到ForumService对应的Class对象*/
		Class clazz = ForumService.class;
		
		Method[] methods = clazz.getDeclaredMethods();
		
		System.out.println("方法数组的长度为："+methods.length);
		
		for(Method m : methods){
			NeedTest nt = m.getAnnotation(NeedTest.class);
			if(nt != null){
				if(nt.value()){
					System.out.println(m.getName()+"()需要测试");
				}else{
					System.out.println(m.getName()+"()不需要测试");
				}
			}
		}
	}
}

