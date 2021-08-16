package com.base.thread;

import java.util.concurrent.Callable;

public class ThreadClass implements Callable<Integer> {
    // 使用构造器来实现对数组的筛选。可以创造两个ThreadClass对象分别对同一个arr进行筛选
    private int[] arr;
    private int start;
    private int end;

    // 构造这个对象交给ExecutorService去执行
    public ThreadClass(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }


    @Override
    public Integer call() throws Exception {
        int max = arr[0];
        for (int i = start; i < end; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
