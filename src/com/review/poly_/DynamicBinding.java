package com.review.poly_;

/**
 * java的动态绑定机制
 * 1，当调用对象的方法时，该方法会和该对象的内存地址/运行类型绑定
 * 2，调用对象属性时，没有动态绑定机制，那里有声明，那里使用
 */
public class DynamicBinding {

    public static void main(String[] args) {
        //a 的编译类型 A, 运行类型 B
        A a = new B();

        // 这里是非常明确的，因为运行类型是B，所以只会调用B中的方法和变量
//        System.out.println(a.sum());    // 40
//        System.out.println(a.sum1());   // 30

        // 此时相当于调用父类A中的sum和sum1方法。由于方法的动态绑定机制，因此getI方法任然和B绑定，但是变量是不会绑定的
        System.out.println(a.sum());    // 30
        System.out.println(a.sum1());   // 110

    }
}


class A {    // 父类
    public int i = 100;

    public int sum() {
        return getI() + 10;
    }

    public int getI() {
        return i;
    }

    public int sum1() {
        return i + 10;
    }
}

class B extends A {
    public int i = 20;

//    public int sum() {
//        return getI() + 20;
//    }

    public int getI() {//子类getI()
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}