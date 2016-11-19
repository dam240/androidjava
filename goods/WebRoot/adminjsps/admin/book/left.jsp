<%@ page language="java" import="java.util.*,com.cd.admin.model.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/book/left.css'/>">
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
<script language="javascript">
var bar = new Q6MenuBar("bar", "图书分类");

function load() {
	bar.colorStyle = 2;
	bar.config.imgDir = "<c:url value='/menu/img/'/>";
	bar.config.radioButton=true;
 <%   	
 
   List <List<bean>> li =(List) request.getAttribute("ko");
   
	for(int j=0;j<li.size();j++){
	for(bean u :li.get(j))
	{
	%>
	bar.add("<%=u.getA_name()%>", "<%=u.getBook_name()%>", "all_book.action?pid=<%=u.getA_id()%>", "body");
<%
}
 }
 %>   
 
	var d = document.getElementById("menu");
	d.innerHTML = bar.toString();
}
</script>
  </head>
  
  <body onload="load()">
<div id="menu"></div>
  </body>
</html>
