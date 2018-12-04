package com.acition;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ITeacherbiz;

import entity.Teacher;
@WebServlet ("/submitteacher.do")
public class teacheraction extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ITeacherbiz biz=new ITeacherbiz();
		//获取参数
		String type=request.getParameter("type");
		if("information".equals(type)){
				//获取传递过来的参数
				String  teacherName=request.getParameter("teacherName");
				String  teachersex=request.getParameter("teachersex");
				String  teacherphone=request.getParameter("teacherphone");
				System.out.println(teacherphone);
				Teacher en=new Teacher();
				en.setTea_name(teacherName);
				en.setTea_sex(teachersex);
				en.setPhone(Integer.valueOf(teacherphone));
				if(biz.addteacher(en)){
						//如果添加成功
					out.print("success");
					out.close();
				}else{
					out.print("fasle");
					out.close();
				}
				
		}

	}

}
