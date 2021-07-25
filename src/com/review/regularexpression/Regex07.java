package com.review.regularexpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择
 * 用圆括号 () 将所有选择项括起来，相邻的选择项之间用 | 分隔。
 *
 *
 */
public class Regex07 {

    public static void main(String[] args) {
        String content = "123456java122javascript1341springjavaboot23987java123";

        // 1 用圆括号 () 将所有选择项括起来，相邻的选择项之间用 | 分隔。
        // 说明：+ 只作用在a-z上
        // Pattern pattern = Pattern.compile("[0-9|a][a-z]+");
        // 加上分组的概念
        // 这里就分了两组
        // Pattern pattern = Pattern.compile("([0-9|a])([a-z]+)");

        // 但用圆括号会有一个副作用，使相关的匹配会被缓存，此时可用 ?: 放在第一个选项前来消除这种副作用。
        // Pattern pattern = Pattern.compile("(?:[0-9|a])([a-z]+)");

        // 但用圆括号会有一个副作用，使相关的匹配会被缓存，此时可用 ?: 放在第一个选项前来消除这种副作用。
        // 其中 ?: 是非捕获元之一，还有两个非捕获元是 ?= 和 ?!，这两个还有更多的含义，前者为正向预查，
        // 在任何开始匹配圆括号内的正则表达式模式的位置来匹配搜索字符串，后者为负向预查，在任何开始不匹配
        // 该正则表达式模式的位置来匹配搜索字符串。

        //2， 下面列举 ?=、?<=、?!、?<! 的使用区别

        // 2.1 ?= 在任何开始匹配 圆括号内 的正则表达式的位置来匹配搜索字符串
        // 使用：?= 后面跟上一个表达式或者一个组的表达式
        //Pattern pattern = Pattern.compile("java(?=[\\d]+3)");

        // 2.2 (?<=exp2)exp1：查找 exp2 后面的 exp1。
        // (?<=exp2)exp1    包含?<=的表达式必须在一个小括号内
        // Pattern pattern = Pattern.compile("(?<=[0-9][0-9][0-9][0-9])java");

        // 2.3 exp1(?!exp2)：查找后面不是 exp2 的 exp1
        // 查找的是java，在写下小括号内的捕获元素
        // Pattern pattern = Pattern.compile("java(?![\\d]+)");    // 捕获后面不是数字的java

        // 2.4 (?<!exp2)exp1：查找前面不是 exp2 的 exp1。
        // Pattern pattern = Pattern.compile("(?<![[\\d]+])java");    // 捕获前面不是数字的java

        // 总结：
        // 后面是某个条件的匹配   exp1(?=exp2)    匹配后面是exp2的exp1
        // 前面是某个条件的匹配   (?<=exp2)exp1   匹配前面是exp2的exp1,箭头指向条件在待匹配的方向
        // 后面不是某个条件的匹配  exp1(?!exp2)    匹配后面不是exp2的exp1
        // 前面不是某个条件的匹配  (?<!exp2)exp1   匹配前面不是exp2的exp1

        // Pattern pattern = Pattern.compile("(?<=[a-zA-Z])java");
        // Pattern pattern = Pattern.compile("java(?!123)");   // 后面不是123的java
        Pattern pattern = Pattern.compile("(?<![\\d])java");

        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group());
        // System.out.println(matcher.group(1));
        }

    }
}
