<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>book_desc.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=gbk">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/book/desc.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>

<script type="text/javascript" src="<c:url value='/adminjsps/admin/js/book/desc.js'/>"></script>

<script type="text/javascript">

$(function() {
	$("#box").attr("checked", false);
	$("#formDiv").css("display", "none");
	$("#show").css("display", "");	
	
	// 操作和显示切换
	$("#box").click(function() {
		if($(this).attr("checked")) {
			$("#show").css("display", "none");
			$("#formDiv").css("display", "");
		} else {
			$("#formDiv").css("display", "none");
			$("#show").css("display", "");		
		}
	});
});


function loadChildren() {
	/*
	1. 获取pid
	2. 发出异步请求，功能之：
	  3. 得到一个数组
	  4. 获取cid元素(<select>)，把内部的<option>全部删除
	  5. 添加一个头（<option>请选择2级分类</option>）
	  6. 循环数组，把数组中每个对象转换成一个<option>添加到cid中
	*/
	// 1. 获取pid
	var pid = $("#pid").val();
	// 2. 发送异步请求
	$.ajax({
		async:true,
		cache:false,
		url:"book_mai",
		data:{ pid:pid},
		type:"POST",
		dataType:"json",
		success:function(arr) {
			// 3. 得到cid，删除它的内容
			$("#cid").empty();//删除元素的子元素
			$("#cid").append($("<option>====请选择2级分类====</option>"));//4.添加头
			// 5. 循环遍历数组，把每个对象转换成<option>添加到cid中
			for(var i = 0; i < arr.length; i++) {
				var option = $("<option>").val(arr[i].cid).text(arr[i].cname);
				$("#cid").append(option);
			}
		}
	});
}




/*
 * 点击删除按钮时执行本函数
 */

</script>
  </head>
  
  <body>
    <input type="checkbox" id="box"><label for="box">编辑或删除</label>
    <br/>
    <br/>
  <div id="show">
    <div class="sm">${book.book_name} </div>
    <img align="top" src="<c:url value='/${book.tu_A}'/>" class="tp"/>
    <div id="book" style="float:left;">
	    <ul>
	    	<li>商品编号：${book.book_id}</li>
	    	<li>当前价：<span class="price_n">&yen;${book.now_ji}</span></li>
	    	<li>定价：<span style="text-decoration:line-through;">&yen;${book.d_ji}</span>　折扣：<span style="color: #c30;">${book.zhe}</span>折</li>
	    </ul>
		<hr style="margin-left: 50px; height: 1px; color: #dcdcdc"/>
		<table class="tab">
			<tr>
				<td colspan="3">
					作者：${book.zuo}
				</td>
			</tr>
			<tr>
				<td colspan="3">
					出版社：${book.chu}</a>
				</td>
			</tr>
			<tr>
				<td colspan="3">出版时间：${book.chu_tiem}</td>
			</tr>
			<tr>
				<td>版次：${book.ban_one}</td>
				<td>页数：${book.page}</td>
				<td>字数：${book.zhi_shu}</td>
			</tr>
			<tr>
				<td width="180">印刷时间：${book.yi_tiem}</td>
				<td>开本：${book.k_b}</td>
				<td>纸张：${book.zi_zhang}</td>
			</tr>
		</table>
	</div>
  </div>
  
  
  <div id='formDiv'>
   <div class="sm">&nbsp;</div>
   <form action="book_g.action" method="post" id="form">
   	<input type="hidden" name="id" value="${book.book_id}"/>
   	<input type="hidden" name="image_w" value=""/>
   	<input type="hidden" name="image_b" value=""/>
    <img align="top" src="<c:url value='/${book.tu_A}'/>" class="tp"/>
    <div style="float:left;">
	    <ul>
	    	<li>商品编号：${book.book_id}</li>
	    	<li>书名：　<input id="bname" type="text" name="bname" value="${book.book_name}" style="width:500px;"/></li>
	    	<li>当前价：<input id="currPrice" type="text" name="price" value="${book.now_ji}" style="width:50px;"/></li>
	    	<li>定价：　<input id="price" type="text" name="disprice" value="${book.d_ji}" style="width:50px;"/>
	    	折扣：<input id="discount" type="text" name="discount" value="${book.zhe}" style="width:30px;"/>折</li>
	    </ul>
		<hr style="margin-left: 50px; height: 1px; color: #dcdcdc"/>
		<table class="tab">
			<tr>
				<td colspan="3">
					作者：　　<input id="author" type="text" name="author" value="${book.zuo}" style="width:150px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					出版社：　<input id="press" type="text" name="press" value="${book.chu}" style="width:200px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">出版时间：<input id="publishtime" type="text" name="publishtime" value="${book.chu_tiem}" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>版次：　　<input id="edition" type="text" name="edition" value="${book.ban_one}" style="width:40px;"/></td>
				<td>页数：　　<input id="pageNum" type="text" name="pageNum" value="${book.page}" style="width:50px;"/></td>
				<td>字数：　　<input id="wordNum" type="text" name="wordNum" value="${book.zhi_shu}" style="width:80px;"/></td>
			</tr>
			<tr>
				<td width="250px">印刷时间：<input id="printtime" type="text" name="printtime" value="${book.yi_tiem}" style="width:100px;"/></td>
				<td width="250px">开本：　　<input id="booksize" type="text" name="booksize" value="${book.k_b}" style="width:30px;"/></td>
				<td>纸张：　　<input id="paper" type="text" name="paper" value="${book.zi_zhang}" style="width:80px;"/></td>
			</tr>
			<tr>
				<td>
					一级分类：<select name="pid" id="pid" onchange="loadChildren()">
						<option value="">==请选择1级分类==</option>
			    			<s:iterator value="#request.li" id="cs">
			    		<option value="<s:property value="#cs.A_id"/>" ><s:property value="#cs.book_name"/> </option>
			    	  </s:iterator>
					</select>
				</td>
				<td>
					二级分类：<select name="cid" id="cid">
						<option value="">==请选择2级分类==</option>
			    	
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<input onclick="editForm()" type="button" name="method" id="editBtn" class="btn" value="编　　辑">
					
				</td>
				<td></td>
			</tr>
		</table>
	</div>
   </form>
  </div>

  </body>
</html>
