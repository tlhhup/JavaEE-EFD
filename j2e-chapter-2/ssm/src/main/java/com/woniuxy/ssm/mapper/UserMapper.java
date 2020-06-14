package com.woniuxy.ssm.mapper;

import com.woniuxy.ssm.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	public User validateUserInfo(User user);

}
