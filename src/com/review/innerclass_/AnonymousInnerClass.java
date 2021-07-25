package com.review.innerclass_;

/**
 * 匿名内部类
 * 1，本质还是一个类，但是可以理解成对象类
 * 2，该类没有名字
 * 3，定义在方法中
 * 4，同时他还是一个对象
 * new 类或接口(参数列表){ 类中的实现 }
 *
 *
 * 匿名内部类只是在实现的方式和局部内部类不同
 * 匿名内部类的语法比较奇特，即是一个类的定义，同时他本省也是一个对象，从语法上看，它即有定义类的特征，也有创基对象的特性
 *
 * 其他的访问和作用于局部内部类相同。
 *
 * 匿名内部类在java8中的lambda函数中大量使用，我们可以使用一个匿名类的实当作参数传递，不用在写接口或者抽象类的
 * 实现，在传入实现类的实例
 *
 */
public class AnonymousInnerClass {
}

class Outer {
    private int n1 = 10;

    private void method() {

        //基于接口的匿名内部类
        // 1.需求： 想使用 IA 接口,并创建对象
        // 2.传统方式，是写一个类，实现该接口，并创建对象
        // 3.老韩需求是 Tiger/Dog 类只是使用一次，后面再不使用
        // 4. 可以使用匿名内部类来简化开发 //5. tiger 的编译类型 ? IA
        // 6. tiger 的运行类型 ? 就是匿名内部类 Outer04$1
        class Inner1 implements IA {

            @Override
            public void cry() {
                System.out.println("实现了IA接口");
            }
        }

        // 这里就是匿名类的实现方法，他的编译类型是：IA，运行类型是 匿名内部类
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("");
            }
        };

    }
}


interface IA {//接口

    public void cry();
}