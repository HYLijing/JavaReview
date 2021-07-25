package com.review.thread_;

/**
 * 1，祝线程每隔1s，输出一次hi，一共10次
 * 2，共输出hi5次时，启动一个子线程（实现Runnable），每个1s输出hello，等该线程输出10次hello后，退出
 * 3，主线程继续出hi，直到主线程退出
 */
public class ThreadMethodExercise {

    public static void main(String[] args) {

        int count = 0;

        while (true) {
            count++;
            System.out.println("hi");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                Thread subT = new Thread(new SubThread());
                subT.start();
                try {
                    subT.join();    // 主线程必须等当前线程执行完毕后才开始执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (count == 10) {
                break;
            }
        }
    }
}

class SubThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}