package com.review.enum_;


// enum 关键字来实现枚举类
public class Enumeration02 {

    public static void main(String[] args) {
        System.out.println(Season2.getNameByCode(1));

    }

}


enum Season2 {
    // 这里需要定义枚举的常量
    SPRING("春天","温暖",1),
    WINTER("冬天","寒冷",2),
    AUTUMN("秋天","凉爽",3),
    SUMMER("夏天","炎热",4);

    private String name;
    private String desc;//描述
    private int code;

    private Season2(String name,String desc,int code) {
        this.desc = desc;
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

    public static String getNameByCode(int code) {
        for (int i = 0; i < Season2.values().length; i++) {
            if (code == Season2.values()[i].code) {
                return Season2.values()[i].name;
            }
        }

        return "";
    }
}
