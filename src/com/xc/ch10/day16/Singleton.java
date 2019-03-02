package com.xc.ch10.day16;

/**
 * 单例模式值饿汉式
 */
public class Singleton {
    //1.私有化构造器(饿汉式和懒汉式的第一步都是要私有化构造器)

    private Singleton() {
    }

    //2.在类的内部创建一个对象
    //3.私有化该对象
    private static Singleton instance = new Singleton();

    //4.通过公共的方法来调用
    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1==s2);

    }
}
