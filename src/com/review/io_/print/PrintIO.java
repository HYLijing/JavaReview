package com.review.io_.print;


import java.io.*;

/**
 * 打印流：打印流只有输出流
 * PrintStream：字节打印流
 * PrintWriter：字符打印流
 *
 */
public class PrintIO {

    /**
     * 案例一：打印流的使用
     * 1，构造参数中指定字节打印流输出的位置，可以是文件，也可以是控制台，PrintStream必须要指定输出的位置
     * 2，如果想要在控制台输出，那么需要使用标准输出流也就是System.out
     * 3，
     *
     * @param args
     * @throws FileNotFoundException
     */
//    public static void main(String[] args) throws FileNotFoundException {
//        String path = "/Users/yuanhaiyang/Document/note.txt";
//        // // 这个就是相当于指定输出的路径
//        PrintStream printStream = new PrintStream(path);
//        //PrintStream printStream = System.out;
//        printStream.println("你好");    // 标准输出流默认是输出的控制台
//        printStream.close();
//
//    }


    /**
     * 案例二：使用字符打印流 PrintWriter直接操作字符，默认是输出到控制台
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {    // 只能向文件中打印
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("/Users/yuanhaiyang/Document/note.txt")));

        writer.println("nihao");    // 将这个文字写入到文件中
        writer.close();
    }
}
