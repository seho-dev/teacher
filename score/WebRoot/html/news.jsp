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
    
    <title>My JSP 'news.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/news.css">
	<script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
  </head>
  <body>
    	<p class="xml">您现在所在的位置：<a href=#>首页</a><<a href=# >消息列表</a></p>

<table id="ta">
  <thead>
    <tr>
      <th class="th1">消息ID</th>
      <th class="th1">所在专业</th>
       <th class="th1">昵称</th>
        <th class="th1">投诉内容</th>
        <th class="th1">投诉状态</th>
        <th class="th1">操作</th>
    </tr>
</thead>
  <tbody>
   <!-- 迭代循环 -->
   <c:forEach items="${newslist}" var="list1">
   		<tr>
   			<c:forEach items="${list1}" var="list2">
   				<td>${list2}</td>
   			</c:forEach>
   	         	<td class="td">
   				<div class="bianji" onclick="doajax('news.do?option=update',${list1[0]})"><img src="http://localhost:8080/score/images/teacher_bianji.png" alt=""></a></div>
   				<div class="shouli" onclick="doajax('news.do?option=shouli',${list1[0]})"><img src="images/同意.png.png" alt=""></a></div>
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
  	<p><a href="news.do?option=fenye&&page=1">首页</a>&nbsp;<a href="news.do?option=fenye&&page=${requestScope.news-1}">上一页</a>&nbsp;<a href="news.do?option=fenye&&page=${requestScope.news+1}">下一页</a>&nbsp;<a href="news.do?option=fenye&&page=${sessionScope.newsend}">末页</a></p>
  </div>
  	<script type="text/javascript">
  		function doajax(url,ids){
  			$.ajax({
  				url:url,
  				type:"post",
  				data:{"ids":ids},
  				success:function(data){
  					window.location.reload(); 
  				}
  			})
  		};
  		
  	</script>
  </body>
</html>
