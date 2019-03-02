package com.xc.ch12.day18;

import org.junit.Test;

/**
 * String与包装类_字节数组_字符数组间的转换.
 */
public class TestTransfer {
    /*
	 * 1.字符串 与基本数据类型、包装类之间转换
	 * ①字符串 --->基本数据类型、包装类:调用相应的包装类的parseXxx(String str);
	 * ①基本数据类型、包装类--->字符串:调用字符串的重载的valueOf()方法
	 *
	 * 2.字符串与字节数组间的转换
	 * ①字符串---->字节数组:调用字符串的getBytes()
	 * ②字节数组---->字符串：调用字符串的构造器
	 *
	 * 3.字符串与字符数组间的转换
	 * ①字符串---->字符数组：调用字符串的toCharArray();
	 * ②字符数组---->字符串:调用字符串的构造器
	 */
    @Test
    public void test1(){
        String str="123";
        int num = Integer.parseInt(str);
        //System.out.println(num);
        String s = String.valueOf(num);
//        System.out.println(s);
        byte[] bytes = s.getBytes();
//        for(int i=0;i<bytes.length;i++){
//            System.out.println((char) bytes[i]);
//        }
        String s1 = new String(bytes);
//        System.out.println(s1);

        //字符串转为字节数组
        char[] chars = s1.toCharArray();
//        for(int i=0;i<chars.length;i++){
//            System.out.print(chars[i]);
//        }
        String s2 = new String(chars);
        System.out.println(s2);

    }
}
