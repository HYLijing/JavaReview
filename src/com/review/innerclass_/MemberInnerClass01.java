package com.review.innerclass_;


/**
 * 成员内部类：定义在外部类的成员位置，并且是没有被static修饰
 * 1，可以直接访问外部类的所有成员，包括私有
 * 2，可以添加任意访问修饰符，因为它就相当于成员变量
 * 3，作用域与其他的成员变量相同，作用域当前整个类中
 * 4，访问外部类成员的方式：直接访问
 * 5，外部类访问成员内部类的方式： 创建对象 在通过对象访问
 * 6，外部其他类访问成员内部类：创建对象 再访问
 * 7，外部内成员和局部内部类成员重名，也是相同。就近原则
 */
public class MemberInnerClass01 {


}

class Outer2 {
    private int n1 = 10;
    public String name = "张三";


    private void hi() {
        System.out.println("hi()方法...");
    }


    // 1.注意: 成员内部类，是定义在外部内的成员位置上
    // 2.可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    public class Inner2 {//成员内部类.他的作用域在当前类，因此不能被继承

        private double sal = 99.8;
        private int n1 = 66;

        public void say() {
            //可以直接访问外部类的所有成员，包含私有的
            // 如果成员内部类的成员和外部类的成员重名，会遵守就近原则.
            // ，可以通过 外部类名.this.属性 来访问外部类的成员
            System.out.println("n1 = " + n1 + " name = " + name + " 外部类的 n1=" + Outer2.this.n1);
            hi();
        }
    }


}









