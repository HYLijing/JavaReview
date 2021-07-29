package com.review.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo01 {

    // JDK9以前是不支持有参的构造的反射的
    public static void main(String[] args) {

        try {
            // 通过类的全路径名拿到这个类的Class对象
            Class class1 = Class.forName("com.review.reflect.ClassDemo");
            // 通过Class对象创建对象
            ClassDemo cd = (ClassDemo) class1.newInstance();
            System.out.println(cd);

            // 返回这个Class对象所对应的实体名称.返回这个类的全限定名
            System.out.println(class1.getName());

            // 父类的Class对象
            Class superclass = class1.getSuperclass();
            System.out.println(superclass.getName());

            // 获取类的接口列表.返回的是接口的Class对象数组
            Class[] interfaces = class1.getInterfaces();

            // 获取当前类的加载器
            ClassLoader classLoader = class1.getClassLoader();
            System.out.println(classLoader);

            // BootstrapClassLoader类加载器是C++代码实现的，因此不能支持java语言的打印
            System.out.println(String.class.getClassLoader());

            System.out.println("获取构造器");
            Constructor[] constructors = class1.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
                ClassDemo classDemo01;
                if (constructor.getParameterCount() == 1) {
                    // 调用构造器
                    classDemo01 = (ClassDemo) constructor.newInstance(100);
                } else {
                    classDemo01 = (ClassDemo) constructor.newInstance();
                }

                System.out.println(classDemo01);
            }

            System.out.println("获取对象中的属性信息");
            // 返回对象中所有的public修饰的属性
            Field[] fields = class1.getFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            // 返回对象中所有的属性
            Field[] declaredFields = class1.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField.getName());
                //System.out.println(declaredField.getChar("name"));
//                declaredField.get
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
