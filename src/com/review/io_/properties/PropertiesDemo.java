package com.review.io_.properties;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {

    /**
     * 引出Properties类：专门用来读取配置文件的。包含一系列的API方便我们操作和修改配置
     *
     *  关于Properties类的总结：
     *  Properties的本质是一个HashTable，相对于HashMap是线程安全的，其他的都相似，只是扩容的加载因子可能不同
     *  Properties管理配置文件的方式类似与将配置文件交给Properties进行管理。通过store方法在写入的方式在进行回写
     *      所以Properties管理配置文件的方式是：
     *      通过load方法加载到配置文件
     *      在通过store方法将写入的内容同步到配置文件中
     *      本质上还是IO的读写，使用的是Reader字符流和PrintWriter打印流
     *
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 创建Properties对象，用来管理一个配置文件
        Properties properties = new Properties();
        // load方法：加载此配置文件，交给Properties类来管理
        properties.load(new FileReader("src/application.properties"));
        // list：将Properties类中管理的配置内容输出到指定的位置.通过打印流的方式
        // properties.list(System.out); // 输出到控制台
        // properties.list(new PrintWriter(new FileWriter("/Users/yuanhaiyang/Document/note.txt")));

        // 获取key对应的值
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.get("password"));

        properties.values().forEach(v -> System.out.println(v));

        // 这里是新增或者修改Properties对象中的属性，需要通过store才能写入到指定的文件中，本质是IO的写入
        properties.setProperty("table","oracle");
        properties.store(new FileWriter("src/application.properties"),null);

    }



    /**
     * 需求一：使用传统的方法读取application配置文件的中key value
     * @param args
     * @throws IOException
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/application.properties"));
//
//        String line = null;
//
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println("key="+line.split("=")[0] + " value=" + line.split("=")[1]);
//        }
//
//        bufferedReader.close();
//    }




}
