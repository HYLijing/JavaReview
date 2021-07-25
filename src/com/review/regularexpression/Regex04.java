package com.review.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 第三部分：特殊字符
 */
public class Regex04 {

    public static void main(String[] args) {
    /*
     $	匹配输入字符串的结尾位置。如果设置了 RegExp 对象的 Multiline 属性，则 $ 也匹配 '\n' 或 '\r'。要匹配 $ 字符本身，请使用 \$。
    ( )	标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)。
    *	匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*。
    +	匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+。
    .	匹配除换行符 \n 之外的任何单字符。要匹配 . ，请使用 \. 。
    [	标记一个中括号表达式的开始。要匹配 [，请使用 \[。
    ?	匹配前面的子表达式零次或一次，或指明一个非贪婪限定符。要匹配 ? 字符，请使用 \?。
    \	将下一个字符标记为或特殊字符、或原义字符、或向后引用、或八进制转义符。例如， 'n' 匹配字符 'n'。'\n' 匹配换行符。序列 '\\' 匹配 "\"，而 '\(' 则匹配 "("。
    ^	匹配输入字符串的开始位置，除非在方括号表达式中使用，当该符号在方括号表达式中使用时，表示不接受该方括号表达式中的字符集合。要匹配 ^ 字符本身，请使用 \^。
    {	标记限定符表达式的开始。要匹配 {，请使用 \{。
    |	指明两项之间的一个选择。要匹配 |，请使用 \|。
     */

        String content = "absdfsadf21\f34312#\t%#@$%asd\nfda\rs@#b$#UK UIku1";
        // 1,$ 匹配输入字符串的结尾位置。从结尾位置向前匹配
        // 那么结尾：包含字符串本身的结尾，也包括\n \r
        //Pattern pattern = Pattern.compile("[a-zA-Z]$");
        
        // 2, ( )	标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)。用于比爱是分组
        // Pattern pattern = Pattern.compile("([a-d])([c-e])");

        // 3 * 表示匹配0次或者多次 相当于{0,}
        // Pattern pattern = Pattern.compile("[a-z]*");  // 匹配0个或多个字符.为什么会匹配到空呢？为匹配上的，相当于0次，因此也是会被匹配到的

        // 4，+ 匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+。
        // Pattern pattern = Pattern.compile("[a-z]+");    // 表示a-z出现一次或者多次的组合匹配

        // 5，.	匹配除换行符 \n，\r回车符 之外的任何单字符。要匹配 . ，请使用 \.
        // Pattern pattern = Pattern.compile(".+");   // 匹配换行符之外的任意字符（贪婪匹配，因此匹配的结果可以这样理解：只有到换行符\n才会出现得到一个结果，否则一直匹配完字符串）

        // 6 [ 标记一个中括号表达式的开始。要匹配 [，请使用 \[。
        // [ ] 和 ( )一起理解，[ ]表示一个个表示。( ) 表示表达式的组合
        // Pattern pattern = Pattern.compile("[a-z](\\d\\d)");    // 这里就有一个分组\\d ，也就是两个表达式的组合，表示一个消协字母加上一个数字

        // 7  ? 匹配前面的子表达式零次或一次，或指明一个非贪婪限定符。要匹配 ? 字符，请使用 \?。
        // Pattern pattern = Pattern.compile("^\\d?");    // 表示从输入字符串的后面匹配出现两个数字一次或者没有出现。肯定会被匹配上的

        // 8 ^	匹配输入字符串的开始位置，除非在方括号表达式中使用，当该符号在方括号表达式中使用时，表示不接受该方括号表达式中的字符集合。要匹配 ^ 字符本身，请使用 \^
        // 总结：^ 在方括号中表示否定的意思，取反的意思
        // 否则就是表达匹配字符串开始的位置
        // Pattern pattern = Pattern.compile("^[a-zA-Z]+");    // 从字符串的开始位置开始匹配，最少出现一个字母的贪婪匹配
        // 如果放在[]内，表示取反的意思
        // Pattern pattern = Pattern.compile("[^a-zA-Z]+");    // 匹配整个字符串中，最少出现一次非字母的贪婪贪婪匹配。很多个结果
        // Pattern pattern = Pattern.compile("^[^a-zA-Z]+");   // 从字符串开始位置匹配，因此只能得到一个结果或者没有结果
        // Pattern pattern = Pattern.compile("^[^a-zA-Z]?");   // 这里肯定是一次结果，要么是匹配到，要么是每匹配到

        // 9 {	标记限定符表达式的开始。要匹配 {，请使用 \{。
        // 什么叫限定符：表示范围的
        // 例如：
        // {1,3} 表示最少一次，最多三次
        // {3} 表示必须出现3次
        // {3,} 表示最少出现3次
        // * 相当于 {0,}
        // + 相当于 {1,}
        // ？ 相当于 {0,1}
        // 限定符作用在表达式上
        // Pattern pattern = Pattern.compile("[a-zA-Z]{3}"); // 匹配出现三次以上的字母组合。这里是贪婪匹配，因此匹配按照最多个数匹配

        // 限定符作用在单个字符上
        // Pattern pattern = Pattern.compile("a{1,3}b");   // 表示ab aab aaab

        // Pattern pattern = Pattern.compile("a?b");   // 表示ab或者b
        // Pattern pattern = Pattern.compile("a+b");   // 表示ab aab aaab ...
         Pattern pattern = Pattern.compile("a*b");      // 表示b ab aab ...

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到："+matcher.group(0));
//            System.out.println(matcher.group(1));   // 表示第一组的匹配到的元素
//            System.out.println(matcher.group(2));   // 第二组匹配到的元素
        }


    }

}
