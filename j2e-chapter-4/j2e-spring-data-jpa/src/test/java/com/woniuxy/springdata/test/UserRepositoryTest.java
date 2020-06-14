package com.woniuxy.springdata.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woniuxy.j2e.springdata.Application;
import com.woniuxy.j2e.springdata.entity.User;
import com.woniuxy.j2e.springdata.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void save(){
		User user=new User();
		user.setAddress("成都");
		user.setAge(10);
		user.setRealName("离歌笑");
		user.setUserName("tlhhup");
		user.setBirthday(new Date());
		
		this.userRepository.save(user);
	}
	
	@Test
	public void update(){
		User user=new User();
		user.setId(1);
		user.setAddress("北京");
		
		this.userRepository.save(user);
	}
	
	@Test
	public void modifyPwd(){
		this.userRepository.modifyingPassword("zhangsan", 1);
	}
	
	@Test
	public void findAll(){
		Iterable<User> users = this.userRepository.findAll();
		for (User user : users) {
			System.out.println(user.getRealName());
		}
		
	}
	
	@Test
	public void findUserByUserName(){
		User user = this.userRepository.findUserByUserName("tlhhup");
		System.out.println(user.getRealName());
	}
	
	@Test
	public void findUserNative(){
		User user = this.userRepository.findUserInfoNativeQuery("tlhhup");
		System.out.println(user.getUserName());
	}

	@Test
	public void sortByUserName(){
		Iterable<User> users = this.userRepository.findAll(new Sort(Direction.DESC, "userName"));
		for (User user : users) {
			System.out.println(user.getUserName());
		}
	}

@Test
public void paging(){
	Page<User> page = this.userRepository.findAll(new PageRequest(0, 5));
}
	
}
