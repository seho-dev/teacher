package com.biz;

import com.entity.IPqueryentity;

public interface IPquery {
		//增加ip数据库内
		public boolean IPquery(IPqueryentity en);
		//查询访问ip是否存在到数据库内
		public boolean IPHave(IPqueryentity en);
		//删除某个ip记录段
		public boolean deleteIp(String ip);
}
