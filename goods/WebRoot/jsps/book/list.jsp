<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/book/list.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/book/list.js'/>"></script>
  </head>
  
  <body>

<ul>

	<s:iterator value="#request.li" id="cs">
  <li>
  <div class="inner">
    <a class="pic" href="use_list.action?pid=<s:property value="#cs.book_id"/>"><img src="<%=basePath %><s:property value="#cs.tu_B"/>" border="0"/></a>
    <p class="price">
		<span class="price_n">&yen;<s:property value="#cs.now_ji"/></span>
		<span class="price_r">&yen;<s:property value="#cs.d_ji"/></span>
		(<span class="price_s"><s:property value="#cs.zhe"/>折</span>)
	</p>
	<p><a id="bookname" title="<s:property value="#cs.book_name"/>" href="<c:url value='/jsps/book/desc.jsp'/>"><s:property value="#cs.book_name"/></a></p>
	<p><a href="<c:url value='/jsps/book/list.jsp'/>" name='P_zz' title='Craig Walls'><s:property value="#cs.zuo"/></a></p>
	<p class="publishing">
		<span>出 版 社：</span><a href="<c:url value='/jsps/book/list.jsp'/>"><s:property value="#cs.chu"/></a>
	</p>
	<p class="publishing_time"><span>出版时间：</span><s:property value="#cs.chu_tiem"/></p>
  </div>
  </li>


</s:iterator>




</ul>

<div style="float:left; width: 100%; text-align: center;">
	<hr/>
	<br/>
	<%@include file="/jsps/pager/pager2.jsp" %>
</div>

  </body>
 
</html>

