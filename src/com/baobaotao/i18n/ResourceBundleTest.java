package com.baobaotao.i18n;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename ResourceBundleTest.java
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
 * @Date: 2015年12月21日 上午8:37:29
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ResourceBundleTest extends BaseLoggerController{
	public void test(){
		
		/**使用静态的国际化资源文件*/
		ResourceBundle usResourceBundle = ResourceBundle.getBundle("com/baobaotao/i18n/resource",Locale.US);
		ResourceBundle chResourceBundle = ResourceBundle.getBundle("com/baobaotao/i18n/resource",Locale.CHINA);
		
		logger.info("[us={}]",usResourceBundle.getString("greeting.common"));
		logger.info("[zh={}]",chResourceBundle.getString("greeting.common"));
		
		/**使用动态的国际化资源文件和MessageFormat结合使用*/
		ResourceBundle fUsResourceBundle = ResourceBundle.getBundle("com/baobaotao/i18n/fmt_resource",Locale.US);
		ResourceBundle fChResourceBundle = ResourceBundle.getBundle("com/baobaotao/i18n/fmt_resource",Locale.CHINA);
		
		Object[] params = {"John",new GregorianCalendar().getTime()};
		
		String str1 = new MessageFormat(fUsResourceBundle.getString("greeting.common"),Locale.US).format(params);
		String str2 = new MessageFormat(fChResourceBundle.getString("greeting.morning"),Locale.CHINA).format(params);
		String str3 = new MessageFormat(fChResourceBundle.getString("greeting.afternoon"),Locale.CHINA).format(params);
		
		logger.info("[使用动态的国际化资源文件-美式打招呼:{}]",str1);
		logger.info("[使用动态的国际化资源文件-中式早上好:{}]",str2);
		logger.info("[使用动态的国际化资源文件-中式下午好:{}]",str3);
	}
	
	public static void main(String[] args) {
		new ResourceBundleTest().test();
	}
}
