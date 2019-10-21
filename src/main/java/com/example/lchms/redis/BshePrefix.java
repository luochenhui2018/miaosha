package com.example.lchms.redis;

public abstract class BshePrefix implements KeyPrefix {

   private  int expireSeconds;
   private  String prefix;

   public BshePrefix(int expireSeconds,String prefix){
       this.expireSeconds=expireSeconds;
       this.prefix= prefix;
   }

    @Override
    public int expireSeconds() {
        return 0;  //永不过期
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return  className + ":" + prefix;
    }

}
