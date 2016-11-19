<%@ page language="java" import="java.util.*" pageEncoding="UtF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    

<html>
  <meta charset="utf-8">
<head>
 <style>  
#warp {   
  position: absolute;   
  width:500px;   
  height:200px;   
  left:50%;   
  top:50%;   
  margin-left:-50px;   
  margin-top:-100px;   
      
}   



</style>  
<style>
#wa {   
  position: absolute;   
  width:300px;   
  height:100px;   
  left:50%;   
  top:50%;   
  margin-left:-100px;   
  margin-top:-100px;   
      
} 
</style>




</head>
  <script type="text/javascript">
    
    
     function oci(){
     
     
     self.location.href="tou.action";
     
     }
    
    
    </script>
<body style="background:url(<%=basePath %>admin/image/cd6358d3a06301805bf3cebb54abff43.jpg)" >

<div  id="warp">


<input type="button"  onclick="oci()" value="我的资料" style="background-color: transparent; border: 0;"  style='font-size:100%' >
</div>





</body>





</html>