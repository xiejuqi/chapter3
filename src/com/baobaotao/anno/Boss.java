package com.baobaotao.anno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baobaotao.attr.Car;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Boss.java
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
 * @Date: 2015年11月29日 下午3:58:43
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
@Component
public class Boss extends BaseLoggerController {
	private Car car;
	
	public Boss() {
		logger.info("[construct...]");
	}
	
	/**
	 * @param car the car to set
	 */
	@Autowired
	public void setCar(Car car) {
		logger.info("[execute in setCar]");
		this.car = car;
	}
	
	@PostConstruct
	private void init1() {
		logger.info("[execute in init1]");
	}
	
	@PostConstruct
	private void init2() {
		logger.info("[execute in init2]");
	}
	
	@PreDestroy
	private void destory1() {
		logger.info("[execute in destory1]");
	}
	
	@PreDestroy
	private void destory2() {
		logger.info("[execute in destory2]");
	}
}
