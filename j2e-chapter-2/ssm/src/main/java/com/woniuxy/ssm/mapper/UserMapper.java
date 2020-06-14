package com.woniuxy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniuxy.ssm.entity.User;

@Mapper
public interface UserMapper {

	int insert(User user);
	
	User findUserById(int id);
	
	List<User> findUserByCnname(String name);
	
}
