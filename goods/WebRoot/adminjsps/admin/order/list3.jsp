<%@ page language="java" import="java.util.*,com.cd.use.model.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/order/list.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>" />

  </head>
  
  <body>
<p class="pLink">
  <a href="m_zhi.action">未付款</a>  | 
  <a href="yj_zhi.action">已付款</a>  | 
  <a href="yj_fun.action">已发货</a>  | 
  <a href="w_c.action">交易成功</a>  | 
  <a href="qi_s.action">已取消</a>
</p>
<div class="divMain">
	<div class="title">
		<div style="margin-top:7px;">
			<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
			<span style="margin-left: 40px;margin-right: 100px;">金额</span>
			<span style="margin-left: 50px;margin-right: 53px;">订单状态</span>
			<span style="margin-left: 100px;">操作</span>
		</div>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
	
	
	
        <%
           List<order> li =(List<order>)request.getAttribute("li");
               
        List<List<car>> ca =(List<List<car>>)request.getAttribute("car");
          int i=0;
           for(order o:li)
           {
           
                  %>   
	
	
		<tr class="tt">
			<td width="200px">订单号：<a  href="order_ht.action?commit=<%=o.getOrder_id()%>"><%=o.getOrder_id() %></a></td>
			<td width="300px">下单时间：<%=o.getDate() %></td>
			<td width="178px">&nbsp;</td>
			<td width="205px">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">


<%
  for(car c:ca.get(i))
 {

 %>
	<img border="0" width="70" src="<%=basePath %><%=c.getTu_B()%>"/>

<%

}
 %>

			</td>
			<td style="padding-left: 0">
				<span class="price_t">&yen;<%=o.getJin() %></span>
			</td>
			<td>
			
	等待确认
                                                   
           
<!-- 				
			   交易成功	
				取消
 -->
			</td>
			<td>
				<a href="order_ht.action?commit=<%=o.getOrder_id()%>">查看</a><br/>
			
			</td>
		</tr>



  <%
  i++;
  }
   %>


	</table>
	<br/>
	<%-- <%@include file="/jsps/pager/pager.jsp" %> --%>
</div>
  </body>
</html>
