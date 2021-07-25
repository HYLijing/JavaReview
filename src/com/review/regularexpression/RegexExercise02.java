package com.review.regularexpression;
/**
 * 反向引用的练习
 * 分组：使用()进行分组
 * 捕获：将正则表达式中子表达式/分组匹配到的内容，保存到内存中以数字编码或者显示命令的阻力，方便后面引用。
 * 从左向右，以分组的左括号为标志，第一个出现的组号为1，第二个为2，一次类推。组0代表整个正则表达式
 * 反向引用：可以通过捕获拿到扩后中的内容，从而得到一个比较新的匹配模式。
 * 这种尽可以在正则表达式内部使用，也可以在外部使用。当然需要针对的是同一个mather对象。
 * 内部使用\\组号，外部使用$组号
 */
public class RegexExercise02 {

    public static void main(String[] args) {
        // 1，匹配五个连续相同的数字
        // String content = "111111113335666";
        // 第一步就要分组，然后在通过反向引用
        // \\d：代表数字 \
        // \1:代表反向引用到第一组中,也就是\\d匹配到的值
        // {4}表示 \\1需要出现4次
        // String regex = "(\\d)\\1{4}";

//        Matcher matcher = Pattern.compile(regex).matcher(content);
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }

        // 2 匹配个位数和千位相同，十位和百位相同的千位数
//        String content = "5245";
//        String regex = "(\\d)(\\d)\\2\\1";  //表示四位数
//        Matcher matcher = Pattern.compile(regex).matcher(content);
//        System.out.println(matcher.matches());
//        // 这里如果想取出反向引用的值，必须通过相同的matcher对象取出
//        System.out.println("$1");


        // 3 重复汉字的去重
        // 说明：使用String中的replace方法传入正则的方式
        String content = "我...我要...学学学学....编程java";
        String regex1 = "\\.+";
        String content1 = content.replaceAll(regex1, "");    // 去掉省略号

        // [\\u4e00-\\u9fa5]表示汉字，只针对汉字去重
        // \\1 反向引用到组1中，也只有一个组
        // + 表示最少一个，因此针对的是重复汉字
        String regex2 = "([\\u4e00-\\u9fa5])\\1+";

        // 这里就使用到了非常重要的一个东西，在他同一个对象中，在regex外部，可以使用$组名 的方式拿到分组的内容
        System.out.println(content1.replaceAll(regex2,"$1"));

    }

}
