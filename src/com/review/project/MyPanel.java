package com.review.project;

import java.awt.*;

//1.先定义一个 MyPanel, 继承 JPanel 类， 画图形，就在面板上画
public class MyPanel extends Panel {
    //说明:
    // 1. MyPanel 对象就是一个画板
    // 2. Graphics g 把 g 理解成一支画笔
    // 3. Graphics 提供了很多绘图的方法
    // Graphics g


    @Override
    public void paint(Graphics g) { // 绘图方法
        super.paint(g);//调用父类的方法完成初始化.
        System.out.println("paint 方法被调用了~");

        //画出一个圆形.
        // g.drawOval(10, 10, 100, 100);

        //演示绘制不同的图形..
        // 画直线：父类中的方法drawLine(int x1,int y1,int x2,int y2)
        // g.drawLine(10,10,100,10);

        //画椭圆边框 drawOval(int x, int y, int width, int height)
        //g.drawOval(10,10,100,50);

        //填充矩形 fillRect(int x, int y, int width, int height)
//        g.fillRect(10,10,100,50);
        //设置画笔的颜色
//        g.setColor(Color.yellow);
//        g.fillRect(10,10,100,50);

        //填充椭圆 fillOval(int x, int y, int width, int height)
//         g.setColor(Color.red);
//         g.fillOval(50,50,200,100);

        //画图片 drawImage(Image img, int x, int y, ..)
//         Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
//         g.drawImage(image, 10, 10, 175, 221, this);

        //画字符串 drawString(String str, int x, int y)//写字
        // 给画笔设置颜色和字体

        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 50));

        //这里设置的 100， 100， 是 "北京你好"左下角
        g.drawString("北京你好", 100, 100);

        //设置画笔的字体 setFont(Font font)
        // 设置画笔的颜色 setColor(Color c)
    }
}
