package com.review.baseclass;

public class StringOperator {

    static final String str = "hsp";
    final char[] ch = {'j','a','v','a'};

    public void change(String str,char[] ch) {
        str = "java";
        ch[0] = 'h';
        System.out.println(str);
    }


    public static void main(String[] args) {

        String a = "hello2";

        final String b = "hello";

        String d = "hello";

        String c = b + 2;   // 指向常量池中的 "hello2"
        String e = d + 2;   // "hello2"
        System.out.println((a == c));   // true
        System.out.println((a == e));   // true

        String s1 = "hello1";
        String s2 = "hello" + 1;

        System.out.println(s1==s2);



//        String str2 = "hsp";
//
//        str = str2;
//
//        StringOperator stringOperator = new StringOperator();
//
//        stringOperator.change(stringOperator.str,stringOperator.ch);
//
//        System.out.println(stringOperator.str + " and ");
//        System.out.println(stringOperator.ch);
    }

}
