package com.xc.ch7.day13;

public class Person {

    String name;
    Integer id;

    public Person() {
    }

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void show(){

        System.out.println("我是一个人\n");
    }

    public void displayNation(String nation){
        System.out.println("我的国籍是:"+nation);
    }
}
