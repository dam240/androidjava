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
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/order/list.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
  </head>
  
  <body>
<div class="divMain">
	<div class="divTitle">
		<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
		<span style="margin-left: 40px;margin-right: 38px;">金额</span>
		<span style="margin-left: 50px;margin-right: 40px;">订单状态</span>
		<span style="margin-left: 50px;margin-right: 50px;">操作</span>
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
			<td width="200px">订单号：<a  href="show_list.action?commit=<%=o.getOrder_id() %>"><%=o.getOrder_id() %></a></td>
			<td width="300px">下单时间：<%=o.getDate() %></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">


<%
  for(car c:ca.get(i))
 {

 %>
	<a class="link2" href="use_list.action?pid=<%=c.getBook_id() %>">
	    <img border="0" width="70" src="<%=basePath%><%=c.getTu_B() %>"/>
	</a>
	
  <%
   }
    %>
         
	
       

			</td>
			<td width="115px">
				<span class="price_t">&yen;<%=o.getJin() %></span>
			</td>
			<td width="142px">
          			
			<%
			   if(o.getFun()==0&&o.getZhi_fu()==1)
			   
			   {
			 %>
			 	(准备发货)
			 
			 <%
			 }
			  if(o.getZhi_fu()==0&&o.getFun()==1)
			  {
			  %>
			(等待付款)
			
			<%
			}
			if(o.getZhi_fu()==1&&o.getFun()==2)
			{
			
			 %>
			 
			 	(交易成功)
			 <%
			 }
			 if(o.getZhi_fu()==3&&o.getFun()==1||o.getZhi_fu()==3&&o.getFun()==0)
			 {
			 
			  %>
			  
			  (已取消)
			  <%
			  }
			  if(o.getZhi_fu()==1&&o.getFun()==1)
			  {
			   %>
			         (等待确认)
			  <%
			  }
			   %>
		          	
		 
			 
-               
                 
			</td>
			<td>
			<a href="show_list.action?commit=<%=o.getOrder_id() %>">查看</a><br/>
                 <%
                    if(o.getZhi_fu()==0)
                    {
                  %>
				<a href="zhi_two.action?order_id=<%=o.getOrder_id() %>">支付</a><br/>
				<%
				}
			     if(o.getFun()==1&&o.getZhi_fu()==1)
			     {
				 %>
				<a href="qs_io.action?commit=<%=o.getOrder_id() %>">取消</a><br/>	
				    <%
                 }
                 if(o.getFun()==1&&o.getZhi_fu()==1)
                 {
                  %>
									

				<a href="show_zhi.action?commit=<%=o.getOrder_id() %>">确认收货</a><br/>
                
             <%
             }
              %>
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
