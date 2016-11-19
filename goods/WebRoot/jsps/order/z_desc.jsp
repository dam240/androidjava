<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>订单详细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/order/desc.css'/>">
  </head>
  
<body>
	<div class="divOrder">
		<span>订单号：${ioc.order_id}
			(等待付款)
<!-- 
			(准备发货)
			(等待确认)
			(交易成功)
			(已取消)
 -->
		　　　下单时间：${ioc.date} </span>
	</div>
	<div class="divContent">
		<div class="div2">
			<dl>
				<dt>收货人信息</dt>
				<dd>${ioc.addr}</dd>
			</dl>
		</div>
		<div class="div2">
			<dl>
				<dt>商品清单</dt>
				<dd>
					<table cellpadding="0" cellspacing="0">
						<tr>
							<th class="tt">商品名称</th>
							<th class="tt" align="left">单价</th>
							<th class="tt" align="left">数量</th>
							<th class="tt" align="left">小计</th>
						</tr>


<s:iterator value="#request.li" id="cs">

						<tr style="padding-top: 20px; padding-bottom: 20px;">
							<td class="td" width="400px">
								<div class="bookname">
								  <img align="middle" width="70" src="<%=basePath %><s:property value="#cs.tu_B"/>"/>
								  <a href="<c:url value='/jsps/book/desc.jsp'/>"><s:property value="#cs.book_name"/></a>
								</div>
							</td>
							<td class="td" >
								<span>&yen;<s:property value="#cs.dan_ji"/></span>
							</td>
							<td class="td">
								<span><s:property value="#cs.mout"/></span>
							</td>
							<td class="td">
								<span>&yen;<s:property value="#cs.xi_ji"/></span>
							</td>			
						</tr>


</s:iterator>

					</table>
				</dd>
			</dl>
		</div>
		<div style="margin: 10px 10px 10px 550px;">
			<span style="font-weight: 900; font-size: 15px;">合计金额：</span>
			<span class="price_t">&yen;${ioc.jin}</span><br/>

	
	<a id="confirm" href="gei_w.action?commit=${ioc.order_id }">确认收货</a><br/>	
		</div>
	</div>
</body>
</html>

