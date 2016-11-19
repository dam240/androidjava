<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript">
		function checkForm() {
			if(!$("#cname").val()) {
				alert("分类名不能为空！");
				return false;
			}
			if(!$("#pid").val()) {
				alert("一级分类不能为空！");
				return false;
			}
			if(!$("#desc").val()) {
				alert("分类描述不能为空！");
				return false;
			}
			return true;
		}
	</script>
<style type="text/css">
	body {background: rgb(254,238,189);}
</style>
  </head>
  
  <body>
    <h3>修改2级分类</h3>
    <h1></h1>
    <p style="font-weight: 900; color: red">${msg }</p>
    <form action="uc2.action" method="post" onsubmit="return checkForm()">
    	<input type="hidden" name="pid" value="<s:property value="#request.ua.A_id"/>"/>
    	分类名称：<input type="text" name="cname" value="<s:property value="#request.ua.book_name"/>" id="cname"/><br/>
    	一级分类：<select name="Bid" id="pid">
    		<option value="">===选择1级分类===</option>
    	 <s:iterator value="#request.li" id="cs">
     	<option value="<s:property value="#cs.A_id"/>"><s:property value="#cs.book_name"/></option>
    </s:iterator>
    	
    	</select><br/>
    	分类描述：<textarea rows="5" cols="50" name="desc" id="desc"><s:property value="#request.ua.book_log"/></textarea><br/>
    	<input type="submit" value="修改二级分类"/>
    	<input type="button" value="返回" onclick="history.go(-1)"/>
    </form>
  </body>
</html>
