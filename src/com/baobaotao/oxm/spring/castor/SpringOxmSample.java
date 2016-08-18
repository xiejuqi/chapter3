package com.baobaotao.oxm.spring.castor;

import com.baobaotao.oxm.castor.CastorGeneratorSample;
import com.baobaotao.oxm.castor.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @FileName SpringOxmSample.java
 *
 * @Description Spring结合Castor进行编组和反编组，这里使用的Mapping有些问题，类型错误：
 *                          <p>
 *                              <field name="logs" type="com.baobaotao.oxm.castor.Logs" >
 *                                   <bind-xml name="log"/>
 *                               </field>
 *                          <p/>
 *                          运行时需要注意或者重新使用脚本来生成User类
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
            System.out.println("[objectToXML#Finally...]");
        }
    }

    //XML转化为Java对象
    public void XMLToObject()  {
        FileInputStream is = null;
        User user = null;
        try {
            is = new FileInputStream("E:\\SpringOxmSample.xml");
            user = (User) unmarshaller.unmarshal(new StreamSource(is));
            System.out.println("user.name"+user.getUserName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("[XMLToObject#Finally...]");
        }
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
        springOxmSample.XMLToObject();
    }
}
