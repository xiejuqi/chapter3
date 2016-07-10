package com.baobaotao.executor;

import java.util.concurrent.Executor;

/**
 * 
 * @Filename SimpleExecutor.java
 * 
 * @Description	JDK 5.0的Executor
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年7月10日 下午1:01:28
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class SimpleExecutor implements Executor {

	@Override
	public void execute(Runnable command) {
		/**在提交任务时直接运行任务*/
		command.run();
	}
	
	class ThreadPerTaskExecutor implements Executor{

		@Override
		public void execute(Runnable command) {
			new Thread(command).start();
		}
	}
}

