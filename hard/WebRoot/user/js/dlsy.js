$(function(){
		$(".nd_left a").hover(function(){
		$(this).find("p").stop().animate({bottom:"0px"},100);
		
	},function(){
		$(this).find("p").stop().animate({bottom:"-5px"},100)
	})
	
})
