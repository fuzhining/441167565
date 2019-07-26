package com.czxy.service;

import com.czxy.domain.User;

public interface UserService {

    //添加
    void insertUser(User user);

    User findUserByUser(User user);


    User findUserByName(String username);


}
