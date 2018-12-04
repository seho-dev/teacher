package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.IGetquestionImpl;
import com.entity.question;

import net.sf.json.JSONObject;

public class servletquestion extends HttpServlet {
	
	IGetquestionImpl qu=new IGetquestionImpl();
	question en=new question();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 	HttpSession session =  request.getSession();
			ServletContext app= request.getServletContext();
		 	String type=request.getParameter("add");
		 	String option=request.getParameter("type");
		 	if("add".equals(type)){
	 			request.setCharacterEncoding("UTF-8");
		 		//获取题名
		 		String username=request.getParameter("username");
		 		//调用业务逻辑层的添加方法
		 		en.setQuestionname(username);
		 		if(qu.addquestion(en)){
		 			//如果成功添加就转发到
		 			List<List<Object>> list=qu.getalllist(1);
		 			//把list放到request范围的变量中
		 			request.setAttribute("questionlist",list);
		 			request.getRequestDispatcher("html/question.jsp").forward(request, response);
		 		};
		 	}else if("page".equals(option)){
	 			request.setCharacterEncoding("UTF-8");
		 			IGetquestionImpl biz=new IGetquestionImpl();
		 			//page变换的操作
		 			String index=request.getParameter("index");
		 			app.setAttribute("index", index);
		 			//如果目前是首页，点击上一页则不动
		 			if(Integer.valueOf(index)<=0){
		 				app.setAttribute("index", 1);
		 			};
		 			//如果是末页，则点击下一页不动
		 			if(biz.gettablerow(5)<Integer.valueOf(index)){
		 				app.setAttribute("index",biz.gettablerow(5));
		 			};
		 			List<List<Object>> questionlist=biz.getalllist(Integer.valueOf(index));
		 			request.setAttribute("questionlist", questionlist);
		 			//转发
		 			request.getRequestDispatcher("html/question.jsp").forward(request, response);
		 	}else if("pagenum".equals(option)){
	 			request.setCharacterEncoding("UTF-8");
		 		response.setContentType("text/html;charset=utf-8");
		 		//定义一个输出流
		 		PrintWriter puton=response.getWriter();
		 		//返回参数
		 		IGetquestionImpl biz=new IGetquestionImpl();
		 		puton.print(biz.gettablerow(5));
		 		puton.close();
		 	}else if("update".equals(option)){
	 			request.setCharacterEncoding("UTF-8");
		 			response.setContentType("text/json;charset=utf-8");
		 			PrintWriter oo=response.getWriter();
		 			//获取id
		 			String id=request.getParameter("id");
		 			en.setId(Integer.valueOf(id));
		 			//调用biz
		 			List<Object> list=qu.getsimple(en);
		 			JSONObject json=new JSONObject();
		 			json.put("simplelist", list);
		 			oo.print(json);
		 			oo.close();
		 	}else if("alertupdate".equals(option)){
		 			request.setCharacterEncoding("UTF-8");
		 			response.setContentType("text/html;charset=utf-8");
		 			//获取里面的新名字
		 			String newname=request.getParameter("username");
		 			String id=request.getParameter("ids");
		 			en.setQuestionname(newname);
		 			en.setId(Integer.valueOf(id));
		 			//调用biz
		 			if(qu.nameupdate(en)){
		 				//如果修改成功
		 				List<List<Object>> questionlist=qu.getalllist(1);
		 				request.setAttribute("questionlist",questionlist);
		 				request.getRequestDispatcher("html/question.jsp").forward(request, response);
		 			}else{
		 				response.sendRedirect("html/question.jsp");
		 			};
		 	}else if("delete".equals(option)){
		 			String id=request.getParameter("ids");
		 			en.setId(Integer.valueOf(id));
		 			if(qu.delete(en)){
		 				List<List<Object>> questionlist=qu.getalllist(1);
		 				request.setAttribute("questionlist",questionlist);
		 				request.getRequestDispatcher("html/question.jsp").forward(request, response);
		 			}
		 	}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req,resp);
		}
	}


