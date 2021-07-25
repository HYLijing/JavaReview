package com.review.extends_;

public class ExtendsDetail {

    public static void main(String[] args) {

        Student student = new Student("一中");


    }

}



class Person {

    public Person() {}

    // 类会默认声明无参构造，如果自己写了构造器，默认的无参构造器就会被覆盖，需要显示的声明
    public Person(int gender,String name) {
        this.gender = gender;
        this.name = name;
    }


    private int gender;

    public String name;

}


class Student extends Person{

    public Student(String school) {
        super();    // 会默认调用父类的无参构造构造器
        this.school = school;

        this.name = "zhangsan"; // 可以直接访问父类的属性
//        this.gender = '男'        不能访问私有的属性。要通过父类提供公共的方法去访问

    }

    public String school;

}