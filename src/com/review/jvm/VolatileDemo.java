package com.review.jvm;

public class VolatileDemo {

    /**
     * 结论：volatile关键字只能保证变量的可见性和代码执行的顺序性。不能保证变量的原子性的。
     * <p>
     * volatile关键修饰的变量要求：
     * 第一：我们所有的读取这个变量的操作都是需要从主内存中读取的。对变量进行assign
     * 操作后也都需要立马write到主内存中。
     * 第二：它会创建一个内层屏障来防止计算机的指令冲排序的功能。
     * <p>
     * <p>
     * 针对每一个线程，由于读取到本地线程的栈帧中对变量操作是需要耗时的，因此在这个过程中不能保证其他线程是否对这个
     * 变量进行修改，因为该线程还没有对他进行write操作。因此没法保证原子性的。
     * <p>
     * 指令冲排序：现代计算机机器级别的优化。他会在不影响当前代码程序结果的前提下，可能会打乱代码执行的顺序。
     * 这在单一线程中是没有影响的。但是如果在多线程的情况下，可能就会出现《深入理解Java虚拟机 p447的伪代码》
     *
     * @param args
     */

    private static volatile int race;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            new Thread(() -> {

                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(race);
    }
}
