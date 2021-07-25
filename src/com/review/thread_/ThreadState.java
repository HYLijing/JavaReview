package com.review.thread_;

/**
 * java中线程的状态
 * NEW
 * 未启动的线程处于此状态
 * RUNNABLE
 * 在java虚拟机中执行的线程处于此状态
 * BLOCKED
 * 被阻塞等待监视器锁定的线程处于此状态
 * WAITING
 * 正在等待另一个线程执行特定动作的线程处于此状态
 * TIMED_WAITING
 * 正在等待另一个线程执行动作达到指定等待时间的线程处于此状态
 * TERMINATED
 * 已退出的线程处于此状态
 *
 */
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {

        T t = new T();
        System.out.println("当前线程状态为：" + t.getState());

        t.start();

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);  // main线程状态为TIMED_WAITING
        }

        System.out.println("线程执行结束后："+t.getState());

    }
}


class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}