<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
  <link href="../css/evaluateTable.css" rel="stylesheet" />
  	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="../js/studentFront.js">
		
	</script>

</head>
<body>
  <script src="js/jquery-1.8.3.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
  <div id="backgrondb">
  <div></div>
  <div id="carbonForm">
  <s:if test="exceptionMessage!=null">
  		<h1><span id="exept"><s:property value="exceptionMessage"/></span></h1>
  			<h2 style="margin-left: 300px"><a href="/EvaluateSystem/front/login.jsp">点击返回</a></h2>
  		</s:if><s:else>
   		 <h1>教师测评表</h1>
    </s:else>
    <div class="evaluateTableHead" id="headid">
    </h1>
     <form action="/EvaluateSystem/front/createEvaluateFrontEvaluateTeacherAction.action" method="post" id="signupForm" onsubmit="return buttonSubmit();">
    	教师姓名:	<input type="text" name="evaluate.teacher.teacherName" value="<s:property value="evaluate.teacher.teacherName"/>" readonly="readonly"/>
    	班级:<input type="text" name="evaluate.clazz" value="<s:property value="evaluate.clazz"/>" readonly="readonly"/>
    	课程:<input type="text" name="evaluate.subject" value="<s:property value="evaluate.subject"/>" readonly="readonly" size="10"/>
    		<button value="" id="headButton" type="button" >开始测评 </button>
    </div>
    <div class="fieldContainer" id="headDiv">
	   <div class="logo">		
			<img src="../img/domain_logo.gif"/>
		</div>    
      <div class="formRow">
      
     	<table width=100% align=center  bordercolor='black' cellspacing='0' frame="void">
						<th colspan="6"><h4 align="left">
						针对以下每项测评内容,请在合适的位置点击按钮<br>
						您的评分对人才基地改进教学手段,提高教学水平很有帮助,请认真填写.<br>
						评分标准:<br>
						☆&nbsp;&nbsp;&nbsp;很好:&nbsp;该教师在该项工作很好,作为学员的你较为满意<br>
						☆&nbsp;&nbsp;&nbsp;好　:&nbsp;该教师在该项基本达到你的预期,但明显有提高的必要<br>
						☆&nbsp;&nbsp;&nbsp;一般:&nbsp;教师在该项上勉强合格,距离优秀还有极大的差距<br>
						☆&nbsp;&nbsp;&nbsp;差　:&nbsp;教师在该项上基本不合格,难以满足你的要求<BR>
						☆&nbsp;&nbsp;&nbsp;很差:&nbsp;教师在该项上完全不合格,无法胜任目前的教学工作,你已难以忍受</h4></th>
					</tr>


					<tr align="center">
						<td>教师测评内容</td>
						<td>很好</td>
						<td>&nbsp;好&nbsp;</td>
						<td>一般</td>
						<td>&nbsp;差&nbsp;</td>
						<td>很差</td>
					</tr>
					
					<s:iterator  var="select"  value="selectEvaluateItem" status="list">
					<tr align="center">
						<td   align="left" style="width: 400px"><s:property value="select"/></td>
						<td><input name="selectEvaluateItemDetailMap['<s:property value="#list.index+1"/>']" type="radio" value="5" />
						</td>
						<td ><input name="selectEvaluateItemDetailMap['<s:property value="#list.index+1"/>']" type="radio" value="4" />
						</td>
						<td ><input name="selectEvaluateItemDetailMap['<s:property value="#list.index+1"/>']" type="radio" value="3" />
						</td>
						<td ><input name="selectEvaluateItemDetailMap['<s:property value="#list.index+1"/>']" type="radio" value="2" />
						</td>
						<td ><input name="selectEvaluateItemDetailMap['<s:property value="#list.index+1"/>']" type="radio" value="1" />
						</td>
					</tr>
					
					</s:iterator>
					<s:iterator value="inputEvaluateItem" var="input" status="list">
					<tr align="left">
					<th colspan="6" height="35" ><s:property value="input"/>(150字以内)</th>
					</tr>
					<tr align="left">
					<th colspan="6"> <textarea name="inputeEvaluateItemDetailMap['<s:property value="#list.index+1"/>']"  class='textarea1' id="textarea<s:property value="#list.index+1"/>" style="height: 100px; width: 100%;" onfocus="textarea250(<s:property value="#list.index"/>);" onblur="textarea260(<s:property value="#list.index"/>);" ></textarea></th>
					</tr>
					</s:iterator>
					
			</table>
      
    </div>
    	<input type="text" name="evaluateDetail.evaluateId" value="<s:property value="evaluate.id"/>" style="display: none;"/>
    <!-- Closing fieldContainer -->
    <div class ="d">
   
    <span class="signupButton">
      <input type="submit" name="submit" id="submit" class="registation"/>
      </span>
      
      
       <span class="reset">
      <input type="reset" name="reset" id="reset"/>
      
      
      </span>
    
    </div>
    </form>
  </div>
  </div>
  </div>
</body>
</html>