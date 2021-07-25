package com.review.collection_;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashMap的底层实现原理：Map是和Collection平行的接口
 * <p>
 * 这里主要对Map的扩容和转换为红黑树做原码的了解（看原码）
 *
 * put方法：
 * 1，记住一个结论，两个对象的hash值相等，那么他们不一定是同一个对象，还需要继续判断，
 * 如果两个对象的hash值不同，那么，他两肯定是不同的对象。
 * 因为计算hash的算法时，会出现特例的情况
 * 所以这里需要明白三个东西：
 * hash()散列函数
 * hashCode() 返回对象的哈希码值。 支持此方法是为了有利于哈希表，例如java.util.HashMap提供的哈希表
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map map = new HashMap(15);
        map.put("1",1);

//        for (int i = 0; i < 20; i++) {
//            map.put(i+"",i);
//        }
//        int num = 10;
//
//        if (num > 5) {
//            System.out.println("1");
//        } else if (num >9) {
//            System.out.println("@");
//        }else {
//            System.out.println("3");
//        }

//        int oldCap = 1 << 29;
//        int newCap;
//
//
//
//        if ((newCap = oldCap << 1) < 1 << 30 &&
//                oldCap >= 1 << 30) {
//
//
//        }
//
//        System.out.println("在判断中赋值，但是条件不成立，想看看是否赋值成功");
//        System.out.println(newCap);
//        System.out.println(oldCap);
//        System.out.println(1 << 30);


    }

}

class Person {
    String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        if ("SpiderMan".equals(person.name)) return true;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        if(name.equals("PeterParker")){ return Objects.hash("SpiderMan");
        }
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        Person person1 = new Person("SpiderMan");
        map.put(person1, "蜘蛛侠");

        Person person2 = new Person("SpiderMan");

        System.out.println(map.get(person2));
        map.put(person2,"超人");
        System.out.println(map);
        System.out.println(person1);
        System.out.println(person1.hashCode());

//        System.out.println(map.get(new Person("PeterParker")));
    }

}

