package com.review.reflect;

public class ReflectDemo02 {

    public static void main(String[] args) {

//        Class<ClassDemo.InnerClass> innerClassClass = ClassDemo.InnerClass.class;

        try {
            // 获取一个私有的静态内部类的实例
//            Class aClass = Class.forName("com.review.reflect.ClassDemo.InnerClass");
            Class<ClassDemo.InnerClass> classClass = ClassDemo.InnerClass.class;
            // 没有办法在外部创建这个对象
            ClassDemo.InnerClass demo = (ClassDemo.InnerClass) classClass.newInstance();

            System.out.println(demo);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
