package com.woniu.service;

import java.util.List;


import com.woniu.dao.entity.Area;
import com.woniu.dao.entity.City;
import com.woniu.dao.entity.Province;

public interface AddressService {
	//获取所有的省
	List<Province> getAllProvince();
	//根据城市id获取地区数据
	List<Area> getAreaByCityid(String cityid);
	//根据省id获取城市
	List<City> getCitysByProvinceId(String provenceId);
}
