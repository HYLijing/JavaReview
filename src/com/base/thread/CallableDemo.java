package com.base.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Callable也是实现线程的一种方式
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadClass t1 = new ThreadClass(arr, 0, 50);
        ThreadClass t2 = new ThreadClass(arr, 50, 100);
        Future<Integer> future1 = executorService.submit(t1);
        Future<Integer> future2 = executorService.submit(t2);

        Integer result1 = future1.get();
        System.out.println(result1);

        Integer result2 = future2.get();
        System.out.println(result2);

        executorService.shutdownNow();

    }
}
