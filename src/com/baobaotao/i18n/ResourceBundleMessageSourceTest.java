package com.baobaotao.i18n;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.base.BaseLoggerController;

import net.sf.cglib.core.Local;

/**
 * 
 * @Filename ResourceBundleMessageSourceTest.java
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
 * @Date: 2015年12月22日 上午8:30:28
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ResourceBundleMessageSourceTest extends BaseLoggerController{
	public void test() throws InterruptedException{
		String[] config ={"com/baobaotao/i18n/bean1.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		
		/**1.获取MessageSource的Bean  ResourceBundleMessageSource*/
		MessageSource ms = (MessageSource) ac.getBean("myResource");
		Object[] params = {"John",new GregorianCalendar().getTime()};
		
		/**2.获取格式化的国际化信息*/
		String str1 = ms.getMessage("greeting.common",params,Locale.US);
		String str2 = ms.getMessage("greeting.morning", params,Locale.CHINA);
		String str3 = ms.getMessage("greeting.afternoon", params,Locale.CHINA);
		
		logger.info("[使用不自动刷新的动态的国际化资源文件-美式打招呼:{}]",str1);
		logger.info("[使用不自动刷新的动态的国际化资源文件-中式早上好:{}]",str2);
		logger.info("[使用不自动刷新的动态的国际化资源文件-中式下午好:{}]",str3);
		
		
		/**使用ReloadableResourceBundleMessageSource定时刷新资源文件*/
		MessageSource reloadMessageSource = (MessageSource) ac.getBean("reloadSource");
		for(int i = 0 ; i < 2 ; i ++){
			String str4 = reloadMessageSource.getMessage("greeting.common",params,Locale.US);
			logger.info("[使用ReloadableResourceBundleMessageSource访问国际化资源文件-美式打招呼：{}]",str4);
			Thread.sleep(20000);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ResourceBundleMessageSourceTest().test();
	}
}
