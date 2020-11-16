package com.example.lchms.exception;

import com.example.lchms.Result.CodeMsg;

/**
 * @author kuangfeng
 * @date 2020-11-05 16:20
 */
public class GlobleException extends RuntimeException {
    private static  final long serialVersionUID = 1L;
    private CodeMsg cm;

    public GlobleException(CodeMsg cm){
        super(cm.toString());
        this.cm = cm;
    }

}
