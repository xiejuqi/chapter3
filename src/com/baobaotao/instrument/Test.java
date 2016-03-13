package com.baobaotao.instrument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Filename Test.java
 * 
 * @Description	测试通过在类加载期织入切面的方式测试，在这里作为应用程序的入口,
 * 					测试命令：java -javaagent:test.jar com.baobaotao.instrument.Test
 * 					测试该包下的test.jar文件，可看到Test{@link #main(String[])})方法前确实织入了Transformer#transform的逻辑方法
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月12日 上午10:25:14
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Test {
	
	private static Logger logger = LoggerFactory.getLogger(Agent.class);
	
	public static void main(String[] args) {
		logger.info("[I'm main() of Test...]"); 
	}
}

