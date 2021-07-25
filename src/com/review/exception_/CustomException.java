package com.review.exception_;


/**
 * 异常分为编译异常和运行时异常
 * 自定义异常：
 * 继承Exception为编译异常
 * 继承RuntimeException为运行时异常，一般继承RuntimeException
 *
 */
public class CustomException extends RuntimeException{

    // 需要提供构造器，让我们抛出异常
    public CustomException(String message) {
        super(message);
//        System.out.println(message);
    }
}
