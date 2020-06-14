package com.woniu.mybatis.dao;

import com.woniu.mybatis.entity.User;

import java.util.List;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
public interface UserDao {

    void saveUserInfo(User user);

    void updateUser(User user);

    void deleteById(int id);

    User findById(int id);

    List<User> findByUser(String name);

}
