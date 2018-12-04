package com.biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.IDaojdbcImpl;
import com.entity.IPqueryentity;

public class IIpquery implements IPquery{
	IDaojdbcImpl dao=new IDaojdbcImpl();
	public boolean IPquery(IPqueryentity en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getIp());
		list.add(en.getAddress());
		return dao.execute("insert into mydiptable values(?,?)", list);
	}
	public boolean IPHave(IPqueryentity en) {
		List<Object> list=new ArrayList<Object>();
		list.add(en.getIp());
		list.add(en.getAddress());
		if(dao.getSimpleObject("select * from mydiptable where ip=? and address=?", list).size()==0){
			//如果没有查到此ip记录，说明访客没有访问过，可以进入页面
				return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean deleteIp(String ip) {
		List<Object> list=new ArrayList<Object>();
		list.add(ip);
		return dao.execute("delete from mydiptable where ip=?", list);
	}
}
