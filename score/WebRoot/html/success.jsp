<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Document</title>
</head>
<link rel="stylesheet" type="text/css" href="../css/success.css">
<style>
html, body, div, span, object, iframe, h1, h2, h3, h4, h5, h6, p, a, em, img, strong, b, u, i, dl, dt, dd, ol, ul, li, form, label, table, tbody, thead, tr, th, td{
  margin: 0;
  padding: 0;
  border: 0;
}
ol, ul { list-style: none; }
img {
    margin:-134px 17%;
}
h1{
margin:0 44%;
}
p{
margin:0 43%;
}

</style>
<script>
var i = 5;
var intervalid;
intervalid = setInterval("fun()", 1000);
function fun() {
if (i == 0) {
window.location.href = "text.jsp";
clearInterval(intervalid);
}
document.getElementById("mes").innerHTML = i;
i--;
}</script>
<body>
<div id="errorfrm">
    <img src="images/success.png" alt="">
    <h1>提交成功！</h1>
    <p>将在 <span id="mes">5</span> 秒钟后返回首页！</p>
    </div>
</body>
</html>
