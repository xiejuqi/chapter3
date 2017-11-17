package com.baobaotao.beiyou.db;

import com.baobaotao.beiyou.Book;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @FileName BookDao.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2017/11/16  9:28
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class BookDao {

    public Connection getConnection()  {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=GBK",
                    "root", "woaiweiyi");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }

    public void addBooks(Book book) {
        Connection conn = null;
        Statement stmt = null;
        String sql = "insert into book(title, author, publisher, price) " +
                "values('" + book.getTitle() + "', '" + book.getAuthor() + "', '" +
                book.getPublisher() + "', " + book.getPrice().doubleValue() + ")";
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            return;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Book> fetchBooks() {
        Connection conn = null;
        Statement stmt = null;
        String sql = "select *  from book";

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Book> bookList = Populate(resultSet,Book.class);
            return bookList;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List Populate(ResultSet rs, Class cc) {

        //结果集 中列的名称和类型的信息
        List list = null;
        try {
            ResultSetMetaData rsm = rs.getMetaData();
            int colNumber = rsm.getColumnCount();
            list = new ArrayList();
            Field[] fields = cc.getDeclaredFields();

            //遍历每条记录
            while(rs.next()){
                //实例化对象
                Object obj = cc.newInstance();
                //取出每一个字段进行赋值
                for(int i=1;i<=colNumber;i++){
                    Object value = rs.getObject(i);
                    //匹配实体类中对应的属性
                    for(int j = 0;j<fields.length;j++){
                        Field f = fields[j];
                        if(f.getName().equals(rsm.getColumnName(i))){
                            boolean flag = f.isAccessible();
                            f.setAccessible(true);
                            if(f.getName().equals("price")){
                                value = new BigDecimal((Float) value);
                            }
                            f.set(obj, value);
                            f.setAccessible(flag);
                            break;
                        }
                    }

                }
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
