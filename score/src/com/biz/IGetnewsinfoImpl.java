package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;

public class IGetnewsinfoImpl implements Getnewsinfo{

	@Override
	public List<List<Object>> getnews(int pageindex) {
		//调用数据访问层
		IDaojdbcImpl dao=new IDaojdbcImpl();
		List<Object> list=new ArrayList<Object>();
		list.add((pageindex-1)*5);
		list.add((pageindex)*5);
		return dao.getManyObject("select success_id,class_name,user_name,text_success,text_zt FROM (select e.*,rownum rn from (select * from success ORDER BY success_id asc) e )where rn>? and rn<=?", list);
	}

	@Override
	public boolean updatesimple(int ids) {
		//调用数据访问层
		IDaojdbcImpl dao=new IDaojdbcImpl();
		List<Object> list=new ArrayList<Object>();
		list.add(ids);
		return dao.execute("update success set text_zt='已受理' where success_id=?", list);
	}

	@Override
	public int gettablepage(int pageindex) {
		//调用数据访问层
		IDaojdbcImpl dao=new IDaojdbcImpl();
		int count=dao.gettablerow("select count(*) from success");
		if(count%pageindex==0){
			return count/pageindex;
		}else{
			return count/pageindex+1;
		}
	}

	public List<List<Object>> getallfenye(int page) {
				//调用数据访问层
				IDaojdbcImpl dao=new IDaojdbcImpl();
				List<Object> list=new ArrayList<Object>();
				list.add((page-1)*5);
				list.add((page)*5);
				return dao.getManyObject("select success_id,class_name,user_name,text_success,text_zt FROM (select e.*,rownum rn from (select * from success ORDER BY success_id asc) e )where rn>? and rn<=?",list);
	}
}
