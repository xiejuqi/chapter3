package com.baobaotao.quartz;
/**
 * 
 * @Filename MyService.java
 * 
 * @Description	使用MethodInvokingJobDetailFactory将某个Bean的某个方法封装成一个定时任务
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月18日 上午9:15:22
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MyService {
	public void doJob(){
		System.out.println("[in MyService.doJob()]");
	}
}

