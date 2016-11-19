<%@ page language="java" import="java.util.*,com.cd.bean.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
	function _go() {
		var pc = $("#now").val();//获取文本框中的当前页码
		if(!/^[1-9]\d*$/.test(pc)) {//对当前页码进行整数校验
			alert('请输入正确的页码！');
			return;
		}
		if(pc > 10) {//判断当前页码是否大于最大页
			alert('请输入正确的页码！');
			return;
		}
		location = "lolo.action?now="+pc;
	}
</script>

<%

    page1 p =(page1) request.getAttribute("page");

 %>


<div class="divBody">
  <div class="divContent">
    <%--上一页 --%>
       <%
          if(p.isUp())
          {
        %>    
    <!--     <span class="spanBtnDisabled">上一页</span> -->

        <a href="lolo.action?now=${requestScope.page.now -1 }" class="aBtn bold">上一页</a>
<% } %>

    <%-- 计算begin和end --%>
      <%-- 如果总页数<=6，那么显示所有页码，即begin=1 end=${pb.tp} --%>
        <%-- 设置begin=当前页码-2，end=当前页码+3 --%>
          <%-- 如果begin<1，那么让begin=1 end=6 --%>
          <%-- 如果end>最大页，那么begin=最大页-5 end=最大页 --%>

    
    <%-- 显示页码列表 --%>
            
           <%
            for(int i=1;i<=p.getCunot();i++)
            {
              if(i==p.getNow())
              {
            %>
            <span class="spanBtnSelect" ><%=i %></span>
            <%
            }
            else
            {
             %>
         <a href="lolo.action?now=<%=i %>"> <span class="aBtn bold" ><%=i %></span></a>
           <%
           }
           }
            %>
    
    
    <%-- 显示点点点 --%>
      <span class="spanApostrophe">...</span> 

    
     <%--下一页 --%>
                 <%
                 if(p.isNext())
                 {
                  %>
     <!--    <span class="spanBtnDisabled">下一页</span>
 -->        <a href="lolo.action?now=${requestScope.page.now + 1 }" class="aBtn bold">下一页</a> 
             <%} %>
  
    
    <%-- 共N页 到M页 --%>
    <span>共<s:property value="#request.page.cunot"/></span>
    <span>到</span>
    <input type="text" class="inputPageCode" id="now" name="now" value="<%=p.getNow() %>"/>
    <span>页</span>
    <a href="javascript:_go();" class="aSubmit">确定</a>
  </div>
</div>