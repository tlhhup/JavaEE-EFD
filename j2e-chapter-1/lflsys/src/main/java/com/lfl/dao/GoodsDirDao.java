package com.lfl.dao;

public interface GoodsDirDao {
	/**
	 * 根据商品id删除进出库记录
	 * @param id
	 * @throws Exception
	 */
	public void deleteByGoodID( Integer id )throws Exception;
}
