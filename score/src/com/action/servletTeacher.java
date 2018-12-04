package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.IGetinfomationImpl;
import com.entity.Teachertable;

import net.sf.json.JSONObject;

public class servletTeacher extends HttpServlet {
	// 调用业务逻辑层
	IGetinfomationImpl biz = new IGetinfomationImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		ServletContext app=req.getServletContext();
		System.out.println(req.getParameter("option"));
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter o = resp.getWriter();
		String option = req.getParameter("option");
		if (option.equals("delete")) {
			// 如果是删除
			String ids = req.getParameter("ids");
			if (biz.deleteinformation(Integer.parseInt(ids))) {
				// 如果删除成功就跳转到show页面
				List<List<Object>> list = biz.getall(1);
				req.setAttribute("teacherlist", list);
				req.getRequestDispatcher("html/teacher_list.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("html/teacher_list.jsp");
			}
			;
		}
		if (option.equals("fenye")){
			String page = req.getParameter("page");
			app.setAttribute("pages",page);
			if (!page.equals("") && page != null && !page.equals("null")) {
				if (Integer.parseInt(page) <= 0) {
					app.setAttribute("page",1);
				}
				if (Integer.parseInt(page) > biz.gettablepage(5)) {
					app.setAttribute("page", biz.gettablepage(5) + 1);
				}
				List<List<Object>> list = biz.getall(Integer.parseInt(page));
				session.setAttribute("ye", biz.gettablepage(5));
				req.setAttribute("teacherlist", list);
				req.getRequestDispatcher("html/teacher_list.jsp").forward(req, resp);
			}
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取类型
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter o = resp.getWriter();
		String option = req.getParameter("option");
		System.out.println(option);
		String ids = req.getParameter("ids");
		if (option.equals("update")) {
			// 调用业务逻辑层
			List<Object> list = biz.getsimpleinformation(Integer.parseInt(ids));
			// 获取json对象
			JSONObject js = new JSONObject();
			js.put("simpleteacherlist", list);
			o.print(js);
			// 关闭输出
			o.close();
		}
		if (option.equals("alertupdate")) {
			// 获取类型
			resp.setContentType("text/json;charset=utf-8");
			// 获取值
			String ids1 = req.getParameter("ids");
			String username = req.getParameter("username");
			String sex = req.getParameter("sex");
			String clas = req.getParameter("class");
			/**
			 * 把数据封装在实体类
			 * 
			 */
			Teachertable en = new Teachertable();
			en.setTeacher_id(Integer.parseInt(ids1));
			en.setTeacher_name(username);
			en.setTeacher_sex(sex);
			en.setClass_id(Integer.parseInt(clas));
			/**
			 * 调用业务逻辑层修改的方法
			 */
			if (biz.updatesimple(en)) {
				// 如果为真就显示show页面
				List<List<Object>> list = biz.getall(1);
				req.setAttribute("teacherlist", list);
				req.getRequestDispatcher("html/teacher_list.jsp").forward(req, resp);
			}
			;
		}
		Teachertable en = new Teachertable();
		if (option.equals("alertadd")) {
			// 获取值
			String username = req.getParameter("username");
			String sex = req.getParameter("sex");
			String clas = req.getParameter("class");
			en.setTeacher_name(username);
			en.setTeacher_sex(sex);
			en.setClass_id(Integer.parseInt(clas));
			/**
			 * 调用业务逻辑层修改的方法
			 */
			if (biz.addinformation(en)) {
				// 如果为真就显示show页面
				List<List<Object>> list = biz.getall(1);
				req.setAttribute("teacherlist", list);
				req.getRequestDispatcher("html/teacher_list.jsp").forward(req, resp);
			}
		}
			if (option.equals("sousuo")) {
				String page = req.getParameter("page");
				String sousuokuang = req.getParameter("textname");
				String select = req.getParameter("xuanze");
				System.out.println(sousuokuang+""+select);
				// 获取搜索框中的值
				if (("姓名").equals(select)) {
					en.setTeacher_name(sousuokuang);
					// 如果是编号调用biz
					if (page != null) {
						List<List<Object>> list = biz.getusernamelist(Integer.parseInt(page), sousuokuang);
						req.setAttribute("teacherlist", list);
					}
					req.getRequestDispatcher("html/teacher_list.jsp").forward(req, resp);
				}
				if (("编号").equals(select)) {
					en.setTeacher_id(Integer.parseInt(sousuokuang));
					// 如果是编号调用biz
					if (page != null) {
						List<List<Object>> list = biz.getusernumlist(Integer.parseInt(page), sousuokuang);
						req.setAttribute("teacherlist", list);
					}
					req.getRequestDispatcher("html/teacher_list.jsp").forward(req, resp);
				}

			}
	}
}
