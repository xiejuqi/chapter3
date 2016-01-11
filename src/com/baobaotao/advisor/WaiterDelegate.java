package com.baobaotao.advisor;
/**
 * 
 * @Filename WaiterDelegate.java
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
 * @Date: 2016年1月11日 上午8:26:48
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class WaiterDelegate {
	
	private Waiter waiter ;
	
	/**
	 * waiter的方法通过该方法发起调用
	 * @param clientName
	 */
	public void service(String clientName){
		waiter.greetTo(clientName);
		waiter.serveTo(clientName);
	}
	
	public void setWaiter(Waiter waiter){
		this.waiter = waiter;
	}
}
