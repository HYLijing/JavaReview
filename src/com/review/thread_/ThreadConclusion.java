package com.review.thread_;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 1，多线程的三要素：
 * 原子性：就是一个或多个线程操作的同时，要么全部执行，要不全部不执行
 * 可见性：多线程的环境下，如果对共享变量的进行了操作，其他线程是立马感知的
 * 有序性：程序执行的顺序按照代码的的顺序执行（volatile）
 *
 * 2，实现可见性的方法：Lock和Synchronized
 * 保证同一时刻只有一个线程可以获取锁对象（互斥锁）对变量进行操作，操作完以后，刷新到内存中，让其他的线程从内存中更新当前变量
 *
 *
 */
public class ThreadConclusion {
    public static void main(String[] args) {

        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");



    }
}
