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
	 	 var msg = document.getElementById("msg");
	  	 if(msg != null){
	  		$.messager.alert("信息",msg.value,"info",function(){
	  			  location.href="<%=request.getContextPath()%>/bk/evaluateListZj.jsp";
	  		});
	  	}
	  	$(function() {
	  	var urlPath="<%=request.getContextPath()%>/evaluateZj/evaluateZj_showAllEvaluate.action"
	  	var tags = document.getElementById("tag").value;
	  	if(tags == "search"){
	  		var content = document.getElementById("content").value;
	  		var condition = document.getElementById("condition").value;
	  		if(condition == "evaluateTime"){
	  			var bd = document.getElementById("begD").value;
	  			var ed = document.getElementById("endD").value;
	  			urlPath = '<%=request.getContextPath()%>/evaluateZj/evaluateZj_showByCondition?searchBean.condition='+condition+'&searchBean.beginDate='+bd+'&searchBean.endDate='+ed;
	  		}
	  		else{
	  			urlPath = '<%=request.getContextPath()%>/evaluateZj/evaluateZj_showByCondition?searchBean.condition='+condition+'&searchBean.content='+content;
	  		}
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
			   $(".updateButton").linkbutton({text:"修改",plain:true,iconCls:"icon-edit"});
			   $(".createResultButton").linkbutton({text:"生成结果",plain:true,iconCls:"icon-edit"});
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
				width : '80',
				rowspan : 2,
				align : 'center'
			}, {
				title : '助教姓名',
				field : 'assistant',
				width : '80',
				rowspan : 2,
				align : 'center',
				formatter:function(value){
					return value.assistantName;
				}
			}, {
				title : '开始时间',
				field : 'beginDate',
				width : '100',
				rowspan : 2,
				align : 'center'
			}, {
				title : '结束时间',
				field : 'endDate',
				width : '100',
				rowspan : 2,
				align : 'center'
			}, {
				title : '班级',
				field : 'clazz',
				width : '60',
				rowspan : 2,
				align : 'center'
			}, {
				title : '结果',
				field : 'totalScore',
				width : '80',
				rowspan : 2,
				align : 'center'
			}, {
				title : '操作',
				field : 'id',
				width : '220',
				rowspan : 2,
				align : 'center',
				formatter:function(value,rowData){
					var str1 = "<a href='<%=request.getContextPath()%>/bk/evaluateDetailsZj.jsp?tag=a&id="+value+"&templateId="+rowData.zjTemplate.id+"&clazz="+rowData.clazz;
					var detailLink= str1+"' class=\"queryDetailButton\"></a>"; 
					var str2 = "<a href='<%=request.getContextPath()%>/evaluateZj/evaluateZj_showEvaluateDetail.action?id="+value;
					var updateLink= str2+"' class=\"updateButton\"></a>"; 
					var str = "<span>"+updateLink+" "+detailLink+"</span>"; 
					if(rowData.totalScore == 0){
						var str3 = "<a href='<%=request.getContextPath()%>/evaluateZj/evaluateZj_createAverageTotalScore.action?id="+rowData.id;
						var resultLink = str3+"' class=\"createResultButton\" ></a>";
						str = "<span>"+updateLink +" "+resultLink+ " " +detailLink+"</span>"; 
					}
					if(rowData.scoreDetail != null){
						var str4 = "<a href='<%=request.getContextPath()%>/evaluateZj/evaluateZj_showScoreDetail.action?id="+rowData.id+"&templateId="+rowData.zjTemplate.id;
						var scoreDetalLink = str4+"' class=\"queryScoreDetailButton\" ></a>";					
						var str5 = "<a href='<%=request.getContextPath()%>/evaluateZj/evaluateZj_showCommendDetail.action?id="+rowData.id+"&templateId="+rowData.zjTemplate.id;
						var commendDetalLink = str5+"' class=\"queryCommendDetailButton\" ></a>";
						str = "<span>"+updateLink + " " +detailLink+"  "+ scoreDetalLink +" "+ commendDetalLink+"</span>"; 
					}
					return str;
				}
			}
			] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
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
							location.href='<%=request.getContextPath()%>/evaluateZj/evaluateZj_removeEvaluateByEvaluateId?deleteId='+str;	
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
                 		 location.href="<%=request.getContextPath()%>/exportData/exportAssistant.action?rows="+rows+"&page="+page; 
					}
					});
                   
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
	<div align="left">
	 <div style="margin:10px"></div>
	<input class="easyui-searchbox" data-options="prompt:'请输入内容',menu:'#mm',searcher:doSearch" style="width:300px"></input>
	<div id="mm" style="width:120px;">
		<div data-options="name:'teacherName',iconCls:'icon-ok'">助教姓名</div>
		<div data-options="name:'studentName'">学员姓名</div>
		<div data-options="name:'subject'">科目名称</div>
		<div data-options="name:'evaluateTime'">测评时间</div>
	</div>
	<!-- 时间控件 -->	
	<span style="margin-left: 40px">
	开始时间： <input id="bd" class="easyui-datebox" required data-options="validType:'md[\'10/11/2012\']'"></input><span style="margin:40px"></span>
	结束时间： <input id="ed" class="easyui-datebox" required data-options="validType:'md[\'10/11/2012\']'"></input>
	</span>
	<span style="padding: 80px">
	<a href="<%=request.getContextPath()%>/evaluateZj/evaluateZj_showAllTemplateAndTeacher.action" class="easyui-linkbutton" icon="icon-add" >创建教学评价表</a>
	</span>
	</div>
	<script>
		function doSearch(value,name){
		if(name!= "evaluateTime"){
			if(value == ""){
				$.messager.alert('警告','请输入搜索内容!','warning');
				return false;
			}
		}
		if(name == "evaluateTime"){
			var bd = $('#bd').datebox('getValue');  
			var ed = $("#ed").datebox('getValue'); 
			if(bd == "" || ed ==""){
				$.messager.alert('错误','时间不能为空!','error');
				return false;
			}
			d1 = toDate(bd);
	 		d2 = toDate(ed);
	 		
	 		if(d1 > d2){
	 			$.messager.alert('错误','开始时间不能晚于结束时间!','error');
	 			return false;
	 		}
			location.href="evaluateListZj.jsp?tag=search&condition="+name+"&beginDate="+bd+"&endDate="+ed;
		}else{
				location.href="evaluateListZj.jsp?tag=search&condition="+name+"&content="+value;	
			}
		}
		function toDate(str){
    		var sd=str.split("-");
   			return new Date(sd[0],sd[1],sd[2]);
		}
	</script>
	
	<script>
		$.extend($.fn.validatebox.defaults.rules, {
			md: {
				validator: function(value, param){
					var d1 = $.fn.datebox.defaults.parser(param[0]);
					var d2 = $.fn.datebox.defaults.parser(value);
					return d2<=d1;
				},
				message: 'The date must be less than or equals to {0}.'
			}
		})
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
</body>
</html>
