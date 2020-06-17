package com.lfl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lfl.dao.GoodsDao;
import com.lfl.model.Goods;
import com.lfl.model.Manager;
import com.lfl.util.DBUtil;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public List<Goods> queryAll() throws Exception {
		List<Goods> list = new ArrayList<Goods>();
		Goods goods = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select gd.id, ( gin.num - IFNULL(gout.num, 0) ) saveNum, gd.goodNo, br.name bName, fst.name fName, sec.name sName, gd.inPrice, gd.outPrice, gd.shelfTime "
							+ " from ( "
									+ " select * "
									+ " from `t_goodsdir` "
									+ " where type = 0 "
								+ " )gin "
								+ " left join ( "
									+ " select * "
									+ " from `t_goodsdir` "
									+ " where type = 1 "
								+ " )gout on gout.goods_id = gin.goods_id "
								+ " left join `t_goods` gd on gd.id = gin.goods_id "
								+ " left join `t_brand` br on gd.brand_id = br.id "
								+ " left join `t_firsttype` fst on gd.firstType_id = fst.id "
								+ " left join `t_sectype` sec on sec.id = gd.secType_id ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ){//用户合法
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setSaveNum(rs.getInt("saveNum"));
				goods.setGoodNo(rs.getString("goodNo"));
				goods.setName(rs.getString("bName"));
				goods.setFirstType(rs.getString("fName"));
				goods.setSecType(rs.getString("sName"));
				goods.setInPrice(rs.getInt("inPrice"));
				goods.setOutPrice(rs.getInt("outPrice"));
				goods.setShelfTime(rs.getInt("shelfTime"));
				list.add(goods);
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
	public void delete(Integer id) throws Exception {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " delete from `t_goods` where id = ? ";
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

	@Override
	public Goods findById(Integer id) throws Exception {
		Connection conn = null;
		Goods goods = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select * from t_goods where id= ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ){
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setGoodNo(rs.getString("goodNo"));
				goods.setBrand_id(rs.getInt("brand_id"));
				goods.setSecType_id(rs.getInt("secType_id"));
				goods.setInPrice(rs.getInt("inPrice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//处理异常
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return goods;
	}

}
