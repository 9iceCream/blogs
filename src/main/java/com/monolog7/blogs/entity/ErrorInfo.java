package com.monolog7.blogs.entity;

public enum ErrorInfo {
    CODE_0(0,"success"),
    CODE_1000(1000,"注册失败"),
    CODE_1001(1001,"用户名已存在"),
    CODE_1002(1002,"用户不存在"),
    CODE_1003(1003,"用户名或者密码错误"),
    CODE_1004(1004,"用户未登录"),
    CODE_1005(1005,"暂无博客信息"),
    CODE_1006(1006,"添加或更新博客信息失败");
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
