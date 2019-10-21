package com.example.lchms.service;

import com.example.lchms.dao.UserDao;
import com.example.lchms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getById(int id){
        return userDao.getById(id);
     }
     //事物标签
     @Transactional
    public Boolean tx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("kuangfeng");
        userDao.insert(u1);
        User u2 = new User();
        u2.setId(1);
        u2.setName("yixaochuan");
        userDao.insert(u2);

        return true;
    }
}
