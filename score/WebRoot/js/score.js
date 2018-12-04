//计时器

window.onload=function(){
    shuzi1(80,50,60,20);
    fanye();
    tjt();
   
}
function fanye() {
    $('.fanye').hover(function () {
        $('.fanye').attr('src','../images/fanye2.png')
    },function () {
        $('.fanye').attr('src','../images/fanye1.png')
    })
    /**
     * 翻页
     */
   $('.fanye').click(function () {
       function stop(){

           $('.page2').stop(true);
       }
       $('.page1').slideToggle(300);
       stop();
       $('.page2').slideToggle(300);
           /* $('.page1').animate({
                opacity:"0"
            },800,function () {
                $('.page1').css({
                    display:'none'
                })
            })
       $('#wangyun').animate({
           opacity:"1"
       },800,function () {
           $('.page2').css({
               display:'block'
           })
       })*/

       /**
        * 调用点击翻页的方法
        */
       clickfanye ();
    })

    /**
     * 点击翻页的效果
     */
    function  clickfanye () {
        $('.fanye').attr('src','../images/fanye3.png')
        shuzi2(70,50,40,60);

    }
}
function shuzi1(rjjd2,dsjd2,dmjd2,uijd2) {

    if ( rjjd2 > 100||dsjd2>100||dmjd2>100||uijd2>100) {
        rjjd2,dsjd2,dmjd2,uijd2;
    }
    rjjd2=rjjd2*3;
    dsjd2=dsjd2*3;
    dmjd2=dmjd2*3;
    uijd2=uijd2*3;

    $('.rjjd2').animate({
        'width': '' + rjjd2 + 'px'
    }, 3000)
    var a=0;
    var timea=setInterval(function () {
        $('#rjbfb').html('&nbsp;'+a+'%');
        a++;
        if(a>rjjd2/3){
            clearInterval(timea);
        }
    },30)
    $('.dsjd2').animate({
        'width': '' + dsjd2 + 'px'
    }, 3000)
    var b=0;
    var timeb=setInterval(function () {
        $('#dsbfb').html('&nbsp;'+b+'%');
        b++;
        if(b>dsjd2/3){
            clearInterval(timeb);
        }
    },30)
    $('.dmjd2').animate({
        'width': '' + dmjd2 + 'px'
    }, 3000)
    var c=0;
    var timec=setInterval(function () {
        $('#dmbfb').html('&nbsp;'+c+'%');
        c++;
        if(c>dmjd2/3){
            clearInterval(timec);
        }
    },30)
    $('.uijd2').animate({
        'width': '' + uijd2 + 'px'
    }, 3000)
    var d=0;
    var timed=setInterval(function () {
        $('#uibfb').html('&nbsp;'+d+'%');
        d++;
        if(d>uijd2/3){
            clearInterval(timed);
        }
    },30)

}
function shuzi2(wyjd2,djjd2,wjjd2,vrjd2) {
    if ( wyjd2 > 100||djjd2>100||wjjd2>100||vrjd2>100) {
        wyjd2,djjd2,wijd2,vrjd2;
    }
    wyjd2=wyjd2*3;
    djjd2=djjd2*3;
    wjjd2=wjjd2*3;
    vrjd2=vrjd2*3;
    $('.wyjd2').animate({
        'width': '' + wyjd2 + 'px'
    }, 3000)
    var a=0;
    var timef=setInterval(function () {
        $('#wybfb').html('&nbsp;'+a+'%');
        a++;
        if(a>wyjd2/3){
            clearInterval(timef);
        }
    },30)
    $('.djjd2').animate({
        'width': '' + djjd2 + 'px'
    }, 3000)
    var b=0;
    var timeg=setInterval(function () {
        $('#djbfb').html('&nbsp;'+b+'%');
        b++;
        if(b>djjd2/3){
            clearInterval(timeg);
        }
    },30)
    $('.wjjd2').animate({
        'width': '' +wjjd2+ 'px'
    }, 3000)
    var c=0;
    var timeh=setInterval(function () {
        $('#wjbfb').html('&nbsp;'+c+'%');
        c++;
        if(c>wjjd2/3){
            clearInterval(timeh);
        }
    },30)
    $('.vrjd2').animate({
        'width': '' + vrjd2 + 'px'
    }, 3000)
    var d=0;
    var timei=setInterval(function () {
        $('#vrbfb').html('&nbsp;'+d+'%');
        d++;
        if(d>vrjd2/3){
            clearInterval(timei);
        }
    },30)
}
function tjt(){
    /**
     * 统计图
     */
     $('#xt_one').animate({
         marginTop:'150px'
     },1200)
    $('#xt_two').animate({
        marginTop:'-40px'
    },1200)
    $('#xt_three').animate({
        marginTop:'-180px'
    },1200)
    $('#xt_four').animate({
        marginTop:'-90px'
    },1200)
    $('#xt_five').animate({
        marginTop:'-130px'
    },1200)
    $('#xt_six').animate({
        marginTop:'-70px'
    },1200)
    $('#xt_seven').animate({
        marginTop:'-70px'
    },1200)
    $('#xt_eight').animate({
        marginTop:'-40px'
    },1200)
    $('#xt_nine').animate({
        marginTop:'-120px'
    },1200)
    $('#xt_ten').animate({
        marginTop:'-60px'
    },1200)

    $('#xt_nine').animate({
        marginTop:'-120px'
    },1200)
    $('#xt_ten').animate({
        marginTop:'-60px'
    },1200)
    $('#xt_eleven').animate({
        marginTop:'-50px'
    },1200)
    $('#xt_twelve').animate({
        marginTop:'-70px'
    },1200)
    $('#xt_thirteen').animate({
        marginTop:'-60px'
    },1200)
    $('#xt_fourteen').animate({
        marginTop:'-30px'
    },1200)
    $('#xt_fifteen').animate({
        marginTop:'-90px'
    },1200)
    $('#xt_sixteen').animate({
        marginTop:'-55px'
    },1200)
}