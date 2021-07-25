package com.review.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的三个常用类
 * Pattern  正则表达式对象，只能通过静态方法构造实例
 * Matcher  是对输入的字符串和正则表达式进行解释和匹配的引擎。与Pattern类一样，没有公共的构造方法，需要通过
 * mather方法来构造对象实例
 * PatternSyntaxException   非强制异常，可以表示一个正则表达式模式中的语法错误
 */
public class Regex09 {

    // 主要是了解和使用一下Mather类中的不同方法
    public static void main(String[] args) {
        // 1，start()    返回以前匹配的初始索引。其实就是维护在内部group数组中的其实元素值 group[0] 的值
        String content = "ABC123AbcABC";
        // String regex = "ABC";

        // 2，start(int group) 返回对应组中匹配到的开始索引
        String regex = "([A-C]{3})(\\w*)?";   // 两个匹配结果

        // 3,lookingAt()尝试从区域开始的输入序列和该模式匹配

        // 4，find()

        // 5，find(int start)    重制次匹配器，然后尝试查找匹配模式，从指定索引的位置开始。所以如果能找到，会一直出现找到的情况，会出现死循环


        // 6 matches()  尝试将整个区域与模式匹配，判断是否匹配成功。这个用的是最多的。相当于带着开头和结果的
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        System.out.println(matcher.lookingAt());    // 判断开头是否满足

        System.out.println(matcher.matches());  // 判断整个字符串是否满足

//        while (matcher.find()) {    // start(0)就是start整个匹配到的开始索引
//            System.out.println("匹配到一条数据：" + matcher.group(0));
//            System.out.println("初始索引："+matcher.start());
//            System.out.println("组一中开始索引："+matcher.start(1));
//            System.out.println("组二中开始索引："+matcher.start(2));    // 没有的是-1
//
//
//            System.out.println("最后匹配字符的偏移量："+matcher.end());
//        }

    }
}
