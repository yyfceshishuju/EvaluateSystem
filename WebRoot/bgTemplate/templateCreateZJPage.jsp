<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html dir="ltr" lang="en-US">
<head>
<!-- Created by Artisteer v4.1.0.59861 -->
<title>助教教评模板生成</title>

<title>Accordion Actions - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
                                                		function tosubmit(f) {
                                                			if ($("#inp1").get(0).value == "") {
                                                				$.messager.alert('提示',"模板名称不能为空",'info');
                                                				return false;
                                                			}
                                                			if ($($("#inp1").get(0)).val().length > 10) {
                                                				$.messager.alert('提示',"模板名称不能超过10个字符",'info');
                                                				return false;
                                                			}
                                                			if($("#inteachers>option").length != 5){
                                                				$.messager.alert('提示',"客观项必须选5项",'info');
                                                				return false;
                                                			}
                                                			if($("#inteachers2>option").length != 2){
                                                				$.messager.alert('提示',"意见建议项必须选2项",'info');
                                                				return false;
                                                			}
                                                			var s = f['inteachers'];
                                                			var s2 = f['inteachers2'];
                                                			for ( var i = 0; i < s.length; i++) {
                                                				s[i].selected = true;
                                                			}
                                                			for ( var i = 0; i < s2.length; i++) {
                                                				s2[i].selected = true;
                                                			}
                                                			return true;
                                                		}
                                                		function moveToList(from, to) {
                                                			var sel = false;
                                                			fromList = document.getElementById(from);
                                                			toList = document.getElementById(to);
                                                			for (i = fromList.options.length - 1; i >= 0; i--)
                                                			{
                                                				var current = fromList.options[i];
                                                				if (current.selected) {
                                                					sel = true;
                                                					txt = current.text;
                                                					val = current.value;
                                                					toList.options[toList.length] = fromList.options[i];
                                                				}
                                                			}
                                                			if (!sel)
                                                				alert('please select a item!');
                                                		}
                                                		function moveAllToList(from, to) {
                                                			fromList = document.getElementById(from);
                                                			toList = document.getElementById(to);
                                                			for (i = fromList.options.length - 1; i >= 0; i--) {
                                                				var current = fromList.options[i];
                                                				txt = current.text;
                                                				val = current.value;
                                                				toList.options[toList.length] = new Option(txt, val);
                                                				fromList.options[i] = null;
                                                			}
                                                		}
                                                		function createTemplate() {
                                                			var jsf = $($("#f1").get(0));
                                                			//tosubmit(jsf);
                                                			jsf.submit();
                                                		}
                                                	</script>
<style>
.art-content .art-postcontent-0 .layout-item-0 {
	margin-bottom: 10px;
}

.art-content .art-postcontent-0 .layout-item-1 {
	border-spacing: 10px 0px;
	border-collapse: separate;
}

.art-content .art-postcontent-0 .layout-item-2 {
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-color: #B5C5C9;
	border-right-color: #B5C5C9;
	border-bottom-color: #B5C5C9;
	border-left-color: #B5C5C9;
	color: #13191B;
	background: #CDD8DB;
	padding-right: 10px;
	padding-left: 10px;
}

.ie7 .art-post .art-layout-cell {
	border: none !important;
	padding: 0 !important;
}

