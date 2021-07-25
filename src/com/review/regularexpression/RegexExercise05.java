package com.review.regularexpression;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  对url进行解析
 *  https://www.sohu.com:8080/abc/index.html
 *  要求得到协议是什么？   http
 *  域名是什么           www.sohu.com
 *  端口是什么           8080
 *  文件名是什么          index.html
 */
public class RegexExercise05 {

    public static void main(String[] args) {

        String content = "https://www.sohu.com:8080/abc/index.html";

        // 分四组的方式，每组按照指定的规则进行正则校验
        String regex = "^(https|http)://([a-zA-Z.]+):(\\d+)([\\w.@#$%/]+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到整个字符串为URL："+matcher.group(0));
            System.out.println("第一组数据："+matcher.group(1));
            System.out.println("第二组数据："+matcher.group(2));
            System.out.println("第三组数据："+matcher.group(3));
            System.out.println("第四组数据："+matcher.group(4));
        }
    }

}
