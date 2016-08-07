package com.baobaotao.oxm.xmlbeans;


import com.baobaotao.domain.jaxb.LoginLog;
import com.baobaotao.domain.jaxb.UserDocument;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @FileName XMLbeansSample.java
 *
 * @Description     使用XMLBeans来转化XML与Java对象，user.jar包中的类是由scomp命令来生成的。
 * <p>
 *  使用objectToXML()方法将Java对象转化为XML时有可能会产生java.lang.IncompatibleClassChangeError: Implementing class这个错误，是由于Class文件冲突导致的，
 *   调试的时候发现是LoginLog这个类冲突的，把com/baobaotao/domain/jaxb/LoginLog.java删掉之后就好了。下次使用时需要注意这个问题。
 * <p/>
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/8/7 15:09
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class XMLbeansSample {

    //Java对象转化为XML
    public static void objectToXML() throws IOException {

        //1.通过UsersDocument工厂类创建实例
        UserDocument doc = UserDocument.Factory.newInstance();

        //2.创建一个新用户
        UserDocument.User user = doc.addNewUser();
        user.setUserName("XMLbeans1");
        UserDocument.User.Logs logs = user.addNewLogs();
        LoginLog log1 = logs.addNewLoginLog();
        log1.setIp("192.168.1.91");
        log1.setLoginDate(Calendar.getInstance());
        File file = new File("E:\\XmlbeansSample.xml");
        doc.save(file);
    }

    public static void main(String[] args) throws IOException {
        XMLbeansSample.objectToXML();
    }
}
