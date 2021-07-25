package com.review.innerclass_;

/**
 * 局部内部类：定义在外部内的局部位置，如方法中，有类名的
 * 具有的特性：（相当于局部变量，并满足局部变量的所有特性）
 * 1，可以访问外部类的所有成员（五大成员/），包含私有属性
 * 2，不能添加访问修饰符，因为就相当于一个局部变量，局部变量是不能使用修饰符,但是可以使用final修饰，
 * 因为局部变量可以被final修饰。
 * 3，作用域：只能在当前代码块和当前方法
 *
 * 4，局部内部类访问外部内的成员： 可以直接访问
 * 5，外部内访问局部内部类的成员： 创建对象在访问（必须在作用域内）
 *      总结：
 *      局部内部类定义在方法或代码块中
 *      它的作用域在当前代码块或方法中
 *      本质仍然是一个类，相当于方法中的一个局部变量
 *
 * 6，外部的其他类不能访问，就像同一个类中不同的方法不能访问相互访问之间的局部变量。因为作用域不同
 * 7，如果外部类和局部内部类的成员名相同时，访问时遵循就近原则，如果在局部内部类中想要访问外部内的名称，可以使用
 * 外部类名.this.成员去访问
 */
public class LocalInnerClass {

    private String category;

    public int age = 10;

    public static final int AVE = 10;

    public void getSum() {

        // 8，外部类和局部内部类成员名相同：age，遵循就近原则
        System.out.println(age);    // 这里就是10，因为他是属于外部内


        // 局部内部类定义在方法中或代码块中
        // 3，只能在当前方法中，作用域
        class InnerClass1 {  // 2。不能添加访问修饰符，因为它就相当于一个局部变量，是有特定作用域的
            private String name;
            private int age = 20;


            public void innerTest() {
                // 1，可以访问外部类的所有成员（五大成员/），包含私有属性
//                System.out.println(AVE);

                System.out.println(age);    // 20

                // 如果想这里访问外部内的age
                System.out.println(LocalInnerClass.this.age);   //10
            }
        }



        // 外部类只能在当前getSum方法中访问局部内部类的成员
        // 外部类访问内部类的成员。首先创建内部类的实例，通过内部类的实例来访问
        InnerClass1 innerClass1 = new InnerClass1();
        innerClass1.innerTest();

    }

    // 7,出去局部内部类作用于的getSum以外任何位置都不能访问局部内部类中的成员




    @Override
    public String toString() {
        return "LocalInnerClass{" +
                "category='" + category + '\'' +
                ", order=" + age +
                '}';
    }
}
