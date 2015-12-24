package com.baobaotao.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @Filename MailSendEvent.java
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
 * @Date: 2015年12月24日 上午8:14:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MailSendEvent extends ApplicationContextEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3420762450433040362L;
	
	private String to ;
	
	public MailSendEvent(ApplicationContext source,String to){
		super(source);
		this.to = to;
	}
	
	public String getTo() {
		return to;
	}
	
}
