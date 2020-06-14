package com.woniu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.woniu.dao.entity.*;
import com.woniu.dao.mapper.*;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private ProvinceMapper provenceMapper;
	@Override
	@Cacheable(value="addrCache")
	public List<Province> getAllProvince() {
		return provenceMapper.getAllProvince();
	}

	@Override
	@Cacheable(value="addrCache")
	public List<Area> getAreaByCityid(String cityid) {
		return areaMapper.getAreaByCityid(cityid);
	}

	@Override
	@Cacheable(value="addrCache")
	public List<City> getCitysByProvinceId(String provenceId) {
		return cityMapper.getCitysByProvenceId(provenceId);
	}
}
