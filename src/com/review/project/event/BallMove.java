package com.review.project.event;

import javax.swing.*;

// JFrame表示窗口
public class BallMove extends JFrame {

    PanelEvent mp = null;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        this.mp = new PanelEvent();

        this.add(mp);
        this.setSize(400, 300);
        //窗口 JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
