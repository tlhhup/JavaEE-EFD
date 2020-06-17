package com.lfl.dao;

import java.util.List;

import com.lfl.model.Brand;

public interface BrandDao {
	public Brand findById(Integer id) throws Exception;
	
	public List<Brand> queryAll()throws Exception;
}
