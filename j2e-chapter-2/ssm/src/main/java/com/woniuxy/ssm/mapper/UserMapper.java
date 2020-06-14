package com.woniuxy.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.woniuxy.ssm.entity.User;

@Mapper
public interface UserMapper {

	public User validateUserInfo(User user);

}
