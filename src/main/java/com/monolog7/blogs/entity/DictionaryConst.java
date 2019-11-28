package com.monolog7.blogs.entity;

public enum DictionaryConst {
    USER_OPER_1(1,"用户登录"),
    USER_OPER_2(2,"校验登录"),

    DELETE_FLAG_1(1,"正常"),
    DELETE_FALG_2(2,"已删除");


    private int code;
    private String message;
    private DictionaryConst(int code,String message){
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
