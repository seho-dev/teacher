package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.ClassInformation;

public class IClassinfoImpl implements Classinformation{
//ªÒ»°dao
	IDaojdbcImpl dao=new IDaojdbcImpl();
	public boolean getclassinfo(ClassInformation cl) {
		List<Object> list=new ArrayList<Object>();
		list.add(cl.getClassname());
		list.add(cl.getProfessional());
		list.add(cl.getPass());
		list.add(cl.getCourse());
		list.add(cl.getTeacher());
		return dao.getSimpleObject("select * from mydclasstable where class_name=? and class_zhuanye=?   and class_pass=? and class_classname=?  and teacher_id=? ", list).size()>0 ? true :false;
	}
}
