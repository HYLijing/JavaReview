package com.review.poly_;


/**
 * 方法的多态：方法的重载和重写就体现了方法的多态
 * <p>
 * 对象的多态（难点）
 * 1，一个对象的编译类型和运行类型可以不一致
 * 2，编译类型在定义对象时就已经确定了，不可以改变
 * 3，运行类型是可以改变的
 * 4，编译类型看 = 号的左边，运行类型看 = 号的右边
 */
public class PolyObject {
    public static void main(String[] args) {
        //体验对象多态特点
//        // animal 编译类型就是 Animal , 运行类型Dog
//        Animal animal = new Dog();
//        // 因为运行时 , 执行到该行时，animal 运行类型是 Dog,所以 cry 就是 Dog 的 cry
//        animal.cry();
//        // 小狗汪汪叫
//        // animal 编译类型 Animal,运行类型就是Cat
//        animal = new Cat();
//        animal.cry(); //小猫喵喵叫


        //向上转型: 父类的引用指向了子类的对象
        // 语法：父类类型引用名 = new 子类类型();
        Animal animal = new Cat();
        Object obj = new Cat(); // 这个也属于向上转型

        //向上转型调用方法的规则如下:
        //(1)可以调用父类中的所有成员属性(需遵守访问权限)
        System.out.println(animal.name);
        System.out.println(animal.age);
        //(2)但是不能调用子类的特有的成员     //(#)因为在编译阶段，能调用哪些成员,是由编译类型来决定的
        // animal.color; 不能调用子类的属性。这里是在编译阶段。需要看左边的编译类型
        // 这里调用的是子类的eat方法，因为执行方法时，看到的是运行类型。这里的运行类型是Cat
        // 在编译时，相当于调用了父类的eat方法
        animal.eat();
        //(4)最终运行效果看子类(运行类型)的具体实现, 即调用方法时，按照从子类(运行类型)开始查找方法，
        // 然后调用，规则我前面我们讲的方法调用规则一致。
        animal.eat();   // 猫吃鱼
        animal.run();   // 跑
        animal.show();  // hello,你好
        animal.sleep(); // 睡

        // 因为animal是Animal类型，因此不能调用子类的catchMouse方法。如果想要调用catchMouse方法，需要向下转型
        Cat cat = (Cat) animal; // 这里cat的编译类型是cat 运行类型也是cat。因为animal的运行类型还是cat

        cat.catchMouse();
        cat.eat();

        // 如果想要向下转型，那么父类的引用必须指向当前目标类型对象。否则不能向下转型
        Animal animal1 = new Animal();
        Cat cat1 = (Cat) animal1;   //这里会报错




    }
}