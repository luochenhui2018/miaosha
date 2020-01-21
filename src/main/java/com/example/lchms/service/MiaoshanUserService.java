package com.example.lchms.service;

import Vo.LoginVo;
import com.example.lchms.Result.CodeMsg;
import com.example.lchms.dao.MiaoshanUserDao;
import com.example.lchms.domain.MiaoshaUser;
import com.example.lchms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kuangfeng
 * @date 2020-01-21 15:12
 */
@Service
public class MiaoshanUserService {

    @Autowired
    MiaoshanUserDao miaoshanUserDao;

    public MiaoshaUser getById(long id){
        return miaoshanUserDao.getById(id);  //实际上就是调用底部的geyById
    }
    public CodeMsg login(LoginVo loginVo) {
        if (loginVo == null){
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginVo.getMobile();
        String inputPass = loginVo.getPassword();
        //首先判断手机号是否存在
        MiaoshaUser user =  getById(Long.parseLong(mobile));
        if (user == null){
            return CodeMsg.MOBILE_NOT_EXIST;
        }
        //验证密码
        String dbPass = user.getPassword();
        String SaltDB = user.getSalt();
        String calcPass = MD5Util.inputPassToDBPass(inputPass,SaltDB);
        if(!calcPass.equals(dbPass)){
            return CodeMsg.PASSWORD_ERROR;
        }
    return CodeMsg.SUCCESS;
    }

}
