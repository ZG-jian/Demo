package com.jian.exception;

/**
 * 用户登录状态的自定义异常
 */
public class UserNotFoundException extends RuntimeException {
    //添加这些构造方法就是为了更方便的使用自定义异常
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
