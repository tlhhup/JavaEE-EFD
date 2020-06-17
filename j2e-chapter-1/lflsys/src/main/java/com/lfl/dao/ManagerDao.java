package com.lfl.dao;

import java.sql.SQLException;

import com.lfl.model.Manager;

public interface ManagerDao {
	public Manager queryManager(String name, String password) throws Exception;
	
	public void setIsLogin( Integer isLogin, Integer managerID )throws Exception;
	
} 
