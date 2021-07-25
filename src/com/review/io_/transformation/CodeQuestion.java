package com.review.io_.transformation;


import java.io.*;
import java.nio.charset.CharsetEncoder;

/**
 * 转换流
 * 先看一个问题：
 * 1，使用字节输入流，从文本文件中读取中文汉字。出现了乱码
 * 2，使用包装的字符输入流来读取，看是否乱码。
 * <p>
 * 如果想要设定编码，一定要在字节流的操作之上，因为文件的存储转换都是一字节为单位的。
 *
 * 从下面代码可以总结：
 * 1，InputStreamReader：Reader的子类，可以将InputStream（字节流）包装成（转换）Reader（字符流）
 * 2，OutputStreamWriter同理
 * 3，当处理文本数据时，如果字符流效率更好，并且可以有效解决中文乱码问题，建议将字节流转换字符流
 * 4，使用时可以指定文件编码
 */
public class CodeQuestion {

    /**
     * 案例三：使用转换流，在hello.txt中写入"你好，袁海洋"，并使用转换流读取，保证乱码！
     *
     *  也可以使用BufferedReader/BufferedWriter来包装转换流
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String path = "/Users/yuanhaiyang/Document/hello.txt";

        // 创建输入转换流,设定编码
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), "GBK");
//
//        osw.write("你好，袁海洋");    // 使用GBK写入中文
        //        osw.close();


        // 使用转换流读取中文
//        InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"GBK");
//        int len = 0;
//        char[] buf = new char[1024];
//
//        while ((len = isr.read(buf)) != -1) {
//            System.out.println(new String(buf,0,len));
//        }
//
//        isr.close();

        // 使用缓冲流来包装转换流（转换流本质是字符流）
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }


    /**
     * 案例二：使用转换流InputStreamReader读取文件中的中文。
     *
     * 自己理解：InputStreamReader 构造参数中传入的是InputStream（字节流），但是工作的确实字符流。
     * 因此他实现的功能是将字节流转换为字符流的过程。并设定了转换过程中使用的编码方式
     *
     * 也就是不管是字符流还是字节流，本质都是字节流在工作
     *
     * @param args
     * @throws IOException
     */
//    public static void main(String[] args) throws IOException {
//        String path = "/Users/yuanhaiyang/Document/object.txt";
//
//        // 使用转换流.也是包装流，不用想的，包装的肯定是字节流，因为需要设定字符编码
//        // 什么叫字符编码：就是字节按照指定的编码规范转换为字节的方式
//        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "latin1");
//
//        // 必须按照字节的方式来读取
//        int len = 0;
//        char[] buf = new char[1024];
//
//        while ((len = isr.read(buf)) != -1) {
//            System.out.println(new java.lang.String(buf,0,len));
//        }
//
//        isr.close();
//    }


    /**
     * 案例一：乱码的展示
     * 由于我的mac电脑创建文件默认就是UTF-8的编码方式，因此和Reader的读取编码相同。
     */
//    public static void main(String[] args) throws IOException {
//        String path = "/Users/yuanhaiyang/Document/object.txt";
//
////        FileInputStream fis = new FileInputStream(path);
////
////        int len = 0;
////        byte[] buf = new byte[8];
////        // 使用缓冲区进行读取
////        while ((len = fis.read(buf)) != -1) {
////            System.out.print(new String(buf,0,len));  // 乱码
////        }
////
////        fis.close();
//
//        // 使用包装的字符输入流。本质还是FileReader在工作
//        BufferedReader br = new BufferedReader(new FileReader(path));
//
//        String line = null;
//
//        // 默认情况下，读取文件是按照UTF-8的编码读取.因为文本是GBK的编码，所以使用UTF-8的方式读取文件就会出现乱码。
//        // 此时就需要使用转换流
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//
//        br.close();
//    }

}
