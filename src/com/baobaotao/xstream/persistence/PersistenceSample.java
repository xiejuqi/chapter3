package com.baobaotao.xstream.persistence;

import com.baobaotao.xstream.annotations.User;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @FileName PersistenceSample.java
 *
 * @Description     使用XStream来持久化对象到文件系統中
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/30  16:57
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class PersistenceSample {
    public static void persist(){

        //1.实例化需要持久化对象
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.setLastIp("192.168.1.1");

        users.add(user);

        //2.创建持久化策略
        File file = new File("E:\\out\\");
        PersistenceStrategy strategy = new FilePersistenceStrategy(file);

        //3.持久化集合对象
        List list = new XmlArrayList(strategy);
        list.addAll(users);
    }

    public static void main(String[] args) {
        PersistenceSample.persist();
    }
}
