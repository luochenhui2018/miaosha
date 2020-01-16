package com.example.lchms.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.codec.digest.DigestUtils;
import org.testng.annotations.Test;

/**
 * @author kuangfeng
 * @date 2019-12-16 19:28
 */
public class MD5Util {
    //一次md5加密
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    private static String salt = "1a2b3c4d";

    public static String inputPassToFromPass(String inputPass){
       String src = ""+ salt.charAt(0)+ salt.charAt(2)+ inputPass+ salt.charAt(5);
       return md5(src);
    }
    public static String fromPassToDBPass(String fromPass,String salt){
        String src = ""+ salt.charAt(0)+ salt.charAt(2)+ fromPass+ salt.charAt(5);
        return md5(src);
    }

    public static String inputPassToDBPass(String input,String saltDB){
        String fromPass = inputPassToFromPass(input);
        String dbPass = fromPassToDBPass(fromPass,saltDB);
        return dbPass;
    }
    @Test
    public void test1(){
//        System.out.println( inputPassToFromPass("123456789"));
//        System.out.println( FromPassToDBPass(inputPassToFromPass("123456789"),"1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }
}
