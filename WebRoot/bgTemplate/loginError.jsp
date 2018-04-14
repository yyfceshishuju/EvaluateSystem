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

		$.messager.alert("提示", "用户名或密码错误，请重新登陆", "error", function() {
			location.href = "/EvaluateSystem/mangerLogin.jsp";
		});

	});

	function isChange() {

	}
</script>
</head>
<body>
	<br>
</body>
</html>
