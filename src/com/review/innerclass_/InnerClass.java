package com.review.innerclass_;

/**
 * 内部类：一个内的内部有完整的嵌套来另一个类结构。被嵌套的类成为内部类，嵌套的类称为外部类
 * 类的五大成员：属性，方法，构造器，代码块和内部类
 *
 * 内部类的最大特性就是可以直接访问私有属性。因为private修饰的范围就是当前类可见，那么内部类是可以属于当前内的范围，
 * 可以直接方法
 *
 * 定义在方法中（局部位置）：可以分为 局部内部类  匿名内部类
 * 定义在成员位置： 可以分为    成员内部类   静态内部类
 */
public class InnerClass extends Outer2{

    public static void main(String[] args) {

        LocalInnerClass localInnerClass = new LocalInnerClass();

        localInnerClass.getSum();   // 输出：10 20 10


    }
}
