package com.example.lchms.redis;

public class Orderkey extends BasePrefix {

    public Orderkey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
