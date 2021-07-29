package com.review.reflect;

/**
 * 类的五大组成部分：
 * 属性
 * 方法
 * 代码块
 * 内部类
 * 构造器
 */
public class ClassDemo {

    private int filed1;

    public String name = "haiyang";

    public ClassDemo(int filed1) {
        this.filed1 = filed1;
    }

    public ClassDemo() {
        this.filed1 = 10;
    }

    public static int method1(int param1, String param2) {
        System.out.println(param1);
        System.out.println(param2);
        return param1 + 2;
    }


    public void method2() {
        System.out.println("成员方法指向～～～～");
    }

    /**
     * 逐级降低
     * public
     * protect  自身，子类及同一个包中类可以访问。
     * default  同一个包中类可以访问。
     * private  当前类中
     */
     static class InnerClass {
        private int x;
        private int y;

        public InnerClass(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 使用反射必须要有构造器
        public InnerClass() {
            this.x = 100;
            this.y = 200;
            System.out.println("无参构造器创建完毕。字节码对应的是init方法");
        }

        @Override
        public String toString() {
            return "InnerClass{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ClassDemo{" +
                "filed1=" + filed1 +
                '}';
    }
}
