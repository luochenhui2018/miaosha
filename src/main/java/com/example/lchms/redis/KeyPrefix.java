package com.example.lchms.redis;

public interface KeyPrefix {
    public int expireSeconds(); //到期时间,秒

    public String getPrefix();


}
