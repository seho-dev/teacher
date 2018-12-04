package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.biz.IClassinfoImpl;
import com.biz.IIpquery;
import com.biz.IQuestionImpl;
import com.biz.ISendSuggestImpl;
import com.entity.ClassInformation;
import com.entity.IPqueryentity;
import com.entity.Suggesttable;
import com.entity.paperclasstable;

import net.sf.json.JSONObject;

@WebServlet("/WebsitesServlet.do")
public class WebsitesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext app = request.getServletContext();
		PrintWriter o = response.getWriter();
		String type = request.getParameter("type");
		if ("information".equals(type)) {
			IIpquery ips = new IIpquery();
			response.setContentType("text/html;charset=utf-8");
			// 获取表单输入的值
			String username = request.getParameter("username");
			String Professional = request.getParameter("Professional");
			String Class = request.getParameter("Class");
			String Teacher = request.getParameter("Teacher");
			String Course = request.getParameter("Course");
			// 把基本信息存放在session中
			//把获取到的teachername转换成id插入数据库中
			//调用biz方法
			IQuestionImpl biz=new IQuestionImpl();
			List<Object> list=biz.getteacherid(Teacher);
			//把集合转化为int类型
			String teacher_id=StringUtils.join(list,"");
			//存到session中
			session.setAttribute("teacher_id", teacher_id);
			session.setAttribute("teacher_name", Teacher);
			session.setAttribute("usernamedata", username);
			session.setAttribute("Professional", Professional);
			session.setAttribute("Class", Class);
			session.setAttribute("Teacher", Teacher);
			session.setAttribute("Course", Course);
			// //获取ip和地址
			// String ip=request.getParameter("ip");
			// String address=request.getParameter("address");
			// System.out.println(ip+""+address);
			// //已获取到ip和地址,调用业务逻辑层保存ip和地址的日志到数据库
			// IIpquery biz=new IIpquery();
			// //把ip and address放到实体类
			// IPqueryentity en=new IPqueryentity();
			// en.setIp(ip);
			// en.setAddress(address);
			// boolean bb=ips.IPHave(en);
			// 如果是新访客就进入页面
			// 如果插入成功
			// JSONObject js=new JSONObject();
			o.print("yes");
			o.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession();
		if ("user".equals(type)) {
			IQuestionImpl qu = new IQuestionImpl();
			response.setContentType("text/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			JSONObject json = new JSONObject();
			json.put("usernamedata", session.getAttribute("usernamedata"));
			// 输出题的名称
			List<Object> list = qu.getquestion(1);
			String questionname = StringUtils.join(list, "");
			json.put("questionname", questionname);
			o.print(json);
			o.close();
		} else if ("page".equals(type)) {
			String index = request.getParameter("index");
			// 调用biz
			IQuestionImpl biz = new IQuestionImpl();
			JSONObject json = new JSONObject();
			List<Object> list = biz.getquestion(Integer.valueOf(index));
			// 输出题的长度
			String questionname = StringUtils.join(list, "");
			int tablerow = biz.getquestionrow();
			json.put("tablerow", tablerow);
			json.put("questionname", questionname);
			o.print(json);
			o.close();
		} else if ("tablerow".equals(type)) {
			// 调用biz
			IQuestionImpl biz = new IQuestionImpl();
			int tablerow = biz.getquestionrow();
			JSONObject json = new JSONObject();
			json.put("tablerow", tablerow);
			o.print(json);
			o.close();
		} else if ("submitUp".equals(type)) {
			JSONObject json = new JSONObject();
			// 获取ip和地址
			String cityname = request.getParameter("cityname");
			String cityip = request.getParameter("cityip");
			// 获取pass
			String pass = request.getParameter("pass");
			// 调用biz
			IIpquery ip = new IIpquery();
			IPqueryentity ipHave = new IPqueryentity();
			ipHave.setIp(cityip);
			ipHave.setAddress(cityname);
			if (ip.IPHave(ipHave)) {
				// 如果没有这个地址和ip的话，可以访问做增加的操作
				if (ip.IPquery(ipHave)) {
					// 如果ip数据增加成功
					IQuestionImpl qu = new IQuestionImpl();
					paperclasstable en = new paperclasstable();
					// 获取3个问答题的分数
					String que1 = request.getParameter("que1");
					String que2 = request.getParameter("que2");
					String que3 = request.getParameter("que3");
					// 获取总分
					String Allscore = request.getParameter("allScore");
					// 之间的问卷信息从session取出
					String username = (String) session.getAttribute("usernamedata");
					String Professional = (String) session.getAttribute("Professional");
					String Class = (String) session.getAttribute("Class");
					String Teacher_id = (String) session.getAttribute("teacher_id");
					String Teacher_name = (String) session.getAttribute("teacher_name");
					String Course = (String) session.getAttribute("Course");
					// 调用biz
					en.setUser_name(username);
					en.setZhuanye_name(Professional);
					en.setClass_name(Class);
					en.setTeacher_name(Teacher_name);
					en.setTeacher_id(Teacher_id);
					en.setKecheng_name(Course);
					en.setQue1(Integer.valueOf(que1));
					en.setQue2(Integer.valueOf(que2));
					en.setQue3(Integer.valueOf(que3));
					en.setAllScore(Allscore);
					boolean bb=qu.insertInformation(en);
					if (bb) {
						// 如果添加成功
						json.put("yes", "yes");
						o.print(json);
					} else {
						json.put("no", "no");
						o.print(json);
					}
				}
			} else {
				// 如果数据库中有此ip和记录数的话，执行下面的方法
				json.put("ipDown", "ipDown");
				o.print(json);
				o.close();
			}

		} else if ("suggest".equals(type)) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String ClassName = request.getParameter("Class");
			String Name = request.getParameter("Name");
			String Text = request.getParameter("Text");
			// 调用方法
			Suggesttable en = new Suggesttable();
			ISendSuggestImpl biz = new ISendSuggestImpl();
			en.setClassName(ClassName);
			en.setName(Name);
			en.setSuggest_Text(Text);
			boolean bb = biz.addSuggest(en);
			if (bb) {
				// 如果添加成功
				o.print("success");
			} else {
				o.print("err");
			}
		}else if("class".equals(type)){
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//获取密钥
			String pass=request.getParameter("pass");
			//获取本ip
			String ip=request.getParameter("cityip");
			String Professional = (String) session.getAttribute("Professional");
			String Class = (String) session.getAttribute("Class");
			String Teacher_id = (String) session.getAttribute("teacher_id");
			String Course = (String) session.getAttribute("Course");
			//调用实体类
			ClassInformation cn=new ClassInformation();
			cn.setClassname(Class);
			cn.setProfessional(Professional);
			cn.setCourse(Course);
			cn.setTeacher(Teacher_id);
			cn.setPass(pass);
			//调用方法
			IClassinfoImpl biz=new IClassinfoImpl();
			if(biz.getclassinfo(cn)){
					//如果能查到记录，说明密钥以及信息正确
					o.print("keysuccess");
					o.close();
			}else{
				//如果没能查询到记录，说明密钥以及信息与原数据不符合
				//需要清除本ip，让用户重新提交
				//调用ip的biz方法
				IIpquery ipbiz=new IIpquery();
				if(ipbiz.deleteIp(ip)){
						//如果删除成功
						o.print("keyerr");
						o.close();
				}
			}
		}
		doGet(request, response);
	}

}
