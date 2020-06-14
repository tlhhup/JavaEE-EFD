package com.woniu.controller;

import com.woniu.vo.Result;
//基础Controller功能
public class BaseController {
	//成功返回
	public Result ok(Object obj) {
		return new Result("0", "", obj);
	}
	//成功
	public Result ok() {
		return ok(null);
	}
	//错误
	public Result error() {
		return new Result("error", "发生错误", null);
	}
	//未找到
	public Result none() {
		return new Result("none", "找不到相应数据", null);
	}
}
