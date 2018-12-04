package com.biz;

import java.util.List;

import com.entity.Teachertable;

public interface Getinformation {
		/**
		 * 获取列表信息（分页，参数：当前页数）
		 */
	public List<List<Object>> getall(int pageindex);
	/**
	 * 通过id删除信息
	 */
	public boolean deleteinformation(int ids);
	/**
	 * 增加单条信息
	 */
	public boolean addinformation(Teachertable en);
	/**
	 * 通过id查询信息
	 */
	public List<Object> getsimpleinformation(int ids);
	/**
	 * 修改单条
	 */
	public boolean updatesimple(Teachertable en);
	/**
	 * 确定一个表中有多少页
	 */
	public int gettablepage(int pagesize);
	/**
	 * 根据名字查询
	 */
	public List<List<Object>> getusernamelist(int pageindex,String username);
	/**
	 * 根据id查询
	 */
	public List<List<Object>> getusernumlist(int pageindex,String username);
	
}
