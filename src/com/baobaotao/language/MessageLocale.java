package com.baobaotao.language;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 
 * @Filename Locale.java
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
 * @Date: 2015年12月20日 下午1:26:33
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MessageLocale {
	public static void main(String[] args) {
		//1.带有语言和国家地区信息的本地化对象
		Locale locale1 = new Locale("zh","CN");
		
		//2.只有语言信息的本地化对象
		Locale locale2 = new Locale("zh");
		
		//3.等同于Locale("zh","CN")
		Locale locale3 = Locale.CHINA;
		
		//4.等同于Locale("zh")
		Locale locale4 = Locale.CHINESE;
		
		//5.获取本地系统默认的本地化对象
		Locale locale5 = Locale.getDefault();
		
		Locale locale6 = new Locale("zh", "CN");
		NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale6);
		double amt = 123456.78;
		System.out.println(currFmt.format(amt));
		
		Locale locale7 = new Locale("en", "US");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale7);
		System.out.println(dateFormat.format(date));
		
		//信息格式化串
		String pattern1 = "{0},你好！你于{1}在工商银行存入{2}元";
		String pattern2 = "At{1,time,short} On {1,date,long} ,{0} paid {2,number,currency}.";
		
		//用于动态替换占位符的参数
		Object[] params = {"John",new GregorianCalendar().getTime(),1.0E3};
		
		//使用默认本地化对象格式化信息
		String msg1 = MessageFormat.format(pattern1, params);
		
		//使用指定的本地化对象格式化字符串
		MessageFormat mf = new MessageFormat(pattern2, Locale.US);
		String msg2 = mf.format(params);
		
		System.out.println("msg1:"+msg1);
		System.out.println("msg2:"+msg2);
		
	}
}

