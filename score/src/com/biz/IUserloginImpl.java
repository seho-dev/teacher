package com.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.Usertable;

public class IUserloginImpl implements Userlogin {

	// 调用数据访问层
	IDaojdbcImpl dao = new IDaojdbcImpl();

	public boolean UserLogin(Usertable user) {
		List<Object> list = new ArrayList<Object>();
		// 给list添加
		list.add(user.getUser_id());
		list.add(user.getUser_pd());
		if (dao.getSimpleObject("select * from mydusertable where user_id=? and user_pd=? and role_id=2", list).size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean UserRigster(Usertable user) {
		List<Object> list = new ArrayList<Object>();
		// 给list添加
		list.add(user.getUser_id());
		list.add(user.getUser_pd());
		if (dao.execute("insert into mydusertable values(?,?,2)", list)) {
			return true;
		}
		;
		return false;
	}
	@Override
	public boolean manage(Usertable user) {
		List<Object> list = new ArrayList<Object>();
		// 给list添加
		list.add(user.getUser_id());
		list.add(user.getUser_pd());
		if (dao.getSimpleObject("select * from mydusertable where user_id=? and user_pd=? and role_id=1", list).size() > 0) {
			return true;
		};
		return false;
	}

	@Override
	public boolean havepeople(Usertable user) {
		List<Object> list = new ArrayList<Object>();
		// 给list添加
		list.add(user.getUser_id());
		return dao.getSimpleObject("select * from mydusertable user_id=?", list).size()>0 ? true : false;
	}
	public BigDecimal columnuser() {
		BigDecimal num =null;
		 List<Object> list=dao.getSimpleObject("select count(*) from mydusertable",null);
		 Iterator<Object> it=list.iterator();
		 while(it.hasNext()){
			num= (BigDecimal)it.next();
		 }
		return num;
	}
	@Override
	public BigDecimal columnnews() {
		BigDecimal num =null;
		 List<Object> list1=dao.getSimpleObject("select count(*) from success",null);
		 Iterator<Object> it=list1.iterator();
		 while(it.hasNext()){
			num= (BigDecimal)it.next();
		 }
		return num;
	}

	@Override
	public BigDecimal getque1() {
		BigDecimal num =null;
		 List<Object> list1=dao.getSimpleObject("select round(avg(que1),2) from mydscoretable",null);
		 Iterator<Object> it=list1.iterator();
		 while(it.hasNext()){
			num= (BigDecimal)it.next();
		 }
		return num;
	}

	@Override
	public BigDecimal getque2() {
		BigDecimal num =null;
		 List<Object> list1=dao.getSimpleObject("select round(avg(que2),2) from mydscoretable",null);
		 Iterator<Object> it=list1.iterator();
		 while(it.hasNext()){
			num= (BigDecimal)it.next();
		 }
		return num;
	}

	@Override
	public BigDecimal getque3() {
		BigDecimal num =null;
		 List<Object> list1=dao.getSimpleObject("select round(avg(que3),2) from mydscoretable",null);
		 Iterator<Object> it=list1.iterator();
		 while(it.hasNext()){
			num= (BigDecimal)it.next();
		 }
		return num;
	}
}
