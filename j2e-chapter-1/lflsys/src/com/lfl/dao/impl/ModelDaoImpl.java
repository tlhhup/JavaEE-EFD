package com.lfl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lfl.dao.ModelDao;
import com.lfl.model.Func;
import com.lfl.model.Model;
import com.lfl.util.DBUtil;

public class ModelDaoImpl implements ModelDao{

	@Override
	public List<Model> queryModelByID(Integer managerID) throws Exception {
		List<Model> list = new ArrayList<Model>();
		Model model = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select model.* "
							+ " from `t_model` model "
							+ " where model.`manager_id` = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, managerID);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ){
				model = new Model();
				model.setId(rs.getInt("id"));
				model.setName(rs.getString("name"));
				model.setManager_id(rs.getInt("manager_id"));
				model.setUrl(rs.getString("url"));
				list.add(model);
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

}
