package com.woniu.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.woniu.dao.entity.City;

@Mapper
public interface CityMapper {
	//根据省id获取城市
	@Select(value="select * from cities where provinceid=${_parameter}")
	List<City> getCitysByProvenceId(String provenceId);
}
