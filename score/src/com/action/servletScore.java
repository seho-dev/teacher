package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.IScoreinfoImpl;
import com.entity.paperclasstable;

import net.sf.json.JSONObject;
public class servletScore extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//获取变量
			String option=req.getParameter("option");
			//匹配变量
			if("submit".equals(option)){
				//获取ajax传过来的参数
				String que1=req.getParameter("que1");
				String que2=req.getParameter("que2");
				String que3=req.getParameter("que3");
				String que4=req.getParameter("que4");
				String user=(String)req.getSession().getAttribute("username");
				//把参数封装在实体类中
				paperclasstable en = new paperclasstable();
				IScoreinfoImpl biz=new IScoreinfoImpl();
				// 把数据先放到实体类
				//把session变量放到实体类
				String Username=(String)req.getSession().getAttribute("Username");
				String select=(String)req.getSession().getAttribute("select");
				String teacher=(String)req.getSession().getAttribute("teacher");
				String clas=(String)req.getSession().getAttribute("clas");
				en.setSelect(select);
				en.setTeacher(teacher);
				en.setClas(clas);
				en.setUsername(Username);
				en.setUser_id(Integer.parseInt(user));
				en.setQue1(que1);
				en.setQue2(que2);
				en.setQue3(que3);
				en.setQue4(que4);
				//定义输出流
				PrintWriter oo=resp.getWriter();
				//调用biz业务逻辑层
				if(biz.addscore(en)){
					//如果为真就用json输出数据
					JSONObject js=new JSONObject();
					js.put("que",en);
					oo.print(js);
					oo.close();
				}
				
			}
		}
}
