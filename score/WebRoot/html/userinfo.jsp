<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'userinfo.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/userinfo.css">
<script src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/userinfo.js"></script>
</head>

<body>
	<p class="xml">
		您现在所在的位置：<a href=#>首页</a><<a href=#>用户中心</a>
	</p>
	=====${imghead}=======
	<div id="window">
		<div id="left">
			<img alt="" src="images/fengjing.jpg">
			<div class="imghead">
				<img src="${applicationScope.imghead}"
					id="headimg">
			</div>
			<h2 class="username">Admin</h2>
			<!-- 修改头像的弹窗 -->
		</div>
		<div id="right">
			<ul class="information">
				<li><img src="images/username.png"><span
					class="usernames">123</span></li>
				<li><img src="images/moregengduo.png"></li>
			</ul>
		</div>
		<div id="headwindow">
		<form action="userinfo.do" enctype="multipart/form-data" method="post">
			<img alt="" src="http://p9s6xow5u.bkt.clouddn.com/truephoto.jpg"
				id="updateimg">
			<p class="chagehead">更换头像</p>
			<span class="chageheads">Change the Avatar</span> 
			<a href="javascript:void(0);" id="choosefile">选择文件 </a> 
				<input type="file" class="myFileUpload" name="file">
			<div class="show"></div>
			<input type="submit" value="提交" style="width:100px;height:100px;margin:0 30px;">
		</div>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".myFileUpload").change(function() {
				var arrs = $(this).val().split('\\');
				var filename = arrs[arrs.length - 1];
				$(".show").html(filename);
			});
		});
	</script>
</body>
</html>
