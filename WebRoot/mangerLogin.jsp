<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta charset="UTF-8">
<title>中关村软件园人才基地</title>
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<link rel="stylesheet" type="text/css" href="./css/demo.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./js/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div style="margin-left:400px;margin-top:50px">

		<div class="easyui-panel" title="管理员登陆"
			style="width:400px;heigth:500px">
			<img src="./img/domain_logo.gif" style="border: 1px">
			<div style="padding:10px 0 10px 60px">
				<form id="ff" method="post"
					action='<s:url namespace="/bgTemplate" action='Admin_login.action'></s:url>'>
					<table>
						<tr>
							<td>用户名:</td>
							<td><input class="easyui-validatebox" type="text"
								name="username" data-options="required:true"></input></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input class="easyui-validatebox" type="password"
								name="password" data-options="required:true"></input></td>
						</tr>
						<tr>
							<td>角色:</td>
							<td><select id="cc" name="role" required="true">
								<option value="manager">管理员</option>
								<option value="teacher">讲师</option>
								<option value="assistant">项目经理</option>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
					</table>
				</form>
			</div>
			<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="submitForm()" icon="icon-ok">登陆</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="clearForm()" icon="icon-cancel">重置</a>
			</div>
		</div>
	</div>
	<script>
		function submitForm() {
			var inputs = $("input");
			for ( var i = 0; i <= inputs.length; i++) {
				if ($(inputs[i]).val() != "") {
					document.getElementById("ff").submit();
					break;
				} else {
					$.messager.alert('提示', "内容不能为空!", 'info');
					return 0;
				}
			}
		}
		function clearForm() {
			$('#ff').form('clear');
		}
	</script>
</body>
</html>