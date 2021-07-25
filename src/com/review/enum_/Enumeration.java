package com.review.enum_;

/**
 * 枚举是一组常量的集合
 * 可以这样理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象。
 * <p>
 * 枚举的两种实现方式：
 * 第一：自定义类实现枚举
 * 第二：使用enum关键字实现枚举
 */
public class Enumeration {

    public static void main(String[] args) {

        /**
         * 1，构造器私有化
         * 2，构建对象时，使用private static修饰
         * 3，提供getter方法，不能提供setter方法
         * 通过类名点对象后获得属性的字段
         */
        System.out.println(Season.SPRING.getName());
        System.out.println(Season.SPRING.getDesc());


    }


}

// 使用对象类型创建枚举
// 1，不需要set方法，以内枚举对象值是只读
// 2，枚举对象属性需要使用final + static共同修饰，底层优化
// 2，属性名大写
class Season {

    private String name;
    private String desc;    // 描述

    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season SUMMER = new Season("夏天", "温暖");


    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }
}
