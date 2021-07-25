package com.review.regularexpression;

/**
 * 综合练习一：
 * 验证电子邮件格式是否合法
 * 规定：
 * 1，只有一个@
 * 2，@前面是用户名，可以是a-z A-Z _- 字符
 * 3，@后面是域名，并且域名只能是英文字母，比如soho.com
 * 4，写出对应的正则表达式，验证输入的字符串是否满足规则
 */
public class RegexExercise03 {

    public static void main(String[] args) {

        // ([a-zA-Z]+\.)+与[a-zA-Z.]+的区别。 前面是多个字符结合一个.出现，后面是可以出现多个...的组合
          String regex = "^[a-zA-Z0-9-_]+@[a-zA-Z.]+$";
        //String regex = "^[\\w-]+@([a-zA-Z]+\\.)+";

        // String email = "haiyang@163.com";
        String email = "haiyang_163@sohu....com";

        System.out.println(email.matches(regex));


    }

}
