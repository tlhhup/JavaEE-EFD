<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>登录</title>
		<meta name="content-type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8"/>
	</head>
	<style>
		body{
		    background-image: url("image/lfl.jpg");
		    background-size: 100%,100%;
		}
		#image{
		    width: 565px;
		    height: 265px;
		    border-radius: 10px;
		    margin: 220px auto 0;
		    border: solid #0098c7 1px;
		    background-image: url("image/loginbg.gif");
		}
		#name,#input,#user{
		    width: 160px;;
		    height: 140px; ;
		    float: left;
		    margin: 100px 0 0 0;
		}
		#name{
		    margin-left: 20px;
		}
		.name{
		    width: 90px;
		    height: 40px;
		    text-align: center;
		    line-height: 40px;
		    margin-left: 70px;
		}
		.input{
		    width: 150px;
		    height: 40px;
		    text-align: center;
		    line-height: 40px;
		}
		
		#text{
		    background-image: url("image/usernamebg.gif");
		}
		#password{
		    background-image: url("image/passwordbg.gif");
		}
		#text,#password{
		    border: 0;
		    background-size: 100% 100%;
		    padding-left: 20px;
		    width: 160px;
		    height: 25px;
		    border-radius: 5px;
		}
		#user{
		    margin: 100px 0 0  60px;
		}
		#below{
		    width: 565px;
		    height: 20px;
		    margin-top: 240px;
		    text-align: center;
		    font-size: 12px;
		}
		.subBtn:HOVER {
			cursor:pointer;
		}
		#codeImg:HOVER {
			cursor:pointer;
		}
	</style>	
    <script type="text/javascript">
    	function subForm(){
    		var formTag = document.getElementById("form");
    		formTag.submit();
    	}
    	
    	function changeCode(imgTag){
    		imgTag.src = imgTag.src + "?code=" + Math.random();
    	}
    </script>
	<body>
		<form id="form" action="login.action" method="post">
			<div id="image">
		      	<div id="name">
		          	<div class="name">用户名：</div>
	         		<div class="name">密&nbsp;&nbsp;&nbsp;&nbsp;码：</div>
	         	 	<div class="name">${ loginInfo }</div>
		      	</div>
		      	<div id="input">
	         	 	<div class="input"><input type="text" id="text" name="name" value="${ name }"/></div>
		          	<div class="input"><input type="password" id="password" name="password"  value="${ password }"/></div>
		          	<div class="input"><input type="checkbox" id="checkbox" name="saveManager" value="1"/>保存登录信息</div>
		      	</div>
		      	<div id="user">
					<div class="subBtn" onclick="subForm();">
						<img src="image/loginbt.gif" />
					</div>
		      	</div>
		      	<div id="below">
		          	<input type="text" name="yzcode"  value=""/>&nbsp;&nbsp;&nbsp;<img id="codeImg" src="yzcode.do" onclick="changeCode(this);"/>
		      	</div>
		  	</div>
		</form>
		
		
		<img src="image/salary.png">
	</body>
</html>












