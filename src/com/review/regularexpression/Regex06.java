package com.review.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 定位符
 *
 * ^	匹配输入字符串开始的位置。如果设置了 RegExp 对象的 Multiline 属性，^ 还会与 \n 或 \r 之后的位置匹配。
 * $	匹配输入字符串结尾的位置。如果设置了 RegExp 对象的 Multiline 属性，$ 还会与 \n 或 \r 之前的位置匹配。
 * \b	匹配一个单词边界，即字与空格间的位置。
 * \B	非单词边界匹配。
 *
 *
 * 不能将限定符与定位符一起使用。由于在紧靠换行或者单词边界的前面或后面不能有一个以上位置，因此不允许诸如
 * ^* 之类的表达式。
 *
 * 定位符不能出现多个限定符的概念，否则冲突
 */
public class Regex06 {

    public static void main(String[] args) {
        // 1. ^ 字符串开始位置开始
        // String content = "nihao a A111\n112";
        String content = "Chapter Chap Chaoor Chte";

        // 默认从输入字符串的开始位置匹配
        // Pattern pattern = Pattern.compile("^\\w");

        // 设定类Multiline 属性，可以从\n \r开始匹配
        // Pattern pattern = Pattern.compile("^\\w", Pattern.MULTILINE);   // 匹配的结果为 n 1


        // 2，$ 从输入字符串末尾开始匹配
        // 从输入字符串末尾匹配，得到12
        // Pattern pattern = Pattern.compile("\\w{2}$");

        // Pattern pattern = Pattern.compile("\\w{2}$", Pattern.MULTILINE);

        // 3, \\b 匹配单词边界，即，空格和单词之间
        // \\b的位置非常重要，出现在前面，就是向前匹配，出现在后面，就是向后匹配
        // Pattern pattern = Pattern.compile("\\bCha");
        // 可以简单的这样理解 \\b就是字符断档的位置。因为单词中不可能存在不连续的字符
        // Pattern pattern = Pattern.compile("[e|r|er]\\b");

        // 4, \\B 就表示匹配在单词中的。也就是表示不能是一个不连续的位置。\\B就相当于必须是一个字母
        // 例如 \\Bllo 可以匹配 Hello 但是不能匹配 llower
        Pattern pattern = Pattern.compile("te\\B"); // 只能匹配 Chapter 不能匹配 Chte


        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到："+matcher.group());
        }
    }
}
