package com.review.regularexpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 反向引用 ： 可以通过 \\n 取出 对应匹配到分组的数据
 * 从之前底层原码中可知：
 * 如果使用()小括号，表示新建一个分组，那么这个分组中记录的数据就是对应匹配到的元素，
 * 可以通过mathch.group(n)取出
 *
 *  如果创建来分组，会将匹配到的分组的信息放入到对应的分组中
 *
 *  捕获的概念就是我们所谓的分组，再通过反向引用可以拿到我们捕获的内容
 *
 *  结合上面一张说的非捕获 ?:  ?=  ?!这三个表示非捕获
 *  ?: 他主要的作用就是指定这个括号为非分组
 *
 *
 */
public class Regex08 {

    public static void main(String[] args) {
        String str = "Is is the cost of of gasoline going up up";

        // Pattern pattern = Pattern.compile("\\b([a-z]+) \\1\\b");
        Pattern pattern = Pattern.compile("(?:\\w+) (\\w+)");


        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            //System.out.println(matcher.group(2));
        }

    }
}
