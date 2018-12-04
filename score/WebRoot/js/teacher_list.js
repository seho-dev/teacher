var xmlhttp;
$(function(){
	addclick();
	close();
})

function addclick(){
	$("#add").click(function(){
		$('#addwindow').css({
			display:'block'
		})
		$('#addwindow').animate({
			opacity: "1"
		},400)
	})
}
function close(){
	$('#closepng1').click(function(){
		$('#update').css({
			display:"none"
		})
	})
	$('#closepng2').click(function(){
		$('#addwindow').css({
			display:"none"
		})
	})
	
}
/**
 * 修改的ajax
 */
function doajax(url,ids){
	//创建核心对象
	//根据浏览器不同，创建核心对象
	   try {
			xmlhttp = new XMLHttpRequest();
		} catch (e) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				try {
					xmhttp = new XMLHttpRequest();
					if (xmlhttp.overrideMimeType) {
						xmlhttp.overrideMimeType("text/xml");
					}
				} catch (e) {
				}
			}
		}
		//设置回调函数
		xmlhttp.onreadystatechange =backajax;
		xmlhttp.open("post",url,true);
		xmlhttp.setRequestHeader("Content-type",
		"application/x-www-form-urlencoded");
		xmlhttp.send("ids="+ids);
}
function backajax(){
	if((xmlhttp.readyState == 4) && (xmlhttp.status == 200)) {
		//把服务器传过来的数据转换为js对象
		var text=xmlhttp.responseText;
		var obj=JSON.parse(text);
		//定义一个数组
		var teacherlist=new Array();
		teacherlist[0]=obj.simpleteacherlist[0];
		teacherlist[1]=obj.simpleteacherlist[1];
		teacherlist[2]=obj.simpleteacherlist[2];
		teacherlist[3]=obj.simpleteacherlist[3];
		//点击编辑后弹出窗口
		var updatealert=document.getElementById("update");
		updatealert.style.display='block';
		//获取编辑框中的按钮对象
		var id=document.getElementById("id");
		var newname=document.getElementById("newname");
		var newsex=document.getElementById("newsex");
		var newclas=document.getElementById("newclas");
		//把获取的json对象传入输入框中
		id.setAttribute("value",teacherlist[0]);
		newname.setAttribute("value",teacherlist[1]);
		newsex.setAttribute("value",teacherlist[2]);
		newclas.setAttribute("value",teacherlist[3]);
		}
	}
/**
 * 搜索框的js
 */
function sousuo(){
	//判断输入框中是否有内容
	var sousuokuang=$('.sousuokuang').val();
	if(sousuokuang==""){
		alert("搜索内容不能为空");
	}else{
//		执行ajax
//		$.ajax({
//			url:"teacher.do?option=sousuo",
//			type:"get",
//			data:{"sousuokuang":$('.sousuokuang').val(),
//					"select":$('#select').val()},
//			success:function(data){
//				
//			}
//		})
	}
}
