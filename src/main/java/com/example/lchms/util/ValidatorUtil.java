package com.example.lchms.util;

import com.example.lchms.Result.CodeMsg;
import com.example.lchms.Result.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kuangfeng
 * @date 2020-01-16 23:24
 * 判断格式
 */
public class ValidatorUtil {
    private static final Pattern mobile_patten = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String src){
        if (StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m = mobile_patten.matcher(src);
        return m.matches();
    }

//    public static void main(String[] args) {
//        System.out.println(isMobile("18912341234"));
//        System.out.println(isMobile("1891234123422222"));
//    }
}
