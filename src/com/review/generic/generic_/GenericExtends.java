package com.review.generic.generic_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 范型的继承
 *
 * 1，范型不具备继承性
 * List<Object> list = new ArrayList<String>(); 错误的，因为ArrayList的范型指定前后一直，没有声明可以是父类或者子类
 * 2，<?>:支持任意范型类型
 * 3，<? extends A>: 表示支持A类及A的子类，规定了范型的上限
 * 4，<? super A> : 表示支持A及A的父类，规定类范型的下限
 */
public class GenericExtends {


    public static void main(String[] args) {

        Dao<String> dao = new Dao<>();

        dao.save("1","1");

        System.out.println(dao.get("1"));

        dao.update("1","2");
        System.out.println(dao.get("1"));

        System.out.println(dao.list());

        dao.delete("1");

    }

}

// 定义一个范型为T的范型类
class Dao<T> {

    private Map<String,T> map;

    public Dao() {
        this.map = new HashMap<String,T>();
    }

    public void save(String id, T entity) {
        map.put(id,entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id,T entity) {
        map.put(id,entity);
    }

    public List<T> list() {
        // 引出一个问题，这里的map.values()的运行类型是啥？我们在初始化的时候，需要指定map，不然的话map为null，无法做后续的操作。

        return map.values().stream().collect(Collectors.toList());

    }

    public void delete(String id) {
        map.remove(id);
    }
}
