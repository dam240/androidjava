<%@ page language="java" import="java.util.*,com.cd.bean.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
	function _go() {
		var pc = $("#now").val();//��ȡ�ı����еĵ�ǰҳ��
		if(!/^[1-9]\d*$/.test(pc)) {//�Ե�ǰҳ���������У��
			alert('��������ȷ��ҳ�룡');
			return;
		}
		if(pc > 10) {//�жϵ�ǰҳ���Ƿ�������ҳ
			alert('��������ȷ��ҳ�룡');
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
    <%--��һҳ --%>
       <%
          if(p.isUp())
          {
        %>    
    <!--     <span class="spanBtnDisabled">��һҳ</span> -->

        <a href="lolo.action?now=${requestScope.page.now -1 }" class="aBtn bold">��һҳ</a>
<% } %>

    <%-- ����begin��end --%>
      <%-- �����ҳ��<=6����ô��ʾ����ҳ�룬��begin=1 end=${pb.tp} --%>
        <%-- ����begin=��ǰҳ��-2��end=��ǰҳ��+3 --%>
          <%-- ���begin<1����ô��begin=1 end=6 --%>
          <%-- ���end>���ҳ����ôbegin=���ҳ-5 end=���ҳ --%>

    
    <%-- ��ʾҳ���б� --%>
            
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
    
    
    <%-- ��ʾ���� --%>
      <span class="spanApostrophe">...</span> 

    
     <%--��һҳ --%>
                 <%
                 if(p.isNext())
                 {
                  %>
     <!--    <span class="spanBtnDisabled">��һҳ</span>
 -->        <a href="lolo.action?now=${requestScope.page.now + 1 }" class="aBtn bold">��һҳ</a> 
             <%} %>
  
    
    <%-- ��Nҳ ��Mҳ --%>
    <span>��<s:property value="#request.page.cunot"/></span>
    <span>��</span>
    <input type="text" class="inputPageCode" id="now" name="now" value="<%=p.getNow() %>"/>
    <span>ҳ</span>
    <a href="javascript:_go();" class="aSubmit">ȷ��</a>
  </div>
</div>