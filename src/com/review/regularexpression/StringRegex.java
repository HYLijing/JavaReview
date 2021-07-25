package com.review.regularexpression;

public class StringRegex {

    public static void main(String[] args) {

        // String 中的很多方法是可以传入正则表达式的
        // 案例一：替换jdk1.3 jdk1.4为jdk
        String content = "JDK1.3,JDK1.4都说是JDK的初始时代";

        String res = content.replaceAll("JDK1\\.[3|4]", "JDK");
        System.out.println(res);

        // String 中的matches方法。判断字符串是否满足正则
        // \\s 匹配空白
        // \\S匹配非空白
        // \\w 匹配字母，数字和下划线
        // 此方法本质还是使用Pattern.matchers()匹配方法
        boolean matches = content.matches("^[a-zA-z][\\S]*$");
        System.out.println(matches);

    }
}
