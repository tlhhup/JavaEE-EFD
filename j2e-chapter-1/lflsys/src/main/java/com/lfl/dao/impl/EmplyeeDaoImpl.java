package com.lfl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lfl.dao.EmplyeeDao;
import com.lfl.model.Emplyee;
import com.lfl.model.Goods;
import com.lfl.util.DBUtil;

public class EmplyeeDaoImpl implements EmplyeeDao{

	@Override
	public List<Emplyee> queryEmpList(Integer pageNow, Integer pageRow) throws Exception {
		List<Emplyee> list = new ArrayList<Emplyee>();
		Emplyee emp = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select emp.id id, emp.`empNo`, emp.`name`, emp.`sex`, emp.`age`, dept.`name` dName, job.`name` jName "
							+ " from `t_employee` emp "
							+ " left join `t_dept` dept on emp.`dept_id` = dept.`id` "
							+ " left join `t_job` job on emp.`job_id` = job.`id` "
							+ " order by emp.id asc "
							+ " limit ?, ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNow - 1) * pageRow);
			ps.setInt(2, pageRow);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ){//用户合法
				emp = new Emplyee();
				emp.setId(rs.getInt("id"));
				emp.setEmpNo(rs.getString("empNo"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getInt("sex"));
				emp.setAge(rs.getInt("age"));
				emp.setdName(rs.getString("dName"));
				emp.setjName(rs.getString("jName"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//处理异常
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public Integer queryTotalRow() throws Exception {
		Connection conn = null;
		Integer totalRow = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = " select COUNT(*) coun from `t_employee` ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) totalRow = rs.getInt("coun");
		} catch (SQLException e) {
			e.printStackTrace();
			//处理异常
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return totalRow;
	}

	@Override
	public void add( String name ) throws Exception {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " insert into `t_employee`(name) values(?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public Emplyee queryByName(String name) throws Exception {
		Connection conn = null;
		Emplyee emp = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select * from `t_employee` where name = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ){
				emp = new Emplyee();
				//下面的set方法不写了。。。。
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//处理异常
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return emp;
	}

}
