$(function () {
    aboutone();
    abouttwo();
    //aboutthree();
    //点击翻页
    mousenext();
    shouzhi();
    textinput();
})
var number1=0;
var num11=0;
var num12=0;
var num13=0;
var num14=0;
function aboutone() {
    //num1=num11+num12+num13+num14;
    //获取对象
    $('.rque1').click(function () {
        var scoreone = 1;
        num11=scoreone;
        $('#tippage1').text(num11);
        $('.forexmple_one').css({
            display:'block'
        })
        $('.forexmple_one').text(scoreone + '分');
    });
    $('.rque2').click(function () {
        var scoretwo = 3;
        num11=scoretwo;
        $('#tippage1').text(num11);
        $('.forexmple_one').css({
            display: 'block'
        })
        $('.forexmple_one').text(scoretwo + '分');

    });
    $('.rque3').click(function () {
        var scorethree = 5;
        num11=scorethree;
        $('#tippage1').text(num11);
        $('.forexmple_one').css({
            display: 'block'
        })
        $('.forexmple_one').text(scorethree + '分');
    });
//第二题
    $('.rque4').click(function () {
        var scorefour = 1;
        num12=scorefour;
        $('#tippage1').text(num11+num12);
        $('.forexmple_two').css({
            display:'block'
        })
        $('.forexmple_two').text(scorefour + '分');
    });
    $('.rque5').click(function () {
        var scorefive = 3;
        num12=scorefive;
        $('#tippage1').text(num11+num12);
        $('.forexmple_two').css({
            display: 'block'
        })
        $('.forexmple_two').text(scorefive + '分');

    });
    $('.rque6').click(function () {
        var scoresix = 5;
        num12=scoresix;
        $('#tippage1').text(num11+num12);
        $('.forexmple_two').css({
            display: 'block'
        })
        $('.forexmple_two').text(scoresix + '分');
    });
    //第三题
    $('.rque7').click(function () {
        var scoreseven = 1;
        num13=scoreseven;
        $('#tippage1').text(num11+num12+num13);
        $('.forexmple_three').css({
            display:'block'
        })
        $('.forexmple_three').text(scoreseven + '分');
    });
    $('.rque8').click(function () {
        var scoreeight = 3;
        num13=scoreeight;
        $('#tippage1').text(num11+num12+num13);
        $('.forexmple_three').css({
            display: 'block'
        })
        $('.forexmple_three').text(scoreeight + '分');

    });
    $('.rque9').click(function () {
        var scorenine = 5;
        num13=scorenine;
        $('#tippage1').text(num11+num12+num13);
        $('.forexmple_three').css({
            display: 'block'
        })
        $('.forexmple_three').text(scorenine + '分');
    });
    //第四题
    $('.rque10').click(function () {
        var score10 = 1;
        num14=score10;
        $('#tippage1').text(num11+num12+num13+num14);
        $('.forexmple_four').css({
            display:'block'
        })
        $('.forexmple_four').text(score10 + '分');
    });
    $('.rque11').click(function () {
        var score11 = 3;
        num14=score11;
        $('#tippage1').text(num11+num12+num13+num14);
        $('.forexmple_four').css({
            display: 'block'
        })
        $('.forexmple_four').text(score11 + '分');

    });
    $('.rque12').click(function () {
        var score12 = 5;
        num14=score12;
        $('#tippage1').text(num11+num12+num13+num14);
        $('.forexmple_four').css({
            display: 'block'
        })
        $('.forexmple_four').text(score12 + '分');
    });
    //求一页的总和
    //var page1score=num11+num12+num13+num14;

}
    function abouttwo() {
        /*第一道题的分数num15 第二16，第三17，第四18*/
        var num15=0;
        var num16=0;
        var num17=0;
        var num18=0;
        //num1=num11+num12+num13+num14;
        //获取对象
        $('.rque13').click(function () {
            var scoreone = 1;
            num15=scoreone;
            $('#tippage2').text(num15);
            $('.forexmple_five').css({
                display:'block'
            })
            $('.forexmple_five').text(scoreone + '分');
        });
        $('.rque14').click(function () {
            var scoretwo = 3;
            num15=scoretwo;
            $('#tippage2').text(num15);
            $('.forexmple_five').css({
                display: 'block'
            })
            $('.forexmple_five').text(scoretwo + '分');

        });
        $('.rque15').click(function () {
            var scorethree = 5;
            num15=scorethree;
            $('#tippage2').text(num15);
            $('.forexmple_five').css({
                display: 'block'
            })
            $('.forexmple_five').text(scorethree + '分');
        });
//第二题
        $('.rque16').click(function () {
            var scoreone = 1;
            num16=scoreone;
            $('#tippage2').text(num15+num16);
            $('.forexmple_six').css({
                display:'block'
            })
            $('.forexmple_six').text(scoreone + '分');
        });
        $('.rque17').click(function () {
            var scoretwo = 3;
            num16=scoretwo;
            $('#tippage2').text(num15+num16);
            $('.forexmple_six').css({
                display: 'block'
            })
            $('.forexmple_six').text(scoretwo + '分');

        });
        $('.rque18').click(function () {
            var scorethree = 5;
            num16=scorethree;
            $('#tippage2').text(num15+num16);
            $('.forexmple_six').css({
                display: 'block'
            })
            $('.forexmple_six').text(scorethree + '分');
        });
        //第三题
        $('.rque19').click(function () {
            var scoreseven = 1;
            num17=scoreseven;
            $('#tippage2').text(num15+num16+num17);
            $('.forexmple_seven').css({
                display:'block'
            })
            $('.forexmple_seven').text(scoreseven + '分');
        });
        $('.rque20').click(function () {
            var scoreeight = 3;
            num17=scoreeight;
            $('#tippage2').text(num15+num16+num17);
            $('.forexmple_seven').css({
                display: 'block'
            })
            $('.forexmple_seven').text(scoreeight + '分');

        });
        $('.rque21').click(function () {
            var scorenine = 5;
            num17=scorenine;
            $('#tippage2').text(num15+num16+num17);
            $('.forexmple_seven').css({
                display: 'block'
            })
            $('.forexmple_seven').text(scorenine + '分');
        });
        //第四题
        $('.rque22').click(function () {
            var score10 = 1;
            num18=score10;
            $('#tippage2').text(num15+num16+num17+num18);
            $('.forexmple_eight').css({
                display:'block'
            })
            $('.forexmple_eight').text(score10 + '分');
        });
        $('.rque23').click(function () {
            var score11 = 3;
            num18=score11;
            alert(num18);
            $('#tippage2').text(num15+num16+num17+num18);
            $('.forexmple_eight').css({
                display: 'block'
            })
            $('.forexmple_eight').text(score11 + '分');

        });
        $('.rque24').click(function () {
            var score12 = 5;
            num18=score12;
            $('#tippage2').text(num15+num16+num17+num18);
            $('.forexmple_eight').css({
                display: 'block'
            })
            $('.forexmple_eight').text(score12 + '分');
        });
    }
