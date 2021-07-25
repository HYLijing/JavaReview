package com.review.generic.customgeneric;

/**
 * 自定义范型类
 * <p>
 * 也就是在类的使用中
 */
public class CustomGeneric {
    public static void main(String[] args) {

        Tiger<String, Double, Integer> t = new Tiger<>("zhongguo", 100.00, 10);
        System.out.println(t);

    }


    /**
     * 范型方法的声明：必须在修饰符之后 返回类型之前添加上 方法需要使用的范型
     *
     * 修饰符 <T ...> 返回类型 方法名(可以使用的范型)
     *
     * 当然如果我们方法中没有声明范型，还可以使用类中定义的范型。
     * 如果类和方法都没有声明对应的范型，那么方法的参数列表中不能自定新建
     *
     * @param t
     * @param r
     * @param <T>
     * @param <R>
     */
    public <T, R> void fly(T t, R r) {
        //泛型方法
        System.out.println(t.getClass());//String
        System.out.println(r.getClass());//Integer
    }
}


//1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
// 2, T, R, M 泛型的标识符, 一般是单个大写字母
// 3. 泛型标识符可以有多个.
// 4. 普通成员可以使用泛型 (属性、方法)
// 5. 使用泛型的数组，不能初始化
// 6. 静态方法中不能使用类的泛型
// 1.Tiger就是范型类
class Tiger<T, R, V> {

    // 2 T R M都是范型的标识符，代表一种类型

    // 4. 普通成员可以使用泛型 (属性、方法)
    private String name;

    private T t;

    private R r;

    private V v;


    public Tiger(T t, R r, V v) {
        this.t = t;
        this.r = r;
        this.v = v;
    }

    //因为静态是和类相关的，在类加载时，对象还没有创建
    // 所以，如果静态方法和静态属性使用了泛型，JVM 就无法完成初始化
    // static R r2; 编译报错
//    public static void getM(V v) {
//
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }


    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", t=" + t +
                ", r=" + r +
                ", v=" + v +
                '}';
    }
}