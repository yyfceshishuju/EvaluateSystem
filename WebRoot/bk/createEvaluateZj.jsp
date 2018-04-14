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
	
		<div class="easyui-panel"  title="创建教评信息" style="width:400px">
		<div style="padding:10px 0 10px 60px">
		<form id="ff" action="<%=request.getContextPath()%>/evaluateZj/evaluateZj_createEvaluate.action" method="POST">
	    	<table>
	    		<tr>
	    			<td>助教姓名:</td>
	    			<td><select class="easyui-combobox" name="assistantId" data-options="required:true">
	  					<s:iterator value="#request.teacherList">
  							<option value="<s:property value='id'/>"><s:property value="assistantName"/></option>
  						</s:iterator>
	  				</select></td>
	    		</tr>
	    		<tr>
	    			<td>科       目:</td>
	    			<td><input id="subject" class="easyui-validatebox" type="text" name="zjEvaluate.subject" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>班     级:</td>
	    			<td><input id="clazz" class="easyui-numberbox" type="text" name="zjEvaluate.clazz" data-options="required:true"></input><span style="">只能输入数字</span>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>班级总人数:</td>
	    			<td><input id="clazzCount" class="easyui-numberbox" type="text" name="zjEvaluate.clazzCount" data-options="required:true"></input><span style="">只能输入数字</span></td>
	    		</tr>
	    		<tr>
	    			<td>班级实际人数:</td>
	    			<td><input id="realCount" class="easyui-numberbox" type="text" name="zjEvaluate.realCount" data-options="required:true"></input><span style="">只能输入数字</span></td>
	    		</tr>
	    		<tr>
	    			<td>请选择教评模板:</td>
	    			<td><select id="temId" name="templateId" data-options="required:true">
  						<s:iterator value="#request.templateList">
  							<option value="<s:property value='id'/>" ><s:property value="templateName"/></option>
  						</s:iterator>
  				</select></td>
	    		</tr>
	    		<tr>
	    			<td>开始时间:</td>
	    			<td><input id="bd" class="easyui-datebox" name="zjEvaluate.beginDate" required data-options="validType:'md[\'10/11/2012\']'"></input>
				</td>
	    		</tr>
	    		<tr>
	    			<td>结束时间:</td>
	    			<td>
	    				<input id="ed" class="easyui-datebox" name="zjEvaluate.endDate" required data-options="validType:'md[\'10/11/2012\']'"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>状态:</td>
	    			<td>
						<select  name="zjEvaluate.statu" data-options="required:true">
  							<option value="y" >活跃</option>
  							<option value="n" >锁定</option>
  						</select>	    		
  					</td>
	    		</tr>
	    	</table>
	    </form>
	    </div>
	    </div>
	    <div style="padding:5px 120px"></div>
	    <div style="padding:5px 120px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" icon="icon-ok">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" icon="icon-back" >返回</a>	   		
	    </div>
	</div>
	<script>
		function submitForm(){
			var sub = document.getElementById("subject").value;
			var clazz = document.getElementById("clazz").value;
			var clazzCount = document.getElementById("clazzCount").value;
			var realCount = document.getElementById("realCount").value;
			var bd = $('#bd').datebox('getValue');  
			var ed = $("#ed").datebox('getValue');
			if(sub == "" || clazz == "" || clazzCount == "" || realCount==""){
				$.messager.alert('信息','内容不能为空','info');
				return false;
			}
			if(bd=="" || ed==""){
				$.messager.alert('信息','时间不能为空','info');
				return false;
			}
			
			d1 = toDate(bd);
	 		d2 = toDate(ed);
	 		if(d1 > d2){
	 			$.messager.alert('错误','开始时间不能早于结束时间!','error');
	 			return false;
	 		}
	 		if (<s:property value="#request.teacherList == null"/>){
	 			return false
	 		}
			$.messager.confirm('确定', '确定创建?', function(r){
			if (r){
				$('#ff').submit();
			}																																																																																							
			});
		}
		function toDate(str){
    		var sd=str.split("-");
   			return new Date(sd[0],sd[1],sd[2]);
		}
		function clearForm(){
			location.href="<%=request.getContextPath()%>/bk/evaluateListZj.jsp";
		}
	</script>
</body>
</html>
