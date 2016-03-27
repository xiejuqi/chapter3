package com.baobaotao.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Filename SequenceNumber.java
 * 
 * @Description	ThreadLocal的具体使用方法
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月26日 下午4:53:35
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SequenceNumber {
	
	private static final Logger logger = LoggerFactory.getLogger(SequenceNumber.class);
	
	/**通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值*/
	private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};
	
	/**
	 * 获取下一个序列值
	 * @return
	 */
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		SequenceNumber sequenceNumber = new SequenceNumber();
		
		TestClient t1 = new TestClient(sequenceNumber);
		TestClient t2 = new TestClient(sequenceNumber);
		TestClient t3 = new TestClient(sequenceNumber);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static class TestClient extends Thread{
		private SequenceNumber sn;
		public TestClient(SequenceNumber sn){
			this.sn=sn;
		}
		
		public void run(){
			for(int i = 0 ; i < 3 ; i ++){
				logger.info("[thread={}]-[sn={}]",Thread.currentThread().getName(),sn.getNextNum());
			}
		}
	}
}

