package com.base.inet;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {


    public static void main(String[] args) throws IOException {

        if (args.length > 0) {

            URL url = new URL(args[0]);

            URLConnection uc = url.openConnection();
            InputStream is = uc.getInputStream();

            Reader reader = new InputStreamReader(is);

            int c;
            while ((c = reader.read()) != -1) {
                System.out.println((char) c);
            }
        }

    }
}
