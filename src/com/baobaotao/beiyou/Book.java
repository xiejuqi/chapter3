package com.baobaotao.beiyou;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @FileName Book.java
 *
 * @Description     北邮Java课程作业实验
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2017/11/4  16:11
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class Book {

    /**书籍书名*/
    private String title;
    /**作者*/
    private String author;
    /**出版商*/
    private String publisher;
    /**价格*/
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void printBookMessage(){
        System.out.println("您输入的书籍信息[书名="+this.title+" ,作者="+this.author+" ,出版社="+this.publisher+" ,价格="+this.price+"]");
    }

    public static void main(String[] args) {

        Book[] bookArray = new Book[10];
        bookArray[0] = new Book();
        bookArray[0] = null;
        try {
            FileReader fr=new FileReader("E:/beiyou/java/books.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入书籍信息，输入OK开始：");
        String isNext = sc.next();
        if(isNext != null && "OK".equals(isNext)){
            while (true){
                System.out.println("请输入书名：");
                String title = sc.next();
                System.out.println("请输入作者：");
                String author = sc.next();
                System.out.println("请输入出版社：");
                String publisher = sc.next();
                System.out.println("请输入价格：");
                String price = sc.next();
                Book book = new Book();
                book.setTitle(title);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setPrice(new BigDecimal(price));
                book.printBookMessage();
            }
        }else{
            System.exit(0);
        }
    }
}
