package com.czxy.dao;

import com.czxy.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

//    @Select("select * from user where username=#{username}")
//    User findByUserName(String username);



}
