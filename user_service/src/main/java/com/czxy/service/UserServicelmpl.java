package com.czxy.service;


import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.List;

@Service
@Transactional
public class UserServicelmpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findUserByUser(User user) {
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        criteria.andEqualTo("password",user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        if (userList.isEmpty()){
            return null;
        }else {
            return   userList.get(0);
        }
    }

    @Override
    public User findUserByName(String username) {
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.isEmpty()){
            return null;
        }else {

            return userList.get(0);
        }
    }


}
