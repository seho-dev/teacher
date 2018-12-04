package com.biz;

import java.util.List;

import com.entity.paperclasstable;

public interface Question {
		//查询数据库中的题
		public List<Object> getquestion(int pages);
		//获取数据库有多少题
		public int getquestionrow();
		//插入答题信息
		public boolean insertInformation(paperclasstable en);
		//通过老师名字查询它的id
		public List<Object> getteacherid(String name);
}
