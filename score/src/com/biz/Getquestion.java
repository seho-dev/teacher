package com.biz;

import java.util.List;

import com.entity.question;

public interface Getquestion {
	//获取问题列表的信息
	public List<List<Object>> getalllist(int pageindex);
	//添加一道题
	public boolean addquestion(question  qu);
	//通过id查数据
	public List<Object> getsimple(question  qu);
	//通过id修改数据
	public boolean nameupdate(question  qu);
	//通过id删除数据
	public boolean delete(question  qu);
	//返回它的末页
	public int gettablerow(int simplepagenum);
}
