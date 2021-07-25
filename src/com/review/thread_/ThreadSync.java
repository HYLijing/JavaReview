package com.review.thread_;

import java.awt.*;

/**
 * 线程同步：同一时刻，只能被一个线程访问
 *
 * 具体同步的方法有多种：最常用的就是Synchronized和Lock
 *
 * 1，在java语言种引入互斥锁的概念，保证数据的完整性
 * 2，每个对象都对应一个互斥锁的的标记，这个标记用来保证任意时刻，只能有一个线程访问
 * 3，关键字synchronized来与对象的互斥锁联系，当某个对象用synchronized修饰时，表明该对象在任意时刻只能有一个线程访问
 * 4，同步的局限性：效率低
 * 5，同步方法（非静态）的锁是this，就是调用这个方法的对象
 * 6，静态方法的锁为当当前类本身
 *
 * java中的哪些操作会释放锁对象
 * 1，线程的同步方法或者同步代码块执行完毕后，会释放锁对象
 * 2，线程的同步方法或同步代码快遇到break，return时，会释放锁
 * 3，线程的同步方法或同步代码块中出现Error或者Exception时，会释放锁
 * 4，线程的同步方法或同步代码块中执行了线程对象的wait()方法，当前线程暂停，释放锁
 *
 * 以下操作不会释放锁哦
 * 1，同步方法或同步代码块中执行Thread.sleep()或者Thread.yield()方法，不会释放锁
 */
public class ThreadSync {

    public static void main(String[] args) {
        // 这里不是同一个对象了
        TicketSell1 ticketSell1 = new TicketSell1();
        TicketSell1 ticketSell2 = new TicketSell1();
        TicketSell1 ticketSell3 = new TicketSell1();
        Thread t1 = new Thread(ticketSell1);
        Thread t2 = new Thread(ticketSell1);
        Thread t3 = new Thread(ticketSell1);

        System.out.println("三个窗口同时启动");
        t1.start();
        t2.start();
        t3.start();

    }

}


class TicketSell1 implements Runnable {

    int tickets = 100;

    boolean loop = true;

    public synchronized void sellTickets() {

        if (tickets == 0) {
            System.out.println("当前票以卖完");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"线程出售当前票为："+tickets--);

    }


    @Override
    public void run() {
        // 启动这个线程，调用一个售票的方法
        while (tickets > 0) {
            sellTickets();
        }

    }



}