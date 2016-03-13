package com.baobaotao.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @Filename Agent.java
 * 
 * @Description	代理类，可以在premain()方法中将字节码转换器注册到JVM中
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月12日 上午10:14:54
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Agent  {
	
	private static Logger logger = LoggerFactory.getLogger(Agent.class);
	
	/**
	 * @param agentArgs
	 * @param instrumentation
	 * 
	 * -javaagent:jarpath[=options]的options值会通过premain()方法的agentArgs入参传递进来，
	 * 它不像main()函数的args是一个String[]，agentArgs的类型为String，
	 * 由用户负责参数的具体解析工作。
	 */
	public static void premain(String agentArgs,Instrumentation instrumentation) {
		
		logger.info("[agentArgs={}]",agentArgs);
		
		logger.info("[instrumentation={}]",instrumentation);
		
		/**实例化转换器*/
		ClassFileTransformer classFileTransformer = new Transformer();
		
		/**将转换器注册到JVM的Instrumentation中*/
		instrumentation.addTransformer(classFileTransformer);
	}
}

