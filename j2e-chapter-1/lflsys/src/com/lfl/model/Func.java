package com.lfl.model;

public class Func {
	private Integer id;
	private String name;
	private Integer manager_id;
	private String url;
	private Integer model_id;
	
	
	public Integer getModel_id() {
		return model_id;
	}
	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	@Override
	public String toString() {
		return "Func [id=" + id + ", name=" + name + ", manager_id=" + manager_id + ", url=" + url + ", model_id="
				+ model_id + "]";
	}
	
}
