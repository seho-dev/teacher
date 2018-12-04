package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.biz.IInformationImpl;
import com.entity.EnInformation;

@WebServlet("/submitinformation.do")
public class ServletInformation extends HttpServlet {
	EnInformation en = new EnInformation();
	IInformationImpl biz = new IInformationImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if ("information".equals(type)) {
			System.out.println("login");
			// 获取信息
			String ClassName = request.getParameter("ClassName");
			String ClassZhuanye = request.getParameter("ClassZhuanye");
			String ClassTeacher = request.getParameter("ClassTeacher");
			String ClassKecheng = request.getParameter("ClassKecheng");
			String Passport = request.getParameter("Passport");
			// 调用实体封装到里面
			en.setClassName(ClassName);
			en.setClassZhuanye(ClassZhuanye);
			en.setClassTeacher(ClassTeacher);
			en.setClassKecheng(ClassKecheng);
			en.setPassport(Passport);
			// 判断老师id
			List<Object> list = biz.getid(ClassTeacher);
			if (list.size() == 0) {
				// 如果没有这个老师
				out.print("noteacher");
				out.close();
			} else {
				// 集合转换int类型并且保存到数据库中作为外键的teacherid
				String id=StringUtils.join(list,"");
				// 判断输入的值在数据库中是否存在
				boolean bb = biz.Cover(en);
				if (bb) {
					// 如果为真，说明有值
					out.print("false");
					out.close();
				} else {
					// 调用业务逻辑层
					if (biz.add(en, id)) {
						// 如果成功
						out.print("success");
						out.close();
					} else {
						// 如果失败
						out.print("false");
						out.close();
					}
				}
			}
		}
	}

}
