//页码
var index = 1;
//分数
var one = 0;
var two = 0;
var three = 0;
var four = 0;
var pass = 0;
$(function() {
	//监控scorll
	getscorll();
	getinformation();
	/*鼠标滚动往右走*/
	$('body').mousewheel(function(event, delta) {
		var left = $(window).scrollLeft();
		$(window).scrollLeft(left - (delta * 100))
		event.preventDefault();
	});
	$("html").niceScroll("#window");
	setTimeout(
		function() {
			/*让笔消失*/
			$('#pencil').animate({
				opacity : '0'
			}, 400)
		}, 1300);
	setTimeout(title_show, 1300);
	/*获取当前时间的方法*/
	getDate();
	clickbook();
	/*答题窗口的页码*/
	$('.start_num').text(index);
	gettablerow();
	//计算总分
	//    allscore();
	//range滑块
	range();
	//给填写窗加值
	changeRangeValue();
	//点击提交的事件
	clickSubmit();
	checksure();
});
function getDate() {
	var myDate = new Date();
	var hour = myDate.getHours();
	if (hour == "1" || hour == "2" || hour == "3" || hour == "4" || hour == "5" || hour == "6" || hour == "7" || hour == "8" || hour == "9" || hour == "10" || hour == "11") {
		/*这里写日期判断*/
		$('.user_data').html("早上好&nbsp;&nbsp;");
	} else if (hour == "12" || hour == "13" || hour == "14") {
		$('.user_data').html("中午好&nbsp;&nbsp;");
	} else if (hour == "15" || hour == "16" || hour == "17" || hour == "18") {
		$('.user_data').html("下午好&nbsp;&nbsp;");
	} else {
		$('.user_data').html("晚上好&nbsp;&nbsp;");
	}
}
/*延时处理标题缓慢展开*/
function title_show() {
	$('.user_title').show(200);
	$('.user_data').show(200);
}
function clickbook() {
	/*点击书发生的事件*/
	$('#bookimg').click(function() {
		/*背景变淡*/
		$('#window').animate({
			opacity : '0.7'
		})
		$('#alert_page').show(300);
	})
}
function getinformation() {
	$.ajax({
		url : 'WebsitesServlet.do?type=user',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json",
		type : 'post',
		success : function(data) {
			/*更改网站的标题*/
			$('.user_title').text("亲爱的" + data.usernamedata + "同学");
			/*输出题目*/
			$('#page_title').text(data.questionname);
		}
	});
}
;
function clickone() {
	index++;
	one = one + 1;
	$.ajax({
		url : 'WebsitesServlet.do?type=page',
		data : {
			index : this.index
		},
		type : 'post',
		success : function(data) {
			var textlength = data.questionname;
			returnfonts(textlength);
			$('#page_title').text(data.questionname);
			$('.end_num').text(data.tablerow);
			$('.start_num').text(index);
			questionOver(data.tablerow);
		}
	})
}
;
function clicktwo() {
	index++;
	two = two + 2;
	$.ajax({
		url : 'WebsitesServlet.do?type=page',
		data : {
			index : this.index
		},
		type : 'post',
		success : function(data) {
			var textlength = data.questionname;
			returnfonts(textlength);
			$('#page_title').text(data.questionname);
			$('.end_num').text(data.tablerow);
			$('.start_num').text(index);
			questionOver(data.tablerow);
		}
	})
}
;
function clickthree() {
	index++;
	three = three + 3;
	$.ajax({
		url : 'WebsitesServlet.do?type=page',
		data : {
			index : this.index
		},
		type : 'post',
		success : function(data) {
			var textlength = data.questionname;
			returnfonts(textlength);
			$('#page_title').text(data.questionname);
			$('.end_num').text(data.tablerow);
			$('.start_num').text(index);
			questionOver(data.tablerow);
		}
	})
}
function clickfour() {
	index++;
	four = four + 4;
	$.ajax({
		url : 'WebsitesServlet.do?type=page',
		data : {
			index : this.index
		},
		type : 'post',
		success : function(data) {
			var textlength = data.questionname;
			returnfonts(textlength);
			$('#page_title').text(data.questionname);
			$('.end_num').text(data.tablerow);
			$('.start_num').text(index);
			questionOver(data.tablerow);
		}
	})
}
;
function returnfonts(data) {
	//返回的题目如果超过16个字符，那么字体就变小
	if (data.length > 16) {
		$('#page_title').css({
			fontSize : '19px'
		})
	} else if (data.length > 20) {
		$('#page_title').css({
			fontSize : '17px'
		})
	} else {
		$('#page_title').css({
			fontSize : '23px'
		})
	}
}
;
/**
 * 如果题答完之后出现填写框
 */
