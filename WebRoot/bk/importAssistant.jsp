<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function (){
			$("#btn1").click(function (){
				var files = $(".fileName");
				var clazz = $("#clazz").val();
				if(clazz==""){
					$.messager.alert('信息','请输入班级','info');
					return false;
				}
				for(var i = 0; i < files.length;i++){
					var fileName =  files[i].value;
					if(fileName == ""){
						 $.messager.alert("提示","请选择上传文件","info")
       				 	 return false
					}
				}
				
				$.messager.confirm('confirm','确认上传？',function(r){
					if(r){
						$('#ff').submit();
					}	
				});
			});
		});
	</script>
  </head>
  
  <body>
  <div align="center">
  
  <div style="margin:10px 0px;" align="center">
	<div class="easyui-panel" title="教评结果上传" style="width:500px">
		 <form id="ff" action="<%=request.getContextPath() %>/importData/importAssistants.action" method="post" enctype="multipart/form-data">    	
    		<div style="padding:20px 20px">
    		请输入班级：
	    	<input id="clazz" class="easyui-numberbox" type="text" name="clazz" data-options="required:true"></input><span style="">只能输入数字</span><br/><br/>	
    		选择助教测评信息的excel表:<input class="fileName" type="file" name="upload" value="请选择"/><br/><br/><br/>
    		选择助教测评详细信息的excel表:<input class="fileName" type="file" name="upload" value="请选择"/><br/><br/>
  			</div>
    </form>
	</div>
	<div align="center">
		    <a id="btn1" href="javascript:void(0)" class="easyui-linkbutton" icon="icon-ok">提交</a>
    </div>
	</div>
	</div>
  </body>
</html>
