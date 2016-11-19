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
	
	// ��������ʾ�л�
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
	1. ��ȡpid
	2. �����첽���󣬹���֮��
	  3. �õ�һ������
	  4. ��ȡcidԪ��(<select>)�����ڲ���<option>ȫ��ɾ��
	  5. ���һ��ͷ��<option>��ѡ��2������</option>��
	  6. ѭ�����飬��������ÿ������ת����һ��<option>��ӵ�cid��
	*/
	// 1. ��ȡpid
	var pid = $("#pid").val();
	// 2. �����첽����
	$.ajax({
		async:true,
		cache:false,
		url:"book_mai",
		data:{ pid:pid},
		type:"POST",
		dataType:"json",
		success:function(arr) {
			// 3. �õ�cid��ɾ����������
			$("#cid").empty();//ɾ��Ԫ�ص���Ԫ��
			$("#cid").append($("<option>====��ѡ��2������====</option>"));//4.���ͷ
			// 5. ѭ���������飬��ÿ������ת����<option>��ӵ�cid��
			for(var i = 0; i < arr.length; i++) {
				var option = $("<option>").val(arr[i].cid).text(arr[i].cname);
				$("#cid").append(option);
			}
		}
	});
}




/*
 * ���ɾ����ťʱִ�б�����
 */

</script>
  </head>
  
  <body>
    <input type="checkbox" id="box"><label for="box">�༭��ɾ��</label>
    <br/>
    <br/>
  <div id="show">
    <div class="sm">${book.book_name} </div>
    <img align="top" src="<c:url value='/${book.tu_A}'/>" class="tp"/>
    <div id="book" style="float:left;">
	    <ul>
	    	<li>��Ʒ��ţ�${book.book_id}</li>
	    	<li>��ǰ�ۣ�<span class="price_n">&yen;${book.now_ji}</span></li>
	    	<li>���ۣ�<span style="text-decoration:line-through;">&yen;${book.d_ji}</span>���ۿۣ�<span style="color: #c30;">${book.zhe}</span>��</li>
	    </ul>
		<hr style="margin-left: 50px; height: 1px; color: #dcdcdc"/>
		<table class="tab">
			<tr>
				<td colspan="3">
					���ߣ�${book.zuo}
				</td>
			</tr>
			<tr>
				<td colspan="3">
					�����磺${book.chu}</a>
				</td>
			</tr>
			<tr>
				<td colspan="3">����ʱ�䣺${book.chu_tiem}</td>
			</tr>
			<tr>
				<td>��Σ�${book.ban_one}</td>
				<td>ҳ����${book.page}</td>
				<td>������${book.zhi_shu}</td>
			</tr>
			<tr>
				<td width="180">ӡˢʱ�䣺${book.yi_tiem}</td>
				<td>������${book.k_b}</td>
				<td>ֽ�ţ�${book.zi_zhang}</td>
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
	    	<li>��Ʒ��ţ�${book.book_id}</li>
	    	<li>��������<input id="bname" type="text" name="bname" value="${book.book_name}" style="width:500px;"/></li>
	    	<li>��ǰ�ۣ�<input id="currPrice" type="text" name="price" value="${book.now_ji}" style="width:50px;"/></li>
	    	<li>���ۣ���<input id="price" type="text" name="disprice" value="${book.d_ji}" style="width:50px;"/>
	    	�ۿۣ�<input id="discount" type="text" name="discount" value="${book.zhe}" style="width:30px;"/>��</li>
	    </ul>
		<hr style="margin-left: 50px; height: 1px; color: #dcdcdc"/>
		<table class="tab">
			<tr>
				<td colspan="3">
					���ߣ�����<input id="author" type="text" name="author" value="${book.zuo}" style="width:150px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					�����磺��<input id="press" type="text" name="press" value="${book.chu}" style="width:200px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">����ʱ�䣺<input id="publishtime" type="text" name="publishtime" value="${book.chu_tiem}" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>��Σ�����<input id="edition" type="text" name="edition" value="${book.ban_one}" style="width:40px;"/></td>
				<td>ҳ��������<input id="pageNum" type="text" name="pageNum" value="${book.page}" style="width:50px;"/></td>
				<td>����������<input id="wordNum" type="text" name="wordNum" value="${book.zhi_shu}" style="width:80px;"/></td>
			</tr>
			<tr>
				<td width="250px">ӡˢʱ�䣺<input id="printtime" type="text" name="printtime" value="${book.yi_tiem}" style="width:100px;"/></td>
				<td width="250px">����������<input id="booksize" type="text" name="booksize" value="${book.k_b}" style="width:30px;"/></td>
				<td>ֽ�ţ�����<input id="paper" type="text" name="paper" value="${book.zi_zhang}" style="width:80px;"/></td>
			</tr>
			<tr>
				<td>
					һ�����ࣺ<select name="pid" id="pid" onchange="loadChildren()">
						<option value="">==��ѡ��1������==</option>
			    			<s:iterator value="#request.li" id="cs">
			    		<option value="<s:property value="#cs.A_id"/>" ><s:property value="#cs.book_name"/> </option>
			    	  </s:iterator>
					</select>
				</td>
				<td>
					�������ࣺ<select name="cid" id="cid">
						<option value="">==��ѡ��2������==</option>
			    	
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<input onclick="editForm()" type="button" name="method" id="editBtn" class="btn" value="�ࡡ����">
					
				</td>
				<td></td>
			</tr>
		</table>
	</div>
   </form>
  </div>

  </body>
</html>
