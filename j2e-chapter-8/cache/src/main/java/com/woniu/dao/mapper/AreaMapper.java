package com.woniu.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.woniu.dao.entity.Area;

@Mapper
public interface AreaMapper {
	//根据城市id获取地区数据
	@Select("select * from areas where cityid = #{_parameter}")
	List<Area> getAreaByCityid(String cityid);
}
