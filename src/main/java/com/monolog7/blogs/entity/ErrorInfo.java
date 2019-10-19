package com.monolog7.blogs.entity;

public enum ErrorInfo {
    CODE_0(0,"success"),
    CODE_1000(1000,"注册失败"),
    CODE_1001(1001,"用户名已存在"),
    CODE_1002(1002,"用户不存在"),
    CODE_1003(1003,"用户名或者密码错误");
    private int code;
    private String message;
    private ErrorInfo(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
