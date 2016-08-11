package com.baobaotao.oxm.castor;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.UnmarshalHandler;
import org.exolab.castor.xml.Unmarshaller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @FileName CastorSample.java
 *
 * @Description Castor自省方式的编组与反编组
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/8/11 8:25
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class CastorSample {

    //Java对象转化为XML
    public static void objectToXML() throws Exception {
        User user = CastorGeneratorSample.getUser();
        FileWriter writer = new FileWriter("E:\\CastorSample.xml");
        Marshaller marshaller = new Marshaller(writer);
        marshaller.setEncoding("GBK");
        marshaller.marshal(user);
    }

    //XML转化为Java对象
    public static void XMLToObject() throws Exception {
        FileReader reader = new FileReader("E:\\CastorSample.xml");
        User user = (User) Unmarshaller.unmarshal(User.class, reader);
        System.out.println("user.name:" + user.getUserName() + System.getProperty("line.separator") + "user.ip:" + user.getLastIp());
    }

    public static void main(String[] args) throws Exception {
        CastorSample.objectToXML();
        CastorSample.XMLToObject();
    }
}
