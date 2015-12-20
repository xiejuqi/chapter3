package com.baobaotao.editor;

import java.beans.PropertyEditorSupport;

/**
 * 
 * @Filename CustomCarEditor.java
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
 * @Date: 2015年12月19日 下午3:38:51
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class CustomCarEditor extends PropertyEditorSupport {
	//1.将字面值转换为属性类型对象
	public void setAsText(String text){
		if(text == null || text.indexOf(",") == -1){
			throw new IllegalArgumentException("设置的字符串格式不正确！");
		}
		
		String[] infos = text.split(",");
		Car car = new Car();
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		
		//调用父类的setValue()方法设置转换后的属性对象
		setValue(car);
	}
}

