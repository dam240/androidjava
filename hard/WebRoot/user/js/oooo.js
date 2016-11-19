	  var time = setInterval('showTime()',500);
   function showTime()
    {
// var timedate= new Date("");                //自定义结束时间  
    var now = new Date();                                         //获取当前时间
//  var date = parseInt(now.getTime())/1000; //得出的为秒数；
// var s1 = "2010-09-12";  
       var d= new Date("2016/9/14,23:17:00");  
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
