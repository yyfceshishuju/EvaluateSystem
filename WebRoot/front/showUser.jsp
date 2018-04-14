
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
  <link href="../css/showUser.css" rel="stylesheet" />
	<script type="text/javascript" src="../js/registation.js">
	</script>

</head>
<body>
  <div id="carbonForm">
    <h1>注册信息</h1>
    
    <form action="/EvaluateSystem/front/loginFrontUserAction.action" method="post" id="signupForm">
    <div class="fieldContainer">
    
	   <div class="logo">		
			<img src="../img/domain_logo.gif"/>
		</div>    
      <div class="formRow">
      
      
        <div class="label">
          <label for="name">用户名:</label>
        </div>
        
        
        <div class="field">
        	<font size="4px"><s:property value="user.name"/></font>
        </div>
      </div>
      
      <div class="formRow">
        <div class="label">
          <label for="pass">密码:</label>
        </div>
        <div class="field">
        	<font size="4px"><s:property value="user.password"/></font>
        </div>
      </div>
      
      
      <div class="formRow">
        <div class="label">
          <label for="name">班级:</label>
        </div>
        <div class="field">
        	<font size="4px"><s:property value="user.clazz"/></font>
        </div>
      </div>
       
       <div class="formRow">
        
        <div class="label">
          <label for="name">提示问题:</label>
        </div>
        
        <div class="field">
        	 <font size="4px"><s:property value="user.passwordQuestion"/></font>
        </div>
      </div>
      
      
       <div class="formRow">
       <div class="label">
          <label for="name">问题答案:</label>
        </div>
        <div class="field">
        	 <font size="4px"><s:property value="user.passwordAnswer"/></font>
        </div>
      </div>
      
       <div class="formRow">
       <div class="label">
          <label for="name">注册时间:</label>
        </div>
        <div class="field">
        	 <font size="4px"><s:date name="user.createDate" format="yyyy年MM月dd日"/></font>
        	 
        </div>
      </div>
    </div>
    <!-- Closing fieldContainer -->
    <div class ="d">
   	<input type="text" name="user.name" value="<s:property value="user.name"/>" style="display: none;"/>
   	<input type="text" name="user.password" value="<s:property value="user.password"/>" style="display: none;"/>
    <span class="signupButton">
      <input type="submit" name="submit" id="submit" class="registation"/>
      </span>
      
      
    
    </div>
    </form>
  </div>
</body>
</html>