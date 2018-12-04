package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.biz.Question;
import com.dao.IDaojdbcImpl;
import com.entity.paperclasstable;

public class IQuestionImpl implements Question{
	IDaojdbcImpl dao=new IDaojdbcImpl();
	public List<Object> getquestion(int pages) {
		List<Object> list=new ArrayList<Object>();
		list.add((pages-1)*1);
		list.add(pages*1);
		return dao.getSimpleObject("select que_name FROM (select e.*,rownum rn from (select * from mydquestiontable ORDER BY id asc) e )where rn>? and rn<=?", list);
	}
	@Override
	public int getquestionrow() {
		
		return dao.gettablerow("select count(*) from mydquestiontable");
	}
	@Override
	public boolean insertInformation(paperclasstable en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getUser_name());
		list.add(en.getClass_name());
		list.add(en.getKecheng_name());
		list.add(en.getQue1());
		list.add(en.getQue2());
		list.add(en.getZhuanye_name());
		list.add(en.getQue3());
		list.add(en.getAllScore());
		list.add(en.getTeacher_id());
		list.add(en.getTeacher_name());
		return dao.execute("insert into mydscoretable values(SCORE_XX.nextval,?,?,?,?,?,?,?,?,?,?)", list);
	}
	public List<Object> getteacherid(String name) {
		List<Object> list=new ArrayList<Object>();
		list.add(name);
		return dao.getSimpleObject("select teacher_id from mydteachertable where teacher_name=?", list);
	}
}
;