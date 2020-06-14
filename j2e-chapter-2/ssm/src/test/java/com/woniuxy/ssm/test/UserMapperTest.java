package com.woniuxy.ssm.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woniuxy.ssm.config.App;
import com.woniuxy.ssm.entity.User;
import com.woniuxy.ssm.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=App.class)
public class UserMapperTest {
	
	@Resource
	private UserMapper userMapper;

	@Test
	public void findById(){
		User user = userMapper.findUserById(1);
		System.out.println(user.getCnname());
	}
	
}
