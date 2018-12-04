package com.dao;

import java.util.List;

public interface Daojdbc {
	 /**
     *  查找一条记录
     */
	public List<Object> getSimpleObject(String sql,List<Object> list);
	
	
	
	/*
	 * 
	 * 查询多条记录
	 */
	public List<List<Object>> getManyObject(String sql,List<Object> list);
	
	
	
	/*
	 * 删除，更新。修改
	 */
	public boolean execute(String sql,List<Object> list);
	/**
	 * 查询表中有多少记录
	 */
	public int gettablerow(String sql);
	/**
	 * 模糊查询
	 */
	public List<List<Object>> getblurObject(String sql,List<Object> list);
}
