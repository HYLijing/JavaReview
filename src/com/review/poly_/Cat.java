package com.review.poly_;

public class Cat extends Animal {
    String color = "红色";

    public void eat() {
        //方法重写
        System.out.println("猫吃鱼");
    }

    public void catchMouse() {
        //Cat 特有方法
        System.out.println("猫抓老鼠");
    }
}