<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<script language="javascript">
<!--
function mhEnter()
{
window.event.srcElement.className="lt1";
}
function mhLeave()
{
window.event.srcElement.className="lt0";
}
//-->
</script>
<link rel="stylesheet" href="image/style.css"/>
<style type="text/css">
<!--
.blogtitle {
	font-size: 18px;
	font-weight: bold;
}
.idiograph {
	position: relative;
	left: 50px;
}

-->
</style>
</head>

<body>
<table width="1000" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td background="user/image/bg1.jpg" height="150">
		<!-- 博客标题位置-->
		<span class="blogtitle">${sessionScope.blogtitle}</span><br />
	  <span class="idiograph">${sessionScope.idiograph}     </span>		<!-- 个性签名位置-->		</td>
	</tr>
	<tr height="31">
		<td background="user/image/line.jpg">
			<table width="1000" border="0" cellpadding="0" cellspacing="0">
				<tr height="20" align="center">
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="/po/allshow">开心博客首页</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="/po/addArticle2">用户首页</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="/po/user/editbloginfo.jsp">个性化设置</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../index.html">日志</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../index.html">相册</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../index.html">留言板</a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>

