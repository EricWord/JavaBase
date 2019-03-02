package com.xc.ch12.day18;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//接口
interface Subject {
    void action();
}

//被代理类
class RealSubject implements Subject {


    @Override
    public void action() {
        System.out.println("我是被代理类，要记得执行我哦！");
    }
}

class MyInvocationHandler implements InvocationHandler {
    //实现了接口的被代理类的对象声明
    Object obj;

    //给被代理的对象实例化
    //返回一个代理类的对象
    public Object blind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);


    }

    //当通过代理类的对象发起对被重写的方法的调用时，都会转换为对invoke方法的调用
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        Object res = method.invoke(obj, args);
        return res;
    }
}

public class TestProxy {
    public static void main(String[] args) {
            //1.被代理类的对象
        RealSubject real = new RealSubject();
        //2.创建一个实现了InvocationHandler接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //3.调用blind方法，动态地返回一个同样实现了real所在类实现的接口Subject的代理类的对象

        Object obj = handler.blind(real);
        //强转
        Subject sub=(Subject)obj;
        sub.action();

    }
}
