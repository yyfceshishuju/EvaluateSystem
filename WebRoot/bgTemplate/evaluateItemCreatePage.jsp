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
		<div class="easyui-panel" title="创建教师教评项"
			style="width:500px;heigth:500px">
			<div style="padding:10px 0 10px 60px">
				<form id="ff" method="post"
					action='<s:url action='EvaluateItem_createEvaluateItem.action'></s:url>'>
					<table>
						<tr>
							<td>教评项名称:</td>
							<td><input class="easyui-validatebox" type="text"
								name="evaluateItem.itemName" data-options="required:true"></input><span style="color:red;">*字符不能超过10</span>
							</td>
						</tr>
						<tr>
							<td>教评项分值:</td>
							<td><input id="itemScore" class="easyui-validatebox"
								type="text" name="evaluateItem.itemScore"
								data-options="required:true"></input><span style="color:red;">*请输入5分</span></td>
						</tr>
						<tr>
							<td>教评项类型:</td>
							<!-- <td><input class="easyui-validatebox" type="text" name="subject" data-options="required:true"></input></td> -->
							<td><select name="evaluateItem.itemCategory"
								class="easyui-combobo">
									<option value="selector">客观项</option>
									<option value="Input">意见建议项</option>
							</select></td>
						</tr>

					</table>
				</form>
			</div>
			<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					icon="icon-ok" onclick="submitForm()">添加教师教评项</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					icon="icon-cancel" onclick="clearForm()">清空</a>
					<a href="evaluateItemManagePage.jsp" class="easyui-linkbutton"
					icon="icon-back" onclick="clearForm()">返回上一页</a>
			</div>
		</div>
	</div>
	<script>
		function submitForm() {
			
			var inputs = $("input");
			if ($(inputs[0]).val() == "") {
				$.messager.alert('提示','用户名不能为空！','info');
				return false;
			}
			if($(inputs[0]).val().length>10){
				$.messager.alert('提示',"模板名称不能超过10个字符",'info');
				return false;
			}
			var str = inputs[1].value;
			if (str != "5") {
				$.messager.alert('提示',"分数分数必须为5!",'info');
				return false;
			}
			/* if (isNaN(str)) {
				alert("分值必须为数字");
				return;
			} */
			document.getElementById("ff").submit();
		}
		function clearForm() {
			$('#ff').form('clear');
		}
	</script>
</body>
</html>