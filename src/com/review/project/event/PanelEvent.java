package com.review.project.event;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 画板
// Panel 画板
// KeyListener 事件监听
public class PanelEvent extends Panel implements KeyListener {

    //为了让小球可以移动, 把他的左上角的坐标(x,y)设置变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按下键盘事件
    //根据用户按下的不同键，来处理小球的移动 (上下左右的键)
    // 在 java 中，会给每一个键，分配一个值(int)
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char) e.getKeyCode() + "被按下..");
        //根据用户按下的不同键，来处理小球的移动 (上下左右的键)
        // 在 java 中，会给每一个键，分配一个值(int)
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //KeyEvent.VK_DOWN 就是向下的箭头对应的 code
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        //让面板重绘
         this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
