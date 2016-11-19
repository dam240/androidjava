<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=gbk">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/book/add.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
<script type="text/javascript">
$(function () {
	$("#publishtime").datepick({dateFormat:"yy-mm-dd"});
	$("#printtime").datepick({dateFormat:"yy-mm-dd"});
	
	$("#btn").addClass("btn1");
	$("#btn").hover(
		function() {
			$("#btn").removeClass("btn1");
			$("#btn").addClass("btn2");
		},
		function() {
			$("#btn").removeClass("btn2");
			$("#btn").addClass("btn1");
		}
	);
	
	$("#btn").click(function() {
		var bname = $("#bname").val();
		var currPrice = $("#currPrice").val();
		var price = $("#price").val();
		var discount = $("#discount").val();
		var author = $("#author").val();
		var press = $("#press").val();
		var pid = $("#pid").val();
		var cid = $("#cid").val();
		var image_w = $("#image_w").val();
		var image_b = $("#image_b").val();
		
		if(!bname || !currPrice || !price || !discount || !author || !press || !pid || !cid || !image_w || !image_b) {
			alert("ͼ������ǰ�ۡ����ۡ��ۿۡ����ߡ������硢1�����ࡢ2�����ࡢ��ͼ��Сͼ������Ϊ�գ�");
			return false;
		}
		
		if(isNaN(currPrice) || isNaN(price) || isNaN(discount)) {
			alert("��ǰ�ۡ����ۡ��ۿ۱����ǺϷ�С����");
			return false;
		}
		$("#form").submit();
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

</script>
  </head>
  
  <body>
  <div>
   <p style="font-weight: 900; color: red;">${msg }</p>
   <form action="upload.action" enctype="multipart/form-data" method="post" id="form">
    <div>
	    <ul>
	    	<li>��������<input id="bname" type="text" name="bname" value="Springʵս(��3��)��In Actionϵ���������Springͼ�飬��ʮ�����ѧϰSpring�Ĺ�ͬѡ��" style="width:500px;"/></li>
	    	<li>��ͼ����<input id="image_w" type="file" name="image_w"/></li>
	    	<li>Сͼ����<input id="image_b" type="file" name="image_b"/></li>
	    	<li>��ǰ�ۣ�<input id="price" type="text" name="price" value="40.7" style="width:50px;"/></li>
	    	<li>���ۣ���<input id="currPrice" type="text" name="disprice" value="59.0" style="width:50px;"/>
	    	�ۿۣ�<input id="discount" type="text" name="discount" value="6.9" style="width:30px;"/>��</li>
	    </ul>
		<hr style="margin-left: 50px; height: 1px; color: #dcdcdc"/>
		<table>
			<tr>
				<td colspan="3">
					���ߣ�����<input type="text" id="author" name="author" value="Craig Walls" style="width:150px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					�����磺��<input type="text" name="press" id="press" value="�����ʵ������" style="width:200px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">����ʱ�䣺<input type="text" id="publishtime" name="publishtime" value="2013-6-1" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>��Σ�����<input type="text" name="edition" id="edition" value="1" style="width:40px;"/></td>
				<td>ҳ��������<input type="text" name="pageNum" id="pageNum" value="374" style="width:50px;"/></td>
				<td>����������<input type="text" name="wordNum" id="wordNum" value="48700" style="width:80px;"/></td>
			</tr>
			<tr>
				<td width="250">ӡˢʱ�䣺<input type="text" name="printtime" id="printtime" value="2013-6-1" style="width:100px;"/></td>
				<td width="250">����������<input type="text" name="booksize" id="booksize" value="16" style="width:30px;"/></td>
				<td>ֽ�ţ�����<input type="text" name="paper" id="paper" value="����ֽ" style="width:80px;"/></td>
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
				<td>
					<input type="button" id="btn" class="btn" value="�����ϼ�">
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
   </form>
  </div>

  </body>
</html>
