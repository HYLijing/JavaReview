package com.review.thread_;

/**
 * 线程创建的方式：1，继承Thread类 2，实现Runnable接口
 * <p>
 * 线程常用的方法：线程是获取到CPU的使用资源，
 * 1，start 将一个线程修改为可运行的状态，可以获取CPU执行的权利。因此调用几次start方法就是启动多少个子线程
 * 2，interrupt 终端线程。但并没有真正的结束线程，所以一般用于中断正在休眠线程
 * 3，sleep：线程的静态方法，让当前线程休眠
 * <p>
 * 常用方法第二组：
 * yield：线程让步。当前线程让出CPU，重新参与到线程之间的获取中，因此可能会出现让步不成功的现象
 * join：线程让步，此方法是当等待前线程执行完毕。
 */
public class ThreadMethods {

    public static void main(String[] args) {
        ThreadM t = new ThreadM();
        ThreadS s = new ThreadS();



        // 设置线程优先级
//        t.setPriority(Thread.MIN_PRIORITY);
        t.start();

        try {
            t.join();   // 让当前线程执行完毕之后，在执行其他线程。其他线程登台当前线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s.start();

        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            if (i == 4) {
//                t.interrupt();
//            }
            System.out.println(Thread.currentThread().getName() + "线程执行！" + i);
        }
    }
}


class ThreadM extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 线程让步，相当于让出当前CPU资源，重新参与CPU的争夺
//            Thread.yield();

            System.out.println(Thread.currentThread().getName() + "子线程执行" + i);
        }
    }
}

class ThreadS extends Thread {
    @Override
    public void run() {

        for (int i = 100; i < 120; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "子线程执行" + i);
        }
    }
}
