package com.baobaotao.xstream.json;

import com.baobaotao.xstream.User;
import com.baobaotao.xstream.alias.XStreamAliasSample;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Calendar;

/**
 * @FileName XStreamJSONSample.java
 *
 * @Description     使用XStream来转换JSON
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/30  17:16
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class XStreamJSONSample {

        private static XStream xStream;

        //1.连续的没有分隔JSON串
        public static void toJsonByJettisonMappedXmlDriver() throws FileNotFoundException {

                User user = XStreamAliasSample.getUser();
                FileOutputStream outputStream = new FileOutputStream("E:\\JettisonMappedSample.json");

                OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));

                xStream = new XStream(new JettisonMappedXmlDriver());
                xStream.setMode(XStream.NO_REFERENCES);
                xStream.alias("user",User.class);
                xStream.toXML(user,writer);
        }

        //2.格式化良好的JSON串
        public static void toJsonByJsonHierarchicalStreamDriver() throws FileNotFoundException {

                User user = XStreamAliasSample.getUser();

                FileOutputStream outputStream = new FileOutputStream("E:\\JettisonMappedSample.json");
                OutputStreamWriter writer = new OutputStreamWriter(outputStream,Charset.forName("UTF-8"));

                xStream = new XStream(new JsonHierarchicalStreamDriver());
                xStream.alias("user",User.class);
                xStream.toXML(user,writer);
        }

        public static void main(String[] args) throws FileNotFoundException {
                XStreamJSONSample.toJsonByJsonHierarchicalStreamDriver();
        }

}