function questionOver(tablerow) {
	if (this.index > tablerow) {
		$('.questionimg').css({
			display : 'none'
		});
		$('#page_title').css({
			display : 'none'
		});
		$('#page_ul').css({
			display : 'none'
		});
		$('#score_num').css({
			display : 'none'
		});
		$('#alert_page').css({
			display : 'none'
		})
		$('.textAlert').css({
			display : 'block'
		})
	}
}
;
function gettablerow() {
	$.ajax({
		url : 'WebsitesServlet.do?type=tablerow',
		type : 'post',
		success : function(data) {
			$('.end_num').text(data.tablerow);
		}
	})
}
;
function range() {
	var emleOne = document.querySelector(".text_questionOne");
	var init = new Powerange(emleOne, {
		min : 1,
		max : 99,
		klass : 'range',
		hideRange : 'false'
	});
	var emleTwo = document.querySelector(".text_questionTwo");
	var init = new Powerange(emleTwo, {
		min : 1,
		max : 99,
		klass : 'range',
		hideRange : 'false'
	});
	var emleThree = document.querySelector(".text_questionThree");
	var init = new Powerange(emleThree, {
		min : 1,
		max : 99,
		klass : 'range',
		hideRange : 'false'
	});
}
function changeRangeValue() {
	var changeInputOne = document.querySelector('.text_questionOne');
	changeInputOne.onchange = function() {
		$('.value_questionOne').text(changeInputOne.value);
	};
	var changeInputTwo = document.querySelector('.text_questionTwo');
	changeInputTwo.onchange = function() {
		$('.value_questionTwo').text(changeInputTwo.value);
	};
	var changeInputThree = document.querySelector('.text_questionThree');
	changeInputThree.onchange = function() {
		$('.value_questionThree').text(changeInputThree.value);
	};
}
;
function clickSubmit() {
	$('#textSubmit').click(function() {
		//点击提交确定是否全部写全无遗漏
		var textarea = $('textarea').val();
		if (textarea != "") {
			$('.textAlert').css({
				opacity : "0.8"
			})
			$('#tips').css({
				display : 'block'
			});
		} else {
			//如果有空就给它加placeholder
			$('#textarea').attr("placeholder", "您此处未填写不可提交");
		}
	});
}
/*用户点击取消执行的操作*/
function clickfalse() {
	$('.textAlert').css({
		opacity : "1"
	})
	$('#tips').hide(300);
	$('#tips').css({
		display : 'none'
	})
}
//这是点击确定提交的方法
function checksure() {
	//点击确定时要确定数据库中是否有本ip和地址
	$('.true').click(function() {
		/*用户点击继续的方法执行ajax*/
		//layer弹框
		layer.prompt({
			title : '请输入本班答题密钥',
			formType : 1
		}, function(key, index) {
			pass = key;
			layer.close(index);
		});
		$('.layui-layer-btn0').click(function() {
			$.ajax({
				url : 'WebsitesServlet.do?type=class',
				type : "post",
				data : {
					pass : pass,
					cityip:cityip
				},
				success : function(data) {
					if(data=="keysuccess"){
							//说明key密钥以及填写信息全部正确
							//执行添加分数的方法(ajax)
						$.ajax({
							url : 'WebsitesServlet.do?type=submitUp',
							type : "post",
							data : {
								//任课情况
								que1 : $('.value_questionOne').text(),
								//周分享情况
								que2 : $('.value_questionTwo').text(),
								//本次调查系统情况
								que3 : $('.value_questionThree').text(),
								//对老师说的话
								que4 : $('textarea').text(),
								//答题的总分
								allScore : one + two + three + four,
								//ip和地址
								cityip : cityip,
								cityname : cityname
							},
							success : function(data) {
								//关于变量：ip变量是否重复
								var ip = data.ipDown;
								var yes = data.yes;
								if (ip == "ipDown") {
									//说明从servlet返回的参数的是ipDown
									layer.msg('您已经参与过答题');
								} else if (yes == "yes") {
									//添加记录成功
									layer.msg('提交成功');
									$('#tips').css({
										display : 'none'
									});
									$('.textAlert').css({
										display : 'none'
									});
									$('#window').css({
										opacity : '1'
									})
									$('#bookimg').hide(600);
								}
							},
							error : function() {
								//如果出现了提交失败的情况
								layer.msg('系统繁忙，请稍后再试');
								//				        $('#tips_img').attr("src","images/jinggao.png");
								//				        /*更改弹框内容*/
								//				        $('.tip_title').html("未知的错误");
								//				        $('.false').html("继续");
								//				        $('.false').css({
								//				            left:'38%'
								//				        })
								//				        /*取消确定键*/
								//				        $('.true').css({
								//				            display:'none'
								//				        })

							}
						})
					}else{
							//如果key值不符合
							//弹出提示框
						layer.msg('您在准备页面所填写的问卷信息或者密钥输入有误,请退回到准备页面重新填写相关信息再输入正确的密钥',{time:7000});
					}
				}
			})
		})


	})
}
;
//监控scorll的方法
function getscorll() {
	$(document).scroll(function() {
		var step1 = $('html,body').scrollLeft();
		var step2 = $('html,body').scrollLeft();
		//		console.log(step);
		if (step1 > 1200) {
			//出现投诉界面
			$('#Suggestion').show(300);
			$('#Suggestion').addClass("animated rubberBand");
		}
		;
		if (step2 < 1200) {
			$('#Suggestion').removeClass("animated rubberBand");
			$('#Suggestion').hide(300);
		}
	});
}
/**
 * 点击投诉的ajax
 */
