package com.baobaotao.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Filename SimpleThreadLocal.java
 * 
 * @Description	ThreadLocal简单实现版本
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月26日 下午4:43:48
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SimpleThreadLocal {
	private Map valueMap = Collections.synchronizedMap(new HashMap());
	
	/**
	 * 键为线程对象，值为本线程的变量副本
	 * @param newValue
	 */
	public void set(Object newValue){
		valueMap.put(Thread.currentThread(), newValue);
	}
	
	public Object get(){
		Thread currentThread = Thread.currentThread();
		/**返回本线程对应的变量*/
		Object o = valueMap.get(currentThread);
		
		/**如果在Map中不存在，就放到Map中保存起来*/
		if(o == null && !valueMap.containsKey(currentThread)){
			o = initialValue();
			valueMap.put(currentThread, o);
		}
		
		return o;
	}
	
	public void remove(){
		valueMap.remove(Thread.currentThread());
	}
	
	public Object initialValue(){
		return null;
	}
}

