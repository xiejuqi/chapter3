package com.baobaotao.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Transformer.java
 * 
 * @Description	转换器类，可以对Class文件的字节码进行转换
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月12日 上午10:12:56
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Transformer extends BaseLoggerController implements ClassFileTransformer {

	
	/**
	 * @classfileBuffer：类文件对应的字节码数组，返回的byte[]为转换后的字节码。
	 * 该方法返回null，则表示不进行字节码处理
	 */
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		logger.info("[loader={}]",loader);
		logger.info("[Hello={} !]",className);
		logger.info("[classBeingRedefined={}]"+classBeingRedefined);
		logger.info("[protectionDomain={}]"+protectionDomain);
		logger.info("[classfileBuffer={}]"+classfileBuffer);
		
		return null;
	}

}

