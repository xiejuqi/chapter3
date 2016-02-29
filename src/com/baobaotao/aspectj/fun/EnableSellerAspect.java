package com.baobaotao.aspectj.fun;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 
 * @Filename EnableSellerAspect.java
 * 
 * @Description	用于演示引介增强，基于AspectJ注解的引介增强切面
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年1月26日 上午8:36:49
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Aspect
public class EnableSellerAspect {
	
	/**
	 * @value为NaiveWaiter添加接口实现-
	 * @defaultImpl为默认的接口实现类-
	 * */
	@DeclareParents(value="com.baobaotao.aspectj.fun.NaiveWaiter",defaultImpl=SmartSeller.class)
	/**要实现的目标接口*/
	public static Seller seller;
}
