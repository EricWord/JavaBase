package com.xc.ch12.day18;

import com.xc.ch7.day13.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试反射机制
 */
public class TestReflection {

    //测试使用反射的方式调用对象的属性和方法
    @Test
    public  void test1() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person p = null;
        try {
            p = clazz.newInstance();
//            System.out.println(p);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //通过反射调用运行时类的指定属性
        Field f1 = clazz.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(p, "小红");
//        System.out.println(p);

        //通过反射机制调用运行时类的指定方法
        Method m1 = clazz.getMethod("show");
        m1.invoke(p);

        Method m2 = clazz.getMethod("displayNation", String.class);
        m2.invoke(p,"中国");


    }

    @Test
    public void test(){
        Person person = new Person();
        person.setId(1);
        person.setName("李明");
        System.out.println(person);


    }
}
