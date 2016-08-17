package com.baobaotao.oxm.spring.castor;

import com.baobaotao.oxm.castor.CastorGeneratorSample;
import com.baobaotao.oxm.castor.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @FileName SpringOxmSample.java
 *
 * @Description Spring结合Castor进行编组和反编组
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/8/17 8:56
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class SpringOxmSample {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    //Java转换为XML对象
    public  void objectToXML(){
        User user = CastorGeneratorSample.getUser();
        FileOutputStream os = null;
        try {
            os = new FileOutputStream("E:\\SpringOxmSample.xml");
            this.marshaller.marshal(user,new StreamResult(os));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("Finally...");
        }
    }

    //XML转化为Java对象
    public void XMLToObject(){

    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/baobaotao/oxm/spring/castor/spring-castor.xml");
        SpringOxmSample springOxmSample = (SpringOxmSample) applicationContext.getBean("springOxm");
        springOxmSample.objectToXML();
    }
}
