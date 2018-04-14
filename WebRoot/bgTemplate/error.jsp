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
   $(function(){var inp = document.getElementById("ip1");
		var va = inp.value;
		var inp2 = document.getElementById("ip2");
		var va2 = inp2.value;
		if (va == "y") {
			location.href = "EvaluateItem_showEvaluateItemById.action?evaluateItemId="
					+ va2;
		}else{
			$.messager.alert("提示","该项已被使用不能修改","info",function(){
                location.href="evaluateItemManagePage.jsp";
      });
			
		}
      
   });


	function isChange() {
		
	}
</script>
</head>
<body >
	<input style="display: none;" id="ip1" value="${param.evaluateItemStatu}"></input>
	<input style="display: none;" id="ip2" value="${param.evaluateItemId}"></input>
	<br>
</body>
</html>
