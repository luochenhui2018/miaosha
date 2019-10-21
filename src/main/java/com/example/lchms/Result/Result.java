package com.example.lchms.Result;



public class Result<T> {
    private int code;
    private String mag;
    private T data;

    //构造函数
    private Result(T data) {
        this.code=0;
        this.mag="成功调用";
        this.data=data;
    }

    private Result(CodeMsg codeMsg) {
        if (codeMsg == null){
            return;
        }
        this.code=codeMsg.getCode();
        this.mag=codeMsg.getMsg();
    }

    /**
     * 成功时候的调用
     * **/
    public static <T>Result<T> success(T data){
        return new Result<T>(data);
    }
    /**
     *  失败时候的调用
     * **/
    public static  <T>Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
