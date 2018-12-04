package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.paperclasstable;

public class servlettxwj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取用户
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");
		if (option.equals("login")) {
			// 如果操作为登陆就保存用户填写的信息到集合中
			// List<Object> list=new ArrayList<Object>();
			// 获取信息
			String username = req.getParameter("username");
			String select = req.getParameter("select");
			String teacher = req.getParameter("teacher");
			String clas = req.getParameter("clas");
			paperclasstable en = new paperclasstable();
			// 把数据先放到实体类
			//把数据放在session变量中
			req.getSession().setAttribute("Username",username);
			req.getSession().setAttribute("select",select);
			req.getSession().setAttribute("teacher",teacher);
			req.getSession().setAttribute("clas",clas);
			// 当用户点击开始答卷的时候转发到答卷页面
			req.getRequestDispatcher("html/paper.jsp").forward(req, resp);
		}
	}
}
