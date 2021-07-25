package com.review.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 限定符
 *
 * 6种限定符
 *
 *  * + ?
 *  {1,} {1,3} {1}
 *
 *
 *  * 和 + 限定符都是贪婪的，因为它们会尽可能多的匹配文字，只有在它们的后面加上一个 ? 就可以实现非贪婪或最小匹配。
 *
 *  主要要记住6个限定符和 贪婪到非贪婪的转换方式
 */
public class Regex05 {

    public static void main(String[] args) {

        String content = "<h1>RUNOOB-菜鸟教程</h1>";

        // 限定符作用在单个字符上
        // Pattern pattern = Pattern.compile("a{1,3}b");   // 表示ab aab aaab

        // Pattern pattern = Pattern.compile("a?b");   // 表示ab或者b
        // Pattern pattern = Pattern.compile("a+b");   // 表示ab aab aaab ...
        // Pattern pattern = Pattern.compile("a*b");      // 表示b ab aab ...
        // Pattern pattern = Pattern.compile("[1-9][0-9]*");   // 表示一个正整数
        // Pattern pattern = Pattern.compile("[0-9]{1,2}");    // 表示匹配一位数或者两位数


        // 关于贪婪限定符 + * 的使用
        // Pattern pattern = Pattern.compile("<h1>.*</h1>"); // 会匹配到所有的内容

        // 匹配整个标签的内容。可以使用如下的方式
        // Pattern pattern = Pattern.compile("<.*>");  // 将会匹配到整个标签内容，因为它是贪婪匹配。如果想限定为非贪婪匹配的，需要在限定符后加上？
        // Pattern pattern = Pattern.compile("<.*?>"); // 非贪婪的匹配方式。匹配两个标签  <h1> </h1>

        // 匹配整个h1标签
        // Pattern pattern = Pattern.compile("<\\w*>");    // \\w只能匹配数字，字符，和下划线。 因此只能匹配到一个结果 <h1>  不能匹配</h1>

        // 如果想取出标签中的内容。需要通过分组的方式
        Pattern pattern = Pattern.compile("<h1>(\\S+)</h1>");



        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到："+matcher.group(0));
            System.out.println(matcher.group(1));   // 表示第一组的匹配到的元素
//            System.out.println(matcher.group(2));   // 第二组匹配到的元素
        }

    }
}
