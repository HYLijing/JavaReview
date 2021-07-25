package com.review.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java中的正则表达式
 * <p>
 * 体验正则表达式
 */
public class RegularExpression {

    public static void main(String[] args) {
        String content = "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，" +
                "这种程序可以通过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的人力、物力和财力。这个时候，" +
                "Sun公司想起了那个被搁置起来很久的Oak，并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，" +
                "特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的Applet" +
                "（Applet是一种将小程序嵌入到网页中进行执行的技术），并将Oak更名为Java（在申请注册商标时，发现Oak已经被人使用了，再想了一系列名字之后，最终，" +
                "使用了提议者在喝一杯Java咖啡时无意提到的Java词语）。5月23日，Sun公司在Sun world会议上正式发布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、" +
                "HP、Oracle、Netscape和微软等各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为自己的产品开发了相应的Java平台。";

        // 匹配文中所有单词，输出：找到：Oak 找到：IT 找到：Sun
        //Pattern pattern = Pattern.compile("[a-zA-Z]+");

        // 匹配文中所有数字，输出：找到：1995
        //Pattern pattern = Pattern.compile("\\d+");  // + 表示多个
        // 匹配数字或者单词
        Pattern pattern = Pattern.compile("[\\da-zA-Z]+");

        // 2，第二步：通过matcher方法将content用正则表达式做匹配
        Matcher matcher = pattern.matcher(content);

        // 3,第三步：从Matcher中（相当于处理结果的封装集合）查看内容
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }

}
