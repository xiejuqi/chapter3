package com.baobaotao.jaxb;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @FileName DateAdapter.java
 *
 * @Description     JAXB日期解析器只能转换为Calendar类型，编写自定义Date类型适配器
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/31 10:13
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class DateAdapter {

        public static Date parseDate(String s){
            return DatatypeConverter.parseDate(s).getTime();
        }

        public static String printDate(Date dt){
            Calendar cal = new GregorianCalendar();
            cal.setTime(dt);
            return DatatypeConverter.printDate(cal);
        }

    public static void main(String[] args) {
        System.out.println(DateAdapter.printDate(new Date()));
        System.out.println(DateAdapter.parseDate("2016-07-31+08:00"));
    }
}
