<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
  <head>
    <title>index.html</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  </head>
  <div id="index">
     <frameset rows="10%,90%" noresize="noresize">
    	<frame src="title.jsp" frameborder="0" noresize="noresize"/>
    	<frameset cols="10%,80%">
  			<frame src="nav.jsp" frameborder="0" noresize="noresize"/>
  			<frame src="text.jsp" frameborder="0" name="text1" noresize="noresize"/>
  		</frameset>
    </frameset>
  </div>
  <div id="user">


  </div>
  <body>

  </body>
</html>
