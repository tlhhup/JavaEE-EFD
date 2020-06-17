package com.lfl.model;

public class Manager {
	private Integer id;
	private String nikeName;
	private String name;
	private String password;
	private Integer mgrLevel;
	private Integer isLogin;
	
	
	public Integer getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getMgrLevel() {
		return mgrLevel;
	}
	public void setMgrLevel(Integer mgrLevel) {
		this.mgrLevel = mgrLevel;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj == null )return false;
		if( this == obj )return true;
		if( !(obj instanceof Manager) )return false;
		//业务对比
		Manager m = (Manager)obj;
		if( this.name.equals(m.name) )return true;
		return false; 
	}
	
	
	
	@Override
	public String toString() {
		return "Manager [id=" + id + ", nikeName=" + nikeName + ", name=" + name + ", password=" + password
				+ ", mgrLevel=" + mgrLevel + ", isLogin=" + isLogin + "]";
	}
}
