package com.review.string_;

/**
 * 1，String对象用于保存字符串，也就是一组字符序列： 字符串"abc" =》 'a' 'b' 'c'字符序列
 * 2，字符串常量对象是使用双引号括起的字符序列.例如："JACK"，"你好"。他们都是字符常量，保存在常量池中
 * 3，字符串的字符使用Unicode字符编码，一个字符，不管是字母还是汉字，都占用两个字节
 * 4，String常用的构造器
 * String s1 = new String();
 * String s2 = new String(String original)
 * String s3 = new String(char[] a)
 * String s4 = new String(char[] a,int startIndex,int count)
 *
 *
 * 重要：
 * 两种方式创建的比较
 * String s1 = "abc"
 * String s2 = new String("abc")
 *
 * 方式一：先从方法去中的常量池中查找是否有"abc"数据空间，如果有，直接指向，如果没有，新创建再指向。
 * 第一种创建方式，指针永远指向常量池空间地址
 * 方式二：现在堆中创建空间，堆中维护了char[]数组value，value指向常量池中的"abc"空间，如果没有创建，再指向。
 * 第二种方式创建的对象，指针永远指向堆中。
 * 这里可以使用String类的intern()方法来判断。
 * intern()方法用来返回字符串的常量池中的地址的数据
 *
 *
 */
public class StringDemo01 {

    public static void main(String[] args) {

        String s1 = new String("nihao");  // 在堆中创建了一个char[] value数组，s1指向它，而value在指向常量池中的"nihao"

        String s2 = "nihao";    // s2就是一个字符串常量对象。s2直接指向常量池中的"nihao"地址

        String s3 = "nihao";

        System.out.println(s2==s3); // 比较的是地址

        System.out.println(s1.intern());

    }

}
