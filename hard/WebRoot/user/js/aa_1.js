$(function () {
 $('#bta').click(function(){
$('#up').click();
$(".xxs").stop().animate({height:"80px"},0.1);
$(".zhong_weibu").show();
$(".lp").hide();
event.stopPropagation();
});
 $('#lp').click(function(){
$('#up').click();
$(".xxs").animate({height:"35px"},10);
		$(".zhong_weibu").hide();
		$(".lp").show();
event.stopPropagation();
});
$('#bta2').click(function(){
		$(".gif").show();
$(".zhong_weibu").show();
$(".lp").hide();
event.stopPropagation();

});
$('#bta2').blur(function(){
		$(".gif").hide();

event.stopPropagation();

});
});