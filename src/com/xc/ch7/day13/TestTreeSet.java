package com.xc.ch7.day13;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

//TreeSet的定制排序
public class TestTreeSet {
    @Test
    public void test(){

        TreeSet<Object> treeSet = new TreeSet<>(new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Person && o2 instanceof  Person ){
                    Person p1=(Person)o1;
                    Person p2=(Person)o2;
                    int val=p1.getId().compareTo(p2.getId());
                    if(val==0){
                        return p1.getName().compareTo(p2.getName());
                    }
                    return  val;

                }

                return 0;
            }
        });

        treeSet.add(new Person("GG",101));
        treeSet.add(new Person("AA",102));
        treeSet.add(new Person("DD",109));
        treeSet.add(new Person("PP",104));
        treeSet.add(new Person("RR",107));
        for (Object obj:treeSet){
            System.out.println(obj);
        }


    }

}
