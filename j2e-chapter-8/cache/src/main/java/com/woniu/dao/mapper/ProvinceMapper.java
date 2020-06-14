package com.woniu.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.woniu.dao.entity.Province;

@Mapper
public interface ProvinceMapper {
	//获取所有的省
	@Select(value="select * from provinces")
	List<Province> getAllProvince();
}
