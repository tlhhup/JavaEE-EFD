package com.lfl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lfl.dao.GoodsDirDao;
import com.lfl.util.DBUtil;

public class GoodsDirDaoImpl implements GoodsDirDao{

	@Override
	public void deleteByGoodID(Integer id) throws Exception {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " delete from `t_goodsdir` where goods_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
