package com.review.wrapper_;

public class IntegerDemo {

    public static void main(String[] args) {

        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);

        Integer i3 = 1; // 自动装箱调用的是valueOf()方法。而valueOf方法可以看到维护了一个数组
        Integer i4 = 1;
        //这里主要是看范围 -128 ~ 127
        System.out.println(i3==i4);

        Integer i5 = 100;
        int i6 = 100;
        // 只要有基本数据类型，判断的都是值是否相等
        System.out.println(i5==i6);


    }


}
