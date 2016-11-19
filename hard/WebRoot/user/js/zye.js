$(document).ready(function(){
	$(".aa:eq(0)").hover(function(){
		$(this).find(".s1").css("background","url(img/zy1.jpg)no-repeat 0 -1px")
		
	},function(){
		$(this).find(".s1").css("background","url(img/zy.jpg)no-repeat")
	})	
	
	$(".aa:eq(1)").hover(function(){
		$(this).find(".s1").css("background","url(img/tz1.jpg)no-repeat 2px 1px")
		
	},function(){
		$(this).find(".s1").css("background","url(img/tz.jpg)no-repeat")
	
	})
	
	$(".aa:eq(2)").hover(function(){
		$(this).find(".s1").css("background","url(img/sx1.jpg)no-repeat 1px 0px")
		
	},function(){
		$(this).find(".s1").css("background","url(img/sx.jpg)no-repeat")
	})
	
	$(".aa").hover(function(){
		$(this).find("p").stop().animate({bottom:"0px"},100);
		
	},function(){
		$(this).find("p").stop().animate({bottom:"-5px"},100)
	})
	
$(".aa").click(function(){
		$(this).find("div").css("opacity","1");
		$(this).siblings().find("div").css("opacity","0");
})

	})