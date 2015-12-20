package com.baobaotao.injectfun;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

import com.baobaotao.attr.Car;
import com.baobaotao.base.BaseLoggerController;

/**
 * 
 * @Filename Boss2.java
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
 * @Date: 2015年11月22日 下午2:53:30
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */

/**
 * 用于替换他人的Bean必须实现MethodReplacer接口，Spring利用该接口方法替换目标Bean的方法。
 * @author 解巨琦
 * 
 */
public class Boss2 extends BaseLoggerController implements MethodReplacer {
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.support.MethodReplacer#reimplement(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setBrand("美人豹");
		return car;
	}
}
