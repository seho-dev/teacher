<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE>
<html>
  <head>
    <title>up_sugggest.html</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="../js/up_suggest.js"></script>
    <script src="../js/jquery-3.0.0.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  <link rel="stylesheet" type="text/css" href="../css/suggest.css">
  </head>

  <body>
  <div id="window">
    <p id="xml">您现在所在的位置：<a href="#">首页</a><<a href=#>投诉建议</a></p>
  <form action="<%=request.getContextPath()%>/servletsuggest.do?option=submit" method="post" accept-charset="utf-8">
    <p class="zy">您所在的专业/班级:
    	<select name="clas">
  				<option value ="软件专业">软件专业</option>
  				<option value ="电商专业">电商专业</option>
  				<option value="动漫专业">动漫专业</option>
  				<option value="UI专业">UI专业</option>
  				<option value="网运专业">网运专业</option>
  				<option value="电竞专业">电竞专业</option>
  				<option value="5G专业">5G专业</option>
  				<option value="VR专业">VR专业</option>
		</select>
    </p>
    <p class="name">您的昵称:<input type="text" name="name" class="inputname" onkeydown="chkvalue()"></p>
    <p class="suggest">您对我们提出的意见是:</p><textarea class="yijian" style="min-height: 150px;min-width: 370px;max-height: 150px;" onkeydown="chkvalue()" name="text"></textarea>
    <p class="yanzhengma">请输入验证码:<input type="number" id="yzm"></p>
      <input type="submit" name="" value="提交" class="tijiao" id="sub" disabled="disabled">
  </form>
    <canvas id="canvas1"></canvas><br />
<button id="btnRefresh">看不清，刷新一下</button>
</div>
  </body>
</html>
