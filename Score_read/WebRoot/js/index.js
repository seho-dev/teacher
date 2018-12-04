$(function () {
    //页面加载时背景颜色渐变
    $('#window').animate({
        opacity:'1'
    },1000);
    $('#logo').animate({
        left:'33%'
    },800,function () {
        $('.titletext').show(700);
        $('.type_li').animate({
            opacity: '1'
        },700,function () {
            $('#start').animate({
                opacity: '1',
                width:'100px'
            },700)
        })
    });
    start();
});
/**
 * 鼠标开始的时候的样式
 */
function start(){
        //鼠标经过页面背景颜色变化
        $('#start').mouseenter(function () {
            //背景颜色对象
            $('#window').animate({
                opacity:'0.9'
            },400)
        });
        //鼠标经过的样式
        $('#start').mouseleave(function () {
            $('#window').animate({
                opacity:'1'
            },400)
        })
        $('#start').click(function () {
            $('#window').animate({
                opacity: '0'
            },700,function () {
                window.location.href="paperready.html";
            })

        });

}
