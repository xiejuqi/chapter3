package com.baobaotao.oxm.xstream;

import com.baobaotao.xstream.annotations.User;
import com.baobaotao.xstream.annotations.XStreamAnnotationSample;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

import java.io.*;

/**
 * @FileName ObjectStreamSample.java
 *
 * @Description     使用XStream提供的API来流化对象
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/30  16:10
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class ObjectStreamSample {
    private static XStream xStream;

    static{
        xStream = new XStream();
    }

    //Java对象转化为XML
    public static void objectToXml() throws IOException {
        //1.实例化序列化对象
        User user = XStreamAnnotationSample.getUser();

        //2.创建一个PrintWriter对象，用于输出
        PrintWriter pw = new PrintWriter("E:\\XStreamSample.xml");

        //3.选用一个HierarchicalStreamWriter的实现类来创建输出
        PrettyPrintWriter ppw = new PrettyPrintWriter(pw);
        /*CompactWriter cw = new CompactWriter(pw);*/

        //4.创建对象输出流
        ObjectOutputStream out = xStream.createObjectOutputStream(ppw);

        out.writeObject(user);
        out.close();
    }

    //XML流化为Java对象
    public static User xmlToObject() throws IOException, ClassNotFoundException {

        //5.通过对象流进行输入操作
        FileReader reader = new FileReader("E:\\XStreamSample.xml");
        BufferedReader bufferedReader = new BufferedReader(reader);

        //6.创建对象输入流
        ObjectInputStream input = xStream.createObjectInputStream(bufferedReader);

        //7.从XML文件中读取对象
        User user = (User) input.readObject();

        return user;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectStreamSample.objectToXml();
        User user = ObjectStreamSample.xmlToObject();
        System.out.println("[user.credits="+user.getCredits()+"]");
    }
}
