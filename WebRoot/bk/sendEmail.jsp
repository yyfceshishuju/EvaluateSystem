<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
	
</head>
<body>
<div align="center">
	<div style="margin:10px 0px"></div>	
		<div id="p" class="easyui-panel" title="发送邮件" style="width:auto;height:450px;padding:10px;">
		<div style="width:auto">
		<form id="ff" action="<%=request.getContextPath()%>/sendEmail/evaluate_sendEmail.action" method="POST">
	    	<table>
	    		<tr>
	    			<td>收件人 :</td>
	    			<td><input id="reciver" class="easyui-validatebox" type="text" name="messager.receiver" data-options="required:true" style="width:700px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>抄	送:</td>
	    			<td><input id="cc" class="easyui-validatebox" type="text" name="messager.copyReceiver" style="width:700px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>主	题:</td>
	    			<td><input id="title" class="easyui-validatebox" type="text" name="messager.title" data-options="required:true" style="width:700px"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>内	容:</td>
	    			<td><textarea name="messager.content" style="height:300px;width: 700px"></textarea>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    </div>
	    </div>
	    <div style="padding:5px 120px"></div>
	    <div style="padding:5px 120px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm();" icon="icon-ok">发送</a>
	    </div>
	</div>
	<script>
		function submitForm(){
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			var reciver = document.getElementById("reciver").value;
			var cc = document.getElementById("cc").value;
			var title = document.getElementById("title").value;
			if(reciver == "" || title==""){
				$.messager.alert('信息','必填内容不能为空','info');
				return false;
			}
			if((reciver.indexOf("；") != -1)){
				$.messager.alert('信息','请输入英文分号！','info');
				return false;
			}
			if((reciver.indexOf(";") == -1)){
				$.messager.alert('信息','一个或者多个邮箱用英文分号隔开','info');
				return false;
			}
			var recivers = reciver.split(";");
			for(var i = 0; i < recivers.length-1;i ++){	
				if(!myreg.test(recivers[i])){
					$.messager.alert('信息','请输入有效收件人邮箱地址','info');
      				return false;
           		}	
           	}
           	if(cc != ""){
           		if((cc.indexOf("；") != -1)){
           			$.messager.alert('信息','请输入英文分号！','info');
					return false;
           		}
           		if((cc.indexOf(";") == -1)){
					$.messager.alert('信息','一个或者多个邮箱用分号隔开','info');
					return false;
				}
           		var ccs =cc.split(";");
				for(var i = 0; i < ccs.length-1;i ++){	
					if(!myreg.test(ccs[i])){
						$.messager.alert('信息','请输入有效抄送人邮箱地址','info');
	      				return false;
	           		}	
           		}
           	}
			$.messager.confirm('确定', '确定发送?', function(r){
				if (r){
					$('#ff').submit();
				}																																																																																							
			});
		}
	</script>
</body>
</html>
