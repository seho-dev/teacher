/*
* @Author: Marte
* @Date:   2018-05-24 08:51:11
* @Last Modified by:   Marte
* @Last Modified time: 2018-05-27 20:12:28
*/

//触发事件
window.onload=function(){
    var num=false;
    $('.return').click(function(event) {
        if(num==false){
            One();
        }else{
            Two();
        }
    });
    function stopAni(){
        $('#ul_').stop(true,true);
        $('#ul_ li a span').stop(true,true);
    }
    function One(){
         stopAni();
        num=true;
        $('#ul_').animate({
            width:"91%",
        },300,function(){
            $('#ul_ li a span').css({
                display:"inline-block",
            })
            $('#ul_ li a img').css({
                 margin:"-6px 17px"
            })
            $('#ul_ li a span').animate({
                opacity:1
            },300,function(){
                $('.img_').attr("src","images/return.png");
            })
        })
    }
    function Two(){
         stopAni();
        num=false;
        $('#ul_ li a span').animate({
                opacity:0
            },300,function(){
                $('#ul_ li a span').css({
                display:"none",
                })
                $('#ul_ li a img').css({
                 margin:"15px 17px"
            })
                $('#ul_').animate({
                    width:"15%"
                },300,function(){
                    $('.img_').attr("src","images/zhankai.png")
                })
            })
    }
}
