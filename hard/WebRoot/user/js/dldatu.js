$(function(){

	$(":input.required").blur(function(){ 
//判断一下鼠标离开谁了 

	if($(this).is("#name1")){ 
$(".formtip").remove(); 
//按照用户名的规则去验证 
	if(this.value==""||this.value.length<6){ 
	var errMsg = "<span class='formtip'>用户名至少是6个字母！</span>"; 
	$(this).parent().append(errMsg); 
	}else{ 
	var msg = "<span class='formtip'>用户名可以使用</span>"; 
	$(this).parent().append(msg); 
	$(this).parent().find(".formtip").css("color","#BEBDBD")
	} 
	} 

	if($(this).is("#email")){ 
$(".emailtip").remove(); 
//按照email的规则去验证 
var reg = /^\w{1,}@\w+\.\w+$/; 
var $email = $("#email").val(); 
if(!reg.test($email)){ 
var errMsg = "<span class='emailtip'>邮箱不合法！</span>"; 
$(this).parent().append(errMsg); 
}else{ 
var Msg = "<span class='emailtip'>邮箱可以使用</span>"; 
$(this).parent().append(Msg); 
} 
} 
}); 
	$(".tu li").first().show().siblings().hide();
	$(".biana li").first().show().siblings().hide();
	var timer=setInterval(show,3000)
	var i=0;
	function show(){
		i++;
		if(i==3){
			i=0;
		}
		$(".tu li").eq(i).fadeIn(1200).siblings().fadeOut(1200);
		$(".biana li").eq(i).show().siblings().hide();
	}
	timer();
     

})