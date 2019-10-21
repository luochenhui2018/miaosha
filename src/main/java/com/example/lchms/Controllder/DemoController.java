package com.example.lchms.Controllder;

import com.example.lchms.Result.CodeMsg;
import com.example.lchms.Result.Result;
import com.example.lchms.domain.User;
import com.example.lchms.redis.RedisService;
import com.example.lchms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("demo")
public class DemoController {
    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello kuangfeng");

    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);

    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user =userService.getById(1);
        return  Result.success(user);

    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        userService.tx();
        return  Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Long> redisGet() {
        Long v1 = redisService.get("key1",Long.class);
        return Result.success(v1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<String> redisSet() {
        boolean ret = redisService.set(prefix,"key2","kuangfeng");
        String v2 = redisService.get(prefix,"key2", String.class);
        return Result.success(v2);
    }
}