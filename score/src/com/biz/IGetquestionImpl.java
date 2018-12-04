package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.question;

public class IGetquestionImpl implements Getquestion{

	//调用数据访问层
	IDaojdbcImpl dao=new IDaojdbcImpl();
	question qu=new question();
	public List<List<Object>> getalllist(int pageindex) {
		List<Object> list=new ArrayList<Object>();
		list.add((pageindex-1)*5);
		list.add((pageindex)*5);
		return dao.getManyObject("select id,que_name FROM (select e.*,rownum rn from (select * from mydquestiontable ORDER BY id desc) e )where rn>? and rn<=?", list);
	}
	public boolean addquestion(question qu) {
		List<Object> list=new ArrayList<Object>();
		list.add(qu.getQuestionname());
		return dao.execute("insert into mydquestiontable values(question.nextval,?)", list);
	}
	public int gettablerow(int simplepagenum) {
			int allcount=dao.gettablerow("select count(*) from mydquestiontable");
			if(allcount/simplepagenum==0){
					//如果能整除
					return allcount/simplepagenum;
			}else{
					//不能整除的话
					return allcount/simplepagenum+1;
			}
	};
	public List<Object> getsimple(question qu) {
		List<Object> list=new ArrayList<Object>();
		list.add(qu.getId());
		return dao.getSimpleObject("select id,que_name from mydquestiontable where id=?", list);
	}
	@Override
	public boolean nameupdate(question qu) {
		List<Object> list=new ArrayList<Object>();
		list.add(qu.getQuestionname());
		list.add(qu.getId());
		return dao.execute("update mydquestiontable  set que_name=?  where id=?", list);
	}
	@Override
	public boolean delete(question qu) {
		List<Object> list=new ArrayList<Object>();
		list.add(qu.getId());
		return dao.execute("delete from mydquestiontable where id=?",list);
	}
}
