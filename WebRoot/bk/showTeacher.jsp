<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
</head>
	<body>
	   <script type="text/javascript">
	  	$(function() {
	  	var urlPath="<%=request.getContextPath()%>/evaluate/evaluate_showAllEvaluate.action"
	  	var tags = document.getElementById("tag").value;
	
	  	if(tags == "search"){
	  		var content = document.getElementById("name").value;
	  		var condition = "teacherName"
	  		urlPath = '<%=request.getContextPath()%>/evaluate/evaluate_showByCondition?searchBean.condition='+condition+'&searchBean.content='+content;
	  	}
		$('#ff').hide();
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
			url :urlPath,
			loadMsg : '数据装载中......',
			onLoadError : function() {
				$.messager.alert('信息','数据加载失败!','info')
			},
			onLoadSuccess : function(data){
			   $(".queryDetailButton").linkbutton({text:"查看详细信息",plain:true,iconCls:"icon-edit"});
			   $(".queryScoreDetailButton").linkbutton({text:"查看教评均分",plain:true,iconCls:"icon-edit"});
			   $(".queryCommendDetailButton").linkbutton({text:"查看意见汇总",plain:true,iconCls:"icon-edit"});
			},
			sortName : 'code',
			sortOrder : 'desc',
			remoteSort : false,
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				title : '课程名称',
				field : 'subject',
				width : '100',
				rowspan : 2,
				align : 'center'
			}, {
				title : '教师姓名',
				field : 'teacher',
				width : '100',
				rowspan : 2,
				align : 'center',
				formatter:function(value){
					return value.teacherName;
				}
			}, {
				title : '开始时间',
				field : 'beginDate',
				width : '120',
				rowspan : 2,
				align : 'center'
			}, {
				title : '结束时间',
				field : 'endDate',
				width : '120',
				rowspan : 2,
				align : 'center'
			}, {
				title : '班级',
				field : 'clazz',
				width : '100',
				rowspan : 2,
				align : 'center'
			}, {
				title : '结果',
				field : 'totalScore',
				width : '100',
				rowspan : 2,
				align : 'center'
			}, {
				title : '操作',
				field : 'id',
				width : '220',
				rowspan : 2,
				align : 'center',
				formatter:function(value,rowData){
				if(rowData.totalScore != 0.0){
					var str1 = "<a href='<%=request.getContextPath()%>/bk/evaluateDetails.jsp?tag=a&id="+value+"&templateId="+rowData.template.id+"&clazz="+rowData.clazz;
					var detailLink= str1+"' class=\"queryDetailButton\"></a>";
					var str4 = "<a href='<%=request.getContextPath()%>/evaluate/evaluate_showScoreDetail.action?id="+rowData.id+"&templateId="+rowData.template.id;
					var scoreDetalLink = str4+"' class=\"queryScoreDetailButton\" ></a>";
					var str5 = "<a href='<%=request.getContextPath()%>/evaluate/evaluate_showCommendDetail.action?id="+rowData.id+"&templateId="+rowData.template.id;
					var commendDetailLink = str5+"' class=\"queryCommendDetailButton\" ></a>";
					str = "<span>"+detailLink+"  "+ scoreDetalLink +"  "+commendDetailLink+ "</span>"; 
					return str;
				}
				else{
					return "暂无结果";
				}
				}
			}
			] ],
			pagination : true,
			rownumbers : true,
		<%--	toolbar : [ {
               text : '删除',
               iconCls :'icon-remove',
               handler : function() {
                	var ids = [];
					var rows = $('#tt').datagrid('getSelections');
					if(rows.length == 0){
						$.messager.alert('警告','请选择删除项!','warning');
						return false;
					}
					$.messager.confirm('确认', '确定删除?', function(r){
						if (r){
							var str ="";
							for(var i=0; i<rows.length; i++){
								(rows[i].id);
								str+=rows[i].id+",";
							}
							location.href='<%=request.getContextPath()%>/evaluate/evaluate_removeEvaluateByEvaluateId?deleteId='+str;	
						}
					});
				
                }
              },"-", {
               text : '导出',
               iconCls :'icon-print',
               handler : function() {
              		$.messager.confirm('确认', '确定导出?', function(r){
					if (r){
						 page = $(".pagination-num").val();
                		 var rows = $(".pagination-page-list :selected").text();
                 		 location.href="<%=request.getContextPath()%>/exportTeacher.action?rows="+rows+"&page="+page; 
					}
					});
                   
                }
              }
            ] --%>
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

	<div style="margin-top: 30px">
	
	</div>
	<!-- 表格控件 -->
	<table id="tt"></table>
	<input id="condition" type="hidden" value="${param.condition }"/>
	<input id="content" type="hidden" value="${param.content}" />
	<input id="tag" type="hidden" value="${param.tag }" />
	<input id="begD" type="hidden" value="${param.beginDate}"/>
	<input id="endD" type="hidden" value="${param.endDate}"/>
	<input id="msg"  type="hidden" value="${msg}" />
	
	 <input type="hidden" id="name" value="<s:property value='#session.teacher.teacherName'/> "/>
	 <input type="hidden" id="name" value="${name}"/>
</body>
</html>
