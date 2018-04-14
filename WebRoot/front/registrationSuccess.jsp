<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script src="../js/jquery-1.8.0.js"></script>
 <script type="text/javascript">
        $(document).ready(function() {  
            function jump(count) {  
                window.setTimeout(function(){  
                    count--;  
                    if(count>0) {  
                        $("#num").html(count);  
                        jump(count);  
                    } else {  
                        location.href="login.jsp";  
                    }  
                }, 1000);  
            }  
            jump(5);  
        });  
    </script>
 
 <link href="/EvaluateSystem/css/box_style.css" type="text/css" rel="stylesheet" />
  <link href="../css/styles.css" rel="stylesheet" />
</head>
<body onload="javascript:bindunbeforunload();">
  <div id="carbonForm">
    
    <span class="excep1"><s:fielderror fieldName="UserNameAndPasswordException"/>
		</span>
    <div class="fieldContainer">
	   <div class="logo">		
			<img src="../img/domain_logo.gif"/>
		</div>    
      <h1>注册成功: <a style="font-size: 18px" href="/EvaluateSystem/front/login.jsp"><span id="num">5</span>秒后自动跳转</a></h1>
    </div>
  </div>
</body>
</html>