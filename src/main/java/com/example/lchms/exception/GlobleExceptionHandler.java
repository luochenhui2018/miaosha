package com.example.lchms.exception;

import com.example.lchms.Result.CodeMsg;
import com.example.lchms.Result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author kuangfeng
 * @date 2020-11-05 10:40
 * 全局的异常拦截器
 */
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {
    //拦截所有的异常
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request ,Exception e){

        if (e instanceof BindException){
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else {
            //如果不是.则返回一个服务端通用的异常。
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
