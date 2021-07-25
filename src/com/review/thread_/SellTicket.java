package com.review.thread_;

/**
 * 使用三个线程模拟售票
 */
public class SellTicket {
    public static void main(String[] args) {
//        方式一：
//        Thread thread1 = new Thread1();
//        Thread thread2 = new Thread1();
//        Thread thread3 = new Thread1();
//        thread1.start();
//        thread2.start();
//        thread3.start();

        // 方式二：
        Thread2 thread1 = new Thread2();
        Thread2 thread2 = new Thread2();
        Thread2 thread3 = new Thread2();
        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();


    }

}


// 创建线程类
class Thread1 extends Thread {

    private static int tickets = 100;


    @Override
    public void run() {
        while (true) {

            if (tickets <= 0) {
                System.out.println("票已经售完～");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--tickets));

        }
    }
}


class Thread2 implements Runnable {

    private static int tickets = 100;


    @Override
    public void run() {
        while (true) {

            if (tickets <= 0) {
                System.out.println("票已经售完～");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--tickets));

        }
    }
}
