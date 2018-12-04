package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.Teachertable;

public class IGetinfomationImpl implements Getinformation{
	//调用数据访问层
	IDaojdbcImpl dao=new IDaojdbcImpl();
	public List<List<Object>> getall(int pageindex) {
		//调用数据访问层
		List<Object> list=new ArrayList<Object>();
		list.add((pageindex-1)*5);
		list.add((pageindex)*5);
		return dao.getManyObject("select teacher_id,teacher_name,teacher_sex,class_id FROM (select e.*,rownum rn from (select * from mydteachertable ORDER BY teacher_id asc) e )where rn>? and rn<=?",list);
	}
	@Override
	public boolean deleteinformation(int ids) {
		List<Object> list=new ArrayList<Object>();
		list.add(ids);
		return dao.execute("delete from mydteachertable where teacher_id=?", list);
	}
	public List<Object> getsimpleinformation(int ids) {
		List<Object> list=new ArrayList<Object>();
		list.add(ids);
		return dao.getSimpleObject("select * from mydteachertable where teacher_id=?", list);
	}
	@Override
	public boolean updatesimple(Teachertable en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getTeacher_name());
		list.add(en.getTeacher_sex());
		list.add(en.getClass_id());
		list.add(en.getTeacher_id());
		return dao.execute("update mydteachertable set teacher_name=?,teacher_sex=?,class_id=? where teacher_id=?", list);
	}
	public boolean addinformation(Teachertable en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getTeacher_name());
		list.add(en.getTeacher_sex());
		list.add(en.getClass_id());
		return dao.execute("insert into mydteachertable values(teacher_xx.nextval,?,?,?)",list);
	}
	
	public int gettablepage(int pagesize) {
		int count=dao.gettablerow("select count(*) from mydteachertable");
		if(count%pagesize==0){
			return count/pagesize;
		}else{
			return count/pagesize+1;
		}
		
	}
	@Override
	public List<List<Object>> getusernamelist(int pageindex,String username) {
		List<Object> list=new ArrayList<Object>();
		list.add(username);
		list.add((pageindex-1)*5);
		list.add((pageindex)*5);
		return dao.getblurObject("select teacher_id,teacher_name,teacher_sex,class_id FROM (select e.*,rownum rn from (select * from mydteachertable where teacher_name=? ORDER BY teacher_id asc) e )where rn>? and rn<=?", list);
	}
	@Override
	public List<List<Object>> getusernumlist(int pageindex, String username) {
		List<Object> list=new ArrayList<Object>();
		list.add(username);
		list.add((pageindex-1)*5);
		list.add((pageindex)*5);
		return dao.getblurObject("select teacher_id,teacher_name,teacher_sex,class_id FROM (select e.*,rownum rn from (select * from mydteachertable where teacher_id=? ORDER BY teacher_id asc) e )where rn>? and rn<=?", list);
	}
	
	}
	
