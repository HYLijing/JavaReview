package com.base.inet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerSocketDemo01 {


    /**
     * ServerSocket是服务端用来监听指定段的Socket
     * 它是等他客户端socket过来连接。
     * 没建立一次连接就会 accept方法就会创建一个发向给客户端的普通Socket。用来做数据的传输
     */
    public static void main(String[] args) {

        // 使用java7中的try with resource

        // 监听本地的8888端口
        try (ServerSocket serverSocket = new ServerSocket(8888)) {

            while (true) {
                // 作为服务器始终监听这个serverSocket。等待连接
                // 如果被监听到，就会创建这个Socket。这个Socket完成以后会被销毁。
                // 但是作为Http1.1 SFP等协议，他们是不会为一个请求销毁一个Socket
                try (Socket socket = serverSocket.accept()) {
                    OutputStream os = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(os);

                    Date now = new Date();
                    writer.write(now.toString());
                    writer.flush(); // 不要缓存。立马写出
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
