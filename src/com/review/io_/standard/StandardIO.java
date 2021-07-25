package com.review.io_.standard;


import java.util.Scanner;

/**
 *
 * 标准输入/输出流
 * 默认是从键盘录入和显示器显示
 *
 */
public class StandardIO {

    public static void main(String[] args) {

        // InputStream  字节输入流
        // System.in    标准输入流

        // PrintStream  打印流
        // System.out   标准输出流   打印流
        // 使用Scanner的时候，就需要从键盘传入标准输入流
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输出：");

        String next = scanner.next();

        // 屏幕输出
        System.out.println(next);
    }

}
