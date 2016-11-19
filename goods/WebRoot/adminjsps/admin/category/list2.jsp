<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/category/list.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>">
  </head>
  
  <body>
    <h2 style="text-align: center;">分类列表</h2>
    <table align="center" border="1" cellpadding="0" cellspacing="0">
    	<caption class="captionAddOneLevel">
    	</caption>
    	<tr class="trTitle">
    		<th>分类名称</th>
    		<th>描述</th>
    		<th>操作</th>
    	</tr>
    	
    	
    	<tr class="trOneLevel">
    		<td width="200px;"><s:property value="#request.book.book_name"/></td>
    		<td><s:property value="#request.book.book_log"/></td>
    		<td width="200px;">
    		  <a href="add2.action">添加二级分类</a>
    		</td>
    	</tr>
    	    	<s:iterator value="#request.ln" id="cs">
    	<tr class="trTwoLevel">
    		<td><s:property value="#cs.book_name"/></td>
    		<td><s:property value="#cs.book_log"/></td>
    		<td width="200px;" align="right">
    		  <a href="up2.action?pid=<s:property value="#cs.A_id"/>">修改</a>
    		  <a onclick="return confirm('您是否真要删除该二级分类？')" href="delete2.action?Bid=<s:property value="#cs.A_id"/>&&pid=<s:property value="#cs.B_id"/>">删除</a>
    		</td>
    	</tr>
      	</s:iterator>

    </table>
  </body>
</html>
