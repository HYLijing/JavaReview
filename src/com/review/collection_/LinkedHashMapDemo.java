package com.review.collection_;

import java.util.*;


/**
 * 1，LinkedHashMap底层维护了一个数组 + 双向链表
 * 2，LinkedHashMap的put方法任然是他的parentClass HashMap的put方法的实现
 * 3，根据java的多态，我们在创建结点：newNode(hash, key, value, null)时，LinkedHashMap就对当前链表的数据进行了双向链表的维护，使用after和before
 *  如果是是替换数组中或链表中或红黑树中的Node结点，那么会使用afterNodeAccess方法进行双向链表的维护
 * 4，我们在遍历的时候，不管是通过EntrySet或者是KeySet都是通过这个双向链表进行遍历的，而HashMap则是通过table数组的角标遍历的，因此放入的顺序和出来的属性可能不同。
 *
 * 总结：与HashMap的不同
 * LinkedHashMap底层在HashMap的基础之上又维护了每个元素之间的双向指针，用来记录元素插入的顺序。因此LinkedHashMap是有序的
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {

        Map map = new LinkedHashMap();

        map.put("5",1);
        map.put("6",2);

        map.forEach((k,v) -> System.out.println(k+":"+v));
//        map.put("3",3);
//        map.put("1",4);
//        map.put("2",5);
        map.entrySet().forEach(System.out::println);
//
//        Map map1 = new HashMap();
//        map1.put("5",1);
//        map1.put("6",2);
//        map1.put("3",3);
//        map1.put("1",4);
//        map1.put("2",5);
//        map1.entrySet().forEach(System.out::println);
//        String str = null;
//        System.out.println(str.hashCode());

//        Map table = new Hashtable();
//        table.put(1,null);

        // return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2) : comparator.compare((K)k1, (K)k2);
        // 这段代码可以看出来，TreeMap的key必须是Comparable接口实现，也就是不行能够使用Comparable来作为引用。
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();

        Map treeMap = new TreeMap();
        treeMap.put(person1,1);
        treeMap.put(person2,2);
        treeMap.put(person3,3);
        treeMap.put(person4,4);

//        treeMap.entrySet().forEach(System.out::println);
        System.out.println(treeMap);
    }


}
