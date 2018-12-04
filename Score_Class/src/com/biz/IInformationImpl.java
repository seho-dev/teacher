package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.EnInformation;

public class IInformationImpl implements Information{

	static IDaojdbcImpl dao=new IDaojdbcImpl();
	public boolean add(EnInformation en,String teacherid) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getClassName());
		list.add(en.getClassZhuanye());
		list.add(en.getClassTeacher());
		list.add(en.getPassport());
		list.add(en.getClassKecheng());
		list.add(teacherid);
		return dao.execute("insert into mydclasstable values(Clsss_xx.nextval,?,?,?,?,?,?)", list);
	}
	@Override
	public boolean Cover(EnInformation en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getClassName());
		list.add(en.getClassZhuanye());
		list.add(en.getClassTeacher());
		list.add(en.getClassKecheng());
		System.out.println(list);
		return dao.getManyObject("select * from mydclasstable where class_name=? and class_zhuanye=? and class_teacher=? and class_name=?", list).size()>0 ?  true : false;
	}
	@Override
	public List<Object> getid(String name) {
		List<Object> list=new ArrayList<Object>();
		list.add(name);
		return dao.getSimpleObject("select teacher_id from mydteachertable where teacher_name=?", list);
	}
	
}
