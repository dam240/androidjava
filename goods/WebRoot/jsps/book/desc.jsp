<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ͼ����ϸ</title>
    
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
	    	<li>��Ʒ��ţ�${book.book_id}</li>
	    	<li>���Ǽۣ�<span class="price_n">&yen;${book.now_ji}</span></li>
	    	<li>���ۣ�<span class="spanPrice">&yen;${book.d_ji}</span>���ۿۣ�<span style="color: #c30;">${book.zhe}</span>��</li>
	    </ul>
		<hr class="hr1"/>
		<table>
			<tr>
				<td colspan="3">
					���ߣ�${book.zuo} ��
				</td>
			</tr>
			<tr>
				<td colspan="3">
					�����磺${book.chu} 
				</td>
			</tr>
			<tr>
				<td colspan="3">����ʱ�䣺${book.chu_tiem} </td>
			</tr>
			<tr>
				<td>��Σ�${book.ban_one}</td>
				<td>ҳ����${book.page}</td>
				<td>������${book.zhi_shu}</td>
			</tr>
			<tr>
				<td width="180">ӡˢʱ�䣺${book.yi_tiem}</td>
				<td>������${book.k_b}��</td>
				<td>ֽ��:${book.zi_zhang}</td>
			</tr>
		</table>
		<div class="divForm">
			<form id="form1" action="car_ini.action" method="post">
	
					<input type="hidden" name="tu_B" value="${book.tu_B}"/>
			    	<input type="hidden" name="book_name" value="${book.book_name}"/>
					<input type="hidden" name="book_id" value="${book.book_id}"/>
				<input type="hidden" name="dan_ji" value="${book.now_ji}"/>
  				��Ҫ��<input id="cnt" style="width: 40px;text-align: center;" type="text" name="mout" value="1"/>��
  			</form>
  			<a id="btn" href="javascript:$('#form1').submit();"></a>
  		</div>	
	</div>
  </div>
  </body>
</html>
