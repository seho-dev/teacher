package com.biz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.dao.IDaojdbcImpl;
import com.entity.paperclasstable;

public class IScoreinfoImpl implements Scoreinfo{

	@Override
	public boolean addscore(paperclasstable en) {
		List<Object> list=new ArrayList<Object>();  
		list.add(en.getUser_id());
		list.add(en.getUsername());
		list.add(en.getSelect());
		list.add(en.getTeacher());
		list.add(en.getClas());
		list.add(en.getQue1());
		list.add(en.getQue2());
		list.add(en.getQue3());
		list.add(en.getQue4());
		//µ÷ÓÃdao°ü
		IDaojdbcImpl dao=new IDaojdbcImpl();
		return dao.execute("insert into mydscoretable values(score_xx.nextval,?,?,?,?,?,?,?,?,?)", list);
	}
		
}
