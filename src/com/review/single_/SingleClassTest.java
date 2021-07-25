package com.review.single_;

public class SingleClassTest {


    public static void main(String[] args) {
//
//        for (int i = 0; i < 3; i++) {
//
//            System.out.println("第"+i + "次：" +SingleClassLazy.getInstance());
//
//        }

        for (int i = 0; i < 100; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "=" +SingleClassLazy.getInstanceSafe());
            }).start();

        }
    }
}
