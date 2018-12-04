<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
  <head>
    <title>text.html</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <!--导入semantic框架-->
    <link rel="stylesheet" type="text/css" href="js/semantic UI/semantic.css">
    <link rel="stylesheet" type="text/css" href="js/semantic UI/semantic.min.css">
    <script src="js/semantic UI/semantic.min.js"></script>
    <script src="js/semantic UI/semantic.js"></script>
    <!--导入唯译框架包-->
    <script src="js/WYUtil Edition v0.5/js/WYUtil/wyUtil.js"></script>
    <link rel="stylesheet" type="text/css" href="js/WYUtil Edition v0.5/css/wyUtilStyle.css">
    <!--导入jq包-->
    <script src="js/semantic UI/jquery-1.10.2.js"></script>
    <script src="js/semantic UI/jquery-1.10.2.min.js"></script>
    <script src="js/semantic UI/jquery-3.0.0.js"></script>
    <!--正文CSS and JS-->
    <link rel="stylesheet" href="css/text.css">
      <link href="css/jquery.circliful.css" rel="stylesheet" type="text/css" />
      <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
      <script src="js/jquery.circliful.min.js"></script>
      <!--调用接口实现识别本机IP地址-->
      <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>    </head>
  <body>
<p id="index">欢迎您，首页！</p>
<p class="hr"></p>
    <img src="images/user.png" alt="">
    <p class="user_text">用户：admin 身份：普通用户<br/><br/>登陆IP：<span class="ip"></span></p>
    <img src="images/fangke.png" alt="" class="user_fangke_img">
    <p class="user_fangke">访客数：8,457<br/>Visitors</p>
    <img src="images/user_group.png" alt="" class="user_group_img">
    <p class="user_group"><br/>User</p>
    <img src="images/emil.png" alt="" class="user_emil_img">
    <p class="user_emil">消息：32条<br/>Message</p>
  </body>
 <div id="news">
     <p class="tz">通知栏</p>
        <ul class="ui ul">
            <li><a href="#" onclick="add()">探秘中国互联网的发源地”——免费北 ......</a></li>
            <li><a href="#" onclick="add()">新华·优客一订单班签约仪式圆满成功 ......</a></li>
            <li><a href="#" onclick="add()">新华X-Gaming战队出征北京2018WVA全球V ......</a></li>
            <li><a href="#" onclick="add()">超大福利 20名电商学子赴义乌实习啦 ......</a></li>
        </ul>
 </div>
  <div id="myStat" data-dimension="250" data-text="75%" data-info="学生对老师的任课情况" data-width="30" data-fontsize="38" data-percent="75" data-fgcolor="#61a9dc" data-bgcolor="#eee" data-fill="#ddd"></div>
  <div id="myStat1" data-dimension="250" data-text="60%" data-info="学生对老师的周分享情况" data-width="30" data-fontsize="38" data-percent="60" data-fgcolor="red" data-bgcolor="#eee" data-fill="#ddd"></div>
  <div id="myStat3" data-dimension="250" data-text="90%" data-info="完成满意度调查问卷情况" data-width="30" data-fontsize="38" data-percent="90" data-fgcolor="#99CCCC" data-bgcolor="#eee" data-fill="#ddd"></div>
  <script>
      $( document ).ready(function() {
          $('#myStathalf').circliful();
          $('#myStat').circliful();
          $('#myStat1').circliful();
          $('#myStat3').circliful();
          $('#myStathalf2').circliful();
          $('#myStat2').circliful();
          $(".ip").html(returnCitySN["cip"]);
      });
    //调用唯译框架
      function add(){
          wyUtil.wyAlert().promptAlert("adddd","暂未开发",'#4969C7','#fff','确定','10');
      }
       var xmlhttp;
      $(function(){
      	 $.ajax({
      	url:"userservlet.do?type=UserNum",
      	type:"post",
      	success:function(data){
      	alert(data);
      		//把值插入到对应的class中
      		$('.user_group').text("用户数："+data);
      	},html})
      })
  </script>
</html>
