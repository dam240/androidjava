<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@ taglib uri="/struts-tags" prefix="s" %>
    



<html>
<head>

<style type="text/css">
table.hovertable {
position:absolute;
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
width:100%;
height:80%;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;

}

#up{
    position:absolute;
    
	width:500px;
        left:50px;
   
 
}

#dow{
    position:absolute;
	right:-400px;
	width:500px;
    
   
 
}



#zo{
    position:absolute;
	right:120px;
	width:500px;
    
   
 
}
</style>
 <script type="text/javascript">
    
    
     function oci(){
     
     
 var i='<s:property value="pa.Nowpage"/>';
     var j=parseInt(i)+1;
      

   document.getElementById('ok').href='list.action?now='+j;
    
     }
    
     function up(){
     
     
 var i='<s:property value="pa.Nowpage"/>';
     var j=parseInt(i)-1;
      

   document.getElementById('up').href='list.action?now='+j;
    
     }
    
    </script>
</head>
<body>


<!-- Table goes in the document BODY -->
<table class="hovertable" width="866" height="258">
<tr>
	<th>头像</th><th>用户ID</th><th>用户名字</th><th>管理</th>
</tr>
<s:iterator value="list"  var="it">
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td><img src="<%=basePath %><s:property value="#it.photo"/>" ></td><td><s:property value="#it.user_id"/></td><td><s:property value="#it.user_name"/></td><td><a href="Adetele.action?id=<s:property value="#it.user_id"/>" >删除</a>  </td>
</tr>

</s:iterator>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>
	
	<s:if test="pa.up"> 
	<a href="#" id="up" onclick="up()">上页</a>
	</s:if> 
	</td> <td>  <p ><s:property value="pa.Nowpage"/>页/<s:property value="pa.count"/></p> </td>  
	
		
	 <td> <s:if test="pa.next">  <a href=""  id="ok" onclick="oci()">下页</a></s:if></td>
</tr>
</table>
            
</body>
</html>