.ie6 .art-post .art-layout-cell {
	border: none !important;
	padding: 0 !important;
}
</style>
</head>
<body>


	<div style="margin-left:100px;margin-top:20px">
		<div class="easyui-panel" title="创建助教教评模板"
			style="width:1000px;heigth:900px">
			<div>
				<div>
					<div class="art-content-layout">
						<div class="art-content-layout-row">
							<div class="art-layout-cell art-content">

								<div class="art-postmetadataheader"></div>


								<div class="art-content-layout-wrapper layout-item-0">
									<div class="art-content-layout layout-item-1">
										<div class="art-content-layout-row">
											<div class="art-layout-cell layout-item-2"
												style="width: 100%">
												<p></p>
												<p></p>
												<p></p>
												<div id="d1">
													<div id="d1_body">
														<form id="f1"
															action="<s:url action='TemplateZJ_createTemplate.action'/>"
															method="post" onsubmit="return tosubmit(this)">
															<!-- 	<div style="padding-left: ">
																	模板名稱:<input id="inp1" class="easyui-validatebox"
																		type="text" name="templateName"
																		data-options="required:true"></input>
																</div> -->
															<table style="width:100%;">
																<tr>
																	<td></td>
																	<td align="right" style="text-align: center; "><span
																		style="font-size: 16px;">
																		<h3 style="margin-top: 20px;" align="right">
																				<span style="color: #000000; ">模板名称:</span>
																			</h3> </span>
																	</td>
																	<td><div>
																			<input placeholder="请输入模版名称"
																				style="width: 200px;height: 30px" height="50px"
																				id="inp1" class="easyui-validatebox"
																				style="huerreson:(this.width=this.scrollWidth)"
																				type="text" name="templateName"
																				data-options="required:true">
																		</div></td>
																</tr>
																<tr style="border: medium;border: 2px;">
																	<td style="width:20%;"><div style="padding-left: ">
																			<h3>客观项:</h3>
																		</div></td>
																	<td><select id="notinteachers" multiple="true"
																		style="width:250px;height:150px;"
																		ondblclick="moveToList('notinteachers', 'inteachers')">
																			<s:iterator
																				value="evaluateItems.{? #this.itemCategory == 'selector'}">
																				<option value='<s:property value='id'/>'>
																					<s:property value="itemName" />
																				</option>
																			</s:iterator>
																	</select></td>
																	<td align="left" style="width:20%;"><input
																		type="button" value="→" style="width:120px"
																		onclick="moveToList('notinteachers', 'inteachers')">
																		<p /> <input type="button" value="→→"
																		style="width:120px"
																		onclick="moveAllToList('notinteachers', 'inteachers')">
																		<p /> <input type="button" value="←"
																		style="width:120px"
																		onclick="moveToList('inteachers', 'notinteachers')">
																		<p /> <input type="button" value="←←"
																		style="width:120px"
																		onclick="moveAllToList('inteachers', 'notinteachers')">
																		<p /></td>
																	<td><select id="inteachers" multiple="true"
																		name="evaluateItemId"
																		style="width:250px;height:150px;"
																		ondblclick="moveToList('inteachers', 'notinteachers')">
																	</select></td>
																	<td>
																</tr>
															</table>
															<table style="width:100%;">
																<tr>
																	<td style="width:20%;">
																		<h3>意见建议项:</h3>
																		</div></td>
																	<td><select id="notinteachers2" multiple="true"
																		style="width:250px;height:150px;"
																		ondblclick="moveToList('notinteachers2', 'inteachers2')">
																			<s:iterator
																				value="evaluateItems.{? #this.itemCategory == 'Input'}">
																				<option value='<s:property value='id'/>'>
																					<s:property value="itemName" />
																				</option>
																			</s:iterator>
																	</select></td>
																	<td align="left" style="width:20%;"><input
																		type="button" value="→" style="width:120px"
																		onclick="moveToList('notinteachers2', 'inteachers2')">
																		<p /> <input type="button" value="→→"
																		style="width:120px"
																		onclick="moveAllToList('notinteachers2', 'inteachers2')">
																		<p /> <input type="button" value="←"
																		style="width:120px"
																		onclick="moveToList('inteachers2', 'notinteachers2')">
																		<p /> <input type="button" value="←←"
																		style="width:120px"
																		onclick="moveAllToList('inteachers2', 'notinteachers2')">
																		<p /></td>
																	<td><select id="inteachers2" multiple="true"
																		name="evaluateItemId2"
																		style="width:250px;height:150px;"
																		ondblclick="moveToList('inteachers2','notinteachers2')">
																	</select></td>
																</tr>
																<tr>
																	<td colspan="4" align="center"><!-- <a href="javascript:void(0)"
																	class="easyui-linkbutton" plain="true" icon="icon-ok"
																	onClick="createTemplate();">创建模版</a>  -->
																	<a href="#"  class="easyui-linkbutton" icon="icon-ok" onclick="createTemplate()">创建模板</a>
																	<a href="templateManageZJPage.jsp" class="easyui-linkbutton" icon="icon-back" onclick="clearForm()">返回上一页</a>
																	</td>
																</tr>
															</table>
														</form>
													</div>
												</div>
												<div style="height:10px"></div>

												<p></p>
												<p></p>
												<p></p>
											</div>
										</div>
									</div>
								</div>
							</div>
							</article>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	</div>


</body>
</html>