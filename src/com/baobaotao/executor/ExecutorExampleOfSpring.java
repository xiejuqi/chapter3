package com.baobaotao.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;


/**
 * 
 * @Filename ExecutorExampleOfSpring.java
 * 
 * @Description 使用Spirng中的TaskExecutor
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年7月10日 下午1:57:32
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ExecutorExampleOfSpring {
	
	private TaskExecutor executor;

	/** 1.声明一个执行器 */
	public void setExecutor(TaskExecutor executor) {
		this.executor = executor;
	}

	/** 用执行器执行多个任务 */
	public void executeTasks() {
		for (int i = 0; i < 6; i++) {
			executor.execute(new SimpleTimerTask("task" + i));
		}
	}

	class SimpleTimerTask implements Runnable {

		private String taskName;

		public SimpleTimerTask(String taskName) {
			this.taskName = taskName;
		}

		@Override
		public void run() {
			System.out.println("[do " + taskName + "... in Thread:" + Thread.currentThread().getId() + "]");
		}
	}

	public static void main(String[] args) {
		ExecutorExample ee = new ExecutorExample();
		/** 3.使用Spring的TaskExecutor实现类 */
		ee.setExecutor(new SimpleAsyncTaskExecutor());
		ee.executeTasks();
	}
}
