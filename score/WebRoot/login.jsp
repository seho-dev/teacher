<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师满意度调查系统-登陆</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<div id="yellowsolid"></div>
<body class="Login">
<div class="Login_k">
	<div class="Login_T denglu">密码登录<p></p></div>
    <!--登录-开始-->
    <form class="Login_dl denglu" method="post" action="userservlet.do?type=login">
        <div class="Login_row">
            <input name="email" type="text" value="" class="Login_input Login_inp1" placeholder="用户名" />
        </div>
        <div class="Login_row">
            <input name="password" type="password" value="" class="Login_input Login_inp2" placeholder="密码" />
        </div> 
        <input type="submit" class="Login_dla" value="登陆"></a>
        <label class="Login_pitch fl">
        	<input type="checkbox" name="checkbox01" class=" fl" /><div class="fl">自动登录</div><div class="clear"></div>
        </label>
        <div class="Login_wj fr">
        	<a>忘记密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="hrefzhuce">注册</a>
        </div><div class="clear"></div>
   </form>
    <!--登录-结束-->
    <div class="Login_T zhuce" id="zz">账号注册<p></p></div>
    <form class="Login_dl zhuce" method="post" action="userservlet.do?type=rigster">
        <div class="Login_row">
            <input name="email" type="text" class="Login_input Login_inp1" id="username" placeholder="用户名" onkeydown="ss()"/>
        </div>
        <div class="Login_row">
            <input name="password" type="password" value="" class="Login_input Login_inp2" placeholder="密码" />
        </div> 
        <input type="submit" class="Login_dla" value="注册"></a>
        <label class="Login_pitch fl">
        	<input type="checkbox" name="checkbox01" class=" fl" /><div class="fl">自动登录</div><div class="clear"></div>
        </label>
        <div class="Login_wj fr">
        	<a>忘记密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="hrefdenglu">登陆</a>
        </div><div class="clear"></div>
   </form>
</body>
<script>
$(function () {
    $('#yellowsolid').animate({
        opacity:'1'
    },1500,function(){
        $('.Login_dl').animate({
            opacity:'1'
        },500)
    })
    cc();
})
function cc(){
	$('.hrefzhuce').click(function(){
    		//登陆窗口隐藏
    		$('.denglu').css({
    			display:'none'
    		})
    		//注册窗口显示
    		$('.zhuce').css({
    			display:'block'
    		})
    });
    $('.hrefdenglu').click(function(){
    	//注册窗口隐藏
    		$('.zhuce').css({
    			display:'none'
    		})
    		//注册窗口显示
    		$('.denglu').css({
    			display:'block'
    		})
    })
}
/*
function ss(){
		setTimeout(check,100);
	}
	var xmlhttp;
function check(){
 	var a=document.getElementById("username").value;
 	//获取点击框
 	var b=document.getElementsByClassName("Login_dla").value;
	//检查如果输入值就执行ajax
	if(username==""){
		b.setAttribute("disabled","disabled");
	}else{
		$.post("userservlet.do?type=rigster",{
			username:encodeURI(a)
		},function(data){
			if(data.zc=="err"){
				//如果数据库已存在该用户就弹提示和禁止提交
				alert("该用户已存在");
				b.setAttribute("disabled","disabled");
			}else{
				b.removeAttribute("disabled");
			}
		},json)
	}
}
*/
</script>
</html>
