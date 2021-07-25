package com.review.regularexpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 第二部分：非打印字符
 */
public class Regex03 {

    public static void main(String[] args) {
        int i = 1;
        //  \cx	匹配由x指明的控制字符。例如， \cM 匹配一个 Control-M 或回车符。x 的值必须为 A-Z 或 a-z 之一。否则，将 c 视为一个原义的 'c' 字符。
        //\f	匹配一个换页符。等价于 \x0c 和 \cL。
        //\n	匹配一个换行符。等价于 \x0a 和 \cJ。
        //\r	匹配一个回车符。等价于 \x0d 和 \cM。
        //\s	匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [\f\n\r\t\v]。注意 Unicode 正则表达式会匹配全角空格符。
        //\S	匹配任何非空白字符。等价于 [^\f\n\r\t\v]。
        //\t	匹配一个制表符。等价于 \x09 和 \cI。
        //\v	匹配一个垂直制表符。等价于 \x0b 和 \cK。


        // 主要看\n \r \s \S \t
        String content = "abc   你好 ";
        //
        // \\s 匹配任何空白字符：包括空格 \n,制表符 \t,换页符 \f
//        Pattern pattern = Pattern.compile("\\s");

        // \\S 匹配任何非空白字符， 包括非空格，非制表符，非换页符
        Pattern pattern = Pattern.compile("\\S");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到第"+(i++) + "个为：" + matcher.group(0));
        }


    }

}
