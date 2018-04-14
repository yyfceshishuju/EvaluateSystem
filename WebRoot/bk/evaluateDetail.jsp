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
   <div class="easyui-panel" title="修改教评" style="width:400px;height: 400px">
		<div style="padding:10px 0 10px 60px">
		<form id="ff" action="<%=request.getContextPath()%>/evaluate/evaluate_modifyEvaluate.action" method="POST">
			<input type="hidden" name="evaluate.id" value="<s:property value='evaluate.id'/>"/>
			<table> 	
    		<tr>
    			<td>课程名称</td>
    			<td><input id="subject" class="easyui-validatebox" data-options="required:true" type="text" name="evaluate.subject" value="<s:property value='evaluate.subject'/>"/> </td>
    		</tr>
    		<tr>
    			<td>班级</td>
    			<td><input id="clazz"  required data-options="onChange: function(value){$('#vv').text(value);}" type="text" name="evaluate.clazz" value="<s:property value='evaluate.clazz'/>"/> </td>
    		</tr>
			<tr>
    			<td>班级人数</td>
    			<td><input id="clazzCount" class="easyui-numberbox" data-options="required:true" type="text" name="evaluate.clazzCount" value="<s:property value='evaluate.clazzCount'/>"/> </td>
    		</tr>
    		<tr>
    			<td>实际测评人数</td>
    			<td><input id="realCount" class="easyui-numberbox" required data-options="onChange: function(value){$('#vv').text(value);}" type="text" name="evaluate.realCount" value="<s:property value='evaluate.realCount'/>"/> </td>
    		</tr>
    		<tr>
    			<td>教师姓名</td>
    			<td><select class="easyui-combobox" name="teacherId" >
	  					<s:iterator value="#request.teacherList">
  							<option value="<s:property value='id'/>"><s:property value="teacherName"/></option>
  						</s:iterator>
	  				</select>
		</tr>
    		 <tr>
    			<td>开始时间</td>
    			<td><input id="bd" class="easyui-datebox" required data-options="validType:'md[\'10/11/2012\']'" name="evaluate.beginDate" value="<s:property value='evaluate.beginDate'/>"/> </td>
    		</tr>
    		<tr>
    			<td>结束时间</td>
    			<td><input id="ed" class="easyui-datebox" required data-options="validType:'md[\'10/11/2012\']'" name="evaluate.endDate" value="<s:property value='evaluate.endDate'/>"/> </td>
    		</tr>
    		<tr>
    			<td>测评模板</td>
    			<td><select class="easyui-combobox" name="evaluate.template.id">
  						<s:iterator value="#request.templateList">
  							<option value="<s:property value='id'/>"><s:property value="templateName"/></option>
  						</s:iterator>
  				</select> </td>
    		</tr>
    		
    		 <tr>
    			<td>管理员姓名</td>
    			<td><input class="easyui-validatebox" data-options="required:true" type="text" value="<s:property value='evaluate.admin.username'/>"  readonly="readonly"/> </td>
    		</tr>
    		 <tr>
    			<td>状态</td>
    			<td><select  name="evaluate.statu" data-options="required:true">
  						<option value="y" >活跃</option>
  						<option value="n" >锁定</option>
  				</select> </td>
    		</tr>
	    	</table>
	    </form>
	    </div>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" icon="icon-ok">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" icon="icon-cancel">取消</a> 
	    </div>
	</div>
	</div>
	<script>
		function submitForm(){
		
			var subject = document.getElementById("subject").value;
			var clazz = document.getElementById("clazz").value;
			var clazzCount = document.getElementById("clazzCount").value;
			var realCount = document.getElementById("realCount").value;			
			var bd = $('#bd').datebox('getValue');  
			var ed = $("#ed").datebox('getValue');
			
			if(subject== "" || clazz == "" || clazzCount == "" || realCount==""){
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
			$.messager.confirm('确认', '确认提交?', function(r){
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
			location.href="<%=request.getContextPath()%>/bk/evaluateList.jsp";
		}
	</script>
</body>
</html>
