package com.baobaotao.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * 
 * @Filename ExecutorExample.java
 * 
 * @Description	使用线程池
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年7月10日 下午1:23:53
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ExecutorExample {
	
	private Executor executor;
	
	/**1.声明一个执行器*/
	public void setExecutor(Executor executor){
		this.executor = executor;
	}
	
	/**用执行器执行多个任务*/
	public void executeTasks(){
		for(int i = 0 ; i < 6 ; i ++){
			executor.execute(new SimpleTimerTask("task"+i));
		}
	}
	
	class SimpleTimerTask implements Runnable{
		
		private String taskName;
		
		public SimpleTimerTask(String taskName){
			this.taskName = taskName;
		}

		@Override
		public void run() {
			System.out.println("[do "+taskName+"... in Thread:"+Thread.currentThread().getId()+"]");
		}
	}
	
	public static void main(String[] args) {
		ExecutorExample ee = new ExecutorExample();
		/**3.通过工厂类创建一个带3个线程固定线程值的执行器*/
		ee.setExecutor(Executors.newFixedThreadPool(3));
		ee.executeTasks();
	}
}

