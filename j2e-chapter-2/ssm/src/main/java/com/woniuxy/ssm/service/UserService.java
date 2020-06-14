package com.woniuxy.ssm.service;

import com.woniuxy.ssm.entity.User;
import com.woniuxy.ssm.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 离歌笑
 * @desc
 * @date 2020-06-14
 */
@Service("userService")
@Transactional(readOnly=true)
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User validateUserInfo(User user){
        return this.userMapper.validateUserInfo(user);
    }

}
