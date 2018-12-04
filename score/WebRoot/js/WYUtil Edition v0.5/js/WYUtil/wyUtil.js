/*@唯译*/

/*
* * "WYUtil"为基于jQuery插件与JavaScript混合封装的常用工具包。
说明：

需求：
jQuery3.0以上
将css文件夹下的wyUtilStyle.css文件链接
（如有jq3.0以上请忽略此步）将所有jQuery插件链接
将js/WYUtil文件夹下的wyUtil.js链接

/********@@@@@@@@@@@@@@@@@@@@@##########RRRRRRRRR**********/

/*
* rem响应式布局：调用即可生效
* 根据html的font-size大小来变化
* 可以在每一个设备下根据设备的宽度设置对应的html字号
* 实现自适应布局。
* 此插件布局比例：
* 窗口大小/10=1rem；
* */
//rem响应式布局：1/10




var wyUtil=function () {
   /*
    wyUtil工具包：@唯译
    封装内容：
    wyAlert弹出层
    wyDriveBox可拖动盒子的方法
    rem响应式布局
    wyLoadingAni预载动画方法
    mouseFunction鼠标事件
    centerLocation()居中方法（传id值）
    * */

    /*
    wyAlert弹出层：
    版本信息：
    v1.0
    name,time,content,bgColor,fontColor传参函数
    v1.1更新：增加传参函数bgColor，fontColor；背景颜色，文字颜色
    v1.2更新：增加传参函数width,height；弹出层宽，弹出层高
    v1.3更新：增加PromptAlert（****）提示弹出层


    wyAlert目前封装：
    wyUtil.obj();//调用
    方法：
    foAlert(name,time,content,bgColor,fontColor,width,height)//渐变弹出层foAlert(id标签名字,弹出层存在时间,弹出层内容,背景颜色,文字颜色,弹出层宽，弹出层高)
    shakeAlert(name,time,sktime,content,bgColor,fontColor,width,height)//抖动弹出层ShakeAlert(id标签名字,弹出层存在时间,弹出层抖动速度,弹出层内容,背景颜色,文字颜色,弹出层宽，弹出层高)
    promptAlert(name,content,bgColor,fontColor,inputContent,inputBgColor,inputFontColor,hoverAlertBgColor,hoverAlertFontColor,width,height)//提示弹出层promptAlert(id标签名字,弹出层抖动速度,弹出层内容,背景颜色,文字颜色,按钮内容,按钮背景颜色,按钮文字颜色,按钮hover背景颜色,按钮hover文字颜色,弹出层宽,弹出层高)


    wyDriveBox可拖动盒子的方法:
    driveBox(name);增加//可拖动盒子的方法,函数id名字即可。注意：盒子必须有定位元素，且不可为万能居中法


    mouseFunction鼠标事件：
    mouserRightClickMenu(name,menuName)://鼠标右键菜单：name值为鼠标右键点击区域的id，menuName值为显示的菜单(注意右键菜单需自行添加)
    */

    return{
        //rem自适应
        selfAdaption:function () {
            $('head').append('<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" >')
            var oFz = document.getElementsByTagName("html")[0];
            var width = window.innerWidth;
            oFz.style.fontSize = width / 10 + "px";
            window.onresize = function () {
                wyUtil.selfAdaption();
            }
        },

        wyAlert:function(){
            //wyAlert()
        //JQuery渐变弹出层（@唯译封装）foAlert(id标签名字,弹出层存在时间,弹出层内容,背景颜色,文字颜色,弹出层宽,弹出层高)
            // foAlert(name,time,content,bgColor,fontColor,width,height);
        //JQuery抖动弹出层（@唯译封装）ShakeAlert(id标签名字,弹出层存在时间,弹出层抖动速度,弹出层内容,背景颜色,文字颜色,弹出层宽,弹出层高)
            //shakeAlert(name,time,sktime,content,bgColor,fontColor,width,height);
        //JQuery提示弹出层（@唯译封装）promptAlert(id标签名字,弹出层抖动速度,弹出层内容,背景颜色,文字颜色,按钮内容,按钮背景颜色,按钮文字颜色,按钮hover背景颜色,按钮hover文字颜色,弹出层宽,弹出层高)
            // promptAlert(name,content,bgColor,fontColor,inputContent,inputBgColor,inputFontColor,hoverAlertBgColor,hoverAlertFontColor,width,height);

        return{

        //JQuery渐变弹出层（@唯译封装）WYAlert(id标签名字,弹出层存在时间,弹出层内容,背景颜色,文字颜色,文字大小,弹出层宽,弹出层高)
             foAlert:function(name,time,content,bgColor,fontColor,fontSize,width,height){
                var alertH='<div class="empty" id='+name+' style="opacity:0;display:none">'+content+'</div>';
                $('body').append(alertH);
                $('.empty').css({
                    background:""+bgColor+"",
                    color:""+fontColor+"",
                    width:""+width+"px",
                    height:""+height+"px",
                    lineHeight:""+height+"px",
                    fontSize:""+fontSize+"px"
                })
                $('#'+name+'').css({
                    display:"block"
                });
                $('#'+name+'').animate({
                    opacity:"0.85"
                },300,function () {
                    setTimeout(function (){disapper()},time);
                })
                function disapper(){
                    $('#'+name+'').animate({
                        opacity:"0"
                    },300,function () {
                        $('#'+name+'').css({
                            display:"none"

                        });
                        $('.empty').remove();
                    })
                }
            },
            //JQuery抖动弹出层（@唯译封装）ShakeAlert(id标签名字,弹出层存在时间,弹出层抖动速度,弹出层内容,背景颜色,文字颜色,文字大小,弹出层宽,弹出层高)
            shakeAlert:function(name,time,sktime,content,bgColor,fontColor,fontSize,width,height) {
                var alertH='<div class="empty" id='+name+' style="opacity:0;display:none;">'+content+'</div>';
                $('body').append(alertH);
                $('.empty').css({
                    background:""+bgColor+"",
                    color:""+fontColor+"",
                    width:""+width+"px",
                    height:""+height+"px",
                    lineHeight:""+height+"px",
                    fontSize:""+fontSize+"px"
                })
                $('#'+name+'').css({
                    display:"block"
                });
                $('#'+name+'').animate({
                    opacity:"0.85"
                },100,function () {
                    $('#'+name+'').animate({
                        left:"100px"
                    },sktime,function () {
                        $('#'+name+'').animate({
                            right:"200px"
                        },sktime,function () {
                            $('#'+name+'').animate({
                                left:0,
                                right:0
                            },sktime,function () {
                                setTimeout(function (){disapper()},time);
                            })
                            function disapper() {
                                $('#'+name+'').animate({
                                    opacity:"0"
                                },300,function () {
                                    $('#'+name+'').css({
                                        display:"none"
                                    })
                                    $('.empty').remove();
                                })
                            }
                        })
                    })
                })
            },

            //JQuery提示弹出层（@唯译封装）promptAlert(id标签名字,弹出层内容,背景颜色,文字颜色,文字大小,按钮内容,按钮背景颜色,按钮文字颜色,按钮hover背景颜色,按钮hover文字颜色,弹出层宽,弹出层高)
            promptAlert: function (name,content,bgColor,fontColor,fontSize,inputContent,inputBgColor,inputFontColor,hoverAlertBgColor,hoverAlertFontColor,width,height) {
                if(inputContent==null){
                    inputContent="确认"
                }if(hoverAlertBgColor==null){
                    hoverAlertBgColor="#888888"
                }if(inputBgColor==null){
                    inputBgColor="#000000"
                }

                var alertH='<div class="prompt" id='+name+' style="opacity:0;display:none;"><div class="pos">'+content+'<input type="button" value="'+inputContent+'"></div></div>'
                $('body').append(alertH);
                $('.prompt').css({
                    background:""+bgColor+"",
                    color:""+fontColor+"",
                    width:""+width+"px",
                    height:""+height+"px",
                    lineHeight:""+height+"px",
                    fontSize:""+fontSize+"px"
                })
                $('.prompt input').css({
                    background:""+inputBgColor+"",
                    color:""+inputFontColor+""
                })
                $('#'+name+'').css({
                    display:"block"
                });
                $('#'+name+'').animate({
                    opacity:"0.85"
                },300)
                $('.prompt input').click(function () {
                    disapper();
                })
                $('.prompt input').hover(function () {
                    $('.prompt input').css({
                        background:""+hoverAlertBgColor+"",
                        color:""+hoverAlertFontColor+""
                    })
                },function () {
                    $('.prompt input').css({
                        background:""+inputBgColor+"",
                        color:""+inputFontColor+""
                    })
                })
                function disapper(){
                    $('#'+name+'').animate({
                        opacity:"0"
                    },300,function () {
                        $('#'+name+'').css({
                            display:"none"
                        });
                        $('.prompt').remove();
                    })
                }
                wyUtil.centerLocation(name);
            },


         }
        },


            //wyDriveBox可拖动盒子的方法:
            wyDriveBox:function(){
                //wyDriveBox()
                return{
                    //driveBox(name);增加//可拖动盒子的方法,函数id名字即可。注意：盒子必须有定位元素，且不可为万能居中法
                    driveBox:function (name) {
                        var MoverWrap=document.getElementById(""+name+"");
                        $("#"+name+"").mousedown(function (){
                            down()
                        })
                        $(document).mousemove(function (){
                            move()
                        })
                        $(document).mouseup(function (){
                            end()
                        });
                        var isMove=false;
                        var cur={
                            x:0,
                            y:0
                        }
                        var downx,downy,movex,movey,x,y;
                        function down(){
                            isMove=true;  //确认鼠标按下
                            cur.x=event.clientX;//当前鼠标的x坐标
                            cur.y=event.clientY;//当前鼠标的y坐标
                            downx=MoverWrap.offsetLeft;//div此时的左偏移量
                            downy=MoverWrap.offsetTop;//div此时的上偏移量
                        }
                        function move() {
                            if(isMove){                        //如果是鼠标按下则继续执行
                                movex = event.clientX - cur.x;  //鼠标在x轴移动的数据
                                movey = event.clientY - cur.y;  //鼠标在y轴移动的数据
                                x = downx+movex;                   //div在x轴的偏移量加上鼠标在x轴移动的距离
                                y = downy+movey;                 //div在y轴的偏移量加上鼠标在y轴移动的距离
                                MoverWrap.style.left = x+"px";
                                MoverWrap.style.top = y+"px";
                            }
                        }
                        function end() {
                            isMove=false;
                        }

                    },


                }
            },

        //鼠标事件
        mouseFunction:function () {

            return{
                //鼠标右击菜单
                mouseRightClickMenu:function (name,menuName) {//name值为鼠标右键点击区域的id，menuName值为显示的菜单
                document.oncontextmenu = function(){//屏蔽鼠标右键
                    return false;
                }
                $('#'+name+'').mousedown(function () {
                    var key=event.which;
                    if(key==3){
                        var x=event.clientX;
                        var y=event.clientY;
                        $('#'+menuName+'').show().css({left:x,top:y});
                    }

                })
                $(document).click(function () {
                    $('#'+menuName+'').hide();
                })
            }

            }
        },

        //居中方法传容器id值
        centerLocation:function (name){
            $("body,html").css({
                height:"100%"
            });
        var windowW=document.body.clientWidth;
        var windowH=document.body.clientHeight;
        var wrap=document.getElementById(""+name+"");
        var wrapW=wrap.offsetWidth;
        var wrapH=wrap.offsetHeight;
        var l=((windowW/2)-(wrapW/2));
        var t=((windowH/2)-(wrapH/2));
        wrap.style.left=l+"px";
        wrap.style.top=t+"px";
    },






    }
}();