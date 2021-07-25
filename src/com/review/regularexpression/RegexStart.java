package com.review.regularexpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 记住正则表达式的入门：
 * 记住结论：
 * 1，Java中的正则表达式都是通过模式和匹配结合的方式
 *  模式：Pattern  主要用来封装正则表达式     通过Pattern中的静态方法compile方法来得到对象
 *  匹配：Matcher  主要用来使用正则表示来进行字符产的匹配，封装匹配的结果
 *
 * 2，使用Pattern的matcher方法对字符串进行匹配，得到结果的包装。Matcher模式匹配对象。
 *  Matcher对象是对字符串进行匹配和结果的封装
 *
 * 3，正则表示底层中操作字符串的记录放在group数组中
 *      每匹配到一个放入到group数组中的0号角标的位置
 *
 * 4，就是正则表达式的操作了
 *
 * 关于Matcher中group组进行匹配的大致方式为：
 * 1，初始化一个group组，默认长度是20；初始化一个locals数组，默认长度为分组的个数
 * 2，group中0角标和1角标用来记录的是匹配到的正则表达式的一个串的的开始角标和结束角标
 * 3，locals是用来记录每一组匹配到的开始角标和结束几标的位置。最终将数据是放在group数组中
 * 4，最终匹配到的结果都在group数组中，记录的是group数组中的角标位置
 *
 *
 *
 */
public class RegexStart {

    public static void main(String[] args) {
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。\" +\n" +
                "                \"2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。\" +\n" +
                "                \"2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），\" +\n" +
                "                \"代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、\" +\n" +
                "                \"格式化I/O及可变参数。";
        // 第一步：得到Pattern模式对象
        Pattern pattern = Pattern.compile("(\\d\\d)(\\d)(\\d)");

        // 第二步：得到Matcher匹配对象
        Matcher matcher = pattern.matcher(content);

        // 第三步：进行模式匹配
        while (matcher.find()) {
            // 这个就是取的group数组中的0号角标的元素
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println("------");
        }


    }

}
