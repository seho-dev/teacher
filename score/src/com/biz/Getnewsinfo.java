package com.biz;

import java.util.List;

import com.entity.newstable;

public interface Getnewsinfo {
	/**
	 * 获取全部的消息列表
	 */
	public List<List<Object>> getnews(int pageindex);
	/**
	 * 修改单条的消息状态
	 */
	public boolean updatesimple(int ids);
	/**
	 * 确定一个表有多少页
	 */
	public int gettablepage(int pageindex); 
	/**
	 * 获取所有分页显示
	 */
	public List<List<Object>> getallfenye(int page);
}
