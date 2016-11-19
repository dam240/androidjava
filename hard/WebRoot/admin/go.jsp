
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@ taglib uri="/struts-tags" prefix="s" %>
    


<html>


<head>

<style type="text/css">
#go{
position:absolute;
  width:30%;
  height:30%;
  background-color:#FFF000;
}
#head{
position:absolute;
  width:70%;
  height:20%;
  background-color:#FFF000;
 left:30%;

}
#lea{
position:absolute;
  width:30%;
  height:50%;
  background-color:#FFFFFF;
margin-top:30px;
}


#my{
position:absolute;
  width:70%;
  height:80%;
   background: #8AC007;
 left:30%;
top:20%
 


}

#po{
position:absolute;
  width:30%;
  height:70%;
  background-color:#86531A;
   padding-right:30px;
top:30%
}



#tab{
position:absolute;
   width:300px;
  height:300px;
   left:400px;
     top:100px;
}





#tet{
position:absolute;
   width:300px;
  height:300px;
   left:300px;
     top:50px;
}



</style>
 
</head>

<body>



<div id="go">
go

<img src="<%=basePath %><s:property value="use.photo"/>"  id="lea"/>

</div> <div id="head">

<h1 id="tet">修改</h1>


</div>
<div id="my">



<form action="Adate"  enctype="multipart/form-data"   method="post">
<table border="1" id="tab">
<input type="hidden" name="id" value="<s:property value="use.id"/>"/>
<tr><td>名字</td><td><input type="text" name="name"  value="<s:property value="use.name"/>"></td><tr/>
<tr> <td>说说</td><td><input type="text" name="card" value="<s:property value="use.card"/>"></td><tr/>
<tr><td>图片</td><td><input  id="pot"  type="file" name="pot"></td><tr/>

 <tr><td><input type="submit" value="提交"></td></tr>
</table>
</form>
</div>


<div id="po">
po
</div>


</body>
</html>