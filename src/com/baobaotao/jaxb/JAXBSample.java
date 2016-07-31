package com.baobaotao.jaxb;

import com.baobaotao.xstream.User;
import com.baobaotao.xstream.alias.XStreamAliasSample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @FileName JAXBSample.java
 *
 * @Description     使用JAXB编组与反编组Java对象，需要注意的是必须在User对象上标注@XmlRootElement注解，否则会报错
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/31 11:11
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class JAXBSample {

    //Java转化为XML对象
    public static void ObjectToXML() throws JAXBException, IOException {

        User user = XStreamAliasSample.getUser();

        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        FileWriter writer = new FileWriter("E:\\JaxbSample.xml");
        m.marshal(user,writer);
    }

    //XML转化为Java对象
    public static void XMLToObject() throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(User.class);
        FileReader reader = new FileReader("E:\\JaxbSample.xml");
        Unmarshaller um = context.createUnmarshaller();

        User user = (User) um.unmarshal(reader);
        System.out.println(user.getUserName());
    }

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBSample.ObjectToXML();
        JAXBSample.XMLToObject();
    }

}
