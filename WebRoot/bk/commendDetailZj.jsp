<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
</head>
<body style="overflow: auto;">
	
	<div id="p" class="easyui-panel" title="评价意见详情" style="width:auto;height:400px;padding:10px;">
		<p style="font-size:14px"><s:property value="#request.inputItem[0]"/></p>
		<ul>
		<s:iterator value="#request.commend1" var="i" status="k">
			<li><s:property value="i"/>;</li>
			</s:iterator>
		</ul>
		
		
		<p style="font-size:14px"><s:property value="#request.inputItem[1]"/></p>
		<ul>
		<s:iterator value="#request.commend2" var="j" status="k">
			<li><s:property value="j"/>;</li>
			</s:iterator>
		</ul>
	
	
	</div>
	<div style="margin: 20px  100px" align="center">
		  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="callback();" icon="icon-back" >返回</a>	   		
	
	</div>
 

	<script type="text/javascript">
		function callback(){
			var val = document.getElementById("role").value;
			if(val == "teacher"){
				location.href="<%=request.getContextPath()%>/bk/showTeacher.jsp?tag=search";
			}
			if(val == "assistant"){
				location.href="<%=request.getContextPath()%>/bk/showAssistant.jsp?tag=search";
			}
			if(val == ""){
				location.href="<%=request.getContextPath()%>/bk/evaluateListZj.jsp";
			}
	}
	</SCRIPT>
	<input id="role" type="hidden" value="<s:property value='#session.role' />"/>
</body>
</html>
