package com.review.collection_;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * set是无序集合，也就是放入的顺序和读取出来的顺序不一定相同
 *
 * 它的本质就是HashMap的key实现的，也就是通过Hash散列表实现的
 *
 * 查看HashMap的put方法可以得到：
 * 1，HashSet底层是HashMap，第一次添加时，会调用resize()方法，table数组扩容到16，默认的加载因子：0.75,临界值为：16*0.75
 * 2,如果table数组使用达到来临界值12，就会扩容，按照2倍进行扩容，新的临界值也是乘以2，因此类推
 * 3，在java8中，如果一条链表的元素个数达到 TREEIFY_THRESHOLD = 8时，并且table的大小 >=
 * MIN_TREEIFY_CAPACITY(64)时，就会转化为红黑树，否则任然采用数组扩容机制
 *
 */
public class HashSetDemo {

    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//
//        set.add("nihao");
//        set.add(new String("nihao"));
//
//        System.out.println(set);

        Map<String,Integer> map = new HashMap<>();

        map.put("nihao",1);
        map.put("nihao",2);



    }

}
