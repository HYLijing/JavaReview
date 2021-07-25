package com.review.io_.node;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 节点流和处理流（包装流）
 * 节点流：只能读取和写入特定数据源读写数据，叫做节点流，InputStream/OutputStream  FileReader/FileWriter
 * 读取字节文件：InputStream，FileReader
 * 读取数组：ByteArrayInputStream   CharArrayReader
 * 读取管道：PipedInputStream   PipedReader
 * <p>
 * <p>
 * 处理流：也叫做包装流，'连接'在已经存在的流之上（节点流或处理流），为程序提供更强大的读写功能
 * 本质还是节点流在操作，只是对节点流进行了包装，使用了修饰器设计模式
 * 缓冲流：BufferedInputStream/BufferedOutputStream    BufferedReader/BufferedWriter
 * 是对字节流/字符流的包装。然后使用了缓冲区，提高流效率。构造参数传入的类型就是包装流操作的类型
 * <p>
 * 转换流：InputStreamReader/OutputStreamWriter    他两都是字符流，也就是他们的属性中使用的是字符流
 * 转换流的目的主要是将字符流转换为字节流，这里是可以通过设定编码。
 * 一般字符流都是用来操作文本文件的，因此在写入文本的时候是有编码的，如果编码不同，会出现乱码。因此
 * 使用包转换流对字符流转换为自定编码的字节流进行文本的读写
 * <p>
 * 对象流：ObjectInputStream/ObjectOutputStream    都是字节流
 * 对 对象进行IO的读写，要求对象需要实现Serializable
 * Serializable是一个标记接口，底层告知这个是需要进行序列化和反序列化操作的。
 * <p>
 * <p>
 * <p>
 * 如BufferedReader BufferedWriter
 */
public class NodeIO {


    /**
     * BufferedReader 和 BufferedWriter 字符处理流
     * 关闭流只需要关闭当前外部流就好了
     * <p>
     * 案例：使用BufferedReader读取文件，并在控制台打印
     */
    @Test
    public void test1() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            String path = "/Users/yuanhaiyang/Document/note.txt";

            // 与元数据交互的属于节点流。得到当前文件的字符输入流-节点流
            Reader reader = new FileReader(path);

            // 参数说明：需要传入一个节点流
            bufferedReader = new BufferedReader(reader);

            int res = 0;
//            char[] buf = new char[8];
//            // 使用缓冲数组读取流中的内容
//            while ((res = bufferedReader.read(buf)) != -1) {
//                // 打印出缓冲数组中读取到的数据
//                System.out.println(new String( buf,0, res));
//            }

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            bufferedReader.close();
        }
    }

    /**
     * 案例二：使用BufferedWriter将 "Hello 袁海洋"写入到文件中
     */
    @Test
    public void test2() throws IOException {
        String path = "/Users/yuanhaiyang/Document/haiyang.txt";

        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
        }

        // 得到当前文件的字符输出流
        Writer writer = new FileWriter(path);

        // 创建包装流:需要传入实际操作流的对象
        BufferedWriter bw = new BufferedWriter(writer);

        bw.write("Hello 袁海洋");  // 字符流在写入的时候是按照UTF编码

        bw.close();
    }

    /**
     * 案例三：使用BufferedReader和BufferedWriter完成文本的copy
     * 注意文件编码
     * 这里的BufferedReader和BufferedWriter用来字符操作的，因此不能操作二进制文件，会出现问题。
     * 二进制文件可以使用BufferedInputStream 和 BufferedOutputStream
     */
    @Test
    public void test3() throws IOException {
//        String src = "/Users/yuanhaiyang/Document/mac中快捷键.xml";
//        String dest = "/Users/yuanhaiyang/macIdeal.xml";
        String src = "/Users/yuanhaiyang/Document/haiyang1.jpeg";
        String dest = "/Users/yuanhaiyang/Document/haiyang.jpeg";

//        File file = new File(dest);
//        if (!file.exists()) file.createNewFile();

        // 得到src的输入流。dest的输出流
        Reader reader = new FileReader(src);
        Writer writer = new FileWriter(dest);

        // 创建FileReader和FileWriter的处理流
        BufferedReader br = new BufferedReader(reader);
        BufferedWriter bw = new BufferedWriter(writer);

        String line = null;

        while ((line = br.readLine()) != null) {
            bw.write(line); // 这里是没有换行的
            bw.newLine();   // 写入一行
        }

        br.close();
        bw.close();
    }

    /**
     * 使用BufferedInputStream和BufferedOutputStream来实现图片的复制
     */
    @Test
    public void test4() throws IOException {
        String src = "/Users/yuanhaiyang/Document/haiyang.jpeg";
        String dest = "/Users/yuanhaiyang/Document/haiyang1.jpeg";

        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);

        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(os);

//        int len = 0;
        byte[] buf = new byte[1024];
        int len = 0;

        while ((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }

        bis.close();
        bos.close();

    }
}














