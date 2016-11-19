<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=gbk">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/regist.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/user/regist.js'/>"></script>
  </head>
  
  <body>
<div class="divBody">
  <div class="divTitle">
    <span class="spanTitle">新用户注册</span>
  </div>
  <div class="divCenter">
    <form action="whe.action" method="post">
    <input type="hidden" name="method" value=""/>
    <table>
      <tr>
        <td class="tdLabel">用户名：</td>
        <td class="tdInput">
          <input type="text" name="loginname" id="loginname" class="inputClass" value="${form.loginname }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="loginnameError">${errors.loginname }</label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">登录密码：</td>
        <td class="tdInput">
          <input type="password" name="loginpass" id="loginpass" class="inputClass" value="${form.loginpass }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="loginpassError">${errors.loginpass }</label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">确认密码：</td>
        <td class="tdInput">
          <input type="password" name="reloginpass" id="reloginpass" class="inputClass" value="${form.reloginpass }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="reloginpassError">${errors.reloginpass}</label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">Email：</td>
        <td class="tdInput">
          <input type="text" name="email" id="email" class="inputClass" value="${form.email }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="emailError">${errors.email}</label>
        </td>
      </tr>
      <tr>
        <td class="tdLabel">图形验证码：</td>
        <td class="tdInput">
          <input type="text" name="verifyCode" id="verifyCode" class="inputClass" value="${form.verifyCode }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="verifyCodeError">${errors.verifyCode}</label>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>
      <img  src="createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()"  title="点击图片刷新验证码"/><br>
        </td>
<!--          <td><a href="javascript:_hyz()">换一张</a></td>
 -->       </tr>
      <tr> <!--
       -->
        <td>&nbsp;</td>
        <td>
          <input type="image" src="<c:url value='/images/regist1.jpg'/>" id="submit"/>
        </td>
        <td>&nbsp;</td>
      </tr>
    </table>
    </form>
  </div>
</div>
  </body>
</html>
	