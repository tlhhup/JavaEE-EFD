package com.lfl.dao;

import java.util.List;

import com.lfl.model.Emplyee;

public interface EmplyeeDao {
	public List<Emplyee> queryEmpList( Integer pageNow, Integer pageRow ) throws Exception;
	
	public Integer queryTotalRow() throws Exception;
	
	public void add( String name ) throws Exception;
	
	public Emplyee queryByName( String name )throws Exception;
}
