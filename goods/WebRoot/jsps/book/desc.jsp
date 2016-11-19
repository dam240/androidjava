<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书详细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=gbk">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/book/desc.css'/>">
	<script src="<c:url value='/jsps/js/book/desc.js'/>"></script>
  </head>
  
  <body>
  <div class="divBookName">${book.book_name}</div>
  <div>
    <img align="top" src="<%=basePath %>${book.tu_A}" class="img_image_w"/>
    <div class="divBookDesc">
	    <ul>
	    	<li>商品编号：${book.book_id}</li>
	    	<li>传智价：<span class="price_n">&yen;${book.now_ji}</span></li>
	    	<li>定价：<span class="spanPrice">&yen;${book.d_ji}</span>　折扣：<span style="color: #c30;">${book.zhe}</span>折</li>
	    </ul>
		<hr class="hr1"/>
		<table>
			<tr>
				<td colspan="3">
					作者：${book.zuo} 著
				</td>
			</tr>
			<tr>
				<td colspan="3">
					出版社：${book.chu} 
				</td>
			</tr>
			<tr>
				<td colspan="3">出版时间：${book.chu_tiem} </td>
			</tr>
			<tr>
				<td>版次：${book.ban_one}</td>
				<td>页数：${book.page}</td>
				<td>字数：${book.zhi_shu}</td>
			</tr>
			<tr>
				<td width="180">印刷时间：${book.yi_tiem}</td>
				<td>开本：${book.k_b}开</td>
				<td>纸张:${book.zi_zhang}</td>
			</tr>
		</table>
		<div class="divForm">
			<form id="form1" action="car_ini.action" method="post">
	
					<input type="hidden" name="tu_B" value="${book.tu_B}"/>
			    	<input type="hidden" name="book_name" value="${book.book_name}"/>
					<input type="hidden" name="book_id" value="${book.book_id}"/>
				<input type="hidden" name="dan_ji" value="${book.now_ji}"/>
  				我要买：<input id="cnt" style="width: 40px;text-align: center;" type="text" name="mout" value="1"/>件
  			</form>
  			<a id="btn" href="javascript:$('#form1').submit();"></a>
  		</div>	
	</div>
  </div>
  </body>
</html>
