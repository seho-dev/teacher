package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.Usertable;

public class IGetuserInfoImpl implements GetuserInfo{

	/**
	 * ĞŞ¸ÄÍ·Ïñ
	 */
	IDaojdbcImpl dao=new IDaojdbcImpl();
	public boolean insertimg(Usertable en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getUser_img());
		list.add(en.getUser_id());
		list.add(en.getUser_pd());
		return dao.execute("update mydusertable set user_img=? where user_id=? and user_pd=?", list);
	}
	public List<Object> getheadimg(Usertable en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getUser_id());
		list.add(en.getUser_pd());
		return dao.getSimpleObject("select user_img from mydusertable where user_id=? and user_pd=?", list);
	}

}
