package com.xc.ch12.day18;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

    @Test
    public  void test3(){
        //测试日历类
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.DAY_OF_MONTH);
//        System.out.println(i);

       instance.add(Calendar.DAY_OF_MONTH,-2);
       i=instance.get(Calendar.DAY_OF_MONTH);
//        System.out.println(i);

        instance.set(Calendar.DAY_OF_MONTH,22);
        i=instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
    }

    @Test
    public  void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String s = sdf.format(new Date());
//        System.out.println(s);
        //通过构造器的方式格式化时间
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        String s1 = sdf2.format(new Date());
//        System.out.println(s1);
    //解析
        Date parse = sdf.parse("14-5-12 下午3:24");
        System.out.println(parse);
    }
    @Test
    public void test1() {

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        Date date1 = new Date(1551157659263L);
        System.out.println(date1);

    }
}
