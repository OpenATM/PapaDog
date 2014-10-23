<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script src="js/jquery-1.3.2.min.js"></script>
<html>
  <head>
  </head>
  <script>
    
  	function submitMe(){
		var url="user/user_findUserById.action";
   		var obj = {
   		    id:'1',
  			userName:'hejun',
  			studentId:'200801780',
  		}
  	
  		//var jobj = eval('({provinceId:"1",cityId:"2",countyId:"1",userName:"yang8",password1:"123456",mobile:"13587873214",iDNo1:"510234197808255233",email:"aaa@123.com",zipCode:"610000",sexy:"先生",realName:"张三",owingMention:"Y",verifyCode:""})');
  		//jobj.verifyCode = document.getElementById('vcode').value;
  		$.post(url,obj,callback);
  		
  	}	
  	function callback(data, textStatus){
  			alert(data);
  	}
  	function changeme(obj){
  		obj.src = "common/verify_graphCode.action?rnd=" + Math.random();
  	}
  </script>
  <body>
    	<form method="get"></form>
    	验证码：<input type="text" id="vcode" maxlength=4/>
    <!--    <img src="common/verify_graphCode.action" onclick="changeme(this)" style="cursor:pointer"/>   --> 
    	
    	<input type="button" value="提交" onclick="submitMe()">
  </body>
</html>
