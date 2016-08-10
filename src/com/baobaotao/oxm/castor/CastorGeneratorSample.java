package com.baobaotao.oxm.castor;

import com.baobaotao.xstream.annotations.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @FileName CastorGeneratorSample.java
 *
 * @Description 使用Castor编组和反编组Java对象
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/8/10 8:24
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class CastorGeneratorSample {

    //Java对象转化为XML
    public static void objectToXML() throws Exception {
        User user = getUser();
        FileWriter writer = new FileWriter("E:\\CastorSample.xml");
        user.marshal(writer);
    }

    //XML对象转换为Java对象
    public static void XMLToObject() throws Exception {
        FileReader reader = new FileReader("E:\\CastorSample.xml");
        User user = User.unmarshal(reader);
        System.out.println("user.name" + user.getUserName());
    }

    public static User getUser() {
        LoginLog log1 = new LoginLog();

        Logs logs = new Logs();
        logs.addLoginLog(log1);

        User user = new User();
        user.setUserId(1);
        user.setUserName("castorSample");

        /**
         * 这里有一个问题，假如User中有一个对象不赋值的话反编组的时候会报错，应该通过一个Mapping文件去映射关系，设置可选字段，默认是通过自省的方式去映射的。
         * <!DOCTYPE databases PUBLIC
         *     "-//EXOLAB/Castor Mapping DTD Version 1.0//EN"
         *    "http://castor.exolab.org/mapping.dtd">
         *
         * <mapping>
         *       <description>Basic mapping example</description>
         *       <class name="FlightBean" auto-complete="true">
         *           <map-to xml="flight"/>
         *           <field name="carrier">
         *               <bind-xml name="carrier" node="attribute"/>
         *           </field>
         *           <field name="departureTime">
         *               <bind-xml name="depart" node="attribute"/>
         *           </field>
         *           <field name="arrivalTime">
         *           </field>
         *       </class>
         *   </mapping>
         * */
        user.setPassword("111");
        user.setCredits(11);
        user.setLastIp("10.55.66.33");
        user.setLogs(logs);

        return user;
    }

    public static void main(String[] args) throws Exception {
        CastorGeneratorSample.objectToXML();
        CastorGeneratorSample.XMLToObject();
    }

}
