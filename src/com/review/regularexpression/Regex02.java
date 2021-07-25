package com.review.regularexpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则的基本使用
 * 第一部分：普通字符
 */
public class Regex02 {

    public static void main(String[] args) {
        String content = "abcAcaac BC_192346%%###@@@$$$))((";

        /**
         * 第一部分：普通字符
         */
        // 1,[ABC] 匹配ABC中任一字符，只能匹配一个。默认是区分大小写的。底层使用ASCII码匹配
        // Pattern pattern = Pattern.compile("[ABC]");

        // 2,[^ABC] 匹配非A B C的字符
        //Pattern pattern = Pattern.compile("[^ABC]");

        // 3,[A-Z]表示 表示A到Z直接的一个字符
        // Pattern pattern = Pattern.compile("[A-Z]");

        // 4,[^A-Z]表示 表示非A到Z直接的一个字符
        // Pattern pattern = Pattern.compile("[^A-Z]");

        // 5，\\s 匹配所有空白符，包括换行符
        // Pattern pattern = Pattern.compile("\\s");

        // 6，\\S 匹配所有非空白字符，不包括换行符
        // Pattern pattern = Pattern.compile("\\S");

        // 7,\\w 匹配 字母，数字和下划线_
        // Pattern pattern = Pattern.compile("\\w");

        // 8,\\W 匹配非字母，非数字，非下划线_
         Pattern pattern = Pattern.compile("\\W");

        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("匹配到："+matcher.group(0));
        }
    }

}
