package com.baobaotao.xstream.alias;

import com.baobaotao.xstream.LoginLog;
import com.baobaotao.xstream.User;
import com.baobaotao.xstream.XStreamSample;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileOutputStream;
import java.util.Date;

/**
 * @FileName XStreamAliasSample.java
 *
 * @Description  使用XStream别名来生成XML
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/27 8:52
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class XStreamAliasSample {
    private static XStream xStream;

    static{
        //1.创建XStream实例并指定一个XML解析器
        xStream = new XStream(new DomDriver());
    }

    /**
     * @return
     * 1.初始化转换对象
     */
    public static User getUser(){
        LoginLog log1 = new LoginLog();
        log1.setIp("192.168.1.91");
        log1.setLoginDate(new Date());

        LoginLog log2 = new LoginLog();
        log2.setIp("192.168.1.92");
        log2.setLoginDate(new Date());

        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);
        user.addLoginLog(log2);

        return user;
    }

    /**
     * @throws Exception
     * 2.Java对象转化为XML
     */
    public static void objectToXML() throws Exception{
        //2-1 获取转换的User对象实例
        User user = getUser();

        //2-2 实例化一个文件输出流
        FileOutputStream outputStream = new FileOutputStream("E:\\XStreamSample.xml");

        //3设置类别名，默认为当前类名称加上包名
        xStream.alias("loginLog",LoginLog.class);
        xStream.alias("user",User.class);

        //4.设置类成员别名
        xStream.aliasField("id",User.class,"userId");

        //5.把LoginLog的UserId属性视为XML属性，默认为XML的元素
        xStream.aliasAttribute(LoginLog.class,"userId","id");
        xStream.useAttributeFor(LoginLog.class,"userId");

        //6.去掉集合类型生成XML的父节点，即忽略XML中的<logs></logs>标记
        xStream.addImplicitCollection(User.class,"logs");

        //2-3 将User对象转换为XML，并保存到指定文件
        xStream.toXML(user,outputStream);
    }

    public static void main(String[] args) throws Exception {
        XStreamAliasSample.objectToXML();
    }
}
