<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <link href="../css/styles.css" rel="stylesheet" />
  <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <script src="js/jquery-1.8.3.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
  <div id="carbonForm" style="width: 500px; height: 200PX">
    
    <span class="excep1"><s:fielderror fieldName="UserNameAndPasswordException"/>
		</span>
    <form action="${pageContext.request.contextPath}/front/loginFrontUserAction.action" method="post" id="signupForm" onsubmit="ru">
    <div class="fieldContainer" style="height: 170PX">
    
	   <div class="logo">		
			<img src="../img/domain_logo.gif"/>
		</div>    
      <h1 style="float: left;">测评成功</h1> <a href="${pageContext.request.contextPath}/front/showEvaluateZJByCreateDateAndClazzFrontEvaluateZJAction.action" style="font-size: 20px"><button class="btn btn-large  btn-primary"  type="button">点此处测评助教 </button></a>
      
    </div>
    <!-- Closing fieldContainer -->
    </form>
  </div>
</body>
</html>