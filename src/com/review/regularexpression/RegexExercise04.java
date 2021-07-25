package com.review.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 要求验证是不是整数或者为小数
 *  需要考虑正数和负数
 */
public class RegexExercise04 {

    public static void main(String[] args) {
//        String digit = "-10.11";
           //  String digit = "0.001";
         // String digit = "0002.00001";
        String digit = "1.001";
        // 如果有多个表达式进行组合，可以使用 在  ()  中使用或者的方式
        // String regex = "^-?(0.|[1-9]\\d*\\.?)\\d+$";   // 我这里有个问题，就是\\d必须出现，所以不能匹配到单个数字
        // String regex = "^-?(0.|[1-9]\\d*\\.?)\\d*$";   // 也有问题，会出现.后面没有数字，因此需要将.和\\d一样
        // String regex = "^-?(0.|[1-9]\\d*\\.?)\\d*$";   // 还有个问题，不能匹配0
        // 改造
         String regex = "^-?(0|0.\\d+|[1-9]\\d*\\.?\\d*)$"; // 这样就可以


        // 如果使用[]就不能使用0. 的方式，因为这里表示的是0 或者 .
         // String regex = "^-?[0|[1-9]\\d*](\\.?\\d+)?$";
        // 这里是不能排除掉前面有很多000的字符串
        // 这里的问题在与  [0|[1-9]\\d]  \\d只会作用在[1-9]后面，因此是完整的匹配方式
         //String regex = "^[+-]?[0|[1-9]\\d*](\\.\\d+)?$"; // 这个匹配方式是补完整的
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(digit);

        while (matcher.find()) {
            System.out.println("匹配到："+matcher.group());
        }

    }
}
