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
				var clazz = $("#clazz").val();
				var fileName = $("#fileName").val();
				if(clazz==""){
					$.messager.alert('信息','请输入班级','info');
					return false;
				}
				if(fileName == ""){
       				  $.messager.alert("提示","请选择上传文件","info")
       				  return false
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
	<div class="easyui-panel" title="测评详情" style="width:500px">
		 <form id="ff" action="<%=request.getContextPath() %>/importData/importUsers.action" method="post" enctype="multipart/form-data">    	
    		<div style="padding: 20px 20px">
    		请输入班级：
	    	<input id="clazz" class="easyui-numberbox" type="text" name="clazz" data-options="required:true"></input><span style="">只能输入数字</span><br/><br/>
    		选择上传的excel:<input id="fileName" type="file" name="upload" value="请选择"/><br/><br/><br/>
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
