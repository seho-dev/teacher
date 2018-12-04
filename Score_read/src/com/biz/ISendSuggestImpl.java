package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.Suggesttable;

public class ISendSuggestImpl implements SendSuggest{

	//调用dao
	IDaojdbcImpl dao=new IDaojdbcImpl();
	public boolean addSuggest(Suggesttable en) {
		List<Object> list=new ArrayList<Object>();
			list.add(en.getClassName());
			list.add(en.getName());
			list.add(en.getSuggest_Text());
		return dao.execute("insert into mydsuggest values(success_xx.nextval,?,?,?,'未受理')", list);
	}

}
