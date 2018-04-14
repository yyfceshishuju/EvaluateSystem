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
<body>
	<div style="margin:10px 0px;" align="center">
	<div class="easyui-panel" title="每项得分详情" style="width:500px">
		<s:iterator value="#request.evaluateScoreDetail" var="i">
			<div style="margin: 20px 40px">
				<s:property value="i"/>
			</div>
		</s:iterator>
	</div>
	<div style="margin: 20px  100px">
		  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="callback();" icon="icon-back" >返回</a>	   		
	</div>
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
