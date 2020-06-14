package com.lfl.model;

import java.util.Date;

public class Goods {
	private Integer id;
	private String goodNo;
	private String name;
	private String firstType;
	private String secType;
	private Integer inPrice;
	private Integer outPrice;
	//库存数量
	private Integer saveNum;
	//保质期
	private Integer shelfTime;
	
	
	private Integer brand_id;
	private Integer firstType_id;
	private Integer secType_id;
	
	
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public Integer getFirstType_id() {
		return firstType_id;
	}
	public void setFirstType_id(Integer firstType_id) {
		this.firstType_id = firstType_id;
	}
	public Integer getSecType_id() {
		return secType_id;
	}
	public void setSecType_id(Integer secType_id) {
		this.secType_id = secType_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodNo() {
		return goodNo;
	}
	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstType() {
		return firstType;
	}
	public void setFirstType(String firstType) {
		this.firstType = firstType;
	}
	public String getSecType() {
		return secType;
	}
	public void setSecType(String secType) {
		this.secType = secType;
	}
	public Integer getInPrice() {
		return inPrice;
	}
	public void setInPrice(Integer inPrice) {
		this.inPrice = inPrice;
	}
	public Integer getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(Integer outPrice) {
		this.outPrice = outPrice;
	}
	public Integer getSaveNum() {
		return saveNum;
	}
	public void setSaveNum(Integer saveNum) {
		this.saveNum = saveNum;
	}
	public Integer getShelfTime() {
		return shelfTime;
	}
	public void setShelfTime(Integer shelfTime) {
		this.shelfTime = shelfTime;
	}
	
	
	
}