/*
* 鼠标点击翻页特效*/
function mousenext() {
   
    //当鼠标点击时ul渐渐消失
    $('#fy2').click(function () {
        //把块往左移动
        $('#quesiton1').animate({
            left: '-54%'
        }, 500, function () {
            $('#quesiton2').toggle(true);
        });
        $('#fy2').css({
            display:'none'
        })
        $('#leftsj').css({
            display:'block'
        })
    })
    $('#fy1').click(function () {
        $('#quesiton3').toggle(true);
        $('#quesiton3').animate({
            left: '84%'
        }, 500, function () {
            display:'block'
        });
        $('#fy1').css({
            display:'none'
        })
        $('#rightsj').css({
            display:'block'
        })
    });
}

/**
 * about手指的js
 */
function shouzhi() {
    // //获取第二页以及第三页的display属性
    // var page2=$('#quesiton2').css('display');
    // var page3=$('#quesiton3').css('display');
    // //如果三个题都展开的话就出现手指
    // if(page2==block&&page3==block){
    //     alert("12345");
    //     $('.shouzhi').css({
    //         display:'block'
    //     })
    //     $('.shouzhi').animate({
    //         opacity:'1'
    //     },400)
    //
    // }
    //获取手指的对象
        $('#leftsj').click(function () {
            $('#window').animate({
                left:'60%'
            })
        })
   $('#rightsj').click(function () {
        $('#window').animate({
            left:'-60%'
        })
    })
    $('#middlesj').click(function () {
        $('#window').animate({
            left:'0%'
        })
    })
   
}
function textinput() {
    //获取输入框对象判断输入框的内容是否为空并且最低10分，最高100分否则清空输入框内容
    $('.rque25').blur(function () {
        var a=$('.rque25').val();
        if(a==""||a<10||a>100){
        $('.tips1').css({
            display:'block'
        })
            //清除输入框中的内容
            $('.rque25').val("");
        }else{
            $('.tips1').css({
                display:'none'
            })
        }
    })
    //第二题
    $('.rque26').blur(function () {
        var a=$('.rque26').val();
        if(a==""||a<10||a>100){
            $('.tips2').css({
                display:'block'
            })
            //清除输入框中的内容
            $('.rque26').val("");
        }else{
            $('.tips2').css({
                display:'none'
            })
        }
    })
    //第三题
    $('.rque27').blur(function () {
        var a=$('.rque27').val();
        if(a==""||a<10||a>100){
            $('.tips3').css({
                display:'block'
            })
            //清除输入框中的内容
            $('.rque27').val("");
        }else{
            $('.tips3').css({
                display:'none'
            })
        }
    })
    //第四题
    $('.rque28').blur(function () {
        var a = $('.rque28').val();
        if (a == "" || a < 10 || a > 100) {
            $('.tips4').css({
                display: 'block'
            })
            //清除输入框中的内容
            $('.rque28').val("");
        } else {
            $('.tips4').css({
                display: 'none'
            });
            var rque25=$('.rque25').val();
            var rque26=$('.rque26').val();
            var rque27=$('.rque27').val();
            if(rque25==""||rque26==""||rque27==""){
                $('.tips3').css({
                    display: 'block'
                })
                $('.tips2').css({
                    display: 'block'
                })
                $('.tips1').css({
                    display: 'block'
                })
            }else{
                alert("恭喜你已经完成所有答题，点击右上角的提交吧！");
                $('#buttonsubmit').show();
            }
        }
    })
}
function doajax(){
	//执行ajax
	$.ajax({
		url:"paper.do?option=submit",
		type:"post",
		data:"que1="+$('.rque25').val()+"&que2="+$('.rque26').val()+"&que3="+$('.rque27').val()+"&que4="+$('.rque28').val(),
		success:function (data){
			//接受参数
			alert(data.que.User_id);
		}
	})
	
}


