/*
* @Author: Marte
* @Date:   2018-05-29 02:00:52
* @Last Modified by:   Marte
* @Last Modified time: 2018-05-29 09:55:56
*/

/*定义函数生成随机颜色*/
function colorRandom() {
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	return "rgb(" + r + "," + g + "," + b + ")";
}

/*生成随机数*/
var num = new Array();
var n;
var canvas,
	context;
function getYZ() {
	canvas = document.getElementById("canvas1");
	context = canvas.getContext('2d');
	canvas.width = 200;
	canvas.height = 100;
	context.beginPath();
	context.fillStyle = colorRandom(); //显示验证码区域的背景色
	context.rect(0, 55, 100, 40);
	context.fill();
	for (var i = 0; i < 4; i++) {
		context.font = (Math.random() * 20 + 16) + "px 微软雅黑"; //数字随机大小
		context.fillStyle = colorRandom(); //数字颜色
		n = parseInt(Math.random() * 9);
		context.fillText(n, 20 * i, 90);
		//0-9的随机数
		num[i] = n;
	}
	inNum(num);
}

function inNum(num) {
	var yzm = document.getElementById("yzm");
	var numbers = (num[0] + '' + num[1] + '' + num[2] + '' + num[3]);
	$('#sub').on("click", function() {
		if (yzm.value == numbers) {
		} else {
			alert("验证码输入错误");
			return false;
		}
	})

}

/**
 *
 * 非空验证
 */
function ss() {
	setTimeout(chkvalue, 100);

}
function chkvalue() {
	var text = document.getElementsByClassName("text").value;
	var inputname = document.getElementsByClassName("inputname").value;
	var yijian = document.getElementsByClassName("yijian").value;
	var tijiao = document.getElementById("sub");
	if (text == "" || inputname == "" || yijian == "") {
		//让提交按钮变成锁定状态
		tijiao.setAttribute("disabled", "disabled");
	} else {
		tijiao.removeAttribute("disabled");
	}

}

/*实现*/
window.onload = function() {
	getYZ();
	document.getElementById("btnRefresh").onclick = function() {
		getYZ();
	}

}