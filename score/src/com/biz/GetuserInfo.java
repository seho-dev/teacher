package com.biz;

import java.util.List;

import com.entity.Usertable;

public interface GetuserInfo {
	/**
	 * 修改头像
	 */
	public boolean insertimg(Usertable en);
	/**
	 * 根据账号和密码查询头像等信息（只头像）
	 */
	public List<Object> getheadimg(Usertable en);
}
