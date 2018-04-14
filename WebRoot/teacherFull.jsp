<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>中关村软件园人才基地</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/themes/icon.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
      $(function(){
        var treeData = [{
			text : "讲师功能",
			attributes : {
				p : "true",
			},
			children : [  {
				text : "评测结果查询",
				attributes : {
					url : "<%=request.getContextPath()%>/bk/showTeacher.jsp?tag=search",
				}
			},{
				text : "修改密码",
				attributes : {
					url : "<%=request.getContextPath()%>/bgTemplate/teacherModifyPasswordPage.jsp",
				}
			}]
			
		}];

		$("#tr").tree({
			data : treeData,
			animate : true,
			onClick : function(node) {

				if (!node.attributes.p) {
					openTab(node.text, node.attributes.url);
				}

			}
		});

		function openTab(text, url) {
			if ($("#tb").tabs("exists", text)) {
				$("#tb").tabs("select", text);
			} else {
				$("#tb")
						.tabs(
								"add",
								{
									title : text,
									closable : true,
									content : '<iframe scrolling="no" frameborder="0" src="'
											+ url
											+ '" style="width:100%;height:100%;"></iframe>',
									cache : false,
								});
			}

		}

	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height:90px;background:#E0ECFF;padding:10px">
		<img src="<%=request.getContextPath()%>/img/logo.gif" height="60px" />中关村软件园人才基地后台管理系统
	</div>
	<div data-options="region:'west',split:true,title:'West'"
		style="width:200px;padding:10px;">
		<ul id="tr" class="easyui-tree" data-options="animate:true"></ul>
	</div>
	<div data-options="region:'south',border:false"
		style="height:50px;background:#E0ECFF;padding:10px;">
		<center>中关村软件园人才基地版权 @copyright 2013</center>
	</div>
	<div data-options="region:'center'">
		<div id="tb" class="easyui-tabs" style="width:auto;height:auto">
		</div>
	</div>
</body>
</html>