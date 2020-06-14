package com.woniu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.dao.entity.Area;
import com.woniu.dao.entity.City;
import com.woniu.dao.entity.Province;
import com.woniu.service.AddressService;
import com.woniu.vo.Result;

@RestController
@RequestMapping("addr")
public class AddressController extends BaseController{
	@Autowired
	private AddressService addressService;
	//获取省数据
	@RequestMapping("getProvence")
	public Result getProvince() {
		List<Province> allProvince = addressService.getAllProvince();
		if(allProvince==null || allProvince.size()==0) {
			return none();
		}
		return ok(allProvince);
	}
	//获取城市数据
	@RequestMapping("getCities")
	public Result getCities(String provinceId) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~获取省" + provinceId + "的城市数据");
		List<City> citysByProveiceId = addressService.getCitysByProvinceId(provinceId);
		if(citysByProveiceId==null || citysByProveiceId.size()==0) {
			return none();
		}
		return ok(citysByProveiceId);
	}
	//获取地区
	@RequestMapping("getArea")
	public Result getArea(String cityid) {
		List<Area> areaByCityid = addressService.getAreaByCityid(cityid);
		if(areaByCityid==null || areaByCityid.size()==0) {
			return none();
		}
		return ok(areaByCityid);
	}
}
