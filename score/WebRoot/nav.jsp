<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
  <head>
    <title>nav.html</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="css/alertStyle.css">
    <script src="js/nav.js"></script>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/jquery-3.0.0.js"></script>
    <script src="js/alertJS.js"></script>
  </head>
  <body>
    	<ul id="ul_">
    		<li><a href="nav.do?option=teacher" target="text1"><img src="images/teacher.png" alt=""><span>教师列表</span></a></li>
            <li><a href="#"><img src="images/student.png" alt=""><span>学生列表</span></a></li>
    		<li><a href="html/score_text.jsp" target="text1"><img src="images/score.png" alt=""><span>分数概览</span></a></li>
    		<li><a href="nav.do?option=question" target="text1"><img src="images/question.png" alt=""><span>题库管理</span></a></li>
    		<li><a href="html/up_sugggest.jsp"  target="text1"><img src="images/tousu.png" alt=""><span>投诉建议</span></a></li>
    		<li><a href="html/toupiao.jsp" target="text1"><img src="images/toupiao.png" alt=""><span>竞赛投票</span></a></li>
    		<li><a href="nav.do?option=userinfo" target="text1"><img src="images/userinfo.png" alt=""><span>个人中心</span></a></li>
            <li><a href="nav.do?option=news" target="text1"><img src="images/text.png" alt=""><span>我的消息</span></a></li>
    		<li><a href="html/about.jsp"  target="text1"><img src="images/guanyu.png" alt=""><span>关于系统</span></a></li>
    		<li class="return"><a href="#"><img src="images/zhankai.png" alt="" class="img_"><span>缩进</span></a></li>
    	</ul>
  </body>
</html>
