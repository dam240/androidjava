<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>��ӷ���</title>
    
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
				alert("����������Ϊ�գ�");
				return false;
			}
			if(!$("#desc").val()) {
				alert("������������Ϊ�գ�");
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
    <h3>�޸�1������</h3>
    <h1></h1>
    <p style="font-weight: 900; color: red">${msg }</p>
    <form action="uc.action" method="post" onsubmit="return checkForm()">
    	<input type="hidden" name="pid" value="<s:property value="#request.ua.A_id"/>"/>
    	
    	�������ƣ�<input type="text" name="cname" id="cname" value="<s:property value="#request.ua.book_name"/>"/><br/>
    	����������<textarea rows="5" cols="50" id="desc" name="desc"><s:property value="#request.ua.book_log"/></textarea><br/>
    	<input type="submit" value="�޸ķ���"/>
    	<input type="button" value="����" onclick="history.go(-1)"/>
    </form>
  </body>
</html>
