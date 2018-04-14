<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>  
  <head>  
  
  <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <title>跳转页面</title>   
   
  <script type="text/javascript" src="../js/jquery-1.8.0.js"></script>
  <script type="text/javascript">
    $(document).bind("contextmenu",function(){return false;});
$(document).bind("selectstart",function(){return false;});
$(document).bind("keydown","")
    </script>
  </head>      
  <body>   
  
  <center>
	<textarea rows="400" cols="300px"></textarea>
  </center> 
  </body>  
</html> 
  