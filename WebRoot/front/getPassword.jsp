<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
  <link href="../css/getPassword.css" rel="stylesheet" />
  <script src="../js/jquery-1.8.0.js"></script> 
<script src="/EvaluateSystem/js/formValidator_min.js" type="text/javascript" charset="UTF-8"></script>
<script src="/EvaluateSystem/js/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
 
 <script type="text/javascript">
 $(document).ready(function() {
 		 if($.browser.msie) {
        	$(".fieldContainer").css("display","none");
        	$("#carbonForm>h1").html("Sorry:<a style='margin-left:150px;'><h2>暂时不支持IE浏览器</h2></a>");
     	
     	}else{
	$.formValidator.initConfig({formid:"form1",debug:false,submitonce:true,
		onerror:function(msg,obj,errorlist){
			alert(msg);
		}
	});
	$("#t_UserName").formValidator({onshow:"5-10个字符",onfocus:"5-10个字符",oncorrect:"用户名格式正确"}).inputValidator({min:5,max:10,onerror:"输入有误"}).regexValidator({regexp:"username",datatype:"enum",onerror:"格式有误"});
	$("#t_UserPass").formValidator({onshow:"5-10个字符",onfocus:"5-10个字符",oncorrect:"密码格式正确"}).inputValidator({min:5,max:10,onerror:"输入有误"}).regexValidator({regexp:"username",datatype:"enum",onerror:"格式有误"});
 		$("#iptName").formValidator({onshow:"4-10个英文字符",onfocus:"4-10个英文字符",oncorrect:"输入正确"}).inputValidator({min:4,max:10,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"}).regexValidator({regexp:"^[A-Za-z]+$",onerror:"格式不正确"});;
 	
 
 }
 });
 </script>
    <style type="text/css">

.onShow,.onFocus,.onError,.onCorrect,.onLoad{background:url(/EvaluateSystem/img/reg_bg.png) no-repeat 3000px 3000px;padding-left:30px; font-size: 12px; height:25px; width:124px; display:inline-block; line-height:25px; vertical-align:middle; overflow:hidden; margin-left:6px; color: blue;}
.onShow{ padding-left:0px; color: black;}
.onFocus{background-position:0px -30px; color: red}
.onError{background-position:0px -60px; color: red}
.onCorrect{background-position:0px 0;}
.onLoad{background-position:0px 0;}
.reg_m{margin-left:90px}
.clew_txt{display:inline-block; padding:7px  0 0 15px; font-size:12px;}

.id input,.pw input,.in_id,.in_mo,.reg_input,.reg_input_pic{_behavior:url(js/Round_htc.htc);-moz-border-radius:4px;-webkit-border-radius:4px;border-radius:4px; height:25px;}
.user_button a,.pay_but{_behavior:url(js/Round_htc.htc);-moz-border-radius:100px;-webkit-border-radius:100px;border-radius:100px;}


</style>
</head>
<body>
  <div id="carbonForm">
    <h1>密码找回<a style="font-size: 20px; margin-left: 50px;"><s:property value="exceptionMessage"/></a></h1>
    <form action="/EvaluateSystem/front/showUserByPasswordQuestionFrontUserAction.action" method="post" id="form1">
    <div class="fieldContainer">
	   <div class="logo">		
			<img src="../img/domain_logo.gif"/>
		</div>    
         <div class="formRow">
      
      
        <div class="label">
          <label for="name">用户名:</label>
        </div>
        
        
        <div class="field">
            <input class="reg_input" name="user.name" id="t_UserName" onblur="checkusername(this.value);" type="text" /><span id="t_UserNameTip" class="onshow"></span>
        </div>
      </div>
       <div class="formRow">
        <div class="label">
          <label for="name">提示问题:</label>
        </div>
        <div class="field">
          <input name="user.passwordQuestion" id="iptName" class="reg_input" type="text" onblur="return isCnn(this)" /><span id="iptNameTip" class="onshow"></span>
        </div>
      </div>
       <div class="formRow">
       <div class="label">
          <label for="name">问题答案:</label>
        </div>
        <div class="field">
          <input class="reg_input" onblur="return checkpasswd(this);" id="t_UserPass" name="user.passwordAnswer" type="password"/><span id="t_UserPassTip" class="onshow"></span>
        </div>
      </div>
    </div>
    <!-- Closing fieldContainer -->
    <div class ="d">
    <span class="signupButton">
      <input type="submit" name="submit" id="submit" class="submit"/>
      </span>
       <span class="reset">
      <input type="reset" name="reset" id="reset"/>
      </span>
    </div>
    </form>
  </div>
</body>
</html>