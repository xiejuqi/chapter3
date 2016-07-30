package com.baobaotao.xstream.annotations;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @FileName XStreamAnnotationSample.java
 *
 * @Description 使用XStream自定义别名输出XML
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/30  15:50
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class XStreamAnnotationSample {
    private static XStream xStream;

    static{
        xStream = new XStream(new DomDriver());

        //1.实现该方法，判断要转换的类型
        xStream.processAnnotations(User.class);
        xStream.processAnnotations(LoginLog.class);

        //2.自动加载注解Bean
        /*xStream.autodetectAnnotations(true);*/
    }


    //Java对象转换为XML
    public static void objectToXml() throws FileNotFoundException {
        User user = getUser();
        FileOutputStream fs = new FileOutputStream("E:\\XStreamSample.xml");
        OutputStreamWriter writer = new OutputStreamWriter(fs, Charset.forName("UTF-8"));
        xStream.toXML(user,writer);
    }

    /**
     * @return
     * 1.初始化转换对象
     */
    public static User getUser(){
        LoginLog log1 = new LoginLog();
        log1.setIp("192.168.1.91");
        log1.setLoginDate(new Date());

        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);

        return user;
    }

    public static void main(String[] args) throws FileNotFoundException {
        XStreamAnnotationSample.objectToXml();
    }
}
