<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>boo_gj.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<meta http-equiv="content-type" content="text/html;charset=GBK">
	<!--<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	table {
		color: #404040;
		font-size: 10pt;
	}
</style>
  </head>
  
  <body>
  <form action="look_book.action" method="post">

<table align="center">
	<tr>
		<td>������</td>
		<td><input type="text" name="bname"/></td>
	</tr>
	<tr>
		<td>���ߣ�</td>
		<td><input type="text" name="author"/></td>
	</tr>
	<tr>
		<td>�����磺</td>
		<td><input type="text" name="press"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>
			<input type="submit" value="�ѡ�����"/>
			<input type="reset" value="������д"/>
		</td>
	</tr>
</table>
	</form>
  </body>
</html>
