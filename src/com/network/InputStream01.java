package com.network;

import sun.net.TelnetInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class InputStream01 {

    public static void main(String[] args) throws IOException {

        PrintStream print = new PrintStream(System.out);

        // 标准输出流输出到文件中
//        print.write("测试数据".getBytes(StandardCharsets.UTF_8));

        print.println(99);
    }

}
