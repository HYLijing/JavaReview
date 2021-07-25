package com.review.string_;

public class StringExercise02 {

    String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};


    public void change(String str,char[] ch) {
        str = "java";   // 相当于给参数str变量赋值为"java"
        ch[0] = 'h';    // 给传入的参数ch[0] = 'h'
    }


    public static void main(String[] args) {
        StringExercise02 se = new StringExercise02();
        se.change(se.str, se.ch);
        System.out.println(se.str + " and"); // java and hava
        System.out.println(se.ch);

        String str = "hello";
        System.out.println();


    }

}
