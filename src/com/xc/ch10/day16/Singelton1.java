package com.xc.ch10.day16;

/**
 * 单例模式值懒汉式实现，存在线程安全问题
 */
public class Singelton1 {
    //1.私有化构造器

    private Singelton1() {
    }

    //2.
    private static Singelton1 instance = null;

    //3.
    public static Singelton1 getInstance() {
        synchronized (Singelton1.class) {
            if (instance == null) {
                instance = new Singelton1();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singelton1 s1 = Singelton1.getInstance();
        Singelton1 s2 = Singelton1.getInstance();
        System.out.println(s1 == s2);
    }
}
