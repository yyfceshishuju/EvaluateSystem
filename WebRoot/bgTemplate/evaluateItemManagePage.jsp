<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
								pageList : [ 5, 10, 15 ],
								fitColumns : true,
								nowrap : true,
								striped : true,
								collapsible : true,
								url : 'EvaluateSystem/EvaluateItem_showEvaluateItems.action',
								loadMsg : '数据装载中......',
								onLoadSuccess : function(data) {
									$(".updateButton").linkbutton({
										text : "修改",
										plain : true,
										iconCls : "icon-edit"
									});
								},
								onLoadError : function() {
									$.messager.alert('提示','没有数据!','error');
								},
								sortName : 'code',
								sortOrder : 'desc',
								remoteSort : false,
								frozenColumns : [ [ {
									field : 'ck',
									checkbox : true
								} ] ],
								columns : [ [ /*{
																																																																					},*/
										{
											title : '教师教评项名称',
											field : 'itemName',
											width : '300',
											rowspan : 2,
											align : 'center',
										/* formatter : function(value) {
											return "<a href=''>" + value
													+ "</a>";
										} */
										},
										{
											title : '分数',
											field : 'itemScore',
											width : '100',
											rowspan : 2,
											align : 'center',
										//formatter:function(value){
										//   return value.name;
										//}
										},
										{
											title : '类别',
											field : 'itemCategory',
											width : '100',
											rowspan : 2,
											align : 'center',
											formatter : function(value) {
												if (value == "selector") {
													return "客观项";
												} else {
													return "意见建议项";
												}
											}
										},
										{
											title : '创建时间',
											field : 'createDate',
											width : '100',
											rowspan : 2,
											align : 'center'
										},
										{
											title : '创建者',
											field : 'adminName',
											width : '100',
											rowspan : 2,
											align : 'center'
										},
										{
											field : 'id',
											title : '操作',
											width : '100',
											rowspan : 2,
											align : 'center',
											formatter : function(value, value1) {
												//if (value1.isDelete == "y")
													/* return "<a href=\"EvaluateItem_showEvaluateItemById.action?evaluateItemId="
															+ value1.isDelete
															+ "\" class=\"updateButton\" onclick='isChange();'>修改</a>"; */
												//return "<a href="" class=\"updateButton\" onclick='isChange();'>修改</a>";
												return "<a href=\"error.jsp?evaluateItemStatu="
															+ value1.isDelete+"&evaluateItemId="+value
															+ "\" class=\"updateButton\">修改</a>";
											}
										} ] ],
								pagination : true,
								rownumbers : true,
								toolbar : [
										{
											text : '删除',
											iconCls : 'icon-remove',
											handler : function() {
											if ($("input[type=checkbox]:checked").length == 0) {
													$.messager.alert('提示',"请选择删除项",'info');
													return false;
												}
											$.messager.confirm('确定', '确定删除?', function(r){
												if(r){
												
												var ids = [];
												var str = "";
												var rows = $("#tt").datagrid(
														"getSelections");
												for ( var i = 0; i < rows.length; i++) {
													ids.push(rows[i].isDelete);
													str += rows[i].isDelete
															+ "-";
												}
												if (str.indexOf("n", 0) >= 0) {
													$.messager.alert('提示',"被选中的教评项已经被使用，不能删除！",'info');
												} else {
													var str2 = "";
													for ( var i = 0; i < rows.length; i++) {
														ids.push(rows[i].id);
														str2 += rows[i].id
																+ "-";
													}
													location.href = "EvaluateItem_removeEvaluateItem.action?removeItem="
															+ str2;
											}}});
											
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
	<script type="text/javascript">
		function isChange() {
		alert("");
			if (ff == "n") {
				$.messager.alert('提示',"该项已经被使用不能被修改！",'info');
				return false;
			}
			return true;
		}
	</script>
	<table style="width: 100%">
		<tr>
			<td style="width: 10%">添加教师教评项：</td>
			<td style="width: 50%"><a id="creataEvaluateItem"
				href="<%=request.getContextPath()%>/bgTemplate/evaluateItemCreatePage.jsp"
				class="easyui-linkbutton" icon="icon-add">创建教师教评项</a>
			</td>
			<td style="width: 30%"></td>
			<td style="width: 40%"></td>
		</tr>
	</table>

	<div style="height: 5px;"></div>
	<table id="tt"></table>
</body>

</html>