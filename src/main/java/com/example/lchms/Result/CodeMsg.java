package com.example.lchms.Result;

import lombok.Data;

@Data
public class CodeMsg{
    private int code;
    private  String msg;
    //通过错误码
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务端异常");
    //通过错误码
    public static CodeMsg MOBILE_EMPTY  = new CodeMsg(500211,"手机号不能为空");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500212,"登录密码不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213,"不是一个手机号");
    public static CodeMsg MOBILE_NOT_EXIST= new CodeMsg(500214,"手机号不存在");
    public static CodeMsg PASSWORD_ERROR= new CodeMsg(500215,"密码错误");


    public static CodeMsg SESSION_ERROR = new CodeMsg(500210,"session不存在或已经失效");


    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
