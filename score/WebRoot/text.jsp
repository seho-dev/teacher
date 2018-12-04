<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE">
<html>
<head>
<title>text.html</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="renderer" content="ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<!--自动清除浏览器缓存-->
<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<META HTTP-EQUIV="expires" CONTENT="0">
<!--导入semantic框架-->
<link rel="stylesheet" type="text/css"
	href="js/semantic UI/semantic.css">
<link rel="stylesheet" type="text/css"
	href="js/semantic UI/semantic.min.css">
<!--导入唯译框架包-->
<script src="js/WYUtil Edition v0.5/js/WYUtil/wyUtil.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/WYUtil Edition v0.5/css/wyUtilStyle.css">
<!--导入jq包-->
<script src="js/semantic UI/jquery-1.10.2.js"></script>
<script src="js/semantic UI/jquery-1.10.2.min.js"></script>
<script src="js/semantic UI/jquery-3.0.0.js"></script>
<!--正文CSS and JS-->
<link rel="stylesheet" href="css/text.css">
<link href="css/jquery.circliful.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.circliful.min.js"></script>
<script type="text/javascript" src="js/text.js"></script>
<!--调用接口实现识别本机IP地址-->
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
</head>
<body>
	<p id="index">欢迎您，首页！</p>
	<p class="hr"></p>
	<img src="images/user.png" alt="">
	<p class="user_text">
		用户：admin 身份：管理员<br /> <br />登陆IP：<span class="ip"></span>
	</p>
	<img src="images/fangke.png" alt="" class="user_fangke_img">
	<p class="user_fangke">
		访客数：8,457<br />
	</p>
	<img src="images/user_group.png" alt="" class="user_group_img">
	<p class="user_group">
		<br />
	</p>
	<img src="images/emil.png" alt="" class="user_emil_img">
	<p class="user_emil">
		<br />
	</p>
	<p id="enlish1">Visitors</p>
	<p id="enlish2">User</p>
	<p id="enlish3">Message</p>
	<div id="news">
		<p class="tz">通知栏</p>
		<ul class="ui ul">
			<li><a href="#" onclick="add()">探秘中国互联网的发源地”——免费北 ......</a></li>
			<li><a href="#" onclick="add()">新华·优客一订单班签约仪式圆满成功 ......</a></li>
			<li><a href="#" onclick="add()">新华X-Gaming战队出征北京2018WVA全球V
					......</a></li>
			<li><a href="#" onclick="add()">超大福利 20名电商学子赴义乌实习啦 ......</a></li>
		</ul>
	</div>
	<div id="tjt">
		<div id="myStat" data-dimension="250" data-text="${number[2]}%"
			data-info="学生对老师的任课情况" data-width="30" data-fontsize="38"
			data-percent="${number[2]}" data-fgcolor="#61a9dc" data-bgcolor="#eee"
			data-fill="#ddd"></div>
		<div id="myStat1" data-dimension="250" data-text="${number[3]}%" data-info="学生对老师的周分享情况" data-width="30" data-fontsize="38" data-percent="${number[3]}" data-fgcolor="red" data-bgcolor="#eee" data-fill="#ddd">
		<div id="myStat3" data-dimension="250" data-text="${number[4]}%" data-info="完成满意度调查问卷情况" data-width="30" data-fontsize="38" data-percent="${number[4]}" data-fgcolor="#99CCCC" data-bgcolor="#eee" data-fill="#ddd"></div>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#myStathalf').circliful();
					$('#myStat').circliful();
					$('#myStat1').circliful();
					$('#myStat3').circliful();
					$('#myStathalf2').circliful();
					$('#myStat2').circliful();
					$(".ip").html(returnCitySN["cip"]);
					$.ajax({
						url : "userservlet.do?type=UserNum",
						type : "post",
						success : function(data) {
							console.log(data);
							//把值插入到对应的class中
							$('.user_group').html("用户数：" + data.newsnum[0]);
							$('.user_emil').html("消息数：" + data.newsnum[1]);
						}
					});
				});
			</script>
</html>
