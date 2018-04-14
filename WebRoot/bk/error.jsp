<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
  <link rel="stylesheet" type="text/css"
	href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
  	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
  	<SCRIPT type="text/javascript">
  	 $(function(){
  		 var msg = document.getElementById("msg").value;
         $.messager.alert("提示",msg,"info",function(){
  			location.href="<%=request.getContextPath()%>/bk/evaluateList.jsp";
      });
   });
  </SCRIPT>
    </head>
  <body >
     <div>
   <input id="msg" type="hidden"  value="<s:property value='msg'/>" />
     </div>
  </body>
</html>
