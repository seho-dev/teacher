$(function () {
    //页面加载时背景颜色渐变
    $('body').animate({
        opacity:'1'
    },1000);
    setTimeout(
        function () {
           /*获取对象并且show*/
            $('#form').animate({
                opacity:'1'
            },400)
        },1300);
});
/*判断表单是否为空的方法*/
function checknotnull() {
    /*验证表单是否为空*/
    var a=$('#username').val();
    var b=$('#Professional').val();
    var c=$('#Class').val();
    var d=$('#Teacher').val();
    var e=$('#Course').val();
    if(a!=""&&b!=""&&c!=""&&d!=""&&e!=""){
        /*出现验证框*/
        $('#tips').show(300);
        $('#tips_img').attr("src","images/sure.png");
        /*更改弹框内容*/
        $('.tip_title').html("您确定提交吗");
        $('.false').html("取消");
        $('.false').css({
            left:'22%'
        })
        /*取消确定键*/
        $('.true').css({
            display:'block'
        });
        $('#ready').animate({
            opacity:'0.5'
        },400);
        $('body,html').css({
            background:'rgba(0,0,0,0.5)'
        })
    }else{
        /*如果为空*/
        $('#tips').show(300);
        $('#tips_img').attr("src","images/jinggao.png");
        /*更改弹框内容*/
        $('.tip_title').html("您有空未输入");
        $('.false').html("继续");
        $('.false').css({
            left:'38%'
        })
        /*取消确定键*/
        $('.true').css({
            display:'none'
        });
        $('#ready').animate({
            opacity:'0.5'
        },400);
        $('body,html').css({
            background:'rgba(0,0,0,0.5)'
        })
    }
}
/*用户点击重置执行的操作*/
function checkreset() {
    $('input').val("");
};
/*用户点击取消执行的操作*/
function clickfalse() {
    $('#tips').hide(300);
    $('body,html').css({
        background:'#068AEF'
    });
    $('#tips').css({
        display:'none'
    })
    /*更改背景透明度*/
    $('#ready').css({
        display:'block',
        opacity:'1'
    })
}
function checksure(){
	/*用户点击继续的方法执行ajax*/
	$.ajax({
		url:"WebsitesServlet.do?type=information",
		type:"post",
		data:{
			username:$('#username').val(),
			Professional:$('#Professional').val(),
			Class:$('#Class').val(),
			Teacher:$('#Teacher').val(),
			Course:$('#Course').val(),
		},
		success:function(data){
			if(data=="yes"){
				//同意进入答题页面
				 window.location.href="page.html";
			}else{
//				  alert("为了有效公平的问卷环境，请停止重复提交的操作!");
//				//不能进入
//				$('#tips').show(300);
//		        $('#tips_img').attr("src","images/jinggao.png");
//		        /*更改弹框内容*/
//		        $('.tip_title').html("切勿重复提交！");
//		        $('.false').html("继续");
//		        $('.false').css({
//		            left:'38%'
//		        })
//		        /*取消确定键*/
//		        $('.true').css({
//		            display:'none'
//		        });
//		        $('#ready').animate({
//		            opacity:'0.5'
//		        },400);
//		        $('body,html').css({
//		            background:'rgba(0,0,0,0.5)'
//		        });
		      
			}
		},
		error:function(){
			//如果出现了提交失败的情况
			 $('#tips').show(300);
		        $('#tips_img').attr("src","images/error.png");
		        /*更改弹框内容*/
		        $('.tip_title').html("遇到了一个未知的错误");
		        $('.false').html("继续");
		        $('.false').css({
		            left:'38%'
		        })
		        /*取消确定键*/
		        $('.true').css({
		            display:'none'
		        });
		        $('#ready').animate({
		            opacity:'0.5'
		        },400);
		        $('body,html').css({
		            background:'rgba(0,0,0,0.5)'
		        });
		    }
}
	)};


