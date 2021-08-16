package com.base.inet;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class SocketDemo02 {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);

            InputStream is = socket.getInputStream();

            // 这里是一个字节一个字节的读入到内存中
            StringBuffer time = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "ASCII"));

            String line;  // 读出来的一个ASCII码值    如果是汉字不能使用这个方法
            while ( (line = reader.readLine()) != null) {
                time.append(line);
            }

            System.out.println(time.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
