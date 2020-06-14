package com.lfl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lfl.dao.BrandDao;
import com.lfl.model.Brand;
import com.lfl.model.Goods;
import com.lfl.util.DBUtil;

public class BrandDaoImpl implements BrandDao{

	@Override
	public Brand findById(Integer id) throws Exception {
		Connection conn = null;
		Brand brand = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select * from t_brand where id= ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ){
				brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setName(rs.getString("name"));
				brand.setFirsttype_id(rs.getInt("firsttype_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//处理异常
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return brand;
	}

	@Override
	public List<Brand> queryAll() throws Exception {
		List<Brand> list = new ArrayList<Brand>();
		Connection conn = null;
		Brand brand = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select * from t_brand ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ){
				brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setName(rs.getString("name"));
				brand.setFirsttype_id(rs.getInt("firsttype_id"));
				list.add(brand);
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
