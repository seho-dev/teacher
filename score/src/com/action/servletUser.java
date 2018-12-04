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

import com.biz.IUserloginImpl;
import com.entity.Usertable;

import net.sf.json.JSONObject;

public final class servletUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	//调用业务逻辑层
	IUserloginImpl biz=new IUserloginImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ServletContext app=req.getServletContext();
		HttpSession session=req.getSession(); 
		PrintWriter oo=resp.getWriter();
		//调用实体类
		Usertable en=new Usertable();	
		String type=req.getParameter("type");
			if(type.equals("login")){
				//登陆操作
				String email=req.getParameter("email");
				String password=req.getParameter("password");
				/**
				 * 把登陆和密码的信息存储到session
				 */
				session.setAttribute("username",email);
				session.setAttribute("password",password);
				en.setUser_id(Integer.valueOf(email));
				en.setUser_pd(password);
				if(biz.manage(en)){
					//为真
					req.getRequestDispatcher("index.jsp").forward(req, resp);
					}else{
					if(biz.UserLogin(en)){
						//为真
						req.getRequestDispatcher("index2.jsp").forward(req, resp);
					}else{
						resp.sendRedirect("login.jsp");
					}
				}
			}
			if("UserNum".equals(type)){
				resp.setContentType("text/json;charset=utf-8");
				//如果为管理员登陆就在首页显示用户人数和消息通知
				JSONObject js=new JSONObject();
				//把bigdeciaml转换为String
				//String usernum=biz.columnuser().toPlainString();
				List<Object> list=new ArrayList<Object>();
				list.add(biz.columnuser());
				list.add(biz.columnnews());
				list.add(biz.getque1());
				list.add(biz.getque2());
				list.add(biz.getque3());
				session.setAttribute("number",list);
				session.setAttribute("number2","222");
				js.put("newsnum",list);
				oo.print(js);
				oo.close();
			}
			if(type.equals("rigster")){
				resp.setContentType("text/html;charset=utf-8");
				//调用实体类
				Usertable cn=new Usertable();
				//注册操作
				String email=req.getParameter("email");
				String password=req.getParameter("password");
				cn.setUser_id(Integer.parseInt(email));
				cn.setUser_pd(password);
				if(biz.UserRigster(cn)){
					//为真
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
//			if(type.equals("check")){
//				resp.setContentType("text/json;utf-8");
//				PrintWriter oo=resp.getWriter();
//				String username=req.getParameter("username");
//				//调用实体类
//				Usertable cn=new Usertable();
//				cn.setUser_id(Integer.parseInt(username));
//				//调用业务逻辑层
//				JSONObject js=new JSONObject();
//				if(biz.havepeople(cn)){
//					//如果有用户就输出err
//					js.put("zc","err");
//				}else{
//					//如果没有用户就输出yes
//					js.put("zc","yes");
//				}
//				oo.print(js);
//				oo.close();
//			}
	}
	
}
