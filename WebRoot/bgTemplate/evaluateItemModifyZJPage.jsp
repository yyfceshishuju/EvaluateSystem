<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
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
	<div style="margin-left:400px;margin-top:50px">
		<div class="easyui-panel" title="助教评测项更新"
			style="width:400px;heigth:500px">
			<div style="padding:10px 0 10px 60px">
				<form id="ff" method="post"
					action='<s:url action='EvaluateItemZJ_modifyZJEvaluateItem.action'></s:url>'>
					<table>
						<tr style="display: none;">
							<td>教评项id:</td>
							<td><input class="easyui-validatebox" type="text"
								name="modifyEvaluateItem.id"
								value="<s:property value="evaluateItemId" />"
								data-options="required:true"></input>
							</td>
						</tr>
						<tr>
							<td>教评项名称:</td>
							<td><input class="easyui-validatebox" type="text"
								name="modifyEvaluateItem.itemName"
								value="<s:property value='evaluateItemById.itemName'/>"
								data-options="required:true"></input>
							</td>
						</tr>
						<tr>
							<td>教评分值:</td>
							<td><input class="easyui-validatebox" type="text"
								name="modifyEvaluateItem.itemScore"
								value="<s:property value='evaluateItemById.itemScore'/>"
								data-options="required:true"></input>
							</td>
						</tr>
						<tr>
							<td>类型:</td>
							<!-- <td><input class="easyui-validatebox" type="text" name="subject" data-options="required:true"></input></td> -->
							<td><select name="modifyEvaluateItem.itemCategory"
								class="easyui-combobo">
									<option value="selector">客观项</option>
									<option value="Input">意见建议项</option>
							</select>
							</td>
						</tr>

					</table>
				</form>
			</div>
			<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="submitForm()" icon="icon-ok">更新助教教评项</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="clearForm()" icon="icon-cancel">清空</a>
					<a href="evaluateItemManageZJPage.jsp" class="easyui-linkbutton"
					icon="icon-back" onclick="clearForm()">返回上一页</a>
			</div>
		</div>
	</div>
	<script>
		function submitForm() {
			var inputs = $("input");
			if ($(inputs[1]).val() == "") {
				$.messager.alert('提示',"名称不能为空！");
				return;
			}
			var str = inputs[2].value;
			if (str != 5) {
				$.messager.alert('提示',"分数必须为 5 ！");
				return;
			}
			/* if (isNaN(str)) {
				alert("分值必须为数字");
				return;
			} */
			document.getElementById("ff").submit();
			return;

		}
		function clearForm() {
			$('#ff').form('clear');
		}
	</script>
</body>
</html>