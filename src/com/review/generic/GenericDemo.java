package com.review.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 范型的使用：
 * 优先使用姓名比较，如果姓名相同就按照出生日期进行比较
 */
public class GenericDemo {

    public static void main(String[] args) {

        List list = new ArrayList<Employee>();

        MyDate myDate1 = new MyDate(1991, 05, 15);
        Employee employee1 = new Employee("Abc",10,myDate1);

        MyDate myDate2 = new MyDate(1991, 05, 11);
        Employee employee2 = new Employee("Abc",100,myDate2);

        MyDate myDate3 = new MyDate(1990, 06, 10);
        Employee employee3 = new Employee("Abc",1000,myDate3);

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        list.sort(new CustomComparator());

        list.forEach(System.out::println);
    }
}
