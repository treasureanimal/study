package com.test.springmvc.service.impl;

import com.springmvc.annotation.Service;
import com.test.springmvc.bean.User;
import com.test.springmvc.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {


    public  void  findUser(){
        System.out.println("====调用UserServiceImpl==findUser===");
    }

    public User getUser(){

        return new User(1,"老王","admin");
    }
}