function clickTousu() {
	//判断以上的输入框是否有值
	var inputOne = $('#Sug_Class').val();
	var inputTwo = $('#Sug_Name').val();
	var inputThree = $('#Sug_Text').val();
	if (inputOne == "") {
		$('#Sug_Class').attr("placeholder", "请输入班级或者专业");
	} else if (inputTwo == "") {
		$('#Sug_Name').attr("placeholder", "请输入昵称");
	} else if (inputThree == "") {
		layer.msg('投诉内容未填写');
	} else if (!$('#Sug_Check').is(':checked')) {
		layer.msg("未确认提交信息是否真实正确");
	} else {
		$.ajax({
			url : 'WebsitesServlet.do?type=suggest',
			data : {
				Class : inputOne,
				Name : inputTwo,
				Text : inputThree
			},
			type : 'post',
			success : function(main) {
				if (main == "success") {
					layer.msg('投诉成功');
				//								 $('#tips').show(300);
				//							        $('#tips_img').attr("src","images/sure.png");
				//							        /*更改弹框内容*/
				//							        $('.tip_title').html("提交成功！");
				//							        $('.false').html("继续");
				//							        $('.false').css({
				//							            left:'38%'
				//							        })
				//							        /*取消确定键*/
				//							        $('.true').css({
				//							            display:'none'
				//							        })
				} else {
					layer.msg('系统繁忙,请重试');
				//								 $('#tips').show(300);
				//							        $('#tips_img').attr("src","images/jinggao.png");
				//							        /*更改弹框内容*/
				//							        $('.tip_title').html("未知的错误");
				//							        $('.false').html("继续");
				//							        $('.false').css({
				//							            left:'38%'
				//							        })
				//							        /*取消确定键*/
				//							        $('.true').css({
				//							            display:'none'
				//							        })
				}
			}
		})
	}
}