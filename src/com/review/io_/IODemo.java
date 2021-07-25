package com.review.io_;

import java.io.*;

/**
 * IO原理和分类
 * 按数据操作单位不同：字节流二进制文件（8bit）与字符流文本文件（补充：1byte = 8bit）
 * 按数据的流向不同：输入流和输出流
 * 按流的角色不同：节点流，处理流/包装流
 * <p>
 * 字节流             字符流
 * 输入流     InputStream         Reader
 * 输出流     OutPutStream        Writer
 */
public class IODemo {

    public static void main(String[] args) throws IOException {
        /**
         * FileInputStream用于读取文件的输入流
         *
         * 案例一：使用FileInputStream读取文件，并将文件中的内容在控制台打印
         */
//        String text = "/Users/yuanhaiyang/Document/hello.txt";
//        int res = 0;
//        InputStream inputStream = null;
//        try {
//            // 创建字节输入流
//            inputStream = new FileInputStream(text);
//            // 读取字节流到字节数组中去. 这里是一个字节一个字节的读
//            while ((res = inputStream.read()) != -1) {
//                System.out.print((char) res);
//            }
//
//        } finally {
//            inputStream.close();
//        }


        /**
         * 明白一个知识：计算机存储数据都是以byte字节的方式，计算机无法通过bit来识别数据的。
         * 但是计算机在传输数据的时候是按照bit来传输的，然后8个bit组成一个byte，得到计算机存储数据的最小单位byte
         * 在不同的字符编码中，字符可能占有的byte是不同的。比如utf8编码就是中英文都占用两个byte
         *
         * 字符编码也就是一种将二进制的数字转换为中英文字符的规范（例如之前所学的赫夫曼编码：赫夫曼编码的实质就是二叉树的应用）
         *
         * 字符缓冲的区的读取方式，提高内存和硬件的交互次数，提高效率。
         * 将字节输入流读入到byte[]数组中，当作缓冲区。等缓冲区满了在做下步操作
         *
         * 这里还是要区分字节流的本质，读出来的字节流后可以放入到byte数组中。计算机中所有的数据都可以使用byte字节流表示
         */
//        String path = "/Users/yuanhaiyang/Document/hello.txt";
//        byte[] buf = new byte[8];   // 字节缓冲区。也就是将字节读入到这个字节缓冲区后，在向外输出
//        InputStream inputStream = null;
//        int count = 0;
//
//        try {
//            inputStream = new FileInputStream(path);
//            while ((count = inputStream.read(buf)) != -1) {
//                // 读的数据在buf里
//                System.out.println(new String(buf,0,count));
//            }
//
//        } finally {
//            inputStream.close();
//        }

        /**
         * 案例三 FileOutPutStream是字节输出流的子类。专门用来操作文件的输出
         *
         * 请使用 FileOutputStream 在 a.txt 文件，中写入 “hello，world”.
         * , 如果文件不存在，会创建 文件(注意：前提是目录已经存在.)
         *
         * 再次总结：
         * 在计算机中，不管是在内存中，还是在硬盘中，操作文件或者其他任何文件（图片，音频，电影）本质都是操作字节数组。
         * 因为在计算机中的是以byte字节来做为存储数据的方式。
         * 所以我们通过IO流读取或者写入文件的时候，都是操作byte字节的方式。
         *
         * 个人理解：
         * 在java中char字符数组，应该是按照指定的编码顺序给我们的字符和字节做好流对应关系。因此在java中char本质也可以看作是一个数子，
         * 也就是对应到二进制的数子。
         */
//        String path = "/Users/yuanhaiyang/Document/output.txt";
//
//        File file = new File(path);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        OutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//            byte[] bytes = "hello outputStream".getBytes();
//            // outputStream.write(bytes);  // 这就相当于直接写入一个字节数组，一个字节对应一个字符
//
////            outputStream.write(122);    // 写入一个数字，相当于
//
//
//            outputStream.write(bytes, 1, bytes.length-1); // 类似String的构造函数，在byte数组中选择起始的位置，和终点的文职
//        } finally {
//            outputStream.close();
//        }


        /**
         * 案例三：完成图片的copy
         *  copy 到Document下
         */

        String path = "/Users/yuanhaiyang/haiyang1.jpeg";

        String dest = "/Users/yuanhaiyang/Document/haying.jpeg";

        // 需要输入流将文件读入到内存中
        InputStream inputStream = null;
        OutputStream outputStream = null;

        int res = 0;

        byte[] buf = new byte[8];


        try {
            // 得到该图片的文件输入流
            inputStream = new FileInputStream(path);
            outputStream = new FileOutputStream(dest);

            // 使用缓冲区读，提高操作写入的效率，不然的话向硬盘中写入的时候，只能一个字节一个字节的写入
            while ((res = inputStream.read(buf)) != - 1) {
                // 这里将读取的文件写入到指定的文件中
                outputStream.write(buf,0,res);  // 这里通过写入数组的方式，因为我们读到的byte数据在buf数组中
            }


        } finally {
            inputStream.close();
            outputStream.close();
        }


    }
}















