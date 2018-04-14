<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
 <head>
  	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
  </head>
  <body>
   <script type="text/javascript">
	$(function() {
	$('#ff').hide();
		var evaluateId = ${param.id};
		$('#tt').datagrid({
			title : '信息显示',
			iconCls : 'icon-save',
			width : 'auto',
			height : 'auto',
			pageSize : 10,
			pageList : [ 5, 10, 15 ],
			fitColumns:true,
			nowrap : true,
			striped : true,
			collapsible : true,
			url : '<%=request.getContextPath()%>/evaluate/evaluate_showEvaluateDetails.action?id=${param.id}&tag=a', 
			loadMsg : '数据装载中......',
			onLoadError : function() {
				$.messager.alert("信息","暂无信息","info",function(){
					location.href = '<%=request.getContextPath()%>/bk/evaluateList.jsp';
				});
			},
			sortName : 'code',
			sortOrder : 'desc',
			remoteSort : false,
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				title : '学生姓名',
				field : 'user',
				width : '200',
				rowspan : 2,
				align : 'center',
				formatter:function(value){
					return value.name;
				}
			},{
				title : '平均分',
				field : 'totalScore',
				width : '220',
				rowspan : 2,
				align : 'center'
				
			},{
				title : '查看详细信息',
				field : 'opt',
				width : '220',
				rowspan : 2,
				align : 'center',
				formatter:function(value,rowDate){
					var str1 = "<a href='<%=request.getContextPath()%>/evaluate/evaluate_showEvaluateItemDetail.action?id="+rowDate.id+"&templateId="+${param.templateId}+"&evaluateId="+evaluateId+"&clazz="+${param.clazz};
					var detailLink = str1+"'>详细信息</a>"; 
					return detailLink;
				}
			}
			 ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [{
               text : '导出测评表',
               iconCls :'icon-print',
               handler : function() {
              		$.messager.confirm('确认', '确定导出?', function(r){
					if (r){
						 page = $(".pagination-num").val();
                		 var rows = $(".pagination-page-list :selected").text();
                 		 location.href="<%=request.getContextPath()%>/exportData/exportEvaluateDetailById.action?evaluateId="+evaluateId; 
					}
					});
					}
                },"-",{
               text : '导出测评详细信息',
               iconCls :'icon-print',
               handler : function() {
              		$.messager.confirm('确认', '确定导出?', function(r){
					if (r){
						 page = $(".pagination-num").val();
                		 var rows = $(".pagination-page-list :selected").text();
                 		 location.href="<%=request.getContextPath()%>/exportData/exportEvaluateDetail.action?evaluateId="+evaluateId; 
					}
					});
                }
              },"-",{
               text : '导出用户资料',
               iconCls :'icon-print',
               handler : function() {
              		$.messager.confirm('确认', '确定导出?', function(r){
					if (r){
						 page = $(".pagination-num").val();
                		 var rows = $(".pagination-page-list :selected").text();
                 		 location.href="<%=request.getContextPath()%>/exportData/exportUser.action?clazz="+${param.clazz}; 
					}
					})
                }
              }
            ]
		});
		displayMsg();
	});
	function displayMsg() {
		$('#tt').datagrid('getPager').pagination({
			displayMsg : '当前显示从{from}到{to}共{total}记录'
		});
	}
	function getSelect(){
	}
	function del(){
	}
	</script>
   <!-- 表格控件 -->
	<table id="tt"></table>
	<div align="center" style="margin-top: 20px">
	   	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" icon="icon-back" >返回</a>	   		
	</div>
	<SCRIPT type="text/javascript">
	function clearForm(){
		var val = document.getElementById("role").value;
		if(val == "teacher"){
			location.href="<%=request.getContextPath()%>/bk/showTeacher.jsp?tag=search";
		}
		if(val == "assistant"){
			location.href="<%=request.getContextPath()%>/bk/showAssistant.jsp?tag=search";
		}
		if(val == ""){
			location.href="<%=request.getContextPath()%>/bk/evaluateList.jsp";
		}
	}
	</SCRIPT>
	<input type="hidden" value="${param.id }">
	<input id="role" type="hidden" value="<s:property value='#session.role' />"/>
  </body>
</html>