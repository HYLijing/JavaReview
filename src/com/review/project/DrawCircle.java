package com.review.project;

import javax.swing.*;

/**
 * 演示如何在面板上画图
 *
 * 先要明白几个概念：
 * 1，计算机中的像素：计算机在屏幕中显示的内容由屏幕上的每个像素组成的。
 * 例如：计算及的项目是800*600，表示计算机每行由800个点组成，共有600行，整个计算机屏幕共有480000像素，像素是一个
 * 密度单位，而厘米是长度单位，两者是不同的概念
 *
 */
public class DrawCircle extends JFrame { //JFrame 对应窗口,可以理解成是一个画框

    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {

        new DrawCircle();
        System.out.println("退出程序！");
    }

    public DrawCircle() {
        //初始化面板 mp = new MyPanel();
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(400, 300);
        //当点击窗口的小×，程序完全退出.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示
    }

}
