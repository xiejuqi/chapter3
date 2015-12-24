package com.baobaotao.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @Filename MailSender.java
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
 * @Date: 2015年12月24日 上午8:19:02
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component
public class MailSender implements ApplicationContextAware {
	
	private ApplicationContext ctx;
	
	//1.ApplicationContextAware的接口方法，以便容器启动时注入容器实例
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}
	
	public void sendMail(String to){
		System.out.println("MailSender：模拟发送邮件...");
		MailSendEvent mse = new MailSendEvent(this.ctx, to);
		//2.向容器中的所有事件监听器发送事件
		ctx.publishEvent(mse);
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/baobaotao/event/bean1.xml");
		MailSender ms = (MailSender) ac.getBean("mailSender");
		ms.sendMail("WindowsGa@163.com");
	}
	
}
