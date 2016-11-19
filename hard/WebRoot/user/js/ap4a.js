$(function(){

$(".fatui2").click(function(){
// 	var len=$(".row").length;
//  len++;
//   $("#table").append("<tr><td class='row'>row"+(len)+"</td></tr>");
// 	
//  
// var vl=$(".mad1").text();
//	$(".pp1_a1").text(vl);
//	var vl2=$(".mad2").text();
//	$(".pp1 span").text(vl2);
//	var v=$(".xxs").html()
//	var ra=$(".area").val();
//	$(".pp2").html(ra+v)
//	 
//	
//	$(".xxs").find("img").remove();
//	if($(".area").val()!=""){
//		$(".area").val("");
//	}
 
var txt = $(".xxs").html().trim();
if(txt == ""){
$(".txt").focus();
}else{
$(".meul").append('<li><div class="me"><a href="#"><img src="img/dawo.jpg"></a><p class="pp1"><a href="#"class="pp1_a1"></a><span></span><a href="#" id="timeShow"></a></p><div class="p2"><p class="pp2"></p></div><p class="pp3"><a href="#"><img src="img/m1.jpg"id="tup1"> </a><a href="#"><img src="img/m2.jpg"id="tup2"> </a><a href="#"><img src="img/m3.jpg"id="tup3"> </a><a href="#"><img src="img/m4.jpg"id="tup4"> </a></p></div></li>');
$(".xxs").html("");
//$(".meul li .pp3 a img:eq(0)").hover(function(){
//	var imgsrc=$(this).attr("src");
//	var i=imgsrc.lastIndexOf(".");
//	var unit=imgsrc.substring(i);
//	var ut2=imgsrc.substring(0,i);
//	var imgsrc2=ut2+"_2"+unit;
//	
//	
//},function(){
//	var imgsrc=$(this).attr("src");
//	var i=imgsrc.lastIndexOf(".");
//	var unit=imgsrc.substring(i);
//	var i2=imgsrc.lastIndexOf("_")
//	var u2=imgsrc.substring(0,i2);
//	var img2=u2+unit;
//	$(this).attr("src",img2);
//})
}

	 $(".meul li .pp3 a img").hover(function(){
      var src = $(this).attr("src");
      if(src=="img/m1.jpg"){
          $(this).attr("src","img/m1_2.jpg");
      }else{
          $(this).attr("src","img/m1.jpg");
      }
	if(src=="img/m2.jpg"){
          $(this).attr("src","img/m2_2.jpg");
      }else{
          $(this).attr("src","img/m2.jpg");
      }
   })
//$(".meul li .pp3 a img").mouseout(function(){

//})


var time = setInterval('showTime()',500);
 
})
 showTime();
function showTime()
    {
// var timedate= new Date("");                //自定义结束时间  
    var now = new Date();                                         //获取当前时间
//  var date = parseInt(now.getTime())/1000; //得出的为秒数；
// var s1 = "2010-09-12";  
       var d= new Date("2016/9/16,14:38:00");  
// var d1 = new Date(s1.replace(/-/g,"/"));  
   var j;
if(d.getFullYear()==now.getFullYear()){
   	if(d.getMonth()==now.getMonth()){
   	var m = (now.getTime()-d.getTime())/(1000*60*60)
		if(m>24){
			j=now.getDay()-d.getDay();
			document.getElementById('timeShow').innerHTML =j+"天";
		}else{
			j =now.getHours()-d.getHours();
		     if(j<1){
				j =now.getMinutes()-d.getMinutes()
				if(j<1){
				j=now.getSeconds()-d.getSeconds();
				document.getElementById('timeShow').innerHTML =j+"秒";
				}else{
				document.getElementById('timeShow').innerHTML =j+"分钟";	
				}
			}else{
			document.getElementById('timeShow').innerHTML =j+"小时";
				}
		}

   }else{
   		j=now.getMonth()-d.getMonth();
   	document.getElementById('timeShow').innerHTML =j+"月";
   	}
  }else{
	document.getElementById('timeShow').innerHTML =d;
}
    // document.getElementById('timeShow').innerHTML =m;
     time;        
  }
})
//<div class="me">
//<a href="#"><img src="img/dawo.jpg"></a>
//<p class="pp1"><a href="#"class="pp1_a1"></a><span></span><a href="#" id="timeShow"></a></p>
//<div class="p2"><p class="pp2"></p></div>
//<p class="pp3"><a href="#"><img src="img/m1.jpg"> </a><a href="#"><img src="img/m2.jpg"> </a><a href="#"><img src="img/m3.jpg"> </a><a href="#"><img src="img/m4.jpg"> </a></p>
//</div>
//<p class="pp1"><a href="#"class="pp1_a1"></a><span></span><a href="#"id="timeShow"></a></p><div class="p2"><p class="pp2"></p></div><p class="pp3"><a href="#"><img src="img/m1.jpg"> </a><a href="#"><img src="img/m2.jpg"> </a><a href="#"><img src="img/m3.jpg"> </a><a href="#"><img src="img/m4.jpg"> </a></p>