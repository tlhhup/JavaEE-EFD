package com.lfl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lfl.dao.FuncDao;
import com.lfl.model.Func;
import com.lfl.model.Goods;
import com.lfl.util.DBUtil;

public class FuncDaoImpl implements FuncDao{

	@Override
	public List<Func> queryFuncUrl( Integer managerID ) throws Exception {
		List<Func> list = new ArrayList<Func>();
		Func func = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select furl.id ,func.name fName, furl.`url`, func.`manager_id` `mid`, func.model_id modelID "
							+ " from `t_funcurl` furl "
							+ " left join `t_func` func on furl.`func_id` = func.id "
							+ " where func.`manager_id` = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, managerID);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ){
				func = new Func();
				func.setId(rs.getInt("id"));
				func.setName(rs.getString("fName"));
				func.setUrl(rs.getString("url"));
				func.setManager_id(rs.getInt("mid"));
				
				func.setModel_id(rs.getInt("modelID"));
				
				list.add(func);
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
