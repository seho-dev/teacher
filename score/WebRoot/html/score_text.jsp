<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
  <head>
    <title>score_text.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<!--导入semantic框架-->
    <link rel="stylesheet" type="text/css" href="js/semantic UI/semantic.css">
    <link rel="stylesheet" type="text/css" href="js/semantic UI/semantic.min.css">
    <script src="js/semantic UI/semantic.min.js"></script>
    <script src="js/semantic UI/semantic.js"></script>
    <!--导入唯译框架包-->
    <script src="js/WYUtil Edition v0.5/js/WYUtil/wyUtil.js"></script>
    <link rel="stylesheet" type="text/css" href="js/WYUtil Edition v0.5/css/wyUtilStyle.css">
    <!--导入jq包-->
    <script src="../js/semantic UI/jquery-1.10.2.js"></script>
    <script src="../js/semantic UI/jquery-1.10.2.min.js"></script>
    <script src="../js/semantic UI/jquery-3.0.0.js"></script>
    <!--正文CSS and JS-->
    <link rel="stylesheet" href="../css/score.css">
    <script src="../js/semantic UI/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="../js/echarts.common.min.js"></script>
    <script src="../js/score.js"></script>
  </head>
  
  <body>
  <p class="xml">您现在所在的位置：<a href=#>首页</a><<a href=# >分数概览</a></p>
  <p class="title">各个专业的学生对教师满意度概览</p>
  <div id="ruanjian" class="page1">
    <img src="../images/ruanjian.png" alt="">
    <span class="rjtitle">软件专业</span>
    <span class="font" id="rjbfb"></span>
    <span class="rjjd1"></span>
    <span class="rjjd2"></span>
  </div>
  <div id="dianshang" class="page1">
    <img src="../images/dianshang.png" alt="">
    <span class="dstitle">电商专业</span>
      <span id="dsbfb" class="font"></span>
    <span class="dsjd1"></span>
    <span class="dsjd2"></span>
  </div>
  <div id="dongman" class="page1">
    <img src="../images/dongman.png" alt="">
    <span class="dmtitle">动漫专业</span>
      <span id="dmbfb" class="font"></span>
    <span class="dmjd1"></span>
    <span class="dmjd2"></span>
  </div>
  <div id="ui" class="page1">
    <img src="../images/ui.png" alt="">
    <span class="uititle">UI专业</span>
      <span id="uibfb" class="font"></span>
    <span class="uijd1"></span>
    <span class="uijd2"></span>
  </div>
  <div id="fanye">
    <img src="../images/fanye1.png" alt="" class="fanye">
  </div>
  <div id="wangyun" class="page2">
    <img src="../images/wangyun.png" alt="">
    <span class="wytitle">网运专业</span>
      <span id="wybfb" class="font"></span>
    <span class="wyjd1"></span>
    <span class="wyjd2"></span>
  </div>
  <div id="dianjin" class="page2">
      <img src="../images/game.png" alt="">
      <span class="djtitle">电竞专业</span>
      <span id="djbfb" class="font"></span>
      <span class="djjd1"></span>
      <span class="djjd2"></span>
  </div>
  <div id="wuji" class="page2">
      <img src="../images/5g.png" alt="">
      <span class="wjtitle">5G专业</span>
      <span id="wjbfb" class="font"></span>
      <span class="wjjd1"></span>
      <span class="wjjd2"></span>
  </div>
  <div id="vr" class="page2">
      <img src="../images/vr.png" alt="">
      <span class="vrtitle">VR专业</span>
      <span id="vrbfb" class="font"></span>
      <span class="vrjd1"></span>
      <span class="vrjd2"></span>
  </div>
    <div id="tjone">
       <div class="tjone_two"></div>
        <div class="tjone_three"></div>
        <div class="tjone_four"></div>
      <div class="tjone_five"></div>
      <div class="tjone_six"></div>
    </div>
  <div id="xt">
      <div id="xt_one" class="xiantiao"></div>
      <div id="xt_two" class="xiantiao"></div>
      <div id="xt_three" class="xiantiao"></div>
      <div id="xt_four" class="xiantiao"></div>
      <div id="xt_five" class="xiantiao"></div>
      <div id="xt_six" class="xiantiao"></div>
      <div id="xt_seven" class="xiantiao"></div>
      <div id="xt_eight" class="xiantiao"></div>
      <div id="xt_nine" class="xiantiao"></div>
      <div id="xt_ten" class="xiantiao"></div>
      <div id="xt_eleven" class="xiantiao"></div>
      <div id="xt_twelve" class="xiantiao"></div>
      <div id="xt_thirteen" class="xiantiao"></div>
      <div id="xt_fourteen" class="xiantiao"></div>
      <div id="xt_fifteen" class="xiantiao"></div>
      <div id="xt_sixteen" class="xiantiao"></div>

  </div>
  <div id="myinformation"></div>
  <div id="main">
  		
  </div>
  </body>
  <script>
   
  </script>
</html>
