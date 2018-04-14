<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
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
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$('#ff').hide();
			$('#tt')
					.datagrid(
							{
								title : '信息显示',
								iconCls : 'icon-save',
								width : 'auto',
								height : 'auto',
								pageSize : 10,
								fitColumns : true,
								pageList : [ 5, 10, 15 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url : 'EvaluateSystem/Template_showTemplates.action',
								loadMsg : '数据装载中......',
								onLoadSuccess : function(data) {
									$(".updateButton").linkbutton({
										text : "修改",
										plain : true,
										iconCls : "icon-edit"
									});
								},
								onLoadError : function() {
									$.messager.alert('提示','没有数据!','info');
								},
								sortName : 'code',
								sortOrder : 'desc',
								remoteSort : false,
								frozenColumns : [ [ {
									field : 'ck',
									checkbox : true
								} ] ],
								columns : [ [
										{
											title : '测评模板名字',
											field : 'templateName',
											width : '300',
											rowspan : 2,
											align : 'center'
										},
										{
											title : '创建时间',
											field : 'createDate',
											width : '200',
											rowspan : 2,
											align : 'center',
										//formatter:function(value){
										//   return value.name;
										//}
										},
										{
											title : '创建者',
											field : 'adminName',
											width : '200',
											rowspan : 2,
											align : 'center',
										},
										{
											title : '状态',
											field : 'statu',
											width : '200',
											rowspan : 2,
											align : 'center',
											formatter : function(value, value2) {
												if (value == "y")
													return "<a href='Template_frozenTemplate.action?frozenTemplateId="
															+ value2.id
															+ "'>可用状态</a>";
												else

													return "<a href='Template_setTemplateUseable.action?useableTemplateId="
															+ value2.id
															+ "'>冻结状态</a>";

											}
										},
										{
											field : 'id',
											title : '是否默认',
											width : '100',
											rowspan : 2,
											align : 'center',
											formatter : function(value, value2) {
												if (value2.isDefault == "y")
													return "<a href='Template_SetTemplateDefault.action?templateDefaultId="
															+ value
															+ "'>置为非默认</a>";
												else

													return "<a href='Template_SetTemplateDefault.action?templateDefaultId="
															+ value
															+ "'>置为默认</a>";

											}
										} ] ],
								pagination : true,
								rownumbers : true,
								toolbar : [
										/* {
											text : '全部',
											iconCls : 'icon-ok',
											handler : function() {
												$("input[type=checkbox]").attr(
														"checked", true);
											}
										},
										"-", */
										{
											text : '删除',
											iconCls : 'icon-remove',
											handler : function() {if ($("input[type=checkbox]:checked").length == 0) {
																			$.messager
																					.alert(
																							'提示',
																							"请选择删除项",
																							'info');
																			return false;
																		};
												$.messager
														.confirm(
																'确定',
																'确定删除?',
																function(r) {
																	if (r) {
																		var ids = [];
																		var str = "";
																		var rows = $(
																				"#tt")
																				.datagrid(
																						"getSelections");
																		for ( var i = 0; i < rows.length; i++) {
																			ids
																					.push(rows[i].isDelete);
																			str += rows[i].isDelete
																					+ "-";
																		}
																		if (str
																				.indexOf(
																						"n",
																						0) >= 0) {
																			$.messager
																					.alert(
																							'提示',
																							"被选中的模板已经被生成教评，不能删除！",
																							'info');
																		} else {
																			var ids = [];
																			var str2 = "";
																			var rows = $(
																					"#tt")
																					.datagrid(
																							"getSelections");
																			for ( var i = 0; i < rows.length; i++) {
																				ids
																						.push(rows[i].id);
																				str2 += rows[i].id
																						+ "-";
																			}
																			location.href = "Template_removeTemplate.action?removeId="
																					+ str2;
																		}
																	}
																});
											}
										}]

							});
			displayMsg();
		});
		function displayMsg() {
			$('#tt').datagrid('getPager').pagination({
				displayMsg : '当前显示从{from}到{to}共{total}记录'
			});
		}
		function getSelect() {
		}
		function del() {
		}
	</script>
	<table style="width: 100%">
		<tr>
			<td style="width: 10%">创建模板：</td>
			<td style="width: 50%"><a id="creataEvaluateItem"
				href="<%=request.getContextPath()%>/bgTemplate/Template_showEvaluateItemsForTemplate.action"
				class="easyui-linkbutton" icon="icon-add">创建模板</a></td>
			<td style="width: 30%"></td>
			<td style="width: 40%"></td>
		</tr>
	</table>

	<div style="height: 5px;"></div>
	<table id="tt"></table>
</body>
</html>