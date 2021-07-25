package com.review.collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * List接口继承了Collection接口，表示集合
 * List具有的特性是：有顺序，也就是进去什么顺序出来什么顺序
 * ArrayList底层是使用数组实现的
 * LinkedList底层是使用链表实现的
 * 因此ArrayList和LinkedList的在读取元素和增删元素上有本质区别
 * ArrayList与Vector本质相同，Vector是线程安全的
 */
public class ArrayListDemo {

    /**
     * 在扩容的使用到的
     * 1，这里的 >> 运算符的意思是：低位溢出,符号位不变,并用符号位补溢出的高位。向右移动，高位空出的用符号为补充。
     * 因此它的本质就是除以2的次方
     * <p>
     * 像 oldCapacity >> 1 => 本质就是 oldCapacity / 2^1
     * int newCapacity = oldCapacity + (oldCapacity >> 1);
     * <p>
     * 2，<<: 符号位不变,低位补 ,向左移动，地位，使用符号位补全。
     * 实质就是乘以2的次方
     * <p>
     * 例如：
     * int c=1<<2   =>  1 * 2^2
     * <p>
     * 3 还有一种运算 >>> 叫做逻辑右移。低位溢出，高位补0
     * <p>
     * 逻辑右移也叫无符号右移,运算规则是: 低位溢出，高位补 0
     * <p>
     * 那么，如果是正数，和算数右移相同
     *
     * @param args
     *
     * 无参构造创建数组 添加元素的逻辑：
     * 1，创建一个长度为0的数组
     * 2，第一次添加元素，会调用ensureCapacityInternal方法来确认数组的长度。
     * 继续会调用：ensureExplicitCapacity(calculateCapacity(elementData, minCapacity))方法来判断
     * 数组的是否需要增加数组的长度。
     * 通过calculateCapacity(elementData, minCapacity)方法来计算当前数组的长度和元素的个数大小，返回他们
     * 中的大的值。然后拿这个值和我们当前数组的长度做比较，如果大于当前数组的长度，那么就相当于，元素的个数多了，
     * 就会调用grow方法进行扩容。
     *
     * grow方法扩容的方式：
     * int newCapacity = oldCapacity + (oldCapacity >> 1); 扩容1.5倍
     * 这里有个基本的业务，第一次来加入数据的时候会建一个长度为10的数组，后面如果超过数组的长度，就会乘以1.5倍进行扩容
     * 然后会将老数组的数据放入到新的数组中。并让我们的elementData指向新的数组。
     *
     *
     * 如果是初始化长度的数组，就会创建一个我们自己声明的长度的数组，
     * 那么添加元素的时候，核心也是比较元素的个数和数组的长度，并按照1.5倍增长
     *
     *
     *
     */
    public static void main(String[] args) {

        // 这里会创建一个长度为0的数组
        List list = new ArrayList(4);

        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        list.add("abc5");
        list.add("abc6");
        list.add("abc7");
        list.add("abc8");
        list.add("abc9");
        list.add("abc10");
        list.add("abc11");


    }

}
