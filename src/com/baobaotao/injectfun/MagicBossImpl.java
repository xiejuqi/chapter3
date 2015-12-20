package com.baobaotao.injectfun;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.baobaotao.attr.Car;

/**
 * 
 * @Filename MagicBossImpl.java
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
 * @Date: 2015年11月22日 下午12:30:27
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MagicBossImpl implements MagicBoss, ApplicationContextAware {
	
	private ApplicationContext ctx;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx = applicationContext;
	}
	
	/* (non-Javadoc)
	 * @see com.baobaotao.injectfun.MagicBoss#getCar()
	 */
	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return (Car) this.ctx.getBean("car");
	}
	
}
