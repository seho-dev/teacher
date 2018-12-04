/*about question javaScript
 * By:ShenHao
 */
$(function(){
	 ajaxpagenum();
	//写一个ajax，页面运行就调用，关于分页的数量
	addclick();
	close();
	 tableup();
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
};
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
};
function ajaxpagenum(){
	$.ajax({
		type:'get',
		url:'question.do?type=pagenum',
		success:function(data){
			$(".pageindex").append('<li><a href="question.do?type=page&&index=${applicationScope.index-1}">&laquo;</a></li>');
				for(var y=1;y<=data;y++){
						//获取ul
					$(".pageindex").append('<li><a href="question.do?type=page&&index='+y+'">'+y+'</a></li>');
				}
				$(".pageindex").append('<li><a href="question.do?type=page&&index=${applicationScope.index+1} ">&raquo;</a></li>');
		}
	})
};
function doajax(url,id){
		$.ajax({
			url:url,
			data:{
				id:id
			},
			success:function(data){
					var id=data.simplelist[0];
					var questionname=data.simplelist[1];
					//编辑窗口打开
					$('#update').css({
							display:'block'
					});
					$('#getid').attr("value",id);
					$('#newname').attr("value",questionname);
			}
		})
}