package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.biz.Sugggestup;
import com.dao.IDaojdbcImpl;
import com.entity.Sugggesttable;

public class ISugggesttableImpl implements Sugggestup{

	
	public boolean add(Sugggesttable en) {
		//调用数据访问层
		IDaojdbcImpl dao=new IDaojdbcImpl();
		List<Object> list=new ArrayList<Object>();
		list.add(en.getClass_name());
		list.add(en.getUser_name());
		list.add(en.getText());
		System.out.println(en.getClass_name());
		return dao.execute("insert into success values(success_xx.nextval,?,?,?,'未受理')",list);
	}

}
