package com.review.single_;

public class SingleClassFirst {

    private static SingleClassFirst singleClassFirst = new SingleClassFirst();


    private SingleClassFirst(){}

    /**
     * 饿汉式相对于懒汉式就是创建的时机不同
     * 饿汉式在程序启东时就加载，懒汉式则是在程序调用时才会加载
     *
     * 因此饿汉式可能会存在资源的浪费，但是饿汉式不存线程安全的问题
     * 懒汉式要想线程安全需要改进
     * @return
     */
    public SingleClassFirst getInstance() {
        return singleClassFirst;
    }

}
