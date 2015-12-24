package com.baobaotao.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @Filename MailSendListener.java
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
 * @Date: 2015年12月24日 上午8:16:58
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component
public class MailSendListener implements ApplicationListener<MailSendEvent> {

	//1.对MailSendEvent事件进行处理
		@Override
		public void onApplicationEvent(MailSendEvent event) {
			MailSendEvent mse = event;
			System.out.println("MailSendListener：向"+mse.getTo()+"发送完一封邮件！");
		}
}

