package com.xc.ch10.day16;

import org.junit.Test;

import java.io.*;

public class TestObjectOutputSteam {

    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Person.txt"));
            Person p1 = (Person) ois.readObject();
            System.out.println(p1);
            Person p2 = (Person) ois.readObject();
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Test
    public void test1() {
        Person p1 = new Person("小明", 34);
        Person p2 = new Person("小红", 29);
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("Person.txt"));
            oos.writeObject(p1);
            oos.flush();
            oos.writeObject(p2);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

class Person implements Serializable {
    //姓名
    String name;
    //年龄
    Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}