package com.review.project.games;

import com.review.project.MyPanel;

import javax.swing.*;
import java.awt.*;

public class TankGame01 extends JFrame {

    //定义MyPanel
    MyPanel01 mp = null;

    public static void main(String[] args) {
        new TankGame01();
    }

    public TankGame01() {
        this.mp = new MyPanel01();

        this.add(mp);//把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
