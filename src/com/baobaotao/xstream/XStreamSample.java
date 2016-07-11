package com.baobaotao.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by JuqiXie on 2016/7/16.
 */
public class XStreamSample {
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

        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);

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
        FileOutputStream outputStream = new FileOutputStream("E:\\Idea_workSpace\\chapter3\\WebRoot\\XStreamSample.xml");

        //2-3 将User对象转换为XML，并保存到指定文件
        xStream.toXML(user,outputStream);

    }

    /**
     * @throws Exception
     * 3.XML转化为Java对象
     *
     */
    public static void XMLToObject()throws Exception{
            //3-1 实例化一个文件输入流
        FileInputStream inputStream = new FileInputStream("E:\\Idea_workSpace\\chapter3\\WebRoot\\XStreamSample.xml");

        //3-2 将XML文件输入流转换为对象
        User user = (User) xStream.fromXML(inputStream);

        for(LoginLog log : user.getLogs())
            if (log != null) {
                System.out.println("访问IP" + log.getIp());
                System.out.println("访问时间:" + log.getLoginDate());
            }
    }

    public static void main(String[] args) throws Exception {
        XStreamSample.objectToXML();
        XStreamSample.XMLToObject();
    }

}
