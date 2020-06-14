package com.woniu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.woniu.entity.UserRole;
import com.woniu.entity.Users;
import com.woniu.util.DBUtil;

public class UserDao {
	/**
	 * 根据用户名查询用户
	 * @param conn
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public Users getUsers(Connection conn , String username) throws SQLException {
		String sql = "SELECT * FROM users WHERE username = ?";
		Users users = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			users = new Users();
			users.setId(rs.getInt("id"));
			users.setUsername(rs.getString("username"));
			users.setPassword(rs.getString("password"));
			users.setRoleId(rs.getInt("role_id"));
		}
		return users;
	}
	/**
	 * 根据用户名查询出用户的juse
	 * @param conn
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public Set<String> getRoles(Connection conn , String username) throws SQLException {
		String sql = "SELECT rolename FROM users u, user_role r WHERE u.role_id=r.id AND u.username=?";
		Set<String> roles = new HashSet<String>();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			roles.add(rs.getString("rolename"));
		}
		return roles;
	}
	/**
	 * 根据用户名查询出用户的权限
	 * @param conn
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public Set<String> getPermission(Connection conn , String username) throws SQLException {
		String sql = "SELECT permissionname FROM users u, user_role r , role_permission p WHERE u.role_id=r.id AND p.role_id = r.id AND u.username=?";
		Set<String> roles = new HashSet<String>();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			roles.add(rs.getString("permissionname"));
		}
		return roles;
	}
	public static void main(String[] args) throws SQLException {
		UserDao ud = new UserDao();
		Users users = ud.getUsers(DBUtil.getConnection(), "woniu1");
		Set<String> roles = ud.getRoles(DBUtil.getConnection(), "woniu1");
		Set<String> pre = ud.getPermission(DBUtil.getConnection(), "woniu1");
		System.out.println("�û���Ϣ:" + users);
		System.out.println("��ɫ��Ϣ:" + roles);
		System.out.println("Ȩ����Ϣ:" + pre);
	}
}
