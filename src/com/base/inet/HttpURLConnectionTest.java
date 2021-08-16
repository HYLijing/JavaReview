package com.base.inet;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpURLConnectionTest {


    public static void main(String[] args) throws IOException {

        URL url = new URL("http://localhost:8080/test/f1");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String contentType = connection.getContentType();
        Map<String, List<String>> headerFields = connection.getHeaderFields();

        System.out.println(contentType);
        System.out.println("==========");
        System.out.println(headerFields);

        System.out.println(connection.getRequestMethod());
        System.out.println(connection.getResponseCode());
        long lastModified = connection.getLastModified();
        System.out.println(lastModified);

        InputStream is = connection.getInputStream();

        Reader reader = new InputStreamReader(is);

        int c;
        while ((c = reader.read()) != -1 ){
            System.out.print((char) c);
        }

    }
}
