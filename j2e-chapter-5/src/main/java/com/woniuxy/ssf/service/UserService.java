package com.woniuxy.ssf.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.woniuxy.ssf.entity.User;

@Service("userService")
public class UserService {

	private static List<User> users;
	
	public List<User> findAll(){
		if(users==null){
			users=new ArrayList<User>();
			User user=null;
			for(int i=0;i<5;i++){
				user=new User();
				user.setId(i+1);
				user.setActived(i%2==0);
				user.setBirthday(new Date());
				user.setName("这个是第"+(i+1)+"个数据");
				user.setWeight(Math.random()*200);
				user.setAge(25);
				
				users.add(user);
				
				user=null;
			}
		}
		return users;
	}
	
}
