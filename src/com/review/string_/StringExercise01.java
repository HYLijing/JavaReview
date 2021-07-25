package com.review.string_;

public class StringExercise01 {

    public static void main(String[] args) {

        String s1 = "hspedu";
        String s2 = "java";
        s2 = "haha";
        String s4 = "java";
        String s3 = new String("java");
        s3 = "xixi";

        System.out.println(s2==s3); // F
        System.out.println(s2==s4); // T
        System.out.println(s2.equals(s3)); // T
        System.out.println(s1==s2); // F

        Demo demo = new Demo();
        System.out.println(demo);
        demo = new Demo();
        System.out.println(demo);
    }

}


final class Demo{
    final String str = "";
}