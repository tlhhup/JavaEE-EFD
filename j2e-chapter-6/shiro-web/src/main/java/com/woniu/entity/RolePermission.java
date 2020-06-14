package com.woniu.entity;

public class RolePermission {
	private Integer id;
	private String permissionName;
	private Integer roleId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", permissionName=" + permissionName + ", roleId=" + roleId + "]";
	}
}
