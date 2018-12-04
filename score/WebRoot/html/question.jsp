<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>题库管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="http://localhost:8080/score/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/score/css/question.css">
	<script src="http://localhost:8080/score/js/jquery-3.0.0.js"></script>
	<script type="text/javascript" src="http://localhost:8080/score/js/question.js"></script>
  </head>
  
  <body>
    <p class="xml">您现在所在的位置：<a href=#>首页</a><<a href=# >题库管理</a></p>
    <div id="caozuo">
		<div id="add" onclick= "add()">
			<img src="http://localhost:8080/score/images/teacher_add.png" alt="">
			<span>添加</span>
		</div>
    <table id="ta">
		<thead>
			<tr>
				<th class="th1">题号</th>
				<th class="th2">题名</th>
				<th  class="th3">操作</th>
			</tr>
		</thead>
		<tbody>
			<!-- 迭代循环 -->
			<c:forEach items="${questionlist}" var="list1">
				<tr>
					<c:forEach items="${list1}" var="list2">
						<td>${list2}</td>
					</c:forEach>
					<td class="td">
						<div class="bianji"
							onclick="doajax('question.do?type=update',${list1[0]})">
							<img src="http://localhost:8080/score/images/teacher_bianji.png"
								alt=""></a>
						</div>
						<div class="delete">
							<a href="question.do?type=delete&&ids=${list1[0]}"><img
								src="http://localhost:8080/score/images/teacher_delete.png"
								alt=""></a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="update">
		<div class="update_title">
			<img src="http://p9s6xow5u.bkt.clouddn.com/cc.png" id="closepng1">
			<img alt="" src="http://p9s6xow5u.bkt.clouddn.com/updateicon.png"
				id="updateicon">
			<p class="titless">修改</p>
			<span class="titlen">Update</span>
		</div>
		<form action="question.do?type=alertupdate" method="post"  id="form">
			<input type="hidden" name="ids" id="getid" value=""> <span class="title">新题名&nbsp;:</span></br>
			<img class="icon icon1" src="http://p9s6xow5u.bkt.clouddn.com/usericon.png"> 
			<input type="text" name="username" id="newname" class="input"> </br> 
			<input type="submit" value="确认修改" class="submit">
		</form>
	</div>
	<div id="addwindow">
		<div class="update_title">
			<img src="http://p9s6xow5u.bkt.clouddn.com/cc.png" id="closepng2">
			<img alt="" src="http://p9s6xow5u.bkt.clouddn.com/addicon.png"
				id="updateicon">
		</div>
		<p class="titless">添加</p>
		<span class="titlen">ADD</span>
		<form action="question.do"  method="get"  id="form">
			<span class="title">题名&nbsp;&nbsp;:</br></span> <img class="icon icon1"
				src="http://p9s6xow5u.bkt.clouddn.com/usericon.png"> <input
				type="text" name="username" id="newnames" class="input"> 
				<input type="hidden" name="add" value="add">
			</br> <input type="submit" value="确认添加" id="addsubmit">
		</form>
	</div>
	<ul class="pagination pageindex">
</ul>
  </body>
</html>
