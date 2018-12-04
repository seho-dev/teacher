package com.biz;

import java.util.List;

import com.entity.EnInformation;

public interface Information {

		//增加一条记录
		public boolean add(EnInformation  en,String teacherid);
		//查询是否有重复记录
		public boolean Cover(EnInformation  en);
		//通过老师名字查询id
		public List<Object> getid(String name);
}
