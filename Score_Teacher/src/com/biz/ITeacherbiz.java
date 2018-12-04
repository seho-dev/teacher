package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;

import entity.Teacher;

public class ITeacherbiz implements Teacherbiz{

	IDaojdbcImpl dao=new IDaojdbcImpl();
	public boolean addteacher(Teacher en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getTea_name());
		list.add(en.getTea_sex());
		list.add(en.getPhone());
		return dao.execute("insert into mydteachertable values(TEACHER_XX.nextval,?,?,?)", list);
	}
		
}
