<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

<title>Basic Form - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div style="margin-left:300px;margin-top:50px">
		<div class="easyui-panel" title="项目经理修改密码"
			style="width:500px;heigth:500px">
			<div style="padding:10px 0 10px 60px">
				<form id="ff" method="post"
					action='<s:url namespace="/bgTemplate" action='Admin_assistantModifyPassword.action'></s:url>'>
					<table>
						<tr>
							<td>原始密码:</td>
							<td><input class="easyui-validatebox" type="password"
								name="assisOldPassword" data-options="required:true"></input><span
								style="color:red;"></span>
							</td>
						</tr>
						<tr>
							<td>新密码:</td>
							<td><input id="itemScore" class="easyui-validatebox"
								type="password" name="assisNewPassword" data-options="required:true"></input><span
								style="color:red;"></span></td>
						</tr>
						<tr>
							<td>确认新密码:</td>
							<!-- <td><input class="easyui-validatebox" type="text" name="subject" data-options="required:true"></input></td> -->
							<td><input id="itemScore" class="easyui-validatebox"
								type="password" name="newPassword2" data-options="required:true"></input>
							</td>
						</tr>

					</table>
				</form>
			</div>
			<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					icon="icon-ok" onclick="submitForm()">修改密码</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					icon="icon-cancel" onclick="clearForm()">清空</a>
			</div>
		</div>
	</div>
	<script>
		function submitForm() {
			var inputs = $("input");
			if ($(inputs[0]).val() == "") {
				$.messager.alert('提示', '原始密码不能为空！', 'info');
				return false;
			}
			if ($(inputs[1]).val() == "") {
				$.messager.alert('提示', '新密码不能为空！', 'info');
				return false;
			}
			if ($(inputs[2]).val() != $(inputs[1]).val()) {
				$.messager.alert('提示', '新密码两次输入不一致请重新输入！', 'info');
				clearForm();
				return false;
			}
			if ($(inputs[1]).val().length > 6) {
				$.messager.alert('提示', "新密码不能少于6位", 'info');
				return false;
			}
			confirm1();
		}
		function confirm1() {
			$.messager.confirm('提示：', '确定修改密码？',
					function(r) {
						if (r) {
							document.getElementById("ff").submit();
						}
					});
		}
		function clearForm() {
			$('#ff').form('clear');
		}
	</script>
</body>
</html>