package com.baobaotao.oxm.jibx;

import com.baobaotao.oxm.castor.CastorGeneratorSample;
import com.baobaotao.xstream.User;
import com.baobaotao.xstream.XStreamSample;
import org.jibx.runtime.*;

import java.io.*;

/**
 * @FileName JibxSample.java
 *
 * @Description     使用JiBX进行编组和反编组操作
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/8/12 9:17
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class JibxSample {
    //Java对象转换为XML
    public static void objectToXML() throws JiBXException, FileNotFoundException {

        User user = XStreamSample.getUser();
        IBindingFactory bfact = BindingDirectory.getFactory(User.class);
        IMarshallingContext ctx = bfact.createMarshallingContext();
        FileOutputStream os = new FileOutputStream("E:\\JibxSample.xml");
        ctx.marshalDocument(user,"UTF-8",null,os);
    }

    //XML转化为Java对象
    public static void XMLToObject() throws JiBXException, FileNotFoundException {
        IBindingFactory bfact = BindingDirectory.getFactory(User.class);
        IUnmarshallingContext untx = bfact.createUnmarshallingContext();
        File dataFile = new File("E:\\JibxSample.xml");
        InputStream in = new FileInputStream(dataFile);
        User user = (User) untx.unmarshalDocument(in,null);
        System.out.println("user.Name"+user.getUserName()+"IP:"+user.getLastIp());
    }

    public static void main(String[] args) throws Exception{
        JibxSample.objectToXML();
        JibxSample.XMLToObject();
    }
}
