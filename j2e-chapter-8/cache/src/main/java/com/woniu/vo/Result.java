package com.woniu.vo;
//统一JSON格式
public class Result {
	//处理请求的状态码  0成功  1 失败
	private String code;
	private String msg;
	//返回的数据
	private Object data;
	//无参构造器
	public Result() {
		super();
	}
	//有参构造器
	public Result(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
