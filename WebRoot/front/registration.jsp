<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
  <link href="../css/registation.css" rel="stylesheet" />
  <style type="text/css">


.onShow,.onFocus,.onError,.onCorrect,.onLoad{background:url(/EvaluateSystem/img/reg_bg.png) no-repeat 3000px 3000px;padding-left:30px; font-size: 12px; height:25px; width:124px; display:inline-block; line-height:25px; vertical-align:middle; overflow:hidden; margin-left:6px}
.onShow{padding-left:0px}
.onFocus{background-position:0px -30px; color:red}
.onError{background-position:0px -60px; color:red}
.onCorrect{background-position:0px 0;color: blue}
.onLoad{background-position:0px 0;}
.reg_m{margin-left:90px}
.clew_txt{display:inline-block; padding:7px  0 0 15px; font-size:12px;}

.id input,.pw input,.in_id,.in_mo,.reg_input,.reg_input_pic{_behavior:url(js/Round_htc.htc);-moz-border-radius:4px;-webkit-border-radius:4px;border-radius:4px; height:25px;}
.user_button a,.pay_but{_behavior:url(js/Round_htc.htc);-moz-border-radius:100px;-webkit-border-radius:100px;border-radius:100px;}


</style>
  
  <script src="/EvaluateSystem/js/jquery-1.2.6.min.js" type=text/javascript></script>
<script src="/EvaluateSystem/js/formValidator_min.js" type="text/javascript" charset="UTF-8"></script>
<script src="/EvaluateSystem/js/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
	
	$.formValidator.initConfig({formid:"form1",debug:false,submitonce:true,
		onerror:function(msg,obj,errorlist){
			alert(msg);
			
		}
	});
	$("#t_UserName").formValidator({onshow:"5-10个英文字符",onfocus:"5-10个英文字符",oncorrect:"用户名格式正确"}).inputValidator({min:5,max:10,onerror:"输入有误"}).regexValidator({regexp:"username",datatype:"enum",onerror:"格式有误"});
	$("#t_UserPass").formValidator({onshow:"5-10个英文字符",onfocus:"5-10个英文字符",oncorrect:"密码格式正确"}).inputValidator({min:5,max:10,onerror:"输入有误"}).regexValidator({regexp:"username",datatype:"enum",onerror:"格式有误"});
	$("#iptName").formValidator({onshow:"4-10个英文字符",onfocus:"4-10个英文字符",oncorrect:"输入正确"}).inputValidator({min:4,max:10,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"}).regexValidator({regexp:"^[A-Za-z]+$",onerror:"格式不正确"});;
	$("#t_Email").formValidator({onshow:"2-3个字符班级编号",onfocus:"班级编号例如: 15",oncorrect:"输入正确"}).inputValidator({min:2,max:3,onerror:"输入错误:"}).regexValidator({regexp:"^[1-9]\\d*$",onerror:"格式不正确"});
	$("#t_RePass").formValidator({onshow:"5-10个英文字符",onfocus:"5-10个英文字符",oncorrect:"输入正确"}).inputValidator({min:5,max:10,onerror:"输入有误"}).regexValidator({regexp:"^[A-Za-z]+$",onerror:"格式不正确"});
	
});
function test1(obj)
{
	if(obj.value=="全角字符当做1个长度")
	{
		$.formValidator.getInitConfig("1").wideword = false;
		obj.value = "全角字符当做2个长度";
	}
	else
	{
		$.formValidator.getInitConfig("1").wideword = true;
		obj.value = "全角字符当做1个长度";
	}
	
}


	</script>
</head>
<body>
  <div id="carbonForm">
    <h1>注册  <a style="font-size: 20px; margin-left: 170px;"><s:property value="exceptionMessage"/></a></h1>
    <form action="/EvaluateSystem/front/registerFrontUserAction.action" method="post" id="form1" >
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
          <label for="pass">密码:</label>
        </div>
        <div class="field">
          <input class="reg_input" onblur="return checkpasswd(this);" id="t_UserPass" name="user.password" type="password"/><span id="t_UserPassTip" class="onshow"></span>
        </div>
      </div>
      
      
      <div class="formRow">
        <div class="label">
          <label for="name">班级:</label>
        </div>
        <div class="field">
          <input class="reg_input" name="user.clazz" type="text" id="t_Email" onblur="checkemail(this.value)" /><span id="t_EmailTip" class="onshow"></span>
        </div>
      </div>
       
       <div class="formRow">
        
        <div class="label">
          <label for="name">提示问题:</label>
          
        </div>
        
        <div class="field">
          <!-- <input type="text" name="user.passwordQuestion" id="name" /> -->
          <input name="user.passwordQuestion" id="iptName" class="reg_input" type="text" onblur="return isCnn(this)" /><span id="iptNameTip" class="onshow"></span>
          
        </div>
      </div>
      
      
       <div class="formRow">
       <div class="label">
          <label for="name">问题答案:</label>
        </div>
        <div class="field">
          <input  class="reg_input" type="password" id="t_RePass" name="user.passwordAnswer"/><span id="t_RePassTip" class="onshow"></span>
        </div>
      </div>
      
    </div>
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
</body>
</html>