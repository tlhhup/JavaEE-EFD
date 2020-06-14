package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.User;

import java.util.List;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public interface UserMapper {

    void saveUserInfo(User user);

    void updateUser(User user);

    void deleteById(int id);

    User queryById(int id);

    List<User> queryByName(String name);

}
