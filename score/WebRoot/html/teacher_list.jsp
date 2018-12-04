<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
<head>
<title>teacher_list.html</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/score/css/teacherlist.css">
<link
	href="http://localhost:8080/score/js/WYUtil Edition v0.5/css/wyUtilStyle.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="http://localhost:8080/score/js/WYUtil Edition v0.5/js/WYUtil/wyUtil.js"></script>
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script src="http://localhost:8080/score/js/teacher_list.js"></script>
</head>
<body>
	<p class="xml">
		您现在所在的位置：<a href=#>首页</a><<a href=#>教师列表</a>
	</p>
	<div id="caozuo">
		<div id="add">
			<img src="http://localhost:8080/score/images/teacher_add.png" alt="">
			<span>添加</span>
		</div>
		<form action="teacher.do?option=sousuo" method="post">
			<input type="text" name="textname" class="sousuokuang"
				placeholder="请输入编号/教师姓名"> <input type="submit"
				id="sousuojian" value="查找""> <select name="xuanze"
				id="select">
				<option>编号</option>
				<option>姓名</option>
			</select>
		</form>
	</div>
	<table id="ta">
		<thead>
			<tr>
				<th class="th1">工号</th>
				<th class="th1">姓名</th>
				<th class="th1">性别</th>
				<th class="th1">任课科目</th>
				<th class="th1">操作</th>
			</tr>
		</thead>
		<tbody>
			<!-- 迭代循环 -->
			<c:forEach items="${teacherlist}" var="list1">
				<tr>
					<c:forEach items="${list1}" var="list2">
						<td>${list2}</td>
					</c:forEach>
					<td class="td">
						<div class="bianji"
							onclick="doajax('teacher.do?option=update',${list1[0]})">
							<img src="http://localhost:8080/score/images/teacher_bianji.png"
								alt=""></a>
						</div>
						<div class="delete">
							<a href="teacher.do?option=delete&&ids=${list1[0]}"><img
								src="http://localhost:8080/score/images/teacher_delete.png"
								alt=""></a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- <div id="submit">
      <form action="#" method="get" accept-charset="utf-8">
            <input type="text" name="">
             <input type="text" name="">
              <input type="text" name="">
               <input type="text" name="">
                <input type="text" name="">
      </form>
  </div> -->
	<div id="fenye">
		<p>
			<a href="teacher.do?option=fenye&&page=1">首页</a>&nbsp;<a
				href="teacher.do?option=fenye&&page=${applicationScope.pages-1}">上一页</a>&nbsp;<a
				href="teacher.do?option=fenye&&page=${applicationScope.pages+1}">下一页</a>&nbsp;<a
				href="teacher.do?option=fenye&&page=${sessionScope.ye}">末页</a>
		</p>
	</div>
	<div id="update">
		<div class="update_title">
			<img src="http://p9s6xow5u.bkt.clouddn.com/cc.png" id="closepng1">
			<img alt="" src="http://p9s6xow5u.bkt.clouddn.com/updateicon.png"
				id="updateicon">
			<p class="titless">修改</p>
			<span class="titlen">Update</span>
		</div>
		<form action="teacher.do?option=alertupdate" method="post" id="form">
			<input type="hidden" name="ids" id="id"> <span class="title">新姓名&nbsp;:</span></br>
			<img class="icon icon1"
				src="http://p9s6xow5u.bkt.clouddn.com/usericon.png"> <input
				type="text" name="username" id="newname" class="input"> </br> <span
				class="title">性别&nbsp;&nbsp;:</span></br> <img class="icon icon2"
				src="http://p9s6xow5u.bkt.clouddn.com/sex.png"> <input
				type="text" name="sex" id="newsex" class="input"> </br> <span
				class="title">任课科目:</span></br> <img class="icon icon3"
				src="http://p9s6xow5u.bkt.clouddn.com/%E5%88%86%E7%BB%84%E5%AD%A6%E4%B9%A0&%20%E7%8F%AD%E7%BA%A7%E6%88%90%E5%91%98.png">
			<input type="text" name="class" id="newclas" class="input"> </br>
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
		<form action="teacher.do?option=alertadd" method="post" id="form">
			<span class="title">姓名&nbsp;&nbsp;:</br></span> <img class="icon icon1"
				src="http://p9s6xow5u.bkt.clouddn.com/usericon.png"> <input
				type="text" name="username" id="newnames" class="input"> </br> <span
				class="title">性别&nbsp;&nbsp;:</span></br> <img class="icon icon2"
				src="http://p9s6xow5u.bkt.clouddn.com/sex.png"> <input
				type="text" name="sex" id="newsexs" class="input"> </br> <span
				class="title">任课科目:</span></br> <img class="icon icon3"
				src="http://p9s6xow5u.bkt.clouddn.com/%E5%88%86%E7%BB%84%E5%AD%A6%E4%B9%A0&%20%E7%8F%AD%E7%BA%A7%E6%88%90%E5%91%98.png">
			<input type="text" name="class" id="newclass" class="input">
			</br> <input type="submit" value="确认添加" id="addsubmit">
		</form>
	</div>
</body>
</html>

