package com.xc.ch12.day18;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    void info();

    void fly();
}

//被代理类
class SuperMan implements Human {

    @Override
    public void info() {
        System.out.println("我是超人，我怕谁！");
    }

    @Override
    public void fly() {
        System.out.println("I believe I can fly!");

    }
}

class HumanUtil {
    public void m1() {
        System.out.println("-----方法一--------");
    }

    public void m2() {
        System.out.println("-----方法二--------");
    }
}

class MyInvocationHandler1 implements InvocationHandler {
    //被代理类对象的声明
    Object obj;
    //初始化被代理类对象


    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {

        HumanUtil h = new HumanUtil();
        h.m1();
        Object res = method.invoke(obj, args);
        h.m2();
        return res;
    }
}

class MyProxy {

    //动态的创建一个代理类的对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler1 handler1 = new MyInvocationHandler1();
        handler1.setObj(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler1);

    }
}

public class TestAOP {
    public static void main(String[] args) {
        //创建一个被代理类的对象
        SuperMan man = new SuperMan();
        //返回一个代理类的对象
        Object obj = MyProxy.getProxyInstance(man);
        //强
        Human h=(Human)obj;
        h.info();
        System.out.println();
        h.fly();
    }
}
