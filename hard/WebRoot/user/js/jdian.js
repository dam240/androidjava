$(document).ready(function(){
	var $b;
	$(".xxs").bind("click",function(event){
		$(".xxs").animate({height:"80px"},10);
		$(".lp").hide();
		$(".zhong_weibu").show();
		event.stopPropagation();
	})
 $(".xxs").parent().parents().bind("click",function(event){
		$(".xxs").animate({height:"35px"},10);
		$(".zhong_weibu").hide();
		$(".lp").show();
		event.stopPropagation();
	})
 
})
