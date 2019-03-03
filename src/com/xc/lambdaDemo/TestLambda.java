package com.xc.lambdaDemo;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: TestLambda
 * @Description: 复习Lambad表达式
 * @Author: Eric
 * @Date: 2019.03.03
 * @Email: xiao_cui_vip@163.com
 */
public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    /**
     * 原来的匿名内部类
     */
    @Test
    public void test1() {
        //比较两个字符串的长度大小
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(), t1.length());
            }
        };
        TreeSet<String> treeSet = new TreeSet<>(com);
        new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(), t1.length());
            }
        });
    }

    /**
     * 现在的Lambda表达式
     */
    @Test
    public void test2() {
        Comparator<String> com = (x, y) -> Integer.compare(x.length(), y.length());
        TreeSet<String> strings = new TreeSet<>(com);
    }

    /**
     * 获取年龄小于35的员工信息
     *
     * @param emps 员工信息
     * @return 满足条件的员工信息
     */
    public List<Employee> filterEmployeeByAge(List<Employee> emps) {
        List<Employee> list = new ArrayList<>();

        for (Employee e : emps) {
            if (e.getAge() <= 35) {
                list.add(e);
            }
        }
        return list;
    }

    @Test
    public void test3() {
        List<Employee> ls = filterEmployeeByAge(emps);
        for (Employee e : ls) {
            System.out.println(e);
        }
    }

    //优化方式一：策略设计模式
    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp) {
        List<Employee> list = new ArrayList<>();
        for (Employee e : emps) {
            if (mp.test(e)) {
                list.add(e);
            }
        }
        return list;
    }

    @Test
    public void test4() {

        List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
        for (Employee e : list) {
            System.out.println(e);
        }

        System.out.println(">>>>>>>>>>>>>>>>>");
        List<Employee> list1 = filterEmployee(emps, new FilterEmployeeForSalary());
        for (Employee e : list1) {
            System.out.println(e);
        }
    }

    //优化方式二：匿名内部类
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getId() > 103;
            }
        });

        for (Employee em : list) {
            System.out.println(em);

        }
    }

    //优化方式四：Lambda表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(emps, (e) -> e.getAge() >= 35);
        for(Employee e:list){
            System.out.println(e);
        }


    }



}
