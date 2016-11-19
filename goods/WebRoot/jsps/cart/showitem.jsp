<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>showitem.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/cart/showitem.css'/>">
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script src="<c:url value='/js/round.js'/>"></script>
<style type="text/css">
#addr{width: 500px; height: 32px;border: 1px solid #7f9db9; padding-left: 10px; line-height: 32px;}
</style>

<script type="text/javascript">
	//����ϼ�
	$(function() {
		var total = 0;
		$(".subtotal").each(function() {
			total += Number($(this).text());
		});
		$("#total").text(round(total, 2));
	});
</script>
  </head>
  
  <body>
<form id="form1" action="commit_or.action" method="post">
	<input type="hidden" name="cartItemIds" value=""/>
	
<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<tr bgcolor="#efeae5">
		<td width="400px" colspan="5"><span style="font-weight: 900;">���ɶ���</span></td>
	</tr>
	<tr align="center">
		<td width="10%">&nbsp;</td>
		<td width="50%">ͼ������</td>
		<td>����</td>
		<td>����</td>
		<td>С��</td>
	</tr>

	<s:iterator value="#request.li" id="cs">

	<tr align="center">
		<td align="right">
			<a class="linkImage" href="<c:url value='/jsps/book/desc.jsp'/>"><img border="0" width="54" align="top" src="<%=basePath %>${cs.tu_B}"/></a>
		</td>
		<td align="left">
			<a href="<c:url value='/jsps/book/desc.jsp'/>"><span>${cs.book_name}</span></a>
		</td>
		<td>&yen;${cs.dan_ji}</td>
		<td>${cs.mout}</td>
		<td>
			<span class="price_n">&yen;<span class="subtotal">${cs.xi_ji}</span></span>
		</td>
	</tr>
	</s:iterator>





	<tr>
		<td colspan="6" align="right">
			<span>�ܼƣ�</span><span class="price_t">&yen;<span id="total"></span></span>
		</td>
	</tr>
	<tr>
		<td colspan="5" bgcolor="#efeae5"><span style="font-weight: 900">�ջ���ַ</span></td>
	</tr>
	<tr>
		<td colspan="6">
			<input id="addr" type="text" name="address" value="������ ��ƽ�� ������ �������칫¥1�� ���ǲ��� ����ү"/>
		</td>
	</tr>
	<tr>
		<td style="border-top-width: 4px;" colspan="5" align="right">
			<a id="linkSubmit" href="javascript:$('#form1').submit();">�ύ����</a>
		</td>
	</tr>
</table>
</form>
  </body>
</html>
