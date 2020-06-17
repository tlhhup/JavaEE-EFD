package com.lfl.dao;

import java.util.List;

import com.lfl.model.Func;

public interface FuncDao {
	public List<Func> queryFuncUrl( Integer managerID ) throws Exception;
}
