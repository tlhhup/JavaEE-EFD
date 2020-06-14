package com.lfl.dao;

import java.util.List;

import com.lfl.model.Model;

public interface ModelDao {
	
	/**查询管理员模块权限*/
	public List<Model> queryModelByID( Integer managerID )throws Exception;
	
	
	
	
	
}
