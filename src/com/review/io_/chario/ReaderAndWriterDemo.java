package com.review.io_.chario;


import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.PAData;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Path;

/**
 * 字符流：
 *
 *
 */
public class ReaderAndWriterDemo {

    String path1 = "/Users/yuanhaiyang/Document/副本数据魔方系统修改点_20210514 20210514165310.xlsx";
    String path = "/Users/yuanhaiyang/Document/hello.txt";

    /**
     * FileReader  字符输入流
     *
     * 1，read() 每次读取一个字符，包括中文或者英文字符，返回该字符，如果到文本末尾，那么就返回-1
     * 2，read(char[]):批量读取多个字符到数组中，返回读取到的字符个数，到文本末尾返回-1
     *
     * 案例：使用 FileReader 从 story.txt 读取内容，并显示
     */
    @Test
    public void test1() throws IOException {
        FileReader reader = null;
        try {
            // 创建字符流
             reader = new FileReader(path);

            System.out.println(reader.getEncoding());

            // 读取reader中的文件内容
            int res = 0;
//            while ((res = reader.read()) != -1) {   // 单个字符读取文件
//
//                System.out.print((char) res);    // 这里读出来的是一个char
//            }

            char[] buf = new char[8];

            // 使用缓冲区读取文件
            while ((res = reader.read(buf)) != -1) {    // res相当读取都到的字符个数，在buf中的个数

                String chars = new String(buf,0,res);

                System.out.println(chars);
            }



        }finally {
            reader.close();
        }
    }


    /**
     *
     * Writer：字符输出流，每次写入一个字符的方式，字符按照ascii码匹配
     * 案例：2) 使用 FileWriter 将 “风雨之后，定见彩虹” 写入到 note.txt 文件中, 注意细节.
     *
     * 使用FileWriter
     *
     */
    @Test
    public void test2() {

        Writer writer = null;
        String text = "/Users/yuanhaiyang/Document/note.txt";

        String word = "风雨之后，定见彩虹";

        try {

            File file = new File(text);

            if (!file.exists())
                file.createNewFile();

            // 1，需要判断当前文件是否存在，不存在的会是null
            writer = new FileWriter(text);

            // writer.write('A');    // 1,这里是写入单个字符
            // 2,写入一个字符数组
            // writer.write(word.toCharArray());
            // 3,写入带便宜的字符数组
            // writer.write(word.toCharArray(),5,4);

            // 4，直接写入字符串。字符传的本质就是char数组
            // writer.write("我爱你");

            // 5，字符串偏移量。本质形同
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
