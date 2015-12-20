package com.baobaotao.attr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
 * @Date: 2015年11月21日 下午2:52:38
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Boss extends BaseLoggerController {
	//在低版本的Spring中，内置属性对象需要这样显式实例化，而在Spring3.0中就不必了。
	private Car car = new Car();
	
	private List favorites = new ArrayList();
	
	private Set computers;
	
	private Map jobs;
	
	private Properties mails;
	
	private Map<String, Integer> jobTime;
	
	private String carId;
	
	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}
	
	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}
	
	/**
	 * @param favorites the favorites to set
	 */
	public void setFavorites(List favorites) {
		this.favorites = favorites;
	}
	
	/**
	 * @param computers the computers to set
	 */
	public void setComputers(Set computers) {
		this.computers = computers;
	}
	
	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(Map jobs) {
		this.jobs = jobs;
	}
	
	/**
	 * @param mails the mails to set
	 */
	public void setMails(Properties mails) {
		this.mails = mails;
	}
	
	/**
	 * @param jobTime the jobTime to set
	 */
	public void setJobTime(Map<String, Integer> jobTime) {
		this.jobTime = jobTime;
	}
	
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	
}
