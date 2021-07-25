package com.review.single_;

public class SingleClassLazy {

    private static SingleClassLazy singleClass;


    private SingleClassLazy() {}

    // 整个系统中，只会出现一次一个对象实例。懒汉模式
    public static SingleClassLazy getInstance() {

        if (singleClass == null) {
            singleClass = new SingleClassLazy();
        }
        return singleClass;
    }


    public static SingleClassLazy getInstanceSafe() {

        if (singleClass == null) {  // 为了保证singleClass没有被创建，才会去那这个锁。
            synchronized (SingleClassLazy.class) {
                if (singleClass == null) {  // 在获取到锁后也需要判断其他线程没有创建这个对象
                    singleClass = new SingleClassLazy();
                }
            }
        }
        return singleClass;
    }
}
