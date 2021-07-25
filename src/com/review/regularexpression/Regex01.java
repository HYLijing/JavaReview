package com.review.regularexpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的原码追踪
 *
 */
public class Regex01 {

    /**
     * 匹配4个数字，实现原理的理解
     * @param args
     */
    public static void main(String[] args) {

        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。" +
                "2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。" +
                "2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），" +
                "代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、" +
                "格式化I/O及可变参数。";

        // Pattern pattern = Pattern.compile("\\d{4}");
        Pattern pattern = Pattern.compile("(\\d\\d)(\\d\\d)");

        Matcher matcher = pattern.matcher(content); // 对字符串进行匹配

        /**
         * 对于未分组的匹配维护而言：
         * 对find方法的维护：一次匹配一次取值的方式维护在groups数组中的
         * groups[0]记录类匹配开的字符角标
         * groups[1]记录类匹配字符结束的角标 加1
         *
         * matcher.group(0)方法调用的是substring方法：getSubSequence(groups[group * 2], groups[group * 2 + 1])
         * 传入的是0得到的值正好是 开始角标和结束角标记录的位置：group[0] - group[1]  （substring解决字符串是前闭后开）
         *
         * 追踪原码可知：匹配的方式是一个字符一个字符的匹配，使用递归的方式，进行递增匹配，
         * 每匹配到一个结果，就会维护到groups[]数组中，记录开始和结束+1的角标
         *
         *
         * 对于分组的匹配模式：
         * 维护在group中的 0角标为匹配到的开始位置，1角标维护的是结束字符串角标+1的位置
         * 维护在group中的 2角标为第一组匹配开始的位置，3角标的值是第一组的匹配结束字符串的索引位置+1   （第一组的信息）
         * ...
         *
         */
        while (matcher.find()) {
            System.out.println("匹配到："+matcher.group(0));
            System.out.println("组一为："+matcher.group(1));
            System.out.println("组二为："+matcher.group(2));
        }
    }
}









