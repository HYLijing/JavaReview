package com.review.regularexpression;

public class RegexExercise01 {

    public static void main(String[] args) {

        // 案例一：判断一个字符串是否全是汉字
        // String content = "我是中国人";
        // String regex = "^[\\u4e00-\\u9fa5]+$";

        // 案例二：邮政编码
        // 要求：1-9开头的是6位数
        // String content = "0124121";
        // String regex = "^[1-9]\\d{5}$";  // 表示1-9开头的六位数

        // 案例三：QQ号码
        // 要求：1-9开头的一个（5位数-10位数）
        // String content = "12342";
        // String regex = "^[1-9]\\d{4,9}";

        // 案例四：手机号码
        // 要求：以13 14 15 18 开头的11位数
        // String content = "13865782178";
        // String regex = "^[13|14|15|18]\\d{9}$";  // 这样写是错的，记住操作的只能是单个字符
        // String regex = "^1[3|4|5|8]\\d{9}$";

        // 案例四：匹配URL
        String content = "https://www.baidu.com/s?wd=袁海洋" +
                "%B8%AD%E6%96%87&rsv_spt=1&rsv_iqid=0xf1d50925000040d3&issp=1&f=8&rsv_bp=1&rsv_idx=2&" +
                "ie=utf-8&tn=baiduhome_pg&rsv_dl=ib&rsv_enter=1&rsv_sug3=39&rsv_sug1=33&rsv_sug7=101";

        // \\w 表示字符 数字 和 下划线
        // + 表示最少一个

        // 不能在表达式[]中在使用表达式，否则会不生效
        // 在表达式[]括号中，所有的字符都是其本意，不是正则中符号的含义
        String regex = "^(https?://)([\\w-]+\\.?)+(\\/*[\\w-?=&/%.#\\u4e00-\\u9fa5]*)?$";

        boolean matches = content.matches(regex);
        if (matches){
            System.out.println("是");
        } else {
            System.out.println("不是");
        }

    }

}
