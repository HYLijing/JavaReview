package com.base.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * 提供单文件的HTTP服务器
 */
public class SingleFileHttpServer {

    private static final Logger logger = Logger.getLogger("SingleFileHttpServer");

    private final byte[] content;
    private final byte[] header;
    private final int port;
    private final String encoding;


    public SingleFileHttpServer(String data, String encoding,
                                String mineType, int port) throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, mineType, port);
    }

    public SingleFileHttpServer(byte[] data, String encoding, String mineType, int port) {
        this.content = data;
        this.port = port;
        this.encoding = encoding;

        String header = "HTTP/1.0 200 OK\r\n" +
                "Server: OneFile 2.0\r\n" +
                "Content-length: " + this.content.length + "\r\n" +
                "Content-type: " + mineType + "; charset=" + encoding + "\r\n\r\n";

        this.header = header.getBytes(StandardCharsets.UTF_8);
    }

    public void start() {

        ExecutorService pool = Executors.newFixedThreadPool(100);

        // 会自动关闭连接
        try (ServerSocket server = new ServerSocket(this.port)) {

            logger.info("Accepting connections on port: " + server.getLocalPort());
            logger.info("Data to sent:");
            logger.info(new String(this.content, encoding));

            // 启动服务
            while (true) {
                Socket connection = server.accept();

                // 具体交互的连接任务交给了pool线程池去实现，也就是在call方法中
                pool.submit(new HttpHandler(connection));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * Callable中范型指定了这个线程返回值类型
     */
    private class HttpHandler implements Callable<Void> {

        private final Socket socket;

        public HttpHandler(Socket socket) {
            this.socket = socket;
        }


        @Override
        public Void call() {
            try {
                // 拿到输出流
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

                StringBuilder request = new StringBuilder(80);

                while (true) {
                    // 这是一个字节一个字节的读
                    int c = bis.read();

                    if (c == '\r' || c == '\n' || c == -1) {
                        // 终止当前循环
                        break;
                    }

                    // 不支持中文
                    request.append((char) c);
                }

                if (request.toString().indexOf("HTTP/") != -1) {
                    bos.write(header);
                }
                bos.write(content);
                bos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }


    public static void main(String[] args) {

        int port;
        try {
            port = Integer.parseInt(args[1]);

            if (port < 1 || port > 65535) port = 80;
        } catch (Exception e) {
            port = 80;
        }

        String encoding = "UTF-8";
        if (args.length > 2) encoding = args[2];

        try {
            Path path = Paths.get(args[0]);
            byte[] data = Files.readAllBytes(path);
            String contentType = URLConnection.getFileNameMap().getContentTypeFor(args[0]);

            SingleFileHttpServer server = new SingleFileHttpServer(data, encoding, contentType, port);

            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
