package com.baobaotao.xstream.converters;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @FileName DateConverter.java
 *
 * @Description  使用XStream自定义转换器
 *
 * @Version 1.0
 *
 * @Author xiejuqi
 *
 * @Email xiejuqi@yolo24.com
 *
 * @History Author: xiejuqi
 *
 * @Date: 2016/7/27 8:52
 *
 * @Version: 1.0
 *
 * @Content: create
 */
public class DateConverter implements Converter{

    private Locale locale;

    public DateConverter(Locale locale){
        super();
        this.locale = locale;
    }

    /**
     * 2.实现该方法，编写Java对象到XML转换逻辑
     * @param o
     * @param hierarchicalStreamWriter
     * @param marshallingContext
     */
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DATE_FIELD,this.locale);
        hierarchicalStreamWriter.setValue(formatter.format(o));
    }

    /**
     * 3.实现该方法，编写XML到Java对象转换逻辑
     * @param hierarchicalStreamReader
     * @param unmarshallingContext
     * @return
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {

        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DATE_FIELD,this.locale);

        try {
            calendar.setTime(formatter.parse(hierarchicalStreamReader.getValue()));
        } catch (Exception e) {
            throw new ConversionException(e.getMessage(),e);
        }

        return calendar.getGregorianChange();
    }

    /**
     * 1.实现该方法，判断要转换的类型
     * @param aClass
     * @return
     */
    @Override
    public boolean canConvert(Class aClass) {
        return Date.class.isAssignableFrom(aClass);
    }

}
