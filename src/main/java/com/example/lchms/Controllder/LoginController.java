package com.example.lchms.Controllder;

import Vo.LoginVo;
import com.example.lchms.Result.CodeMsg;
import com.example.lchms.Result.Result;
import com.example.lchms.service.MiaoshanUserService;
import com.example.lchms.service.UserService;
import com.example.lchms.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kuangfeng
 * @date 2019-12-17 20:11
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    MiaoshanUserService miaoshanUserService;
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/to_login")
    public String toLogin() {
        return "hello Login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(LoginVo loginVo) {
        log.info(loginVo.toString());
        //参数校验，判断密码是否为空
        String passInput = loginVo.getPassword();
        String mobile = loginVo.getMobile();
        if (StringUtils.isEmpty(passInput)){
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if (StringUtils.isEmpty(mobile)){
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if (!ValidatorUtil.isMobile(mobile)){
            return Result.error(CodeMsg.MOBILE_ERROR);
        }

        //登录
        CodeMsg msg = miaoshanUserService.login(loginVo);
        if (msg.getCode() == 0){
            return Result.success(true);
        }else {
            return Result.error(msg);
        }
    }
}
