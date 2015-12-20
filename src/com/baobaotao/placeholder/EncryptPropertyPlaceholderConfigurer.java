package com.baobaotao.placeholder;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * @Filename EncryptPropertyPlaceholderConfigurer.java
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
 * @Date: 2015年12月20日 上午9:56:24
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

/** 1.继承PropertyPlaceholderConfigurer定义支持密文版属性的属性编辑器 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private String[] encrytpPropNames = { "userName", "password" };
	private String key = "myKey";

	/** 2.对特定属性的属性值进行转换 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		DESUtils des = new DESUtils();
		if(isEncryptProp(propertyName)){
			String decryptValue = des.decrypt(propertyValue);
			return decryptValue;
		}else{
			return propertyValue;
		}
	}

	/** 3.判断是否是需要进行解密的属性 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encrytpPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
