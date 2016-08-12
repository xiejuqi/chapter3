package com.baobaotao.oxm.jibx;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName JiBXInterfaceFactory.java
 *
 * @Description     使用JiBX接口编程来转换Java对象，否则JiBX不清楚要创建接口的哪个实例
 *                              本例User中声明一个List类型的属性logs，想要它指向一个ArrayList的实例，我们需要写一个返回ArrayList实例的工厂类JiBXInterfaceFactory
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/8/12 8:25
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class JiBXInterfaceFactory {
    //获取List实现类实例
    public static List getArrayListInstance(){
        return new ArrayList();
    }
}
