<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<!-- 简单的登录页面 -->
	<form action="login" method="post">
		用户名：<input name="uname"><span style="color:red">${msg }</span><br>
		密 &nbsp;&nbsp;&nbsp;码：<input name="password" type="password"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>