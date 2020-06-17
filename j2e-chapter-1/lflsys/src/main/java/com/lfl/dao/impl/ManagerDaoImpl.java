package com.lfl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lfl.dao.ManagerDao;
import com.lfl.model.Manager;
import com.lfl.util.DBUtil;

public class ManagerDaoImpl implements ManagerDao{

	@Override
	public Manager queryManager(String name, String password) throws SQLException {
		Manager manager = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select * from t_manager where name=? and password=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ){//用户合法
				manager = new Manager();
				manager.setId(rs.getInt("id"));
				manager.setNikeName(rs.getString("nikeName"));
				manager.setName(rs.getString("name"));
				manager.setPassword(rs.getString("password"));
				manager.setMgrLevel(rs.getInt("mgrLevel"));
				manager.setIsLogin(rs.getInt("islogin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//处理异常
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return manager;
	}

	@Override
	public void setIsLogin(Integer isLogin, Integer managerID) throws Exception {
		Connection conn = null;
		String sql = " update `t_manager` set islogin = ? ";
		try {
			conn = DBUtil.getConnection();
			
			sql = managerID != null ? sql + " where id = ? " : sql;
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, isLogin);
			if( managerID != null )ps.setInt(2, managerID);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			//处理异常
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}

}
