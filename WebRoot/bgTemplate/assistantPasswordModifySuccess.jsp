<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>

<title>Accordion Actions - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {

		$.messager.alert("提示", "密码修改成功！", "info", function() {
			location.href = "assistantModifyPasswordPage.jsp";
		});

	});
</script>
</head>
<body>
	<input style="display: none;" id="ip1"
		value="${param.evaluateItemStatu}"></input>
	<input style="display: none;" id="ip2" value="${param.evaluateItemId}"></input>
	<br>
</body>
</html>
