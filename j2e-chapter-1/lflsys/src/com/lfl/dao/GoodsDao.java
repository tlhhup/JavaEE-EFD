package com.lfl.dao;

import java.util.List;

import com.lfl.model.Goods;

public interface GoodsDao {
	/**
	 * 查询所有库存产品
	 * @return
	 * @throws Exception
	 */
	public List<Goods> queryAll() throws Exception;
	
	/**
	 * 删除商品
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer id)throws Exception;
	
	/**
	 * 根据id查询一个产品
	 * @param id
	 * @throws Exception
	 */
	public Goods findById(Integer id)throws Exception;
		
}	
