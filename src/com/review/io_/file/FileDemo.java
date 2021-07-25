package com.review.io_.file;


import java.io.File;
import java.io.IOException;

/**
 * IO学习之文件
 * 1，文件在程序中是以流的形式来操作
 * 这里需要明白一个基本：所有输入和输出都是对内存而言的。
 * 因此，从内存的二进制数据到硬件中叫做输出流，从源文件通过IO读入到内存中叫做输入流。
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
        /**
         * 案例一：请在：/Users/yuanhaiyang/Document路径下创建文本，使用三种方式
         */
        // 第一方式
        //File file = new File("/Users/yuanhaiyang/Document/test1.txt");
        // 第二方式 在父目录下创建自文件
        // File file = new File("/Users/yuanhaiyang/Document", "test2.txt");
        // 第三方式 使用File对象表示文件的父目录
        File file = new File(new File("/Users/yuanhaiyang/Document"),"test3.txt");
//        file.createNewFile();

        /**
         * 案例二  获取文件的相关信息
         */
        // 获取文件名称，file是否可以是一个文件夹？ 可以。目录本质还是文件，只是一种特殊的文件
//        System.out.println(file.getName());
//        // 获取绝对路径 就是文件的全路径名
//        System.out.println(file.getAbsoluteFile());
//        // 获取文件的父目录
//        System.out.println(file.getParent());
//        // 查看文件长度.这里的文件长度指的什么概念？ 就是文件的大小。byte大小，一个字符一个byte
//        System.out.println(file.length());
//        // 判断是否为文件。从这里可以看出，File也可以表示文件夹
//        System.out.println(file.isFile());
//        // 判断是否为文件
//        System.out.println(file.isDirectory());


        /**
         * 案例三：目录的操作和文件的删除
         */
        if (file.exists())  // 判断文件是否存在，存在就删除
        file.delete();  // 删除当前这个文件

        // 创建一个文件夹
        File dir = new File("/Users/yuanhaiyang/Document/first");
        if (dir.exists()) { // 当前文件夹如果存在，就删除，然后创建
            dir.delete();
        }
        dir.mkdir();

        // 创建多级文件夹
        File multiDir = new File("/Users/yuanhaiyang/Document/multi/second");
        if (multiDir.exists()) {
            System.out.println("已经存在");
        } else {
            multiDir.mkdirs();
        }


    }

}
