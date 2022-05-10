package com.frank.jian.Trowable;
//自定义异常
public class JianException extends  Exception{
    public JianException() {
    }

    public JianException(String message) {
        super(message);
    }

    public JianException(String message, Throwable cause) {
        super(message, cause);
    }

    public JianException(Throwable cause) {
        super(cause);
    }

    public JianException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
